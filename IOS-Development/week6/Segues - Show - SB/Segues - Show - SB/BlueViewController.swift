//
//  BlueViewController.swift
//  Segue - Show - SB
//
//  Created by Xiaoping Jia on 12/21/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class BlueViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var textField: UITextField!
    
    var message: String = "BlueViewController"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    // update view after dismissing or unwinding Show Segues
    func updateView() {
        label.text = message
    }
    
    @IBAction func doneEditing(_ sender: UITextField) {
        sender.resignFirstResponder()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        if let target = segue.destination as? YellowViewController {
            target.message = "From BlueViewController"
            if let text = textField.text  {
                target.message += "\nMessage: \(text)"
            }
        }
    }
    
    @IBAction func unwindToBlue(_ segue : UIStoryboardSegue) {
        if let from = segue.source as? YellowViewController {
            message = "Unwind from YellowViewController"
            if let text = from.textField.text {
                message += "\nMessage: \(text)"
            }
        } else if let from = segue.source as? GreenViewController {
            message = "Unwind from GreenViewController"
            if let text = from.textField.text {
                message += "\nMessage: \(text)"
            }
        }
        // necessry for Show segue
        updateView()
    }
    
}

