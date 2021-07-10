//
//  YellowViewController.swift
//  Segue - Show - SB
//
//  Created by Xiaoping Jia on 12/21/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class YellowViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    
    @IBOutlet weak var textField: UITextField!
    
    var message: String = "YellowViewController"
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func doneEditing(_ sender: UITextField) {
        sender.resignFirstResponder()
    }
    
    @IBAction func switchToBlue(_ sender: UIBarButtonItem) {
        if let from = presentingViewController as? BlueViewController {
            from.message = "From YellowViewController"
            if let text = textField.text {
                from.message += "\nMessage: \(text)"
            }
            // necessry for Show segue 
            from.updateView()
        }
        
        dismiss(animated: true, completion: nil)
    }

    override func viewWillAppear(_ animated: Bool) {
        label.text = message
    }
    
    // update view after dismissing or unwinding Show Segues
    func updateView() {
        label.text = message
    }
    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        if let target = segue.destination as? GreenViewController {
            target.message = "From YellowViewController"
            if let text = textField.text {
                target.message += "\nMessage: \(text)"
            }
        }
    }
    
}
