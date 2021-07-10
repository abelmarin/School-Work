//
//  ViewController.swift
//  abelm_assignment3
//
//  Created by Abel Marin on 1/26/21.
//

import UIKit

class ViewController: UIViewController {
    
    var firstNum: Int?;

    @IBOutlet weak var label: UILabel!
    
    @IBAction func buttonPressed(_ sender: UIButton) {
        if let labelText: String = label.text {
            if let title = sender.currentTitle {
                label.text = "\(labelText)\(title)"
            }
        } else {
            if let title = sender.currentTitle {
                label.text = "\(title)"
            }
        }
    }
    
    @IBAction func addButton(_ sender: UIButton) {
        if let labelText: String = label.text {
            
            // This if statement essentially checks
            // whether or not the label is composed
            // entirely of numbers
            if let first = Int(labelText) {
                firstNum = first
                label.text = ""
            }
        }
    }
    
    @IBAction func equalsButton(_ sender: UIButton) {
        if firstNum != nil {
            if let labelText: String = label.text {
                
                // This if statement essentially checks
                // whether or not the label is composed
                // entirely of numbers
                if let second = Int(labelText) {
                    let total = firstNum! + second
                    label.text = "\(total)"
                }
            }
        }
    }
    
    
    @IBAction func clearButton(_ sender: UIButton) {
        label.text = nil
        firstNum = nil
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

