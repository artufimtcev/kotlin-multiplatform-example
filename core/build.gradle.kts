import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

val kotlinVersion = properties["kotlin_version"]!!
val ktorVersion = properties["ktor_version"]!!
val coroutinesVersion = properties["kotlin_coroutines_version"]!!
val serializationVersion = properties["kotlinx_serialization_version"]!!


plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

kotlin {

    // Select iOS target platform depending on the Xcode environment variables
    val iOSTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iOSTarget("ios") {
        binaries {
            framework {
                baseName = "core"
            }
        }
    }

    jvm("android")

    sourceSets["commonMain"].dependencies {

        // Kotlin Std Library
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")

        // Ktor HTTP client
        implementation("io.ktor:ktor-client-core:$ktorVersion")
        implementation("io.ktor:ktor-client-json:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization:$ktorVersion")

        // Kotlin Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:$coroutinesVersion")

        // Kotlin code-generation based JSON serialization
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationVersion")
    }

    sourceSets["androidMain"].dependencies {

        // Kotlin Std Library
        implementation("org.jetbrains.kotlin:kotlin-stdlib")

        // Ktor HTTP client
        implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
        implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization-jvm:$ktorVersion")

        // Kotlin Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

        // Kotlin code-generation based JSON serialization
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
    }

    sourceSets["iosMain"].dependencies {

        // Ktor HTTP client
        implementation("io.ktor:ktor-client-ios:$ktorVersion")
        implementation("io.ktor:ktor-client-core-native:$ktorVersion")
        implementation("io.ktor:ktor-client-json-native:$ktorVersion")
        implementation("io.ktor:ktor-client-serialization-native:$ktorVersion")

        // Kotlin Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:$coroutinesVersion")
    }
}

/**
 * This task will be executed from Xcode builds
 */
val packForXcode by tasks.creating(Sync::class) {
    val targetDir = File(buildDir, "xcode-frameworks")

    /// Selecting the right configuration for the iOS
    /// framework depending on the environment
    /// variables set by Xcode build
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
        .getByName<KotlinNativeTarget>("ios")
        .binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from({ framework.outputDirectory })
    into(targetDir)

    /// generate a helpful ./gradlew wrapper with embedded Java path
    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText("#!/bin/bash\n"
                + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
                + "cd '${rootProject.rootDir}'\n"
                + "./gradlew \$@\n")
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)