# Abel Marin
# Chapter 8
class BankAccount:

    def __init__(self, balance=0):
        self.b = balance

    def withdraw(self, amount):
        self.b -= amount

    def deposit(self, amount):
        self.b += amount

    def balance(self):
        return self.b

import math
class Polygon:

    def __init__(self, sides, length_of_sides):
        self.n = sides
        self.s = length_of_sides

    def perimeter(self):
        return self.n*self.s

    def area(self):
        return self.s**2*self.n/(4*math.tan(math.pi/self.n))

class Worker:

    def __init__(self, name, rate):
        self.n = name
        self.r = rate

    def changeRate(self, newRate):
        self.r = newRate

    def pay(self, hours):
        print('Not Implemented')

class HourlyWorker(Worker):

    def pay(self, hours):
        if hours < 40:
            return self.r*hours
        else:
            return self.r*40+self.r*2*(hours-40)

class SalariedWorker(Worker):

    def pay(self):
        return self.r*40

from math import sqrt
class Point:

    def __init__(self, xcoord, ycoord):
        self.x = xcoord
        self.y = ycoord

    def distance(self, p):
        return sqrt((self.x - p.x)**2 + (self.y - p.y)**2)

    def up(self):
        self.move(0, 1)

    def down(self):
        self.move(0, -1)

    def left(self):
        self.move(-1, 0)

    def right(self):
        self.move(1, 0)

    def setx(self, xcoord):
        self.x = xcoord

    def sety(self, ycoord):
        self.y = ycoord

    def get(self):
        return (self.x, self.y)

    def move(self, dx, dy):
        self.x += dx
        self.y += dy

import math
class Segment:

    def __init__(self, point1 = Point(0,0), point2 = Point(0,0)):
        self.p1 = point1
        self.p2 = point2

    def length(self):
        return 

    def slope(self):
        if (self.p1.y-self.p2.y)/(self.p1.x-self.p2.x) == TypeError:
            return 'None'
        else:
            return (self.p1.y-self.p2.y)/(self.p1.x-self.p2.x)














