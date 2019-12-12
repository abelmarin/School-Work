from random import *

######################################################################
# Exercises which use container objects
######################################################################

# return the unique words in a sentence as a set
def unique_words(sentence):
     words = sentence.split()
     pass

# Write a function called copy_set.  There is a built-in
# ways to do this in Python, but try to write the code using a loop

# return a set
def copy_set(the_set):
     pass
# Write a function called union_sets.  Again, there is are built-in
# ways to do this in Python, but try to write the code using one or
# more loops
def union_sets(set1, set2):
    pass

# partition a set into to odd and even        
def partition(set_orig, set_even, set_odd):
    pass

######################################################################
# Dictionaries (Python dict class)
#
# Example
######################################################################

def digit_words():
    d = {}
    words = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 	     'seven','eight', 'nine']

    return d

# return a list of tuples, each tuple containing a key and its value
def keys_and_values(dictionary):
    pass

######################################################################
# Write a function called word_indices.  See the lecture notes
# for a description.
######################################################################

hamlet = 'to be or not to be'

# >>> d['to']
# [0, 4]
def word_indices(sentence):
    d = { }

    return d

######################################################################
# Write a function called count_digits.  It is passed an integer,
# and creates a dictionary whose keys are the integers 0-9 and values
# are the number of times that integer appears in the parameter.
# For example

# >>> d = count_digits(3123626106)
# >>> d[3]
# 2
# >>> d[6]
# 3
# >>> d[9]
# error

def count_digits(numbers):
    d = { }
    s = str(numbers)

# index: return a dictionary in which keys are the location of a letter # within a sentence.  The values Is the first position of the key.
# >>> d = index('a stitch in time saves nine.')
# >>> d['a']
# >>> {0, 18}

def index(sentence):
	pass

def indices(sentence):
	pass
