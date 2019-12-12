'''
Abel Marin
'''

# Problem 1
from random import randint
def forPoint(initialRoll):
    while True:
        ranNum = randint(2,12)
        if ranNum == 7:
            return 0
        elif ranNum == initialRoll:
            return 1

def craps():
    loss = [2,3,12]
    win = [7,11]
    while True:
        ranNum = randint(2,12)
        if ranNum in win:
            return 1
        elif ranNum in loss:
            return 0
        else:
            return forPoint(ranNum)

def testCraps(n):
    wins = 0
    losses = 0
    while wins + losses < n:
        game = craps()
        if game == 1:
            wins += 1
        else:
            losses += 1
    return wins/n



from math import sqrt
class Point:
    'class that represents a point in the plane'

    def __init__(self, xcoord, ycoord):
        'constructor for a point with coordinates xcoord and ycoord'
        self.x = xcoord
        self.y = ycoord

    # Exercise 8.10
    def distance(self, point):
        'returns the distance between two points'
        return sqrt(((self.x-point.x)**2)+((self.y-point.y)**2))
    
    # Exercise 8.12
    def up(self):
        'moves a coordinate 1 unit up'
        self.move(0,1)

    def down(self):
        'moves a coordinate 1 unit down'
        self.move(0,-1)

    def left(self):
        'moves a coordinate 1 unit to the left'
        self.move(-1,0)

    def right(self):
        'moves a coordinate 1 unit to the right'
        self.move(1,0)

    def setx(self, xcoord):
        'set x coordinate of point to xcoord'
        self.x = xcoord

    def sety(self, ycoord):
        'set y coordinate of point to ycoord'
        self.y = ycoord

    def get(self):
        'return a tuple with x and y coordinates of the point'
        return (self.x, self.y)

    def move(self, dx, dy):
        'change the x and y coordinates by dx and dy'
        self.x += dx
        self.y += dy



class Rectangle:
    'class that represents rectangles'

    # Exercise 8.13
    def __init__(self, xcoord=1, ycoord=1):
        'constructs a rectangle with sides xcoord and ycoord'
        self.x = xcoord
        self.y = ycoord
    
    def setSize(self, xcoord, ycoord):
        'constructor'
        self.x = xcoord
        self.y = ycoord

    def perimeter(self):
        'returns perimeter of rectangle'
        return 2 * (self.x + self.y)

    def area(self):
        'returns area of rectangle'
        return self.x * self.y


# Problem 8.20
class BankAccount:
    'a bank account class'

    def __init__(self, balance=0):
        'constructs a bank account'
        self.b = balance

    def withdraw(self, amount):
        'withdraws a certain amount from the bank account'
        self.b -= amount

    def deposit(self, amount):
        'deposits a certain amount from the bank account'
        self.b += amount

    def balance(self):
        'returns balance of the bank account'
        return '{:.2f}'.format(self.b)


# Problem 8.24
import time
class Person:
    'person class'

    def __init__(self,name,birth):
        'constructs a Person class by taking the name and birthday as inputs'
        self.n = name
        self.b = birth

    def name(self):
        'returns the name of the person'
        return self.n

    def age(self):
        'returns the age of the person'
        return time.localtime()[0] - self.b



# Problem 8.33
class pseudorandom:
    #INVARIENT: the seed always goes at the front of the list
    'linear congruential pseudorandom number generator'

    'Amount of elements in the pseudorandom sequence'
    elements = 500
    
    def __init__(self,a,x,c,m):
        'constructs a list of pseudorandom sequence of numbers'
        self.p = [x]
        while len(self.p) < pseudorandom.elements:
            self.p.append(((a*self.p[-1]+c)%m))
        
    def next(self):
        'returns the next number in a pseudorandom sequence'
        return self.p.pop(1)





