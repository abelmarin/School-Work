//
//  DvrViewController.swift
//  abelm_assignment7
//
//  Created by Abel Marin on 2/21/21.
//

import UIKit

class DvrViewController: UIViewController {

    @IBOutlet weak var powerLabel: UILabel!
    @IBOutlet weak var stateLabel: UILabel!
    
    @IBOutlet weak var playLabel: UIButton!
    @IBOutlet weak var stopLabel: UIButton!
    @IBOutlet weak var pauseLabel: UIButton!
    @IBOutlet weak var forwardLabel: UIButton!
    @IBOutlet weak var rewindLabel: UIButton!
    @IBOutlet weak var recordLabel: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        stateLabel.text = "Stopped"
        // Do any additional setup after loading the view.
    }
    
    @IBAction func dvrPowerSwitch(_ sender: UISwitch) {
        powerLabel.text = (sender.isOn ? "On" : "Off")
        stateLabel.text = "Stopped"
        let enabled = (sender.isOn == true)
        playLabel.isEnabled = enabled
        stopLabel.isEnabled = enabled
        pauseLabel.isEnabled = enabled
        forwardLabel.isEnabled = enabled
        rewindLabel.isEnabled = enabled
        recordLabel.isEnabled = enabled
    }
    
    @IBAction func playButton(_ sender: UIButton) {
        if let labelText: String = stateLabel.text {
            if labelText != "Recording" {
                stateLabel.text = "Playing"
            } else {
                let actionPopup = UIAlertController(title: nil, message: "Request Failed", preferredStyle: .actionSheet)
                
                let forceAction =
                    UIAlertAction(title: "Force Request",
                                  style: .destructive) { (action) in
                        let alertController =
                            UIAlertController(title: "Forced Request",
                                              message: "Stopped previous state and changed state to Playing",
                                              preferredStyle: .alert)
                        
                        let cancelAction = UIAlertAction(title: "OK", style: .cancel)
                        
                        alertController.addAction(cancelAction)
                        self.present(alertController,
                                animated: true,
                                completion: nil)
                        
                        self.stateLabel.text = "Playing"
                    }
                
                let cancelAction = UIAlertAction(title: "Cancel Request", style: .cancel)
                
                actionPopup.addAction(forceAction)
                actionPopup.addAction(cancelAction)
                
                present(actionPopup,
                        animated: true,
                        completion: nil)
                
            }
        }
    }
    
    @IBAction func stopButton(_ sender: UIButton) {
        stateLabel.text = "Stopped"
    }
    
    @IBAction func pauseButton(_ sender: UIButton) {
        if let labelText: String = stateLabel.text {
            if labelText == "Playing" && labelText != "Recording" {
                stateLabel.text = "Paused"
            } else {
                let actionPopup = UIAlertController(title: nil, message: "Request Failed", preferredStyle: .actionSheet)
                
                let forceAction =
                    UIAlertAction(title: "Force Request",
                                  style: .destructive) {
                        (action) in
                            let alertController =
                                UIAlertController(title: "Forced Request",
                                                  message: "Stopped previous state and changed state to Paused",
                                                  preferredStyle: .alert)
                            
                            let cancelAction = UIAlertAction(title: "OK", style: .cancel)
                            
                            alertController.addAction(cancelAction)
                            self.present(alertController,
                                    animated: true,
                                    completion: nil)
                            
                            self.stateLabel.text = "Paused"
                    }
                
                let cancelAction = UIAlertAction(title: "Cancel Request", style: .cancel)
                
                actionPopup.addAction(forceAction)
                actionPopup.addAction(cancelAction)
                
                present(actionPopup,
                        animated: true,
                        completion: nil)
            }
        }
    }
    
    @IBAction func forwardButton(_ sender: UIButton) {
        if let labelText: String = stateLabel.text {
            if labelText == "Playing" && labelText != "Recording" {
                stateLabel.text = "Fast forwarding"
            } else {
                let actionPopup = UIAlertController(title: nil, message: "Request Failed", preferredStyle: .actionSheet)
                
                let forceAction =
                    UIAlertAction(title: "Force Request",
                                  style: .destructive) {
                        (action) in
                            let alertController =
                                UIAlertController(title: "Forced Request",
                                                  message: "Stopped previous state and changed state to Fast forwarding",
                                                  preferredStyle: .alert)
                        
                            let cancelAction = UIAlertAction(title: "OK", style: .cancel)
                        
                            alertController.addAction(cancelAction)
                            self.present(alertController,
                                    animated: true,
                                    completion: nil)
                        
                            self.stateLabel.text = "Fast forwarding"
                    }
                
                let cancelAction = UIAlertAction(title: "Cancel Request", style: .cancel)
                
                actionPopup.addAction(forceAction)
                actionPopup.addAction(cancelAction)
                
                present(actionPopup,
                        animated: true,
                        completion: nil)
            }
        }
    }
    
    @IBAction func rewindButton(_ sender: UIButton) {
        if let labelText: String = stateLabel.text {
            if labelText == "Playing" && labelText != "Recording" {
                stateLabel.text = "Fast rewinding"
            } else {
                let actionPopup = UIAlertController(title: nil, message: "Request Failed", preferredStyle: .actionSheet)
                
                let forceAction =
                    UIAlertAction(title: "Force Request",
                                  style: .destructive) { (action) in
                        let alertController =
                            UIAlertController(title: "Forced Request",
                                              message: "Stopped previous state and changed state to Fast rewinding",
                                              preferredStyle: .alert)
                        
                        let cancelAction = UIAlertAction(title: "OK", style: .cancel)
                        
                        alertController.addAction(cancelAction)
                        self.present(alertController,
                                animated: true,
                                completion: nil)
                        
                        self.stateLabel.text = "Fast rewinding"
                    }
                
                let cancelAction = UIAlertAction(title: "Cancel Request", style: .cancel)
                
                actionPopup.addAction(forceAction)
                actionPopup.addAction(cancelAction)
                
                present(actionPopup,
                        animated: true,
                        completion: nil)
            }
        }
    }
    
    @IBAction func recordButton(_ sender: UIButton) {
        if let labelText: String = stateLabel.text {
            if labelText == "Stopped" {
                stateLabel.text = "Recording"
            } else {
                let actionPopup = UIAlertController(title: nil, message: "Request Failed", preferredStyle: .actionSheet)
                
                let forceAction =
                    UIAlertAction(title: "Force Request",
                                  style: .destructive) { (action) in
                        let alertController =
                            UIAlertController(title: "Forced Request",
                                              message: "Stopped previous state and changed state to Recording",
                                              preferredStyle: .alert)
                        
                        let cancelAction = UIAlertAction(title: "OK", style: .cancel)
                        
                        alertController.addAction(cancelAction)
                        self.present(alertController,
                                animated: true,
                                completion: nil)
                        
                        self.stateLabel.text = "Recording"
                    }
                
                let cancelAction = UIAlertAction(title: "Cancel Request", style: .cancel)
                
                actionPopup.addAction(forceAction)
                actionPopup.addAction(cancelAction)
                
                present(actionPopup,
                        animated: true,
                        completion: nil)
            }
        }
    }
    

}
