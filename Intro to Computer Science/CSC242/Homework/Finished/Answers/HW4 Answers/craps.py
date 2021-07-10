# Problem 4
from tkinter import Tk, Label, Frame, Entry, Button, END, LEFT
from random import randrange

class Craps(Frame):

    def __init__(self,master=None):
        Frame.__init__(self,master)
        Label(self,text='Your roll:').grid(row=0,column=0,columnspan=2)
        self.e = Entry(self, width=30)
        self.e.grid(row=1,column=0,columnspan=2)
        Button(self,text='New game',command=self.game).grid(row=2,column=0)
        Button(self,text='Roll for point',command=self.forPoint).grid(row=2,column=1)
        self.pack()

    def game(self):
        'constructor that starts a game of craps'
        self.initial = randrange(1,7) + randrange(1,7)
        self.e.delete(0,END)
        if self.initial in [7,11]:
            self.e.insert(0, 'Thow total: {}. You won!'.format(self.initial))
        elif self.initial in [2,3,12]:
            self.e.insert(0, 'Thow total: {}. You lost!'.format(self.initial))
        else:
            self.e.insert(0, 'Thow total: {}. Throw for Point.'.format(self.initial))

    def forPoint(self):
        'throws for point'
        tmp = randrange(1,7) + randrange(1,7)
        self.e.delete(0,END)
        if tmp == self.initial:
            self.e.insert(0, 'Thow total: {}. You won!'.format(tmp))
        elif tmp == 7:
            self.e.insert(0, 'Thow total: {}. You lost!'.format(tmp))
        else:
            self.e.insert(0, "Throw total: "+str(tmp)+". Throw for Point.")
