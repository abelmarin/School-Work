//
//  ViewController.swift
//  abelm_assignment5
//
//  Created by Abel Marin on 2/3/21.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var descriptionText: UITextField!
    @IBOutlet weak var quantityText: UITextField!
    
    @IBOutlet weak var itemsListLabel: UILabel!
        
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        itemsListLabel.lineBreakMode = .byWordWrapping

    }

    @IBAction func backgroundTouched(_ sender: UIControl) {
        descriptionText.resignFirstResponder()
        quantityText.resignFirstResponder()
    }
    
    
    @IBAction func editEnded(_ sender: UITextField) {
        sender.resignFirstResponder()
    }
    
    @IBAction func createNewList(_ sender: UIButton) {
        descriptionText.text = ""
        quantityText.text = ""
        descriptionText.resignFirstResponder()
        quantityText.resignFirstResponder()
        itemsListLabel.text = "No Items"
    }
    
    @IBAction func createNewItem(_ sender: UIButton) {
        descriptionText.text = ""
        quantityText.text = ""
        descriptionText.resignFirstResponder()
        quantityText.resignFirstResponder()
    }
    
    @IBAction func addItem(_ sender: UIButton) {
        // This tests to see if any of the input values
        // are not valid
        var alertMessege:String = ""
        if descriptionText.text == "" {
            alertMessege += "There is no Description\n"
        }
        if quantityText.text == "" {
            alertMessege += "There is no Quantity\n"
        } else if !isStringAnInt(string: quantityText.text) {
            alertMessege += "Quantity is not an integer\n"
        }
        
        if alertMessege != "" {
            let title = "Error!"
            let alertController =
                UIAlertController(title: title,
                                  message: alertMessege,
                                  preferredStyle: .alert)
            let cancelAction =
                UIAlertAction(title: "OK",
                              style: .cancel,
                              handler: nil)
            alertController.addAction(cancelAction)
            present(alertController,
                    animated: true,
                    completion: nil)
            return
        }
        
        if let itemsListUnpack: String = itemsListLabel.text {
            var newList = ""
            // this if statement checks to see if there
            // are no items
            if itemsListUnpack != "No Items" {
                newList += "\(itemsListUnpack)\n"
            }
            if let quantityUnpack: String = quantityText.text {
                newList += "\(quantityUnpack)x "
            }
            if let descriptionUnpack: String = descriptionText.text {
                newList += "\(descriptionUnpack)"
            }
            itemsListLabel.text = newList
        }
        
    }
    
    func isStringAnInt(string: String?) -> Bool {
        if let unpackStr:String = string {
            return Int(unpackStr) != nil
        }
        return false
    }
    
}

