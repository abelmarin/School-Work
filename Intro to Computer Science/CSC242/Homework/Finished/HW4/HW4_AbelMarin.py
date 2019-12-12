# Abel Marin
# Problem 1 (8.34)
# Stat as a subclass of object
class Stat(object):
    'container for numbers that supports statistical methods'

    def __init__(self):
        'constructor'
        self.s = []

    def __len__(self):
        return len(self.s)

    def add(self, num):
        self.s.append(num)

    def min(self):
        return min(self.s)

    def max(self):
        return max(self.s)

    def sum(self):
        return sum(self.s)

    def mean(self):
        return self.sum()/len(self)

    def __contains__(self, other):
        return other in self.s

    def clear(self):
        self.s = []

# Stat as a subclass of list
class Stat2(list):
    'container for numbers that supports statistical methods'

    def add(self,new):
        self.append(new)

    def sum(self):
        return sum(self)

    def min(self):
        return min(self)

    def max(self):
        return max(self)

    def mean(self):
        return sum(self)/len(self)
    

# Problem 2
class NegativeCursorError(Exception):
    pass

class Cursor:
    
    def __init__(self):
        self.c = 0

    def curr(self):
        return self.c

    def next(self):
        self.c += 1
        return self.c

    def prev(self):
        if self.c == 0:
            raise NegativeCursorError()
        self.c -= 1
        return self.c

 
    
