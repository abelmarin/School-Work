'''
CSC 241 Section 404 Fall 2018  
Preparation for Final Exam

These practice problems are intended to help you review for the
upcoming final exam.  Sample solutions will be posted after the
Tuesday lab.  We have covered almost all of the first 7 chapters
of Perkovic' text,  Any questions from material covered in these
chapters may be on the exam, although there will be emphasis
of topics covered during the 2nd half of the quarter.

We will work on these problems during the 11/12 lecture.

This is MUCH LONGER than your final exam will be.
I want you to practice on a wide range of problems.

Problem 0:  Look up your exam date and confirm this information.  

https://academics.depaul.edu/calendar/Pages/finals-calendar.aspx

Autumn Term

Your Class Meeting Day/Time     Exam Date           Exam Time

MW (Loop) 1:30pm-3:00pm         Wednesday - 11/14   11:30am-1:45pm 
'''


# Example written problems

# Problem 1

# Select ONLY one of (a), (b), (c) below.

# You'd like to write a program which receives numeric
# input from the user, intended to represent a month of the
# year.  Your program should print the name of the month.
# For example:
#
# >>> What month?
# 11
# 11 is November
#
# Which would you use:  (a) list (b) set (c) dict
'''
(c) dict
'''
#
# Problem 2

# Select ONLY one of (a), (b), (c) below.

# You'd like to write a program which receives alphabetic
# input from the user, corresponding to the name of
# one of the months.  Your program should print a number
# between 1 and 12 (inclusive).
# For example:
#
# >>> What month?
# January
# January is 1
#
# Which would you use:  (a) list (b) set (c) dict
'''
(c) dict
'''
#
# Problem 3
#
# Which of the following built-in Python classes are mutable?
#
# int, list, str, set, dict, tuple

# For each mutable class, give 3 operators, functions or methods which
# are "desctructive"; that is, they modify the underlying object.
'''
list: append, clear, pop
set: add, remove, union
dict: 
'''
#
# Problem 4
#
# What kind of object is created by each of the following statements?
# Assume the statements are executed in sequence.
#
# (a) x = 20
#
# (b) x = sqrt(20) 
#
# (c) x = { }
'''
(a) int
(b) float
(c) dict
'''
#
# Problem 5
#
# The Python math module contains a function called factorial, which
# is passed one parameter.

# (a) Assume we have used the following import
# statement:
#
# import math
#
# Write Python statements to ask for input from the user, to
# be stored as an int in the variable n, and then print n!
#
# (b) Now assume we have used the following import
# statement:
#
# from math import factorial
#
# Write Python statements  to ask for input from the user, to
# be stored as an int in the variable n, and then print n!

# Example programming problems

# Problem 1

# Write a function that converts a list of words to a string.
# The string should contain each word in the list with a ' '
# in between each.  For example, list_to_string(['final', 'review', 'problems'])
# should return 'final review problems'.

def list_to_string(list):
     s = ' '
     print("'" +s.join(list)+"'")


# Problem 2

# write a function called two_equal_indices, that returns a list of lists.  
# The inner lists are all of length 2, and represent indices of all the pairs #
# in the list which are == .  For example, 
# two_eq_indices([3,1,2,3,6,2,6,1,0,6]) should return 
# [[0,3], [1,7], [4,6], [6,9]).

def two_equal_indices(num_list):
    lst1 = [ ]
    lst2 = [ ]
    for i in num_list:
         for j in range(0,len(lst1)):
              if i == j:
                   lst2.append([num_list.index(i),num_list.index(j)])
         lst1.append(i)
    return lst2

# Problem 3

# write a function that reads a file and returns the number of
# words in the file which begin with a vowel ('aeiou').  For example:
#
# >>>starts_with_vowel('raven.txt')
# 1724

# Your answer may vary depending on the translation table you use to
# eliminate punctuation marks.
to_rid = "'\".,!'\n[]"
table = str.maketrans(to_rid, ' ' * len(to_rid))
def standardize_line(line):
    line = line.lower()
    line = line.translate(table)
    line = line.strip()
    words = line.split()
    return words

def starts_with_vowel(input_file):
    f = open(input_file)
    words = standardize_line(f.read())
    answer = 0
    for i in words:
         if i[0] in 'aeiouAEIOU':
              answer += 1
    return answer

# Problem 4

# write a function that reads a file and returns a dictionary whose keys
# are the 26 letters of the alphabet, and whose values are a list of 
# the words from the file that begin with the letter.
'''
def by_first_letter(input_file):
    d = dict()
    f = open('raven.txt')
    words = f.read().split()
    punc = '!"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~'
    import string
    for word in words:
         if punc in words:
              word.remoce(word)
#
#
              #
     for word in words:
          if word[0] not in d:
               d[word[0]] = [word]
          else:
               d[word[0]].append(word)
    return 
'''
# Problem 5.  Write a function called grep.  It is passed a file name and a string,
# and prints the line number of each line in the file in which the string occurs.
# The whole line is printed.

def grep (string, file):
   f = open(file)
   lines = f.readlines()
   strline = []
   for line in range(len(f.readlines())):
        if string in lines[line].split():
             print(str(line+1) + ' ' + lines[line])
             
   # print when appropriate

# Problem 6.  Write a function called duplicate_keys.  It is passed 2 dictionaries,
# and returns a set of keys that appear in both dicionaries.
def duplicate_keys(d1, d2):
   answer = set()
   for key in d1:
        if key in d2:
             answer.add(key)
   return answer

# Problem 7.  Write a function called update_dictionary.
# The function should be passed 2 parameters, both of which
# are dictionaries.  The first is intended to be an existing
# (older) dictionary. and the second is intended to contain
# entries which should be updated in the first dictionary.
# Therefore the function is destructive on the
# first dictionary (parameter). Whenever the first and second
# dictionaries share a key, the value from the second dictionary
# takes the place of the value in the first dictionary.
# Any keys which are in the second dictionary but not in the
# first are also copied into the first dictionary along with
# their values (entries)

def update_dictionary(old_dictionary, update):
   for key in update:
        old_dictionary[key] = update[key]

