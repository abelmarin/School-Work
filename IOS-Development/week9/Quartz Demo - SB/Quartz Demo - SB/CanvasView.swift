//
//  CanvasView.swift
//  Quartz Demo - SB
//
//  Created by Xiaoping Jia on 12/24/19.
//  Copyright © 2019 DePaul University. All rights reserved.
//

import UIKit

class CanvasView: UIView {

    // Only override draw() if you perform custom drawing.
    // An empty implementation adversely affects performance during animation.
    override func draw(_ rect: CGRect) {
        // Drawing code
        if let context = UIGraphicsGetCurrentContext() {

             // Drawing lines
             context.move(to: CGPoint(x: 20, y: 40))
             context.addLine(to: CGPoint(x: 120, y: 90))
             context.strokePath()
             
             context.setLineWidth(4)
             context.move(to: CGPoint(x: 60, y: 40))
             context.addLine(to: CGPoint(x: 160, y: 90))
             context.strokePath()
             
             // dashed lines
             let shortDash : [CGFloat] = [ 4, 4 ]
             context.setLineDash(phase: 0, lengths: shortDash)
             context.move(to: CGPoint(x: 100, y: 40))
             context.addLine(to: CGPoint(x: 200, y: 90))
             context.strokePath()
             
             context.setLineWidth(2)
             let longDash : [CGFloat] = [ 8, 2 ]
             context.setLineDash(phase:0, lengths: longDash)
             context.move(to: CGPoint(x: 140, y: 40))
             context.addLine(to: CGPoint(x: 240, y: 90))
             context.strokePath()
             
             // Drawing ovals and circles
             context.setStrokeColor(UIColor.blue.cgColor)
             context.setFillColor(UIColor.red.cgColor)
             context.setLineDash(phase:0, lengths: [])
             
             let rect1 = CGRect(x: 20, y: 100, width: 80, height: 60)
             context.strokeEllipse(in: rect1)
             
             context.setLineWidth(4)
             let rect2 = CGRect(x: 120, y: 100, width: 80, height: 60)
             context.fillEllipse(in: rect2)
             context.strokeEllipse(in: rect2)
             
             let rect3 = CGRect(x: 220, y: 100, width: 60, height: 60)
             context.fillEllipse(in: rect3)
             
             // Drawing rectangles and squares
             context.setStrokeColor(UIColor.green.cgColor)
             context.setFillColor(UIColor.yellow.cgColor)
             context.setLineWidth(2)
             
             let rect4 = CGRect(x: 20, y: 180, width: 80, height: 60)
             context.stroke(rect4)
             
             context.setLineWidth(4)
             let rect5 = CGRect(x: 120, y: 180, width: 80, height: 60)
             context.fill(rect5)
             context.stroke(rect5)
             
             let rect6 = CGRect(x: 220, y: 180, width: 60, height: 60)
             context.fill(rect6)
             
             // Drawing path
             context.setStrokeColor(UIColor.blue.cgColor)
             context.setLineWidth(2)
             
             context.move(to: CGPoint(x: 100, y: 250))
             context.addLine(to: CGPoint(x: 150, y: 300))
             context.addLine(to: CGPoint(x: 100, y: 350))
             context.addLine(to: CGPoint(x: 50, y: 300))
             context.closePath()
             context.strokePath()
             
             // Drawing an arc
             context.addArc(center: CGPoint(x: 250, y: 300),
                            radius: 50,
                            startAngle: 0,
                            endAngle: CGFloat(Double.pi),
                            clockwise: true)
             context.strokePath()
             
             // Drawing a quadratic Bézier curve
             context.move(to: CGPoint(x: 20, y: 350))
             context.addQuadCurve(to: CGPoint(x: 170, y: 350),
                                  control: CGPoint(x: 100, y: 450))
             context.strokePath()
             
             // Drawing a cubic Bézier curve
             context.move(to: CGPoint(x: 170, y: 400))
             context.addCurve(to: CGPoint(x: 320, y: 350),
                              control1: CGPoint(x: 220, y: 420),
                              control2: CGPoint(x: 270, y: 330))
             context.strokePath()
    
             // Drawing an image
             if let image = UIImage(named: "Chicago") {
                 let rect = CGRect(x: 20, y: 420, width: 150, height: 100)
                 //image.draw(at: CGPoint(x: 20, y: 420))  // draw at full size
                 image.draw(in: rect)
             }
             
             // Drawing text
             let text =  "Hello Quartz 2D!"
             text.draw(at: CGPoint(x: 20, y: 540), withAttributes: nil) // top-left of text
             
            let textAttr : [NSAttributedString.Key : Any] = [
                 .foregroundColor : UIColor.magenta,
                 .font : UIFont(name: "Papyrus", size: 24)!
             ]
             text.draw(at: CGPoint(x: 20, y: 560), withAttributes: textAttr)
         }
    }

}
