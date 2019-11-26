//
//  ViewThreeTableViewCell.swift
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

class ViewThreeTableViewCell: UITableViewCell {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Properties

    @IBOutlet weak var repoItemView: UIView!
    @IBOutlet weak var repoLinkLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    @IBOutlet weak var authorLabel: UILabel!
    @IBOutlet weak var repoNameLabel: UILabel!


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Setup

    override public func awakeFromNib()  {
        // Configure SN Generated code
        super.awakeFromNib()
        
        self.setupComponents()
    }

    private func setupComponents()  {
        // Selection
        self.selectedBackgroundView = UIView()
        self.selectedBackgroundView?.backgroundColor = UIColor(red: 0.85, green: 0.85, blue: 0.85, alpha: 1) /* #D9D9D9 */
        
        // Setup repoItemView
        self.repoItemView.layer.borderColor = UIColor(red: 0.819, green: 0.835, blue: 0.856, alpha: 1).cgColor /* #D1D5DA */
        self.repoItemView.layer.borderWidth = 1
        
        self.repoItemView.layer.cornerRadius = 8
        self.repoItemView.layer.masksToBounds = true
        
        // Setup repoLinkLabel
        let repoLinkLabelAttrString = NSMutableAttributedString(string: "https://github.com/dtrupenn/Tetris", attributes: [
            .font : UIFont(name: "Roboto-Regular", size: 12)!,
            .foregroundColor : UIColor(red: 0.01, green: 0.4, blue: 0.84, alpha: 1),
            .kern : 0.02,
            .paragraphStyle : NSMutableParagraphStyle(alignment: .left, lineHeight: nil, paragraphSpacing: 0)
        ])
        self.repoLinkLabel.attributedText = repoLinkLabelAttrString
        
        // Setup descriptionLabel
        let descriptionLabelAttrString = NSMutableAttributedString(string: "A C implementation of Tetris using Pennsim through LC4", attributes: [
            .font : UIFont(name: "Roboto-Regular", size: 14)!,
            .foregroundColor : UIColor(red: 0.14, green: 0.16, blue: 0.18, alpha: 1),
            .kern : 0.02,
            .paragraphStyle : NSMutableParagraphStyle(alignment: .left, lineHeight: nil, paragraphSpacing: 0)
        ])
        self.descriptionLabel.attributedText = descriptionLabelAttrString
        
        // Setup authorLabel
        let authorLabelAttrString = NSMutableAttributedString(string: "Author: dtrupenn", attributes: [
            .font : UIFont(name: "Roboto-Light", size: 14)!,
            .foregroundColor : UIColor(red: 0.62, green: 0.65, blue: 0.68, alpha: 1),
            .kern : 0.02,
            .paragraphStyle : NSMutableParagraphStyle(alignment: .center, lineHeight: nil, paragraphSpacing: 0)
        ])
        self.authorLabel.attributedText = authorLabelAttrString
        
        // Setup repoNameLabel
        let repoNameLabelAttrString = NSMutableAttributedString(string: "Some Awesome GitHub Repo", attributes: [
            .font : UIFont(name: "Roboto-Bold", size: 18)!,
            .foregroundColor : UIColor(red: 0.14, green: 0.16, blue: 0.18, alpha: 1),
            .kern : 0.03,
            .paragraphStyle : NSMutableParagraphStyle(alignment: .center, lineHeight: nil, paragraphSpacing: 0)
        ])
        self.repoNameLabel.attributedText = repoNameLabelAttrString
        
    }

    private func setupLocalization()  {
    
    }
}
