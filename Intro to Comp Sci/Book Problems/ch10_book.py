def vertical(n):
    'prints a nonnegative number n vertically'
    if n < 10:
        print(n)
    else:
        vertical(n//10)
        print(n%10)

def reverse(n):
    if n < 10:
        print(n)
    else:
        print(n%10)
        reverse(n//10)

def cheers(n):
    if n <= 0:
        print('Hurray!!!')
    else:
        print('Hip ', end='')
        cheers(n-1)

def factorial(n):
    if n == 0:
        return 1
    return factorial(n-1)*n

def pattern(n):
    if n==0:
        print(0,end=' ')
    else:
        pattern(n-1)
        print(n, end=' ')
        pattern(n-1)

def pattern2(n):
    if n <= 0:
        pass
    elif n == 1:
        print('*')
    else:
        pattern2(n-1)
        print('*'*n)
        pattern2(n-1)

def koch(n):
    if n == 0:
        return 'F'
    k = koch(n-1)
    return k+'L'+k+'R'+k+'L'+k

from turtle import *
def turtleKoch(n):
    s,t = Screen(),Turtle()
    recur = koch(n)
    for i in recur:
        if i == 'F':
            t.forward(300/3**n)
        if i == 'R':
            t.rt(120)
        if i == 'L':
            t.lt(60)
    s.bye()

def snowflake(n):
    s,t = Screen(),Turtle()
    recur = koch(n)

    for i in range(3):
        for j in recur:
            if j == 'F':
                t.forward(300/3**n)
            if j == 'R':
                t.rt(120)
            if j == 'L':
                t.lt(60)
        t.rt(120)
    s.bye()

signatures = {'Creeper':'ye8009g2h1azzx33',
              'Code Red':'99dh1cz963bsscs3',
              'Blaster':'fdp1102k1ks6hgbc'}

import os
def scan(pathname,signatures):
    if os.path.isfile(pathname):
        file = open(pathname)
        content = file.read()
        file.close()

        for i in signatures:
            if content.find(signatures[i]) >= 0:
                print('{}, found virus {}'.format(pathname, i))
        return

    for item in os.listdir(pathname):
        fullpath = os.path.join(pathname,item)
        scan(fullpath,signatures)

def recSum(lst):
    'returns the sum of items in list lst'
    if len(lst) == 0:
        return 0
    return recSum(lst[:-1]) + lst[-1]
    

def recNeg(lst):
    if len(lst) == 0:
        return False
    return recNeg(lst[:-1]) or lst[-1] < 0

def recIncr(lst):
    if len(lst) == 0:
        return []
    return recIncr(lst[:-1]) + [lst[-1]+1]

def f(i):
    return i+1

def recMap(lst,func):
    # Higher Order Function: A function which takes another function as input
    # This type of function is used extensively in functional programming
    if len(lst) == 0:
        return []
    return recMap(lst[:-1],func) + [func(lst[-1])]

def power(a, n):
    'returns a to the nth power'
    res=1
    for i in range(n):
        res *= a
    return res

def pow2(n):
    return 2**n

def rpower(a,n):
    if n == 0:
        return 1
    tmp = rpower(a,n//2)

    if n%2 == 0:
        return tmp*tmp
    else:
        return a*tmp*tmp

def rfib(n):
    if n < 2:
        return 1
    return rfib(n-2)+rfib(n-1)

def fib(n):
    prev, curr = 1,1
    i = 1

    while i<n:
        prev,curr = curr,prev+curr
        i += 1
    return curr

import time
def timing(func, n):
    'runs func on input returned by buildInput'
    funcInput = buildInput(n)
    start = time.time()
    func(funcInput)
    end = time.time()
    return end - start

def buildInput(n):
    return n

def timingAnalysis(func, start, stop, inc, runs):
    '''prints average run times of function func on inputs
    of size start, start+inc, start+2*inc, ..., up to stop'''
    for n in range(start, stop, inc):
        acc = 0.0
        for i in range(runs):
            acc += timing(func, n)
            
        formatStr = 'Run time of {}({}) is {:.7f} seconds.'
        print(formatStr.format(func.__name__, n, acc/runs))

def rpower2(n):
    return rpower(2,n)

def power2(n):
    return power(2,n)

def search(lst,target,i,j):
    if i == j:
        return -1
    mid = (i+j)//2
    if lst[mid] == target:
        return mid
    if target < lst[mid]:
        return search(lst,target,i,mid)
    if target > lst[mid]:
        return search(lst,target,mid+1,j)

def numOnes(n):
    if n < 2:
        return n%2
    return numOnes(n//2)+n%2

def rgcd(a,b):
    if b == 0:
        return a
    return rgcd(b,a%b)

def rem(lst):
    if len(lst) < 2:
        return []
    
def numOnes(n):
    if n == 0:
        return 0
    return numOnes(n//2)+n%2

def rgcd(a,b):
    if b==0:
        return a
    return rgcd(b,a%b)

def address(lst):
    lst.sort()
    if len(lst)<3:
        return lst[0]
    return address(lst[1:-1])

def tough(x,y):
    if y == 0:
        return

def base(n,b):
    if n<b:
        print(n,end="")
    else:
        base(n//b,b)
        print(n%b,end="")

def anagrams(file,word):
    infile=open(file)
    content = readlines(infile)
    close(infile)



