# Problem 10.28
def crawl(filename):
    '''crawls through a set of “linked” files. Every file visited by the
       crawler contains zero or more links, one per line, to other files
       and nothing else. A link to a file is just the name of the file.

       For example, the content of file file0.txt could be:

       file1.txt
       file2.txt
    '''
    print('Visiting {}'.format(filename))
    infile = open(filename)
    links = infile.readlines()
    infile.close()
    for link in links:
        crawl(link[:-1])



# Problem 10.30
from os import listdir
from os.path import join
def traverse(path, depth):
    '''Prints the relative pathname of every file and subfolder contained,
       directly or indirectly, in the folder described by pathname path.
       
       Integer depth specifies the indentation to be used when printing.'''
    for item in listdir(path):
        itemPath = join(path, item)
        print(' '*2*depth+itemPath)
        try:    # recursively traverse a subfolder
            traverse(itemPath, depth+1)
        except: # base case: exception means that item is a file
              pass

# Problem 10.33
def coins(n):
    '''returns True if, starting with n coins, there is a way
       in the simple coin game to end up with 8 coins, False otherwise'''
    if n < 8:
        return False
    if n == 8:
        return True
    if n%10 == 0 and coins(n-9):
        return True
    if n%2 == 0 and coins(n//2+1):
        return True
    if n%3 == 0 and coins(n-7):
        return True
    if n%4 == 0 and coins(n-6):
        return True
    return False


# Problem 10.34
def recDup(lst):
    'returns a copy of list lst in which every item has been duplicated'
    if len(lst) == 0:
        return []
    return recDup(lst[:-1]) + [lst[-1]]*2


# Problem 10.35
def recReverse(lst):
    'returns a reversed copy of list lst'
    if len(lst) == 0:
        return []
    return [lst[-1]] + recReverse(lst[:-1])


# Problem 10.36
def recSplit(lst, i):
    '''splits a copy of list lst so that the second part contains the
       last i items of lst; a list containing the two slices is returned'''
    if i == 0:
        return [lst, []]
    res = recSplit(lst[:-1], i-1)
    return [res[0], res[1]+[lst[-1]]]

# Problem 10.37
def jump(t, x, y):
    'makes turtle t jump to coordinates (x,y)'
    t.penup()
    t.goto(x,y)
    t.pendown()

def square(t, x, y, l):
    'has turtle t draw a square with side length l centered at (x, y)'
    jump(t, x-l/2, y-l/2)
    t.setheading(0)
    t.goto(x+l/2, y-l/2)
    t.left(90)
    t.goto(x+l/2, y+l/2)
    t.left(90)
    t.goto(x-l/2, y+l/2)
    t.left(90)
    t.goto(x-l/2, y-l/2)

def squares(t, x, y, l, n):
    'draws nth pattern of squares'
    # base case, when n = 0: do nothing
    if n > 0:           # induction step
        # draw central square first
        square(t,x,y,l)

        # recursively draw the n-1st patterns centered at
        # the 4 corners of the central square
        squares(t,x+l/2,y+l/2,l/2.2,n-1)
        squares(t,x-l/2,y+l/2,l/2.2,n-1)
        squares(t,x+l/2,y-l/2,l/2.2,n-1)
        squares(t,x-l/2,y-l/2,l/2.2,n-1)
    
