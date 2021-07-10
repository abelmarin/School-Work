from html.parser import HTMLParser
from urllib.request import urlopen
from urllib.parse import urljoin

class LinkParser(HTMLParser):

    def handle_starttag(self, tag, attrs):
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    print(attr[1])

class TagParser(HTMLParser):

    def __init__(self):
        HTMLParser.__init__(self)
        self.depth = 0

    def handle_starttag(self, tag, attrs):
        if tag == 'br':
            return
        print("  "*self.depth+"Start "+tag)
        self.depth += 1


    def handle_endtag(self, tag):
        if tag not in {'br'}:
            self.depth -= 1
            print("  "*self.depth+"End "+tag)


class Collector(HTMLParser):

    def __init__(self, url):
        HTMLParser.__init__(self)
        self.url = url
        self.lst = []
        self.txt = ''

    def handle_data(self, text):
        self.txt += text

    def handle_starttag(self, tag, attrs):
        if ta != 'a':
            return
        for attr in attrs:
            if attr[0] == 'href':
                link = urljoin(self.url,attr[1])
                if link[:5] == 'http:':
                    self.lst.append(link)

    def getLinks(self):
        return self.lst

    def getText(self):
        return self.txt

from re import findall

def analyze(url):
    content = urlopen(url).read().decode()
    c = Collector(url)
    c.feed(content)
    wordCount = frequency(c.getText())
    # print the results
    return c.getLinks()

def crawl(url):
    links = analyze(url)
    for link in links:
        try:
            crawl(link)
        except:
            pass





