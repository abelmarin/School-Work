# Abel Marin

'''
# Exercise 11.7
a) a, b
b) acbc, acbd
c) the empty string, a, b, ab
d) b, aabaa, aaaab, ba
e) abc, ?.?

# Exercise 11.8
a) .*\'.*
b) [a-z][a-z][a-z]
c) [1-9]\d*
d) [1-9]\d*|0
e) \-[1-9]\d*
f) [1-9]\d*|0|\-[1-9]\d*
g) [1-9]\d*\.\d+|0\.\d+|-0\.\d+|\-[1-9]\d*\.\d+

# Exercise 11.9 e-g
>>> from re import findall
>>> infile = open('frankenstein.txt')
>>> content = infile.read()
>>> infile.close()
e) findall('horror of [a-z]+ [a-z]+',content)
f) findall('\w+ death',content)
g) findall('[^.\!\?]*laboratory[^.\!\?]*',content)

'''

# Problem 11.16
from html.parser import HTMLParser
class ListCollector(HTMLParser):

    def __init__(self):
        HTMLParser.__init__(self)
        self.result = []
        self.truth = False

    def handle_starttag(self,tag,attrs):
        if tag in {'ol','ul'}:
            self.lst = []
        elif tag == 'li':
            self.truth = True

    def handle_data(self,data):
        if self.truth:
            self.lst.append(data)

    def handle_endtag(self,tag):
        if tag in {'ol','ul'}:
            self.result.append(self.lst)
        elif tag == 'li':
            self.truth = False

    def getLists(self):
        return self.result

# Problem 11.19
from re import findall
def emails(content):
    'return set of email addresses contained in string content'
    s = set()
    pat = 'mailto:[^@]+@[\w\.]+'
    stuff = findall(pat,content)
    for i in stuff:
        s.add(i[7:])
    return s

# Problem B
from urllib.parse import urljoin
from html.parser import HTMLParser
from urllib.request import urlopen

class Collector(HTMLParser):
    'collects hyperlink URLs into a list'

    def __init__(self, url):
        'initializes parser, the url, and a list'
        HTMLParser.__init__(self)
        self.url = url
        self.links = []
        
    def handle_starttag(self, tag, attrs):
        'collects hyperlink URLs in their absolute format'
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    absolute = urljoin(self.url, attr[1])
                    if absolute[:5] == 'http:':
                        self.links.append(absolute)
                        
    def getLinks(self):
        'returns hyperlinks URLs in their absolute format'
        return self.links

spam_set = set()
def spam(url,n):
    content = urlopen(url).read().decode('utf-8')
    c = Collector(url)
    c.feed(content)
    global spam_set
    spam_set.update(emails(content))
    if n == 0:
        return
    for i in c.links:
        try:
            spam(i, n-1)
        except:
            pass


