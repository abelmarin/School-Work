'Abel Marin'

# Problem 10.24
def base(n, b):
    'returns base-b (1 < b < 10) representation of non-negative integer n'
    if n < b:
        print(n,end="")
    else:
        base(n//b,b)
        print(n%b,end="")


# Problem 10.25
def permutations(lst):
    'returns list of all permutations (represented as lists) of list lst'
    if len(lst) < 2:
        return [lst]
    recur = permutations(lst[1:])
    result = []
    for i in recur:
        for j in range(len(lst)):
            result.append(i[:j]+[lst[0]]+i[j:])
    return result



# Problem 10.27
def pairs1(lst, target):
    '''Checks whether there are two integers in list lst of integers that
       add up to target.

       The search is done by exhaustively computing the sum for every pair
       of integers in list lst.'''
    for i in lst:
        for j in lst:
            if i+j==target:
                return True
    return False

def pairs2(lst, target):
    '''Checks whether there are two integers in list lst of integers that
       add up to target.

       After sorting the list, the search for the pair of integers is done as
       follows. The sum of the first and last integers is computed. If the sum
       is smaller than target, then the first integer cannot be in the solution
       pair and the search continues with the second and last integers. If the sum
       is greater than target, then the last integer cannot be in the solution
       pair and the search continues with the first and next-to-last integers. '''
    lst.sort()
    i = 0
    j = len(lst)-1
    while i<j:
        tmp = lst[i]+lst[j]
        if tmp==target:
            return True
        elif tmp>target:
            j-=1
        else:
            i+=1
    return False


# To run timingAnalysis(), we implement function buildInput() that constructs
# a list of randomly chosen integers in the range [0, 4n) and a random integer
# target in the range [0, 8n-1). Because our timingAnalysis framework lets us
# test functions with one input only, we write wrapper functions that take
# the generated pair (lst, target) as as tuple and call the appropriate function.

def wrapPairs1(tpl):
    return pairs1(tpl[0], tpl[1])

def wrapPairs2(tpl):
    return pairs2(tpl[0], tpl[1])

import random
def buildInput(n):
    '''returns a tuple containing a random sample of n integers in
       range [0, 4n) and a random integer in the range [0, 8n)'''
    lst = random.sample(range(4*n), n)  
    target = random.choice(range(8*n))
    return (lst, target)

import time
def timing(func, n):
    'runs func on input returned by buildInput'
    funcInput = buildInput(n)  # obtain input for func 

    start = time.time()        # take start time
    func(funcInput)            # run func on funcInput
    end = time.time()          # take end time

    return end - start         # return execution time

def timingAnalysis(func, start, stop, inc, runs):
    '''prints average run-times of function func on inputs of
       size start, start+inc, start+2*inc, ..., up to stop'''

    for n in range(start, stop, inc):  # for every input size n
        acc=0.0                        # initialize accumulator

        for i in range(runs):       # repeat runs times:
            acc += timing(func, n)      # run func on input of size n
                                        # and accumulate run-times
        # print average run times for input size n
        formatStr = 'Run-time of {}({}) is {:.7f} seconds.'
        print('Run-time of {}({}) is {:.7f} seconds.'.format(func.__name__,n,acc/runs))

# Abe's Results:
# >>> timingAnalysis(wrapPairs1, 10000, 50000, 10000, 50)
# Run-time of wrapPairs1(10000) is 0.0095394 seconds.
# Run-time of wrapPairs1(20000) is 0.0205278 seconds.
# Run-time of wrapPairs1(30000) is 0.0544561 seconds.
# Run-time of wrapPairs1(40000) is 0.1944493 seconds.
# >>> timingAnalysis(wrapPairs2, 10000, 50000, 10000, 50)
# Run-time of wrapPairs2(10000) is 0.0022794 seconds.
# Run-time of wrapPairs2(20000) is 0.0044275 seconds.
# Run-time of wrapPairs2(30000) is 0.0076940 seconds.
# Run-time of wrapPairs2(40000) is 0.0113491 seconds.


# Problem 10.29
def pascalLine(n):
    '''returns a list containing the sequence of numbers
        appearing in the nth line of Pascals triangle'''
    if n == 0:
        return [1]
    prev = pascalLine(n-1)
    lst = [1]
    for i in range(len(prev)-1):
        lst.append(prev[i] + prev[i+1])
    lst.append(1)
    return lst


# Problem 10.31
import os
def search(filename, folder):
    curr = os.path.dirname(os.path.realpath(folder))
    for root, dirs, files in os.walk(os.path.join(curr,folder)):
        if filename in files:
            return os.path.join(root[len(curr)+1:],filename)
    return None
    



# Problem 11.18
from html.parser import HTMLParser
class ContentParser(HTMLParser):
    def handle_data(self,data):
        print(data, end="")
        

from urllib.request import urlopen
def getContent(url):
    'simple text web browser'
    content = urlopen(url).read().decode()
    a = ContentParser()
    a.feed(content)










