# http://reed.cs.depaul.edu/lperkovic/csc242/homeworks/FinalPracticeW19.html

# Problem 1
def prod(lst):
    if len(lst) == 0:
        return 1
    return prod(lst[:-1])*lst[-1]



# Problem 2
from os import listdir
from os.path import isfile, join
def fileNum(pathname):
    if isfile(pathname):
        return 1
    res = 0
    for item in listdir(pathname):
        res += fileNum(join(pathname,item))
    return res


# Problem 3
import re
def test(filename):
    infile = open(filename)
    text = infile.read()
    infile.close()
    print("Exercise i: the number of times the string Frankenstein appears in the text:")
    print(len(re.findall('Frankenstein', text)))
    print('\n\n')
    print("Exercise ii: the list of all different numbers appearing in the text")
    print(list(set(re.findall('[0-9]+',text))))
    print('\n\n')
    print("Exercise iii: the list of strings of the form 'horror of <lowercase string> <lowercase string>'")
    print(re.findall('REPLACE THIS WITH YOUR REGULAR EXPRESSION',text))
    print('\n\n')
    print("Exercise iv: the sentences containing the word 'laboratory'")
    for res in list(set(re.findall('REPLACE THIS WITH YOUR REGULAR EXPRESSION',text))):
        print(res)
        print()


        
# Problem 4
from urllib.parse import urljoin
from html.parser import HTMLParser
class Collector(HTMLParser):
    'collects hyperlink URLs into a list'

    def __init__(self, url):
        'initializes parser, the url, and a list'
        HTMLParser.__init__(self)
        self.url = url
        self.links = []

        # Solution to practice problem 11.3        
        self.text = ''
        
    def handle_starttag(self, tag, attrs):
        'collects hyperlink URLs in their absolute format'
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    # construct absolute URL
                    absolute = urljoin(self.url, attr[1])
                    if absolute[:4] == 'http': # collect HTTP URLs
                        self.links.append(absolute)
                        
    # Solution to practice problem 11.3        
    def handle_data(self, data):
        'collects and concatenates text data'
        self.text += data

    def getLinks(self):
        'returns hyperlinks URLs in their absolute format'
        return self.links

    # Solution to practice problem 11.3
    def getData(self):
        'returns the concatenation of all text data'
        return self.text

from url.request import urlopen
def webdir(url, depth, indent):
    print('    '*indent+ url)
    content = urlopen(url).read().decode()
    c = Collector(url)
    c.feed(content)
    for link in c.links:
        try:
            webdir(link,depth-1,indent+1)
        except:
            pass








