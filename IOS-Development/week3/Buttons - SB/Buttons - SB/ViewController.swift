//
//  ViewController.swift
//  Buttons - SB
//
//  Created by Xiaoping Jia on 12/20/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    
    
    @IBAction func buttonPressed(_ sender: UIButton) {
        if let title = sender.currentTitle {
            label.text = "\(title) pressed"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

}

