# Problem 1
class Vehicle(object):
#INVARIENT: Last in First out

    def __init__(self):
        self.v = []

    def add_cargo(self, cargo):
        self.v.append(cargo)

    def cargo_contents(self):
        return self.v

    def deliver(self):
        return self.v.pop()


# Problem 2
class Sled(Vehicle):
    
    def __init__(self, xcoord, ycoord):
        Vehicle.__init__(self)
        self.x = xcoord
        self.y = ycoord

    def move(self, dx, dy):
        self.x += dx
        self.y += dy

    def __str__(self):
        return 'Gifts being deliverd at location ({},{})'.format(self.x,self.y)


# Problem 3
from random import sample
from tkinter import Tk,Frame,Entry,Button,LEFT,RIGHT,END
class Lottery(Frame):

    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.e = Entry(master,width=30)
        self.e.grid(row=0,column=0)
        Button(master,text='Select',command=self.set_num).grid(row=0, column=1)

    def set_num(self):
        self.e.delete(0,END)
        lst = sample(range(1,61),6)
        self.e.insert(0, str(lst)[1:-1])
        
