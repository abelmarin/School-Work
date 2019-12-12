def p1(name):
    birth = {'Obama':'Hawaii',
             'Bush':'Connecticut',
             'Clinton':'Arkansas'}
    return birth[name]

phonelookup = {'(123)456-7890':['Anna','Karenina'],
               '(901)234-5678':['Yu','Tsun'],
               '(321)908-7654':['Hans','Castrop']}
def p2(phonelookup):
    number = input('Enter phone number in the format (xxx)xxx-xxxx: ')
    if number in phonelookup:
        return phonelookup[number]
    else:
        return 'The number you have entered is not in use.'

def p3(itemlist):
    counters = {}
    for item in itemlist:
        if item in counters:
            counters[item] += 1
        else:
            counters[item] = 1
    return counters

def p4(text):
    WrdList = text.split()
    counters = {}
    for word in WrdList:
        if word in counters:
            counters[word] += 1
        else:
            counters[word] = 1

    for word in counters:
        if counters[word] == 1:
            print('{:8} appears {} times.'.format(word,counters[word]))
        else:
            print('{:8} appears {} times.'.format(word,counters[word]))

def p5(phonebook):
    while True:
        
        firstName = input('Enter the first name: ')
        lastName = input('Enter the last name: ')
        name = (firstName, lastName)
        if name in phonebook:
            print(phonebook[name])
        else:
            print('This name does not exist in our phonebook')

def p6(phonebooks):
    numbers = set()
    for i in phonebooks:        
        numbers = numbers | i
    return numbers

'''
def p7(string):
    lst1 = ([string[i:i+1] for i in range(0,len(string),1)])
    counter = []
    print('Char','Decimal','Hex','Binary')
    for i in lst1:
        count = []
        encod = ord(i)
        count.append(i)
        count.append('{:d}'.format(encod))
        count.append('{:x}'.format(encod))
        count.append('{:b}'.format(encod))
        counter.append(count)
        count = []
    return counter
'''

def p7(string):
    lst1 = ([string[i:i+1] for i in range(0,len(string),1)])
    print('Char','Decimal','Hex','Binary')
    for i in lst1:
        encode = ord(i)
        print(i,' ' ,ord(i),'{:b}'.format(encode))
        




