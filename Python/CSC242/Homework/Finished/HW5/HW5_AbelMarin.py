# Problem 9.28
##############
# As you can see I tried and I failed at this optional problem.
# All I ask for now is some feedback on where I went wrong.
# I would've gotten it all but I decided to wait until 10 to start.
##############
from tkinter import Tk,Frame,Label,Button
from calendar import monthrange
from tkinter.simpledialog import askstring
class Calendar(Frame):
    'Calendar app'
    
    def __init__(self, master, year, month):
        Frame.__init__(self,master)
        self.pack()
        Label(self,text='Mon').grid(row=0,column=0)
        Label(self,text='Tue').grid(row=0,column=1)
        Label(self,text='Wed').grid(row=0,column=2)
        Label(self,text='Thu').grid(row=0,column=3)
        Label(self,text='Fri').grid(row=0,column=4)
        Label(self,text='Sat').grid(row=0,column=5)
        Label(self,text='Sun').grid(row=0,column=6)
        self.month = list(monthrange(year,month))
        count = 1
        for i in range(6):
            for j in range(7):

                def cmd(x=count):
                    self.click(x)

                a = Button(self,
                            text=count,
                            width=3,
                            command=cmd)
                if i==0 and j==self.month[0]:
                    a.grid(row=i+1,column=j)
                    count += self.month[0]
                else:
                    a.grid(row=count,column=j)
                    count+=1
                    
    def click(self,key):
        pass

# Problem 2
def combinations(n,k):
    'returns the number of ways of choosing k items out of n'
    if k == 0:
        return 1
    if n < k:
        return 0
    return combinations(n-1,k-1) + combinations(n-1,k)

# Exercise 10.14
from time import sleep
def countdown3(n):
    sleep(2)
    if n <= 0:
        print('Blastoff!!!')
    if n == 2:
        print('   BOOOM!!!\n   Scared you...')
    if n > 0:
        print(n)
        countdown3(n-1)

# Problem 10.18
def silly(n):
    'prints n stars followed by n exclamation marks'
    if n > 0:
        print('*',end= ' ')
        silly(n-1)
        print('!',end= ' ')

# Problem 10.19
def numOnes(n):
    'returns number of 1s in the binary representation of non-negative integer n'
    if n == 0:
        return 0
    return numOnes(n//2) + n%2

# Problem 10.20
def rgcd(a, b):
    'returns the greatest common denominator of non-negative integers a and b'
    if b == 0:
        return a
    return rgcd(b, a%b)
