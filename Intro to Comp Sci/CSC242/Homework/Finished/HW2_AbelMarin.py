'''
Abel Marin
'''

class Card:
    'represents a playing card'

    # Exercise 8.15 solutions here

    def __init__(self, rank, suit):
        'initialize rank and suit of card'
        self.rank = rank
        self.suit = suit

    def __repr__(self):
        return '{} {}'.format(self.suit, self.rank)

    def __gt__(self, other):
        'checks to see if the rank of a card is greater than another'
        return int(self.rank) > int(other.rank)

    def __lt__(self, other):
        'checks to see if the rank of a card is less than another'
        return int(self.rank) < int(other.rank)

    def __ge__(self, other):
        'checks to see if the rank of a card is greater than or equal to another'
        return int(self.rank) >= int(other.rank)

    def __le__(self, other):
        'checks to see if the rank of a card is less than or equal to another'
        return int(self.rank) <= int(other.rank)

    def getRank(self):
        'return rank'
        return self.rank

    def getSuit(self):
        'return suit'
        return self.suit


# Exercise 8.16
class myInt(int):
    'peculiar integer type'

    def __add__(self, other):
        'returns a strange behavior when adding an int to another int'
        return 'Whatever ...'
    


# Exercise 8.18
class myList(list):
    'peculiar list type'

    def sort(self):
        'returns a strange behavior when attempting to sort a list'
        return 'You wish...'
    

# Problem 8.21
import math
class Polygon(object):
    'regular polygon class'

    def __init__(self, sides, length):
        'constructs a regular polygon with n sides and n length'
        self.s = sides
        self.l = length

    def perimeter(self):
        'returns the perimeter of a regular polygon'
        return self.s * self.l

    def area(self):
        'returns the area of a regular polygon'
        return ((self.l**2)*self.s)/(4*math.tan(math.pi/self.s))


from random import shuffle
class Deck:
    'This is a container class'

    ranks = ['2','3','4','5','6','7','8','9','10','J','Q','K','A']

    suits = ['\u2660','\u2661','\u2662','\u2663']
    
    def __init__(self):
        self.d = []
        for r in Deck.suits:
            for s in Deck.ranks:
                self.d.append(Card(r,s))

    def shuffle(self):
        shuffle(self.d)

    def dealCard(self):
        return self.d.pop()

# Problem 8.29
class Hand(object):
    'represents a hand of playing cards'

    def __init__(self, player):
        'constructs a hand'
        self.h = []
        self.p = player
        
    def addCard(self, newCard):
        'adds a card to a hand'
        self.h.append(newCard)

    def showHand(self,):
        'prints the contents of a hand'
        print(self.p,':',*self.h)


# Problem 8.32
from random import randrange
class Craps(object):
    'a craps game simulation'

    def __init__(self):
        'plays a game of craps'
        self.r = randrange(1,6)+randrange(1,6)
        if self.r in [7, 11]:
            print('Throw total: {}. You won!'.format(self.r))
        elif self.r in [2,3,12]:
            print('Throw total: {}. You lost!'.format(self.r))
        else:
            print('Throw total: {}. Throw for Point!'.format(self.r))

    def forPoint(self):
        ''
        roll = randrange(1,6)+randrange(1,6)
        if roll == 7:
            print('Throw total: {}. You lost!'.format(roll))
        elif roll == self.r:
            print('Throw total: {}. You won!'.format(roll))
        else:
            print('Throw total: {}. Throw for Point!'.format(roll))



# Problem 8.37
class Square(Polygon):
    'square class'

    def __init__(self, sideLength):
        'constructs a square'
        self.l = sideLength

    def perimeter(self):
        'returns the perimeter of a square'
        return self.l*4

    def area(self):
        'returns the area of a square'
        return self.l*self.l


from math import sqrt
class Triangle(Polygon):

    def __init__(self, sideLength):
        'constructs a triangle'
        self.l = sideLength

    def perimeter(self):
        'returns the perimeter of a triangle'
        return self.l*3

    def area(self):
        'returns the area of a triangle'
        return self.l**2*(sqrt(3)/4)



# Problem 8.38
from time import localtime
class Person(object):
    'person class'

    def __init__(self, name, birthYear):
        'constructs person with given name and birth year'
        self.personName = name
        self.birthYear = birthYear

    def age(self):
        'computes and returns person age'
        return localtime()[0] - self.birthYear

    def name(self):
        'returns person name'
        return self.personName

class Instructor(Person):
    'instructor class'

    def __init__(self, name, birthYear, degree):
        'constructs an instructor with a given name birth year and degree'
        self.personName = name
        self.birthYear = birthYear
        self.d = degree

    def degree(self):
        'returns the degree of an instructor'
        return self.d


class Student(Person):
    'student class'

    def __init__(self, name, birthYear, major):
        'constructs an student with a given name birth year and major'
        self.personName = name
        self.birthYear = birthYear
        self.m = major

    def major(self):
        'returns the major of a student'
        return self.m


