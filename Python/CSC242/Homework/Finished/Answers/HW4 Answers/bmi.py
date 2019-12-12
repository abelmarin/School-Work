# Problem 9.16
from tkinter import Tk, Label, Frame, Entry, Button, END
from tkinter.messagebox import showinfo

class BMI(Frame):

    def __init__(self, master=None):
        Frame.__init__(self,master)
        Label(self, text='Enter your height:').grid(row=0,column=0)
        Label(self, text='Enter your weight:').grid(row=1,column=0)
        self.w = Entry(self)
        self.w.grid(row=1,column=1)
        self.h = Entry(self)
        self.h.grid(row=0,column=1)
        Button(self,text='Compute BMI',command=self.compute).grid(row=2,column=0,columnspan=2)
        self.pack()

    def compute(self):
        weight = eval(self.w.get())
        height = eval(self.h.get())
        bmi = weight*703/height**2
        showinfo(message='You BMI is {}'.format(bmi))
        self.w.delete(0,END)
        self.h.delete(0,END)
    




