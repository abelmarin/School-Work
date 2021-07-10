//
//  ViewController.swift
//  Text Input - SB
//
//  Created by Xiaoping Jia on 12/21/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var textView: UITextView!
    
    @IBOutlet var textFields: [UITextField]!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBAction func editEnded(_ sender: UITextField) {
        sender.resignFirstResponder()
    }
    
    @IBAction func backgroundTouched(_ sender: UIControl) {
        for tf in textFields {
            tf.resignFirstResponder()
        }
        textView.resignFirstResponder()
    }
    
    @IBAction func clearAction() {
        for tf in textFields {
            tf.text = ""
        }
        textView.text = ""
    }
    
    let labels = [
        "Default",
        "URL",
        "Email",
        "Phone",
        "Number",
        "Decimal",
        "Password"
    ]
    
    @IBAction func doneAction() {
        var input : [Int:String] = [:]
        for tf in textFields {
            tf.resignFirstResponder()
            input[tf.tag] = tf.text ?? ""
        }
        
        var message = ""
        for (i, label) in labels.enumerated() {
            if let text = input[i] {
                message += "\n\(label): \(text)"
            }
        }
        if let text = textView.text {
            message += "\nMessage: \(text)"
        }
        
        let title = "Text Input"
        let alertController =
            UIAlertController(title: title,
                              message: message,
                              preferredStyle: .alert)
        
        // Create the action.
        let cancelAction =
            UIAlertAction(title: "OK",
                          style: .cancel,
                          handler: nil)
        alertController.addAction(cancelAction)
        present(alertController,
                animated: true,
                completion: nil)
    }
    
}

