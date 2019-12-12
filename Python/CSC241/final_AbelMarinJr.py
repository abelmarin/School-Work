'''
Abel Marin Jr.
CSC 241 Section 404 Fall 2018  
Final Exam
Wednesday - 11/14   11:30am-1:45pm 

Directions:  The exam is open book, open notes, open Internet.
It will be graded on a scale of 0-10.  The exam is worth 25%
of your overall grade for the quarter.  All work must be
your own, with no communication between you and anyone else.

Each problem is worth 2 points.  Please write your answers
into this .py file, and submit on D2L by the scheduled
end of the exam period.

---------
Problem 1
---------

Select ONLY one of (a), (b), (c) below.
No need to write any Python code.

You'd like to write a program which reads
the contents of a text file and stores them
in a Python object so that the words are
alphabetized (in lexicographical order).
Which Python class would you use to store
the words?

Which would you use:  (a) list (b) set (c) dict
'''
#(a) list
'''
---------
Problem 2
---------

Assume this 

lst1 = [1, 2]
lst2 = [3, 4]
item = 5

Which of the following built-in Python
operators/methods/functions are 
destructive?  Select from any/all of a-d.
No need to write any Python code.

(a) ans = lst1 + lst2
(b) ans = lst1
(c) ans = lst1.append(item)
(d) ans = len(lst1)
'''
# (c) ans = lst1.append(item)
'''
---------
Problem 3
---------

Complete the Python function below, so that
it returns an int. 
'''
def get_int():
  int = 8
  return int

'''
---------
Problem 4
---------

Replace the keyword None below, and then
fill in the missing line(s) of code in the function f.
The function should print 'Thanks' or 
'You already typed that number'.

'''
numbers = [ ]

def f(number):
  if number in numbers:
    return 'You already typed that number'
  elif number not in numbers:
    numbers.append(number)
    return 'Thanks'
  
'''
---------
Problem 5
---------

Complete the function "most_repeatly".  It
should return the item which appears most
often in a list.
'''
def most_repeatedly(lst):
  return max(set(lst), key=lst.count)
  
    
    






