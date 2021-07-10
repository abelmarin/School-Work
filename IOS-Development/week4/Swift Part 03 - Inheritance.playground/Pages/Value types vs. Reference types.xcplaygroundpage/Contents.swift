//: [Previous](@previous)

import Foundation

//: Int is a value type

var a = 0
var b = a
a = 100
print(a)
print(b)

b = 200
print(a)
print(b)


//: Counter is a reference type

class Counter {
    var count = 0
    func increment() {
        count += 1
    }
}

var head = Counter()
var tail = head
head.count = 100
print(head.count)
print(tail.count)

tail.count = 200
print(head.count)
print(tail.count)


//: [Next](@next)
