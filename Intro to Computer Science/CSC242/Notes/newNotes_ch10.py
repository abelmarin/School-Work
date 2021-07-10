def vertical(n):
    'prints digits of n vertical'
    if n < 10:
        print(n)
    else:
        vertical(n//10)
        print(n%10)

def reverse(n):
    'prints digits of n vertically  in reverse order'
    if n < 10:
        print(n)
    else:
        print(n%10)
        reverse(n//10)

def cheers(n):
    'prints n Hips followed by Hurrary!!!'
    if n == 0:
        print('Hurray!!!')
    else:
        print('Hip', end = ' ')
        cheers(n-1)

def factorial(n):
    'prints'
    if n == 0:
        return 1
    return factorial(n-1)*n
        
def prod(lst):
    'returns the product of numbers in list lst'
    if len(lst) == 0:
        return 1
    return prod(lst[:-1])*lst[-1]

def neg(lst):
    'returns True if list lst contains a negative number'
    if lst == []:
        return False
    return lst[-1] < 0 or neg(lst[:-1])

def incr(lst):
    'returns a copy of list lst with every number incrimented by 1'
    if len(lst) == 0:
        return []
    return incr(lst[:-1]) + [lst[-1]+1]

def f(x):
    return x+1

def g(x):
    return x**2

def func(function, lst):
    'return a copy of lst with function being appled to every number in lst'
    if len(lst)==0:
        return []
    return func(function, lst[:-1]) + [function(lst[-1])]

def pattern(n):
    if n == 0:
        print(0,end=' ')
    else:
        pattern(n-1)
        print(n, end=' ')
        pattern(n-1)
        
from turtle import Screen, Turtle
def drawKoch(n):

    s = Screen()
    t = Turtle()
    directions = koch(n)
    for move in directions:
        if move == 'F':
            t.forward(10)
        if move == 'L':
            t.left(60)
        if move == 'R':
            t.right(120)

def koch(n):
    'returns instructions for drawing koch(n)'
    if n == 0:
        return 'F'
    tmp = koch(n-1)
    return tmp+'L'+tmp+'R'+tmp+'L'+tmp

import os
def scan(pathname, signatures):
    '''scans pathname or, if pathname is a folder, scans all files
       contained, directly or indirectly, in the folder pathname'''
    if os.path.isfile(pathname): # base case, scan pathname
        infile = open(pathname)
        content = infile.read()
        infile.close()

        for virus in signatures:
            # check whether virus signature appears in content
            if content.find(signatures[virus]) >= 0:
                print('{}, found virus {}'.format(pathname, virus))
        return
    
    # pathname is a folder so recursively scan every item in it
    for item in os.listdir(pathname):

        # create pathname for item relative
        # to current working directory
        # fullpath = pathname + '/' + item	    # Mac only
        # fullpath = pathname + '\' + item	    # Windows only
        fullpath = os.path.join(pathname, item)     # any OS
        
        scan(fullpath, signatures)

def rfib(n):
    if n in [0,1]:
        return 1
    return rfib(n-1) + rfib(n-2)

def fib(n):
    prev, curr = 1,1
    for i in range(2,n+1):
        prev, curr = curr, prev+curr
    return curr

# If recursive calls are repeated on the same subproblem then
# recursion is not the answer


import time
def timing(func, n):
    start = time.time()
    func(n)
    end = time.time()
    return end-start
    
def timingAnalysis(func,start,stop,inc,runs):

    for n in range(start,stop,inc):
        acc=0.0
        for i in range(runs):
            acc += timing(func,n)

        formatStr = 'Run-time of {} ({}) is {:.7f} seconds.'
        print(formatStr.format(func.__name__,n,acc/runs))

def linSearch(lst,target):
    pass

def binSearch(lst,target):
    return binarySearch(lst,target,0,len(lst))

def binarySearch(lst,target,i,j):
    'returns index of target in sublist lst[i:j], -1 otherwise'
    # Takes logorithmic amount of time instead of n time
    if j <= i:
        return -1
    mid = (i+j)//2
    if target == lst[mid]:
        return mid
    if target > lst[mid]:
        return binarySearch(lst,target,mid+1,j)
    else:
        return binarySearch(lst,target,i,mid)
    

    


