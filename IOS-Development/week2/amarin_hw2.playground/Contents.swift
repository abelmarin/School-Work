// Howmework 2
// Abel Marin
import UIKit

// 2. Binary Search implementaion
func rank (key : Int, array : [Int]) -> Int {
    var left = 0
    var right = array.count - 1
    
    while left <= right {
        let mid = Int(floor(Double(left + right) / 2.0))
        
        if array[mid] < key {
            left = mid + 1
        } else if array[mid] > key {
            right = mid - 1
        } else {
            return mid
        }
    }
    
    return -1
}

let oddNumbers = [1, 3, 5, 7, 9, 11, 13, 15]
let evenNumbers = [2, 4, 6, 8, 10, 12, 14, 16]

// Int not at beginning or end of array
rank(key : 13, array : oddNumbers)
rank(key : 14, array : evenNumbers)

// Int at beggining of array
rank(key : 1, array : oddNumbers)
rank(key : 2, array : evenNumbers)

// Int at end of array
rank(key : 15, array : oddNumbers)
rank(key : 16, array : evenNumbers)

// Int not in array
rank(key : 20, array : oddNumbers)
rank(key : 20, array : evenNumbers)



// 3. Franction Class update
class Fraction {
    var numerator: Int = 0
    var denominator: Int = 1
    
    init(_ numerator: Int, over denominator: Int) {
        self.numerator = numerator
        self.denominator = denominator
    }
    
    init() {}
    
    func setTo(numerator: Int, over denominator: Int) {
        self.numerator = numerator
        self.denominator = denominator
    }
    
    func print() {
        Swift.print("\(numerator)/\(denominator)")
    }
    
    func toDouble() -> Double {
        return Double(numerator) / Double(denominator);
    }
    
    func add(_ f: Fraction) -> Fraction {
        let result: Fraction = Fraction()
        result.numerator = numerator * f.denominator + denominator * f.numerator
        result.denominator = denominator * f.denominator
        result.reduce()
        return result
    }
    
    func subtract(_ f: Fraction) -> Fraction {
        let result: Fraction = Fraction()
        result.numerator = numerator * f.denominator - denominator * f.numerator
        result.denominator = denominator * f.denominator
        result.reduce()
        return result
    }
    
    func multiply(_ f: Fraction) -> Fraction {
        let result: Fraction = Fraction()
        result.numerator = numerator * f.numerator
        result.denominator = denominator * f.denominator
        result.reduce()
        return result
    }
    
    func divide(_ f: Fraction) -> Fraction {
        let result: Fraction = Fraction()
        result.numerator = numerator * f.denominator
        result.denominator = denominator * f.numerator
        result.reduce()
        return result
    }
    
    func reduce() {
        var u = abs(numerator)
        var v = denominator
        var r: Int
        while (v != 0) {
            r = u % v; u = v; v = r
        }
        numerator /= u
        denominator /= u
    }
    
}


// In order to verify that the methods work,
// I will run the same opperations on the double form of
// the test fractions.
let f1 = Fraction(1, over: 2)
let f2 = Fraction(3, over: 4)

let f1Double = f1.toDouble()
let f2Double = f2.toDouble()

let f3 = f1.subtract(f2)
let f3Double = f1Double - f2Double
print(f3.toDouble() == f3Double)
print("The fraction form is \(f3.toDouble()) and the double for is \(f3Double)\n")

let f4 = f1.multiply(f2)
let f4Double = f1Double * f2Double
print(f4.toDouble() == f4Double)
print("The fraction form is \(f4.toDouble()) and the double for is \(f4Double)\n")


let f5 = f1.divide(f2)
let f5Double = f1Double / f2Double
print(f5.toDouble() == f5Double)
print("The fraction form is \(f5.toDouble()) and the double for is \(f5Double)")
