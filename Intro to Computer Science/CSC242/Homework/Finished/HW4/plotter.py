# Problem 5

from tkinter import Tk, Canvas, Frame, Button, Label, SUNKEN, TOP, BOTTOM

class Plotter(Frame):

    def __init__(self, master):
        Frame.__init__(self, master)
        Label(master, text='Use the arrow keys to move').grid(row=0)
        self.canvas = Canvas(master, height=200, width=250, relief=SUNKEN, borderwidth=3)
        self.canvas.grid(row=1)
        self.x, self.y = 125, 100
        master.bind('<Up>',self.up)
        master.bind('<Left>',self.left)
        master.bind('<Down>',self.down)
        master.bind('<Right>',self.right)
        
    def up(self, event):
        'move pen up 10 pixels'
        self.canvas.create_line(self.x,self.y,self.x, self.y-10)
        self.y -= 10

    def down(self, event):
        'move pen down 10 pixels'
        self.canvas.create_line(self.x,self.y,self.x, self.y+10)
        self.y += 10

    def left(self,event):
        'move pen left 10 pixels'
        self.canvas.create_line(self.x,self.y,self.x-10, self.y)
        self.x -= 10

    def right(self, event):
        'move pen right 10 pixels'
        self.canvas.create_line(self.x,self.y,self.x+10, self.y)
        self.x += 10
        
