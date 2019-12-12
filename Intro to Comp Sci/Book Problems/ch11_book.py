from urllib.request import urlopen
def news(url,lst_words):
    ur = urlopen(url).read().decode()
    for i in lst_words:
        numWords = ur.count(i)
        print('{} appears {} times.'.format(i,numWords))
        
# Parsing: The process of analyzing a document in order
# to break it into components and obtain its structure.

from html.parser import HTMLParser
class LinkParser(HTMLParser):
    
    def handle_starttag(self,tag,attrs):
        if tag=='a':
            for attr in attrs:
                if attr[0] == 'href':
                    print(attr[1])

class MyHTMLParser(HTMLParser):

    def __init__(self):
        HTMLParser.__init__(self)
        self.num = 0

    def handle_starttag(self,tag,attrs):
        if tag not in ['br','p']:
            self.num +=1
            print(' '*self.num+tag+' start')

    def handle_endtag(self,tag):
        if tag not in ['br','p']:
            print(' '*self.num+tag+' end')
            self.num -= 1

from urllib.parse import urljoin
class Collector(HTMLParser):

    def __init__(self,url):
        HTMLParser.__init__(self)
        self.url = url
        self.links = []
        self.d = ''

    def handle_starttag(self,tag,attrs):
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    # construct absolute URL
                    absolute = urljoin(self.url,attr[1])
                    if absolute[:4] == 'http':
                        self.links.append(absolute)
                        
    def handle_data(self,data):
        self.d += data
        
    def getLinks(self):
        return self.links

    def getData(self):
        return self.d

'''
Regular Expressions:
best == best

. is a wildcard character which can be any character
except for '\n'

be.t == best,beet,bett,be$t, ect

-----------------------------------------------------------

* is 0 or more repetitions of the previous character

be*t == bt,bet,beet,beeet,ect

-----------------------------------------------------------

# + is 1 or more repetitions of the previous character

be+t == bet, beet, beeet,ect

-----------------------------------------------------------

? is 0 or 1 repetitions of the previous character

be?t == bt,bet

-----------------------------------------------------------

[] matches any 1 character listed with the brackets

be[ls]t == belt, best

- is used in brackets and represent a range of characters

be[l-o]t == belt,bemt,bent,beot

^ is used in brackets and represents range of characters not
allowed in the set

be[^0-9] == best, be!t, ect (not be4t)

-----------------------------------------------------------

| is used as an or operator

hello|Hello == hello,Hello

a+|b+ == a, b, abbb, ect and ba, baa, baaa, ect

'''

'''
Practice Problem 11.4
    a) Hello, hello
    b) re-sign, resign
    c) aaa, best
    d) F16, IBM
    e) <h1>, <<>>>>
'''
'''
\d == any digit or [0-9]
\D == any nodigit character or [^0-9]
\s == any whitespace character including the black space,
    carriage return \r, tab \t, and \n
\S == any non-whitespace character
\w == any alphanumeric character or [a-zA-Z0-9_]
\W == any nonalphanumeric character or [^a-zA-Z0-9_]
'''
'''
Practice Problem 11.5
    a) a[abc]c
    b) abc | xyz
    c) a[b]*
    d) [a-z]+
    e) [a-zA-Z]*oe[a-zA-Z]*
    f) <[^>]*>
'''
from re import findall
def frequency(string):
    d = dict()
    pattern = '[a-zA-Z]+'
    words = findall(pattern, string)
    for i in words:
        if i in d:
            d[i] += 1
        else:
            d[i] = 1
    return d








