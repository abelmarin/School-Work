//: Playground - noun: a place where people can play

import UIKit

let inputString = "50"
//let inputString = "Fifty"
let num = Int(inputString)
print(num)

if num != nil {
    print("The input = \(num!)")
} else {
    print("The input is not an integer")
}

if let n = Int(inputString) {
    print("The input = \(n)")
} else {
    print("The input is not an integer")
}

let v = Int(inputString) ?? 0

var word = "100"
var mynum = Int(word) ?? 0
word = "five"
mynum = Int(word) ?? 0

class Counter {
    var count = 0
    func increment() {
        count += 1
    }
}

var i: Int = 0
var s: String = "A string"
var c: Counter = Counter()

// nil is not allowed in regualr types
// Compile error: nil cannot be assigned to type T
//i = nil
//s = nil
//c = nil

var n : Int?
var str: String?
var counter: Counter?

// Error: value of optional type 'Int?' not unwrapped
//let j: Int = 100 + n


n = 100
str = "A string"
counter = Counter()

n = nil
str = nil
counter = nil


// error: binary operator '+=' cannot be applied to operands of type 'Int?' and 'Int'
//n += 20 


n == 100
n == 0

n = nil

let zero = 0

n = 0
n == zero

counter = Counter()
// counter.count // error

if let c1 = counter {
    c1.count
    c1.count = 10
    c1.increment()
    c1.count
}

counter?.increment()
counter?.count
counter?.count = 10
counter?.count

counter = nil

counter = Counter()

var c2 : Counter! = counter

c2.count
c2.increment()
c2.count

c2 = nil // allowed but wrong

//c2.count // crash



