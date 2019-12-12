'''
Abel Marin
January 9th, 2019


A class is a namespace

lst.sort() == list.sort(lst)
object.method(arg1, arg2)
class.method(object, arg1, arg2)

namespace notation is list.sort(lst, arg1, arg2)

'''
class Point:
    'class that represents a point in the plane'

    def __init__(self, xcoord=0, ycoord=0):
        ''
        self.x = xcoord
        self.y = ycoord

    def __repr__(self):
        return 'Point({},{})'.format(self.x,self.y)

    def __add__(self, other):
        return point(self.x+other.x, self.y+other.y)

    def __eq__(self,other):
        return self.x==other.x and self.y==other.y

    def setx(self, xcoord):
        'set x coordinate of point to xcoord'
        self.x = xcoord

    def sety(self, ycoord):
        'set y coordinate of point to ycoord'
        self.y = ycoord

    def get(self):
        'return coordinates of the point as a tuple'
        return (self.x, self.y)

    def getx(self):
        'return coordinates of point x'
        return self.x

    def move(self, dx, dy):
        'change the x and y coordinates by dx and dy'
        self.x += dx
        self.y += dy


class Animal:
    'class that represents an animal speaking'

    def __init__(self, species = 'dragon', talk = 'breath fire'):

        self.species = species
        self.talk = talk
    
    def setSpecies(self, species):
        'set species to the self'
        self.species = species

    def setLanguage(self, talk):
        'set the language to the self'
        self.talk = talk

    def speak(self):
        ''
        return 'I am a {} and I {}'.format(self.species, self.talk)

class Bird(Animal):

    def speak(self):
        print('{}! '.format(self.talk)*3)

class Card:

    def __init__(self, rank, suit):
        self.rank = rank
        self.suit = suit

    def __repr__(self):
        return "Card('{}','{}')".format(self.rank,self.suit)

    def __eq__(self, other):
        return self.rank==other.rank and self.suit==other.suit

    def getRank(self):
        return self.rank

    def getSuit(self):
        return self.suit


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

class EmptyQueueError(Exception):
    pass

class Queue:
#INVARIANT: the front of the queue is at the front of the list
    ''

    def __init__(self):
        self.q = []

    def __len__(self):
        return len(self.q)

    def isEmpty(self):
        
        return len(self.q) == 0

    def enqueue(self, item):
        self.q.insert(0,item)

    def dequeue(self):
        if self.isEmpty():
            raise EmptyQueueError('dequeuing from an empty queue')
        return self.q.pop()


class Rep:
    
    def __repr__(self):
        return 'Canonical Representaion'
    
    def __str__(self):
        return 'Pretty Representaion'

import random
class MyList(list):
    'a subclass of list that implements method choice'

    def choice(self):
        return random.choice(self)






    
