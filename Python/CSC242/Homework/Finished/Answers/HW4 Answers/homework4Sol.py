# Problem 11 (8.34)
# Stat as a subclass of object
class Stat(object):
    'container for numbers that supports statistical methods'

    def __init__(self):
        'constructor'
        self.l = []

    def add(self, value):
        'adds value to Stat container'
        self.l.append(value)

    def min(self):
        'returns minimum value in container'
        return min(self.l)

    def max(self):
        'returns maximum value in container'
        return max(self.l)

    def mean(self):
        'returns average of items in container'
        return self.sum()/float(len(self))

    def sum(self):
        'returns sum of values in container'
        return sum(self.l)

    def __contains__(self, value):
        'returns True if in the container'
        return value in self.l

    def clear(self):
        'Empties the container'
        self.l = []

    def __len__(self):
        'returns number of items in container'
        return(len(self.l))


# Stat as a subclass of list
class Stat(list):
    'container for numbers that supports statistical methods'

    def add(self, value):
        'adds value to Stat container'
        self.append(value)

    def min(self):
        'returns minimum value in container'
        return min(self)

    def max(self):
        'returns maximum value in container'
        return max(self)

    def sum(self):
        'returns sum of values in container'
        return sum(self)
    
    def mean(self):
        'returns average of items in container'
        return self.sum()/float(len(self))


# Problem 2
class NegativeCursorError(Exception):
    pass

class Cursor(object):
    def __init__(self):
        self.i = 0
    def curr(self):
        return self.i
    def next(self):
        self.i += 1
        return self.i
    def prev(self):
        if self.i == 0:
            raise NegativeCursorError()
        self.i -= 1
        return self.i



    
