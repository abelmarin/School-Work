class Card:
    'represents a playing card'

    val = {'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9,'10':10,'J':12,'Q':13,'K':14,'A':15}

    # Exercise 8.15 solution 
    def __lt__(self, other):
        'self < other if rank of self < rank of other'
        return Card.val[self.rank] < Card.val[other.rank]

    # Exercise 8.15 solution 
    def __gt__(self, other):
        'self > other if rank of self > rank of other'
        return Card.val[self.rank] > Card.val[other.rank]

    # Exercise 8.15 solution 
    def __le__(self, other):
        'self <= other if rank of self <= rank of other'
        return Card.val[self.rank] <= Card.val[other.rank]

    # Exercise 8.15 solution 
    def __ge__(self, other):
        'self >= other if rank of self >= rank of other'
        return Card.val[self.rank] >= Card.val[other.rank]

    def __init__(self, rank, suit):
        'initialize rank and suit of card'
        self.rank = rank
        self.suit = suit

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
        'new add operator behavior'
        return 'Whatever ...'



# Exercise 8.18
class myList(list):
    'peculiar list type'

    def sort(self):
        'new sort behavior'
        print('You wish ...')  




# Problem 8.21
import math
class Polygon(object):
    'regular polygon class'

    def __init__(self, n, s):
        'constructs an n-sided polygon with side length s'
        self.n = n
        self.s = s

    def perimeter(self):
        'returns polygon perimeter'
        return self.n*self.s

    def area(self):
        'returns polygon area'
        return (self.n*self.s**2)/(4*math.tan(math.pi/self.n))



# Problem 8.29
class Hand(object):
    'represents a hand of playing cards'

    def __init__(self, player):
        'initializes player ID and initial empty hand'
        self.player = player
        self.hand = []

    def addCard(self, card):
        'adds card to hand'
        self.hand.append(card)

    def showHand(self):
        'prints player ID and hand'
        print('{}:'.format(self.player), end='')
        for card in self.hand:
            rank = card.getRank()
            suit = card.getSuit()
            print('{:>4} {}'.format(rank, suit), end = '')



# Problem 8.32
from random import randrange
class Craps(object):
    'a craps game simulation'

    def __init__(self):
        'constructor that starts a game of craps'
        self.initial = randrange(1,7) + randrange(1,7)
        if self.initial in [7,11]:
            print('Thow total: {}. You won!'.format(self.initial))
        elif self.initial in [2,3,12]:
            print('Thow total: {}. You lost!'.format(self.initial))
        else:
            print('Thow total: {}. Throw for Point.'.format(self.initial))

    def forPoint(self):
        'throws for point'
        tmp = randrange(1,7) + randrange(1,7)
        if tmp == self.initial:
            print('Thow total: {}. You won!'.format(tmp))
        elif tmp == 7:
            print('Thow total: {}. You lost!'.format(tmp))
        else:
            print("Throw total: "+str(tmp)+". Throw for Point.")



# Problem 8.37
class Square(Polygon):
    'square class'

    def __init__(self, s):
        'constructor that initializes the side length of a square'
        Polygon.__init__(self, 4, s)

    def area(self):
        'returns square area'
        return self.s**2

from math import sqrt
class Triangle(Polygon):
    def __init__(self, s):
        'constructor that initializes the side length of an equilateral triangle'
        Polygon.__init__(self, 3, s)

    def area(self):
        'returns triangle area'
        return sqrt(3)*self.s**2/4



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

    def __init__(self,name,birthYear,degree):
        'constructs instructor with given name, birth year, and degree'
        Person.__init__(self, name, birthYear)
        self.d = degree

    def degree(self):
        'returns instructor degree'
        return self.d

class Student(Person):
    'student class'

    def __init__(self,name,birthYear,major):
        'constructs student with given name, birth year, and major'
        Person.__init__(self, name, birthYear)
        self.m = major

    def major(self):
        'returns student major'
        return self.m




