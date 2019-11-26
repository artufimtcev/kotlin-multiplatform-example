//
//  WelcomeViewController.swift
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

class WelcomeViewController: UIViewController {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Properties

    @IBOutlet weak var loginButtonButton: SupernovaButton!
    @IBOutlet weak var subtitleLabel: UILabel!
    @IBOutlet weak var titleLabel: UILabel!


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Lifecycle

    override public func viewDidLoad()  {
        super.viewDidLoad()
        self.setupComponents()
        self.setupUI()
        self.setupGestureRecognizers()
        self.setupLocalization()
        
        // Do any additional setup after loading the view, typically from a nib.
    }

    override public func viewWillAppear(_ animated: Bool)  {
        super.viewWillAppear(animated)
        
        // Navigation bar, if any
        self.navigationController?.setNavigationBarHidden(true, animated: true)
    }


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Setup

    private func setupComponents()  {
        // Setup loginButtonButton
        self.loginButtonButton.snImageTextSpacing = 10
        
        // Setup subtitleLabel
        let subtitleLabelAttrString = NSMutableAttributedString(string: "Repository Searcher", attributes: [
            .font : UIFont(name: "Roboto-Bold", size: 18)!,
            .foregroundColor : UIColor(red: 0.35, green: 0.38, blue: 0.41, alpha: 1),
            .kern : 0.03,
            .paragraphStyle : NSMutableParagraphStyle(alignment: .center, lineHeight: nil, paragraphSpacing: 0)
        ])
        self.subtitleLabel.attributedText = subtitleLabelAttrString
        
        // Setup titleLabel
        let titleLabelAttrString = NSMutableAttributedString(string: "GitHub", attributes: [
            .font : UIFont(name: "Roboto-Bold", size: 56)!,
            .foregroundColor : UIColor(red: 0.14, green: 0.16, blue: 0.18, alpha: 1),
            .kern : 0.09,
            .paragraphStyle : NSMutableParagraphStyle(alignment: .center, lineHeight: nil, paragraphSpacing: 0)
        ])
        self.titleLabel.attributedText = titleLabelAttrString
        
    }

    private func setupUI()  {
        let navigationBar = self.navigationController!.navigationBar
        
        navigationBar.barTintColor = UIColor(red: 0.14, green: 0.16, blue: 0.18, alpha: 1)
        navigationBar.tintColor = UIColor(red: 0, green: 0, blue: 0, alpha: 0)
        navigationBar.titleTextAttributes = [
            NSAttributedString.Key.font : UIFont(name: "Roboto-Regular", size: 17)!,
            NSAttributedString.Key.foregroundColor : UIColor(red: 1, green: 1, blue: 1, alpha: 1),
        ]
        
        self.navigationController?.setNavigationBarHidden(true, animated: true)
    }

    private func setupGestureRecognizers()  {
    
    }

    private func setupLocalization()  {
    
    }


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Status Bar

    override public var prefersStatusBarHidden: Bool  {
        return true
    }

    override public var preferredStatusBarStyle: UIStatusBarStyle  {
        return .default
    }


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Actions

    @IBAction public func onLoginButtonPressed(_ sender: UIButton)  {
        self.performSegue(withIdentifier: "Push Repositories", sender: nil)
    }
}
