# Problem 8.25
from string import punctuation # used in Problems 8.25, 8.26
class Textfile(object):
    ' a class that provides tools to analyze a text file'

    files = []                     # list of all textfile objects

    def __init__(self, filename):
        '''constructor that associates textfile object with
           file named filename'''
        self.name = filename
        handle = open(filename)
        self.content = handle.read()
        handle.close()
        Textfile.files.append(filename)

    def nchars(self):
        'returns the number of characters in the file'
        return len(self.content)

    def nwords(self):
        'returns the number of words in the file'
        return len(self.content.split())

    def nlines(self):
        'returns the number of lines in the file'
        return self.content.count('\n')

    def read(self):
        'returns the content of the file as a string'
        return self.content

    def readlines(self):
        'returns the content of the file as a list of lines'
        return self.content.split('\n')

    def grep(self, target):
        'prints out all lines containing string target'
        lines = self.readlines()
        for i in range(len(lines)):
            if lines[i].find(target) >= 0:
                print('{}: {}'.format(i, lines[i]))

    # Problem 8.26
    def words(self):
        table = str.maketrans(punctuation, ' '*len(punctuation))
        cleanText = self.content.translate(table)
        res = list(set(cleanText.split()))
        res.sort()
        return res
                
    # Problem 8.27
    def occurences(self):
        table = str.maketrans(punctuation, ' '*len(punctuation))
        cleanText = self.content.translate(table)
        wordList = cleanText.split()
        d = {}
        for w in wordList:
            if w not in d:
                d[w] = 1
            else:
                d[w] += 1
        return d



# Problem 8.35
class Stack(object):
    'classic stack class'

    def __init__(self):
        'constructor initializes empty stack'
        self.s = []

    def pop(self):
        'removes and returns top item in stack'
        return self.s.pop()

    def push (self, item):
        'pushes item into stack'
        return self.s.append(item)

    def isEmpty(self):
        'checks whether stack is empty'
        return (len(self) == 0)

    def __len__(self):
        'returns length of stack'
        return len(self.s)

    def __repr__(self):
        'returns a string representation of stack object'
        return repr(self.s)



# Problem 8.36
# Priority Queue using sorted, in non-increasing order, list invariant
# (with O(1) removeMin).
# The implementation of method insert() is made to be simple rather
# than efficient
class PriorityQueue(object):
    'Priority queue class'

    def __init__(self):
        'constructor initializes empty priority queue'
        self.l = []

    def insert(self, item):
        'inserts item into priority queue'
        self.l.append(item)
        self.l.sort(reverse=True)

    def min(self):
        'returns minimum item in priority queue'
        return self.l[-1]

    def removeMin(self):
        'removes minimum item in priority queue'
        self.l.pop()

    def __len__(self):
        'returns size of priority queue'
        return len(self.l)

    def isEmpty(self):
        'checks whether priority queue is empty'
        return len(self) == 0


# Priority Queue using unsorted list invariant (with O(1) insert)
# The implementation of method removeMin() is made to be simple rather
# than efficient
class PriorityQueue2(object):
    'Priority queue class'

    def __init__(self):
        'constructor initializes empty priority queue'
        self.l = []

    def insert(self, item):
        'inserts item into priority queue'
        self.l.append(item)

    def min(self):
        'returns minimum item in priority queue'
        return min(self.l)

    def removeMin(self):
        'removes minimum item in priority queue'
        self.l.remove(min(self.l))

    def __len__(self):
        'returns size of priority queue'
        return len(self.l)

    def isEmpty(self):
        'checks whether priority queue is empty'
        return len(self) == 0



# Problem 8.40
class BankAccount2(object):
    'a second bank account class'

    def __init__(self, initial=0):
        'constructor; raises ValueError exception if initial balance is negative'
        if initial < 0:
            raise ValueError('Negative balance')
        self.b = initial

    def withdraw(self, amount):
        'withdraws amount; raises ValueError exception if resulting balance is negative'
        if self.b - amount<0:
            raise ValueError('Overdraft')
        self.b -= amount

    def deposit(self, amount):
        'deposits amount; raises ValueError exception if amount is negative'
        if amount < 0:
            raise ValueError('Negative deposit')
        self.b += amount

    def balance(self):
        'returns balance'
        return self.b



# Problem 8.41
class NegativeBalanceError(Exception):
    'negative balance exception'

    def __init__(self,value):
        self.value = value

    def __str__(self):
        return 'Account created with negative balance ' + repr(self.value)

class OverdraftError(Exception):
    'overdraft exception'

    def __init__(self,value):
        self.value = value

    def __str__(self):
        return 'Operation would result in negative balance ' + repr(self.value)

class DepositError(Exception):
    'negative deposit exception'

    def __init__(self,value):
        self.value = value

    def __str__(self):
        return 'Negative deposit ' + repr(self.value)

class BankAccount3(object):
    'a third bank account class'

    def __init__(self, initial=0):
        'constructor; raises NegativeBalanceError exception if initial balance is negative'
        if initial < 0:
            raise NegativeBalanceError(initial)
        self.b = initial

    def withdraw(self, amount):
        'withdraws amount; raises OverdraftError exception if resulting balance is negative'
        if self.b-amount<0:
            raise OverdraftError(self.b-amount)
        self.b -= amount

    def deposit(self,amount):
        'deposits amount raises DepositError exception if amount is negative'
        if amount < 0:
            raise DepositError(amount)
        self.b += amount

    def balance(self):
        'returns balance'
        return self.b

