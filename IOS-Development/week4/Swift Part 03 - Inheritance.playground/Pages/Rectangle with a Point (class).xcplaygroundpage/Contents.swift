//: [Previous](@previous)

import Foundation

class Point {
    var x = 0, y = 0;
    init() {}
    init(x: Int, y:Int) {
        self.x = x
        self.y = y
    }
    func set(x: Int, y: Int) {
        self.x = x
        self.y = y
    }
}

class Rectangle {
    var width = 0, height = 0;
    var origin: Point
    init() {
        origin = Point()
    }
    init(width: Int, height: Int) {
        origin = Point()
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

class Square : Rectangle {
    
    override init() {
        super.init()
    }
    init(side: Int) {
        super.init(width: side, height: side)
    }
    
    var side: Int {
        get { return width }
        set { set(width: newValue, height: newValue) }
    }
    
    var area: Int {
        return side * side
    }
}

var rect = Rectangle(width: 5, height: 8)
var p = Point()
print("Rectangle: w = \(rect.width), h = \(rect.height)")
print("Area = \(rect.area()), Perimeter = \(rect.perimeter()) ")

var square = Square(side: 5)
print("Square: s = \(square.side)")
print("Area = \(square.area()), Perimeter = \(square.perimeter()) ")
print("Area = \(square.area)")

var p1 = Point(x: 100, y:200)
rect.origin = p1
print("Rectangle origin at: (\(rect.origin.x), \(rect.origin.y))")
p1.set(x: 50, y: 50)
print("Rectangle origin at: (\(rect.origin.x), \(rect.origin.y))")



//: [Next](@next)
