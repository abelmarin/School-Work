//
//  ViewController.swift
//  abelm_assignment4
//
//  Created by Abel Marin on 2/1/21.
//

import UIKit
import Foundation

class ViewController: UIViewController {
    
    @IBOutlet weak var powerLabel: UILabel!
    @IBOutlet weak var speakerLabel: UILabel!
    @IBOutlet weak var channelLabel: UILabel!
  
    @IBOutlet weak var powerSwitch: UISwitch!
    @IBOutlet weak var volumeSlider: UISlider!
    @IBOutlet weak var zeroNum: UIButton!
    @IBOutlet weak var oneNum: UIButton!
    @IBOutlet weak var twoNum: UIButton!
    @IBOutlet weak var threeNum: UIButton!
    @IBOutlet weak var fourNum: UIButton!
    @IBOutlet weak var fiveNum: UIButton!
    @IBOutlet weak var sixNum: UIButton!
    @IBOutlet weak var sevenNum: UIButton!
    @IBOutlet weak var eightNum: UIButton!
    @IBOutlet weak var nineNum: UIButton!
    @IBOutlet weak var channelUpButton: UIButton!
    @IBOutlet weak var channelDownButton: UIButton!
    @IBOutlet weak var favoriteSegmentedControl: UISegmentedControl!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        volumeSlider.value = 50
        speakerLabel.text = "\(Int(volumeSlider.value))"
        channelLabel.text = "07"
        favoriteSegmentedControl.selectedSegmentIndex = 0
    }

    @IBAction func powerSwitch(_ sender: UISwitch) {
        powerLabel.text = (sender.isOn ? "On" : "Off")
        let enabled = (sender.isOn == true)
        volumeSlider.isEnabled = enabled
        zeroNum.isEnabled = enabled
        oneNum.isEnabled = enabled
        twoNum.isEnabled = enabled
        threeNum.isEnabled = enabled
        fourNum.isEnabled = enabled
        fiveNum.isEnabled = enabled
        sixNum.isEnabled = enabled
        sevenNum.isEnabled = enabled
        eightNum.isEnabled = enabled
        nineNum.isEnabled = enabled
        channelUpButton.isEnabled = enabled
        channelDownButton.isEnabled = enabled
        favoriteSegmentedControl.isEnabled = enabled
    }
    
    @IBAction func sliderMoved(_ sender: UISlider) {
        speakerLabel.text = "\(Int(sender.value))"
    }
    
    @IBAction func numButtonPressed(_ sender: UIButton) {
        if let labelText: String = channelLabel.text {
            // This if statement makes sure that only values
            // between 1 and 99 inclusive are allowed
            if labelText.count == 2 {
                channelLabel.text = sender.currentTitle
            } else if labelText.count == 1 && labelText != "0" {
                if let title = sender.currentTitle {
                    channelLabel.text = "\(labelText)\(title)"
                }
            } else if labelText.count == 1 && labelText == "0" && sender.currentTitle != "0" {
                if let title = sender.currentTitle {
                    channelLabel.text = "\(labelText)\(title)"
                }
            }
        }
    }
    
    @IBAction func channelUp(_ sender: UIButton) {
        if let labelText: String = channelLabel.text {
            // This if statement makes sure that the channelUp
            // button only works if there is a valid 2 digit value
            // for the channel label
            if labelText.count == 2 {
                if let oldNum = Int(labelText) {
                    if oldNum < 99 {
                        let newNum = oldNum + 1
                        channelLabel.text = String(format: "%02d", newNum)
                    }
                }
            }
        }
    }
    

    @IBAction func channelDown(_ sender: UIButton) {
        if let labelText: String = channelLabel.text {
            if let oldNum = Int(labelText) {
                if oldNum > 1 {
                    let newNum = oldNum - 1
                    channelLabel.text = String(format: "%02d", newNum)
                }
            }
        }
    }
    
    @IBAction func favoriteSelected(_ sender: UISegmentedControl) {
        if let name = sender.titleForSegment(at: sender.selectedSegmentIndex) {
            if name == "ABC" {
                channelLabel.text = "07"
            } else if name == "NBC" {
                channelLabel.text = "08"
            } else if name == "CBS" {
                channelLabel.text = "09"
            } else if name == "FOX" {
                channelLabel.text = "10"
            }


        }
    }
    
}

