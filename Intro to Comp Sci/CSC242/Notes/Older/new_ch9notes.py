from tkinter import Tk, Frame, Button
# alternate version:
from tkinter.messagebox import showinfo
from time import strftime, localtime

class ClickIt(Frame):

    def __init__(self, master):
        Frame.__int__(self, master)
        # create button labeled 'Click it' and event handler clicked()
        button = Button(master,
                text='Click it',    # text on top of button
                command=clicked)    # button click event handler

        button.pack()

    def clicked():
        'prints day and time info'
        time = strftime('Day:  %d %b %Y\nTime: %H:%M:%S %p\n', localtime())
        #print(time)
        # alternate version:
        showinfo(message = time)

###


from tkinter import Tk, Button, Entry, Label, END, Frame
from time import strptime, strftime
from tkinter.messagebox import showinfo

class Day(Frame):

    def __init__(self, master):
        Frame.__init__(self, master)
        # label
        label = Label(self, text='Enter date')
        label.grid(row=0, column=0)

        # entry
        self.dateEnt = Entry(self)
        self.dateEnt.grid(row=0, column=1)

        #  Enter button
        button = Button(self, text='Enter', padx=40, command=self.compute) 
        button.grid(row=1, column=0)

        # Clear button
        button = Button(self, text='Clear', padx=40, command=self.clear) 
        button.grid(row=1, column=1)
        

    def compute():
        #display day of the week corresponding to date in dateEnt;
        #date must have format MMM DD, YYYY (e.g., Jan 21, 1967)

        # read date from entry dateEnt
        date = self.dateEnt.get()

        # compute weekday corresponding to date
        weekday = strftime('%A', strptime(date, '%b %d, %Y'))

        # display the weekday in a pop-up window  
        # showinfo(message = '{} was a {}'.format(date, weekday))
        self.dateEnt.insert(0, weekday+' ')


    def clear():

        # delete date from entry dateEnt
        self.dateEnt.delete(0, END)


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

class App(Frame):

    def __init(self, master):
        Frame.__init__(self, master)
        d = Draw(self)
        d.pack(side=LEFT)
        p = Plotter(self)
        p.pack(side=RIGHT)
