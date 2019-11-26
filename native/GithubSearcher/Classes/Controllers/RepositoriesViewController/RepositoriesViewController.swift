//
//  RepositoriesViewController.swift
//  GithubSearcher
//
//  Created by [Author].
//  Copyright © 2018 [Company]. All rights reserved.
//

// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
// MARK: - Import

import UIKit
import core


// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
// MARK: - Implementation

class RepositoriesViewController: UIViewController {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Properties

    @IBOutlet weak var viewTableView: UITableView!
    @IBOutlet weak var searchView: UIView!
    @IBOutlet weak var searchTextField: UITextField!
    
    let viewModel = RepositoriesViewModel()
    

    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Lifecycle

    override public func viewDidLoad()  {
        super.viewDidLoad()
        self.setupComponents()
        self.setupUI()
        self.setupGestureRecognizers()
        self.setupLocalization()
        
        self.searchTextField.addTarget(self, action: #selector(self.onTextChanged(textField:)), for: .editingChanged)
        
        // Do any additional setup after loading the view, typically from a nib.
        self.viewModel.onDataUpdated = { [unowned self] _ in
            self.viewTableView.reloadData()
        }
        
        self.viewModel.onError = { throwable in
            throwable.printStackTrace()
        }
    }

    override public func viewWillAppear(_ animated: Bool)  {
        super.viewWillAppear(animated)
        
        // Navigation bar, if any
        self.navigationController?.setNavigationBarHidden(false, animated: true)
    }


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Setup

    private func setupComponents()  {
        // Setup viewTableView
        self.viewTableView.separatorStyle = .none
        
        // Setup searchView
        self.searchView.layer.borderColor = UIColor(red: 0.819, green: 0.835, blue: 0.856, alpha: 1).cgColor /* #D1D5DA */
        self.searchView.layer.borderWidth = 1
        
        self.searchView.layer.cornerRadius = 8
        self.searchView.layer.masksToBounds = true
        
    }

    private func setupUI()  {
        // Hide the back button
        self.navigationItem.hidesBackButton = true
        self.navigationController?.setNavigationBarHidden(false, animated: true)
        self.navigationItem.title = "Search Repos"
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
        return .lightContent
    }
    
    
    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---
    // MARK: - Text Change
    
    @objc func onTextChanged(textField: UITextField) {
        self.viewModel.query = textField.text ?? ""
    }
}


// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
// MARK: - Extension RepositoriesViewController

extension RepositoriesViewController: UITableViewDataSource  {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Methods
    func numberOfSections(in tableView: UITableView) -> Int  {
        return 1
    }

    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int  {
        return self.viewModel.lastDownloadedRepos.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell  {
        let cell = tableView.dequeueReusableCell(withIdentifier: "ViewThreeTableViewCell", for: indexPath) as! ViewThreeTableViewCell
        self.configure(viewThreeTableViewCell: cell, atIndexPath: indexPath)
        return cell
    }

    public func configure(viewThreeTableViewCell cell: ViewThreeTableViewCell, atIndexPath indexPath: IndexPath)  {
        
        let repo = self.viewModel.lastDownloadedRepos[indexPath.item]
        
        // Further configure cell
        cell.repoNameLabel.text = repo.name
        cell.authorLabel.text = "Owner: \(repo.owner.name)"
        cell.repoLinkLabel.text = repo.url
        cell.descriptionLabel.text = repo.userDescription ?? "No description provided"
    }
}


// --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
// MARK: - Extension RepositoriesViewController

extension RepositoriesViewController: UITableViewDelegate  {


    // --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- 
    // MARK: - Methods
    public func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath)  {
        print("Row selected at index \(indexPath)")
    }

    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat  {
        if (0..<10).contains(indexPath.row) {
            return 167
        }
        
        return 0
    }
}


extension RepositoriesViewController: UITextFieldDelegate  {
  
}
