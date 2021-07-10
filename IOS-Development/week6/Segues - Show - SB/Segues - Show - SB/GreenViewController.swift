//
//  GreenViewController.swift
//  Segue - Show - SB
//
//  Created by Xiaoping Jia on 12/21/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class GreenViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    
    @IBOutlet weak var textField: UITextField!
    
    var message: String = "GreenViewController"

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        label.text = message
    }
    
    @IBAction func doneEditing(_ sender: UITextField) {
        sender.resignFirstResponder()
    }
    
    @IBAction func switchToBlue(_ sender: UIBarButtonItem) {
        
        var top: UIViewController = self;
        while top.presentingViewController != nil {
            top = top.presentingViewController!;
        }
        
        if let blue = top as? BlueViewController {
            blue.message = "From GreenViewController"
            if let text = textField.text {
                blue.message += "\nMessage: \(text)"
            }
            
            // necessry for Show segue
            blue.updateView()
        }
        
        top.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func switchToYellow(_ sender: UIBarButtonItem) {
        if let from = presentingViewController as? YellowViewController {
            from.message = "From GreenViewController"
            if let text = textField.text {
                from.message += "\nMessage: \(text)"
            }
            
            // necessry for Show segue
            from.updateView()
        }
        
        dismiss(animated: true, completion: nil)
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
