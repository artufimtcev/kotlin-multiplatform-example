//
//  UINavigationController+Utility.swift
//  GithubSearcher
//
//  Created by [Author].
//  Copyright © 2018 [Company]. All rights reserved.
//

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
// MARK: - Import

import UIKit


// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
// MARK: - Implementation

extension UINavigationController {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Utility
    override open var preferredStatusBarStyle: UIStatusBarStyle  {
        return self.topViewController?.preferredStatusBarStyle ?? .default
    }
}
