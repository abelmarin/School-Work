from random import *

def stringToIntList(text): 
    text = text.lower()
    lst = [(ord(letter) - ord('a')) for letter in text if letter.isalpha()] 
    return lst

def intListToString(lst):
    text = ''.join([chr(ord('a')+code) for code in lst]) 
    return text

#affine cipher
def affine_h(pt,a,b):
    #helper function: works on coded text 
    return [(a*x+b)%26 for x in pt]

def antiAffine_h(pt,inverseA,minusB):
    #helper function: works on coded text
    return [((x+minusB)*inverseA)%26 for x in pt] # Change that first x!

def encode(pt,a,b):
    pt = stringToIntList(pt)
    return intListToString(affine_h(pt,a,b))

def decode(pt,inverseA,minusB):
    pt = stringToIntList(pt)
    return intListToString(antiAffine_h(pt,inverseA,minusB))

# trying every possible a-1 and -b to decode the message
message = "gjccz"
for inverseA in [1, 3, 4, 7, 9, 11, 15, 17, 19, 21, 23, 25]:
    for minusB in range(26):
        print("Messege: {}, a-1: {}, -b: {}".format(decode(message,inverseA,minusB),inverseA,minusB))