# Problem 10.24
def base(n, b):
    'returns base-b (1 < b < 10) representation of non-negative integer n'
    if n < b:
        print(n, end=" ")
    else:
        base(n//b, b)
        print(n%b, end=" ")



# Problem 10.25
def permutations(lst):
    'returns list of all permutations (represented as lists) of list lst'
    # base case
    if len(lst) < 2:
        return [lst]

    # induction step, start by obtaining recursively
    # all the permutations of lst[1:]
    perms = permutations(lst[1:])

    # for every permutation of lst[1:], obtain permutations of lst by
    # inserting lst[0] at every possible location
    res = []
    for perm in perms:
        for i in range(len(lst)):
             res.append(perm[:i] + [lst[0]] + perm[i:])
    return res



# Problem 10.27
def pairs1(lst, target):
    '''Checks whether there are two integers in list lst of integers that
       add up to target.

       The search is done by exhaustively computing the sum for every pair
       of integers in list lst.'''
    for i in range(len(lst)-1):
        for j in range(i+1, len(lst)):
            if lst[i] + lst[j] == target:
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
    i = 0            # index of smaller integer in pair
    j = len(lst)-1   # index of larger integer in pair
    while i < j:
        s = lst[i] + lst[j] 
        if s == target:
            return True
        elif s < target: # sum is too small, so consider next smallest integer 
            i+=1
        else:            # sum is too large, so consider next largest integer
            j-=1
    print('no pair adds up to',target)

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
        print(formatStr.format(func.__name__,n,acc/runs))

# Results:
# >>> timingAnalysis(wrapPairs1, 10000, 50000, 10000, 50)
# Run-time of wrapPairs1(10000) is 0.0617672 seconds.
# Run-time of wrapPairs1(20000) is 0.0764420 seconds.
# Run-time of wrapPairs1(30000) is 0.3318517 seconds.
# Run-time of wrapPairs1(40000) is 0.4270773 seconds.
# >>> timingAnalysis(wrapPairs2, 10000, 50000, 10000, 50)
# Run-time of wrapPairs2(10000) is 0.0084601 seconds.
# Run-time of wrapPairs2(20000) is 0.0181129 seconds.
# Run-time of wrapPairs2(30000) is 0.0342777 seconds.
# Run-time of wrapPairs2(40000) is 0.0503310 seconds.



# Problem 10.29
def pascalLine(n):
    '''returns a list containing the sequence of numbers appearing in the
       nth line of Pascal’s triangle'''
    if n == 0:       # base case
        return [1]

    # induction step: start by generating line n-1
    prev = pascalLine(n-1)

    # use line n-1 to generate line n
    res = [1]
    for index in range(len(prev)-1):
        res.append(prev[index]+prev[index+1])
    res.append(1)
    return res



# Problem 10.31
import os
def search(filename, folder):
    for item in os.listdir(folder):
        fullpath = os.path.join(folder, item)
        if os.path.isfile(fullpath):
            if item == filename:
                return fullpath
        else:
            res = search(filename, fullpath)
            if res != None:
                return res
    return None



# Problem 11.18
from html.parser import HTMLParser
class ContentParser(HTMLParser):
    def handle_data(self, data):
        print(data,end='')

from urllib.request import urlopen
def getContent(url):
    'simple text web browser'
    # get HTML content
    content = urlopen(url).read().decode()
    contentParser = ContentParser()
    contentParser.feed(content)


