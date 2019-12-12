# Problem 1
def negCount(lst):
    negNum = 0
    if len(lst)==0:
        return 0
    if lst[-1]<0:
        negNum+=1
    return negNum+negCount(lst[:-1])



# Problem 2
from os import listdir
from os.path import isfile, join, getsize
def dirSize(pathname):
    if isfile(pathname):
        return getsize(pathname)
    size = 0
    for item in listdir(pathname):
        size+=dirSize(join(pathname, item))
    return size



# Problem 3
from re import findall
def test(filename):
    infile = open(filename)
    text = infile.read()
    infile.close()
    print('\n')
    print("Exercise i: words that end with string 'ible'")
    print(list(set(findall('[a-zA-Z]*ible',text))))
    print('\n')
    print("Exercise ii: words that start with an upper case and end with letters 'ar'")
    print(list(set(findall('[A-Z][a-z]*ar[\,\.\!\?\s]',text))))
    print('\n')
    print("Exercise iii: words containing the string 'death' as a substring")
    print(list(set(findall('[a-zA-Z]*death[a-z]*',text))))


# Problem 4
from urllib.parse import urljoin
from html.parser import HTMLParser
class Collector(HTMLParser):

    def __init__(self, url):
        HTMLParser.__init__(self)
        self.url = url
        self.links = []
        
    def handle_starttag(self, tag, attrs):
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    # construct absolute URL
                    absolute = urljoin(self.url, attr[1])
                    if absolute[:4] == 'http': # collect HTTP URLs
                        self.links.append(absolute)

    def getLinks(self):
        return self.links

visited = set()
d = {}

from urllib.request import urlopen
def search(url):
    visited.add(url)
    content = urlopen(url).read().decode()
    c = Collector(url)
    c.feed(content)
    for link in c.links:
        if link in d:
            d[link]+=1
        else:
            d[link]=1
        try:
            search(link)
        except:
            pass

