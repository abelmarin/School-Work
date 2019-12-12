from tkinter import Tk, Canvas, BOTH, Frame

class Draw(Frame):

    def __init__(self,master):
        Frame.__init__(self,master)
        
        self.oldx, self.oldy = 0, 0   # mouse coordinates (global variables)

        # self.canvas
        self.canvas = Canvas(self, height=100, width=150)

        # bind left mouse button click event to function begin() 
        self.canvas.bind("<Button-1>", self.begin)

        # bind mouse motion while pressing left button event 
        self.canvas.bind("<Button1-Motion>", draw)

        self.canvas.pack(expand=True, fill=BOTH)
        

    def begin(self, event):
        'initializes the start of the curve to mouse position'

        self.oldx, self.oldy = event.x, event.y


    def draw(event):
        'draws a line segment from old mouse position to new one'
        newx, newy = event.x, event.y  # new mouse position

        # connect previous mouse position to current one
        self.canvas.create_line(self.oldx, self.oldy, newx, newy)
        
        self.oldx, self.oldy = newx, newy    # new position becomes previous

from tkinter import Tk, Canvas, Frame, Button, SUNKEN, LEFT, RIGHT



# event handlers
def up():
    'move pen up 10 pixels'
    global y, canvas                  # y is modified
    canvas.create_line(x, y, x, y-10)
    y -= 10

def down():
    'move pen down 10 pixels'
    global y, canvas                  # y is modified
    canvas.create_line(x, y, x, y+10)
    y += 10

def left():
    'move pen left 10 pixels'
    global x, canvas                  # x is modified
    canvas.create_line(x, y, x-10, y)
    x -= 10

def right():
    'move pen right 10 pixels'
    global x, canvas                  # x is modified
    canvas.create_line(x, y, x+10, y)
    x += 10



root = Tk()

# canvas with border of size 100 x 150
canvas = Canvas(root, height=100, width=150,
                relief=SUNKEN, borderwidth=3)
canvas.pack(side=LEFT)

# frame to hold the 4 buttons
box = Frame(root)
box.pack(side=RIGHT)

# the 4 button widgets have Frame widget box as their master
button = Button(box, text='up', command=up)
button.grid(row=0, column=0, columnspan=2)
button = Button(box, text='left',command=left)
button.grid(row=1, column=0)
button = Button(box, text='right', command=right)
button.grid(row=1, column=1)
button = Button(box, text='down', command=down)
button.grid(row=2, column=0, columnspan=2)

x, y = 50, 75 # pen position, initially in the middle


root.mainloop()

class App(Frame):

    def __init(self, master):
        Frame.__init__(self, master)
        d = Draw(self)
        d.pack(side=LEFT)
        p = Plotter(self)
        p.pack(side=RIGHT)


