//
//  ViewController.swift
//  Controls - SB
//
//  Created by Xiaoping Jia on 12/20/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var switchLabel: UILabel!
    @IBOutlet weak var sliderValue: UILabel!
    @IBOutlet weak var stepperValue: UILabel!
    
    @IBOutlet weak var leftSwitch: UISwitch!
    @IBOutlet weak var rightSwitch: UISwitch!
    
    @IBOutlet weak var slider: UISlider!
    @IBOutlet weak var stepper: UIStepper!
    
    @IBOutlet weak var image: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        nameLabel.text = "Botticelli"
        sliderValue.text = "Value: \(Int(slider.value))"
        stepperValue.text = "Value: \(Int(stepper.value))"
    }
    
    @IBAction func nameSelected(_ sender: UISegmentedControl) {
        if let name = sender.titleForSegment(at: sender.selectedSegmentIndex) {
            nameLabel.text = name
            if let img = UIImage(named:name) {
                image.image = img
            }
        }
    }
    
    @IBAction func switchToggled(_ sender: UISwitch) {
        switchLabel.text = "Switch " + (sender.isOn ? "on" : "off")
        leftSwitch.setOn(sender.isOn, animated: true)
        rightSwitch.setOn(sender.isOn, animated: true)
    }
    
    @IBAction func sliderMoved(_ sender: UISlider) {
        sliderValue.text = "Value: \(Int(sender.value))"
    }
    
    
    @IBAction func stepperChanged(_ sender: UIStepper) {
        stepperValue.text = "Value: \(Int(sender.value))"
    }
    
    @IBAction func controlDisabled(_ sender: UISegmentedControl) {
        let enabled = (sender.selectedSegmentIndex == 1)
        leftSwitch.isEnabled = enabled
        rightSwitch.isEnabled = enabled
        slider.isEnabled = enabled
        stepper.isEnabled = enabled
    }
    
    @IBAction func controlHidden(_ sender: UISegmentedControl) {
        let hidden = (sender.selectedSegmentIndex == 0)
        leftSwitch.isHidden = hidden
        rightSwitch.isHidden = hidden
        slider.isHidden = hidden
        stepper.isHidden = hidden
    }

}

