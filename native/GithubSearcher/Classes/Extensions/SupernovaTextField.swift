//
//  SupernovaTextField.swift
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

class SupernovaTextField: UITextField {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Properties



    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Insets
    public var snContentInsets: UIEdgeInsets = UIEdgeInsets(top: 0, left: 0, bottom: 0, right: 0) {
        didSet {
            self.setNeedsLayout()
        }
    }

    override func textRect(forBounds bounds: CGRect) -> CGRect  {
        return UIEdgeInsetsInsetRect(super.textRect(forBounds: bounds), self.snContentInsets)
    }

    override func editingRect(forBounds bounds: CGRect) -> CGRect  {
        return UIEdgeInsetsInsetRect(super.editingRect(forBounds: bounds), self.snContentInsets)
    }

    override func clearButtonRect(forBounds bounds: CGRect) -> CGRect  {
        var rect = super.clearButtonRect(forBounds: bounds)
        rect.origin.x -= self.snContentInsets.right
        rect.origin.y += (self.snContentInsets.top - self.snContentInsets.bottom) / 2
        return rect
    }
}
