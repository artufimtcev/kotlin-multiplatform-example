/**
 * Created by [Author].
 */

package io.kotlin.everywhere.activity

import android.widget.TextView
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.view.View
import android.widget.Button
import io.kotlin.everywhere.R


class WelcomeActivity: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, WelcomeActivity::class.java)
		}
	}
	
	private lateinit var groupButton: Button
	private lateinit var repositorySearcherTextView: TextView
	private lateinit var githubTextView: TextView
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.welcome_activity)
		this.init()
	}
	
	private fun init() {
	
		// Configure Group component
		groupButton = this.findViewById(R.id.group_button)
		groupButton.setOnClickListener({ view ->
			this.onGroupPressed()
		})
		
		// Configure Repository Searcher component
		repositorySearcherTextView = this.findViewById(R.id.repository_searcher_text_view)
		
		// Configure GitHub component
		githubTextView = this.findViewById(R.id.github_text_view)
	}
	
	fun onGroupPressed() {
	
		this.startRepositoriesActivity()
	}
	
	private fun startRepositoriesActivity() {
	
		this.startActivity(RepositoriesActivity.newIntent(this))
	}
}
