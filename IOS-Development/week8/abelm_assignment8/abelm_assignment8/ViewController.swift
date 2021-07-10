//
//  ViewController.swift
//  abelm_assignment8
//
//  Created by Abel Marin on 2/28/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var bodyLabel: UILabel!
    var winner: Winner?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        if let w = winner {
            titleLabel.text = w.name
            bodyLabel.text = w.longDescription
        }
    }


}

