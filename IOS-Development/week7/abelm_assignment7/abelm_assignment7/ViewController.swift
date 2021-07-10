//
//  ViewController.swift
//  abelm_assignment7
//
//  Created by Abel Marin on 2/21/21.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var newSegmentedControl: UISegmentedControl!
    @IBOutlet weak var newFavLabel: UITextField!
    @IBOutlet weak var newChannelLabel: UILabel!
    @IBOutlet weak var newChannelStepper: UIStepper!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        newChannelStepper.value = 50
        newChannelLabel.text = String(format: "%02d", Int(newChannelStepper.value))
    }

    @IBAction func changeChannel(_ sender: UIStepper) {
        newChannelLabel.text = String(format: "%02d", Int(newChannelStepper.value))
    }
    
    @IBAction func favoriteLabelChanged(_ sender: UITextField) {
        if let labelText: String = newFavLabel.text {
            if labelText.count > 4 || labelText.count == 0 {
                var title: String
                
                if labelText.count > 4 {
                    title = "Label Too Long"
                } else {
                    title = "Label Too Short"
                }
                
                let alertController =
                    UIAlertController(title: title,
                                      message: "You must enter a label of length 1-4",
                                      preferredStyle: .alert)
                
                let cancelAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
                alertController.addAction(cancelAction)
                newFavLabel.text = ""
                
                present(alertController,
                        animated: true,
                        completion: nil)
                
            }
        }
    }
    
    @IBAction func cancelBtn(_ sender: UIButton) {
        newFavLabel.text = ""
        newSegmentedControl.selectedSegmentIndex = 0
        newFavLabel.resignFirstResponder()

    }
    
    @IBAction func backgroundTouched(_ sender: UIControl) {
        newFavLabel.resignFirstResponder()
    }
    
    @IBAction func saveBtn(_ sender: UIButton) {
        
            
        if let textFieldText: String = newFavLabel.text {
            if textFieldText.count > 4 || textFieldText.count == 0 {
                var title: String
                
                if textFieldText.count > 4 {
                    title = "Label Too Long"
                } else {
                    title = "Label Too Short"
                }
                
                let alertController =
                    UIAlertController(title: title,
                                      message: "You must enter a label of length 1-4",
                                      preferredStyle: .alert)
                
                let cancelAction = UIAlertAction(title: "OK", style: .cancel, handler: nil)
                alertController.addAction(cancelAction)
                newFavLabel.text = ""
                
                present(alertController,
                        animated: true,
                        completion: nil)
                return
            }
            
            currentChannelList.set(
                label: textFieldText,
                channel: String(format: "%02d", Int(newChannelStepper.value)),
                arrayPosition: newSegmentedControl.selectedSegmentIndex)
        }
        
        newFavLabel.resignFirstResponder()
        newFavLabel.text = ""
        newSegmentedControl.selectedSegmentIndex = 0
        
    }
    
}

