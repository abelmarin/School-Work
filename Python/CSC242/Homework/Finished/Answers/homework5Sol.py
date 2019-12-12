# Problem 9.28
from tkinter import Tk,Frame,Label,Button
from calendar import monthrange
from tkinter.simpledialog import askstring
class Calendar(Frame):
    'Calendar app'
    def __init__(self, year, month, master=None):
        'constructor for Calendar for given year and month'
        Frame.__init__(self, master)
        self.pack()
        self.year = year
        self.month = month
        self.d = {}
        Calendar.make_widgets(self)

    def make_widgets(self):
        'defines Calendar widgets'
        weekdays = ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        for i in range(len(weekdays)):
            Label(self, text=weekdays[i]).grid(row=0,column=i)
            (weekday, numDays) = monthrange(self.year,self.month)
            week = 1
            for i in range(1, numDays+1):
                Button(self,text=i,width=2,command=lambda x=i: self.handler(x)).grid(row=week,column=weekday)
                weekday += 1
                if weekday>6:
                    weekday=0
                    week+=1

    def handler(self,i):
        '''handles Calendar button click events by opening an interactive dialog window
           for the day corresponding to the window'''
        if i not in self.d:
            self.d[i] = askstring('Appt','Enter text:')
        else:
            self.d[i] = askstring('Appt','Enter text:',initialvalue=self.d[i])
    
            


# Problem 2
def combinations(n,k):
    'returns the number of ways of choosing k items out of n'
    if k==0:
        return 1
    elif n < k:
        return 0
    else:
        return combinations(n-1,k-1)+combinations(n-1,k)


# Exercise 10.14
from time import sleep
def countdown3(n):
    'counts down to 0'
    if n <= 0:               # base case
        print('Blastoff!!!')
    else:                    # n > 0: recursive step
        print(n)                 # print n first and then
        if n == 3:
            print('    BOOM!!!',end='')
            sleep(1)
            print('\n    Scared you...')
        else:
            sleep(1)
        countdown3(n-1)           # count down from n-1


# Problem 10.18
def silly(n):
    'prints n stars followed by n exclamation marks'
    if n > 0:
        print('*',end='')
        silly(n-1)
        print('!',end='')



# Problem 10.19
def numOnes(n):
    'returns number of 1s in the binary representation of non-negative integer n'
    if n == 0:
        return 0
    if n%2 == 0:
        return numOnes(n//2)
    else:
        return numOnes(n//2)+1



# Problem 10.20
def rgcd(a, b):
    'returns the greatest common denominator of non-negative integers a and b'
    if b == 0:
        return a
    return rgcd(b, a%b)


