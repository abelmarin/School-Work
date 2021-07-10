'''
from tkinter import Tk, Label, PhotoImage, BOTTOM, LEFT, RIGHT, RIDGE
# GUI illustrates widget constructor options and method pack()
root = Tk()

# label with text "Peace begins with a smile."
text = Label(root,                                              
             font=('Helvetica', 16, 'bold italic'),           
             foreground='white',   # letter color          
             background='black',   # background color         
             padx=25,  # widen label 25 pixels left and right 
             pady=10,  # widen label 10 pixels up and down    
             text='Peace begins with a smile.')
text.pack(side=BOTTOM)               # push label down

# label with peace symbol image
peace = PhotoImage(file='peace.gif')
peaceLabel = Label(root,
                   borderwidth=3,  # label border width
                   relief=RIDGE,   # label border style
                   image=peace)
peaceLabel.pack(side=LEFT)           # push label left

# label with smiley face image
smiley = PhotoImage(file='smiley.gif')
smileyLabel = Label(root,
                    image=smiley)
smileyLabel.pack(side=RIGHT)         # push label right

root.mainloop()
'''
'''
from tkinter import Tk, Label, RAISED
root = Tk()
labels = [['1', '2', '3'],     # phone dial label texts
          ['4', '5', '6'],     # organized in a grid
          ['7', '8', '9'],
          ['*', '0', '#']]

for r in range(4):      # for every row r = 0, 1, 2, 3
    for c in range(3):      # for every row c = 0, 1, 2
        # create label for row r and column c
        label = Label(root,
                      relief=RAISED,      # raised border
                      padx=10,            # make label wide
                      text=labels[r][c])  # label text
        # place label in row r and column c
        label.grid(row=r, column=c)

root.mainloop()
'''

# from tkinter import Tk, Frame, Button
# # alternate version:
# from tkinter.messagebox import showinfo
# from time import strftime, localtime

# class ClickIt(Frame):

#     def __init__(self, master):
#         Frame.__init__(self, master)
#         button = Button(self, text='Click it', padx=40, command=self.clicked)

#         self.pack()

#     def clicked():
#         'prints day and time info'
#         time = strftime('Day:  %d %b %Y\nTime: %H:%M:%S %p\n', localtime())
#         #print(time)
#         # alternate version:
#         showinfo(message = time)

# ###

# from tkinter import Tk, Button, Entry, Label, END, Frame
# from time import strptime, strftime
# from tkinter.messagebox import showinfo



# class Day(Frame):

#     def __init__(self, master):
#         Frame.__init__(self, master)
#         # label
#         label = Label(self, text='Enter date')
#         label.grid(row=0, column=0)

#         # entry
#         self.dateEnt = Entry(self)
#         self.dateEnt.grid(row=0, column=1)

#         #  Enter button
#         button = Button(self, text='Enter', padx=40, command=self.compute) 
#         button.grid(row=1, column=0)

#         # Clear button
#         button = Button(self, text='Clear', padx=40, command=self.clear) 
#         button.grid(row=1, column=1)
        
#     def compute(self):
#         date = self.dateEnt.get()
#         weekday = strftime('%A', strptime(date, '%b %d, %Y'))
#         self.dateEnt.insert(0, weekday+' ')
        

#     def clear(self):
#         self.dateEnt.delete(0, END)

# root = Tk()
# Day(root).mainloop()



from tkinter import Tk, Text, BOTH

def record(event):
    #event handling function for key press event;
    #input event is of type tkinter.Event
    print('char = {}'.format(event.keysym)) # print key symbol

root = Tk()

text = Text(root,
            width=20,  # set width to 20 characters
            height=5)  # set height to 5 rows of characters

# Bind a key press event with the event handling function record()
text.bind('<KeyPress-Up>', record)

# widget expands if the master does
text.pack(expand=True, fill=BOTH)

root.mainloop()

'''
from tkinter import Tk, Canvas

def begin(event):
    'initializes the start of the curve to mouse position'

    global oldx, oldy
    oldx, oldy = event.x, event.y

def draw(event):
    'draws a line segment from old mouse position to new one'
    global oldx, oldy, canvas      # x and y will be modified
    newx, newy = event.x, event.y  # new mouse position

    # connect previous mouse position to current one
    canvas.create_line(oldx, oldy, newx, newy)
    
    oldx, oldy = newx, newy    # new position becomes previous

root = Tk()

oldx, oldy = 0, 0   # mouse coordinates (global variables)

# canvas
canvas = Canvas(root, height=100, width=150)

# bind left mouse button click event to function begin() 
canvas.bind("<Button-1>", begin)

# bind mouse motion while pressing left button event 
canvas.bind("<Button1-Motion>", draw)

canvas.pack()

root.mainloop()
'''
'''
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
'''
