# Abel Marin

# Problem 8.25, 8.26, 8.27
class Textfile(object):
    ' a class that provides tools to analyze a text file'

    def __init__(self, file):
        self.f = file

    def nchars(self):
        file = open(self.f)
        return len(file.read())

    def nlines(self):
        file = open(self.f)
        return len(file.readlines())

    def nwords(self):
        file = open(self.f)
        return len(file.read().split())

    def read(self):
        file = open(self.f)
        return file.read()

    def readlines(self):
        file = open(self.f)
        return file.readlines()

    def grep(self, word):
        file = open(self.f)
        lines = file.readlines()
        count = 0
        for i in lines:
            if i.find(word) != -1:
                print('{}:{}'.format(count,i))
            count += 1

    def words(self):
        file = open(self.f)
        lst_words = file.read().split()
        words = []
        for word in lst_words:
            if word not in words:
                words.append(word)
        return words

    def occurences(self):
        file = open(self.f)
        lst_words = file.read().split()
        words = {}
        for i in lst_words:
            if i not in words:
                words[i]=1
            else:
                words[i]+=1
        return words

# Problem 8.35
class Stack(object):
    'classic stack class'

#INVARIENT: All insertions and removals are from the end of the stack (otherwise
#known as the top of the stack) and it is also a last-in-first-out container.

    def __init__(self):
        self.s = []

    def __repr__(self):
        return '{}'.format(self.s)

    def __len__(self):
        return len(self.s)

    def push(self, item):
        self.s.append(item)

    def pop(self):
        return self.s.pop()

    def isEmpty(self):
        return len(self) == 0

# Problem 8.36
class PriorityQueue(object):
    'Priority queue class'

    def __init__(self):
        self.q = []

    def __len__(self):
        return len(self.q)

    def isEmpty(self):
        return len(self) == 0

    def insert(self, item):
        self.q.append(item)

    def min(self):
        return min(self.q)

    def removeMin(self):
        self.q.remove(self.min())

class ValueError(Exception):
    pass

# Problem 8.40
class BankAccount2(object):
    'a second bank account class'

    def __init__(self, initial=0):
        'constructor'
        if initial < 0:
            raise ValueError('Illegal balance')
        self.b = initial
        
        
    def withdraw(self, amount):
        'withdraws amount'
        if self.b - amount < 0:
            raise ValueError('Illegal balance')
        self.b -= amount

    def deposit(self,amount):
        'deposits amount'
        if self.b + amount < 0:
            raise ValueError('Illegal balance')
        self.b += amount

    def balance(self):
        'returns balance'
        return self.b

# Problem 8.41
class NegativeBalanceError(Exception):
    pass

class OverDraftError(Exception):
    pass

class DepositError(Exception):
    pass

class BankAccount3(BankAccount2):

    def __init__(self, initial=0):
        'constructor'
        if initial < 0:
            raise NegativeBalanceError('Account created with negative balance {}'.format(initial))
        self.b = initial
        
    def withdraw(self, amount):
        'withdraws amount'
        if self.b - amount < 0:
            raise OverDraftError('Operation would result in negative balance {}'.format(self.b-amount))
        self.b -= amount

    def deposit(self,amount):
        'deposits amount'
        if self.b + amount < 0:
            raise DepositError('Negative deposit {}'.format(amount))
        self.b += amount
        
