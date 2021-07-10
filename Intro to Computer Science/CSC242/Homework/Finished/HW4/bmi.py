# Abel Marin
# Problem 9.16
from tkinter import Tk, Label, Frame, Entry, Button, END
from tkinter.messagebox import showinfo

class BMI(Frame):

    def __init__(self, master=None):
        Frame.__init__(self, master)
        Label(self, text='Enter your height: ').grid(row=0, column=0)
        Label(self, text='Enter your weight: ').grid(row=1, column=0)
        self.hEnt = Entry(self)
        self.hEnt.grid(row=0, column=1)
        self.wEnt = Entry(self)
        self.wEnt.grid(row=1, column=1)
        Button(self, text='Compute BMI', padx=30, command=self.compute).grid(row=2, columnspan=2)
        self.pack()

    def compute(self):
        weight = eval(self.wEnt.get())
        height = eval(self.hEnt.get())
        bmi = format(703*weight/height**2,'.2f')
        showinfo(message = 'Your BMI is: {}'.format(bmi))
        self.wEnt.delete(0, END)
        self.hEnt.delete(0, END)
