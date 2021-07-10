//: [Previous](@previous)

import Foundation

class Rectangle {
    var width = 0, height = 0;
    init() {}
    init(width: Int, height: Int) {
        self.width = width
        self.height = height
    }
    func set(width w : Int, height h: Int) {
        width = w; height = h;
    }
    func area() -> Int {
        return width * height
    }
    func perimeter() -> Int {
        return (width + height) * 2
    }
}

var r1 = Rectangle()
var r2 = Rectangle(width: 5, height: 8)
r1.set(width: 10, height: 20)
r1.area()
r1.perimeter()

class Square : Rectangle {
    
    override init() {
        super.init()
    }
    init(side: Int) {
        super.init(width: side, height: side)
    }
    
    var side: Int {
        get { return width }
        set(side) { set(width: side, height: side) }
    }
    
    var area: Int {
        return side * side
    }
}

var s1 = Square()
var s2 = Square(side: 10)
s1.side = 10
s1.area()
s1.perimeter()

var rect = Rectangle(width: 5, height: 8)
print("Rectangle: w = \(rect.width), h = \(rect.height)")
print("Area = \(rect.area()), Perimeter = \(rect.perimeter()) ")


var square = Square(side: 5)
print("Square: side = \(square.side)")
print("Area = \(square.area()), Perimeter = \(square.perimeter()) ")
print("Area = \(square.area)")

square.side = 10
print("Square: side = \(square.side)")


//: [Next](@next)
