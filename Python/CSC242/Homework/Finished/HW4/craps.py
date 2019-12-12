# Problem 4
from tkinter import Tk, Label, Frame, Entry, Button, END
from random import randrange

class Craps(Frame):

    def __init__(self, master=None):
        Frame.__init__(self, master)
        Label(self, text='Your roll:').grid(row=0, column=0, columnspan=2)
        self.roll = Entry(self)
        self.roll.grid(row=1, column=0, columnspan=2, ipadx=50)
        Button(self, text='New game', padx=30, command=self.game).grid(row=2, column=0)
        Button(self, text='Roll for point', padx=30, command=self.forPoint).grid(row=2, column=1)
        self.pack()

    def game(self):
        self.roll.delete(0,END)
        self.initial = randrange(1,7) + randrange(1,7)
        if self.initial in [7,11]:
            self.roll.insert(0,'Thow total: {}. You won!'.format(self.initial))
        elif self.initial in [2,3,12]:
            self.roll.insert(0,'Thow total: {}. You lost!'.format(self.initial))
        else:
            self.roll.insert(0,'Thow total: {}. Throw for Point.'.format(self.initial))

    def forPoint(self):
        self.roll.delete(0,END)
        tmp = randrange(1,7) + randrange(1,7)
        if tmp == self.initial:
            self.roll.insert(0, 'Thow total: {}. You won!'.format(tmp))
        elif tmp == 7:
            self.roll.insert(0, 'Thow total: {}. You lost!'.format(tmp))
        else:
            self.roll.insert(0, 'Throw total: {}. Throw for Point.'.format(tmp))
        
