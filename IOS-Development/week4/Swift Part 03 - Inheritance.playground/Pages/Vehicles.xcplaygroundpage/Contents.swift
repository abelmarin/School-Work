//: Playground - noun: a place where people can play

import UIKit

class Vehicle {
    var speed: Int = 0
    func move() {
        print("Moving")
    }
}

class Car : Vehicle {
    func drive() {
        speed = 35
        print("Driving")
    }
    override func move() {
        drive()
    }
}

class Airplane : Vehicle {
    func fly() {
        speed = 100
        print("Flying")
    }
    override func move() {
        fly()
    }
}

// static typing

var myCar = Car()
myCar.drive()
myCar.move()


var myAirplane = Airplane()
myAirplane.fly()
myAirplane.move()


// dynamic binding
var vehicle: Vehicle = myCar
vehicle.move()
vehicle = myAirplane
vehicle.move()


//vehicle.fly() // type error
(vehicle as! Airplane).fly() // okay, but unsafe

//vehicle = myCar
//(vehicle as! Airplane).fly() // crash

if vehicle is Airplane {
    (vehicle as! Airplane).fly()
} else if vehicle is Car {
    (vehicle as! Car).drive()
}

if let airplane = vehicle as? Airplane {
    airplane.fly()
} else if let car = vehicle as? Car {
    car.drive()
}

var object: AnyObject = myCar
// object.move() // type error

if let airplane = object as? Airplane {
    airplane.fly()
} else if let car = object as? Car {
    car.drive()
}

