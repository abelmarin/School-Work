class Article(object):
    
    def setID(self, ID):
        self.id = ID

    def setPrice(self, price):
        self.price = price

    def getPrice(self):
        try:
            return self.price
        except:
            print('The article price has not been set.')

    def getID(self):
        try:
            return self.id
        except:
            print('The article ID has not been set')


from random import randrange
class myInt(int):

    def __eq__(self, other):
        if randrange(0,2) == 1:
            return True
        return False

from tkinter import Tk, Frame, Button, Entry, LEFT, RIGHT, END
from tkinter.messagebox import showinfo
class Calculator(Frame):

    def __init__(self, master):
        Frame.__init__(self, master)
        self.expression = Entry(master)
        self.expression.pack(side=LEFT)
        Button(master, text='Compute', command = self.compute).pack(side=RIGHT)
        
    def compute(self):
        expression = eval(self.expression.get())
        showinfo(message = expression)
        self.expression.delete(0,END)

from tkinter import Canvas, Frame, BOTH, SUNKEN, LEFT, RIGHT
class Draw(Frame):
    'a basic drawing application'

    def __init__(self, parent):
        Frame.__init__(self, parent)
        self.pack()

        # mouse coordinates are instance variables
        self.oldx, self.oldy = 0, 0

        # create canvas and bind mouse events to handlers
        self.canvas = Canvas(self, height=100, width=150,relief=SUNKEN,borderwidth=3)
        self.canvas.bind("<Button-1>", self.begin)
        self.canvas.bind("<Button1-Motion>", self.draw)
        self.canvas.pack(expand=True, fill=BOTH)

    def begin(self, event):
        'handles left button click by recording mouse position'
        self.oldx, self.oldy = event.x, event.y
        
    def draw(self, event):
        '''handles mouse motion, while pressing left button, by
           connecting the previous mouse position to the new one'''
        newx, newy = event.x, event.y
        self.canvas.create_line(self.oldx, self.oldy, newx, newy)
        self.oldx, self.oldy = newx, newy


class App(Frame):

    def __init__(self,master=None):
        Frame.__init__(self, master)
        self.pack()
        Draw(master).pack(side=LEFT)
        Calculator(master).pack(side=RIGHT)
        









