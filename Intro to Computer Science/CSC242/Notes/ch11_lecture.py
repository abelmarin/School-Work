response=urlopen('http://reed.cs.depaul.edu/lperkovic/csc242/lecture8/w3c.html')
>>> response
<http.client.HTTPResponse object at 0x112d962e8>
>>> type(response)
<class 'http.client.HTTPResponse'>
>>> response.geturl()
'http://reed.cs.depaul.edu/lperkovic/csc242/lecture8/w3c.html'
>>> for header in response.getheaders():
	print(header)
	
('Server', 'Apache-Coyote/1.1')
('Set-Cookie', 'JSESSIONID=4314491AFCB331EAEACD100985BA4319; Path=/lperkovic/; HttpOnly')
('Accept-Ranges', 'bytes')
('ETag', 'W/"440-1551068984000"')
('Last-Modified', 'Mon, 25 Feb 2019 04:29:44 GMT')
('Content-Type', 'text/html')
('Content-Length', '440')
('Date', 'Wed, 27 Feb 2019 19:00:51 GMT')
('Connection', 'close')
>>> response.read()
b'<html>\n<head>\n<title>W3C Mission Summary</title>\n</head>\n<body>\n<h1>W3C Mission</h1>\n<p>\nThe W3C mission is to lead the World Wide Web to its full potential<br>\nby developing protocols and guidelines that ensure the long-term growth of the Web.\n</p>\n<h2>Principles</h2>\n<ul>\n<li>Web for All</li>\n<li>Web on Everything</li>\n</ul>\nSee the complete <a href="http://www.w3.org/Consortium/mission.html">W3C Mission document</a>.\n</body>\n</html>\n'
>>> response.read()
b''
>>> response=urlopen('http://reed.cs.depaul.edu/lperkovic/csc242/lecture8/w3c.html')
>>> response.read()
b'<html>\n<head>\n<title>W3C Mission Summary</title>\n</head>\n<body>\n<h1>W3C Mission</h1>\n<p>\nThe W3C mission is to lead the World Wide Web to its full potential<br>\nby developing protocols and guidelines that ensure the long-term growth of the Web.\n</p>\n<h2>Principles</h2>\n<ul>\n<li>Web for All</li>\n<li>Web on Everything</li>\n</ul>\nSee the complete <a href="http://www.w3.org/Consortium/mission.html">W3C Mission document</a>.\n</body>\n</html>\n'
>>> response=urlopen('http://reed.cs.depaul.edu/lperkovic/csc242/lecture8/w3c.html')
>>> content = response.read()
>>> type(content)
<class 'bytes'>
>>> content = content.decode()
>>> content
'<html>\n<head>\n<title>W3C Mission Summary</title>\n</head>\n<body>\n<h1>W3C Mission</h1>\n<p>\nThe W3C mission is to lead the World Wide Web to its full potential<br>\nby developing protocols and guidelines that ensure the long-term growth of the Web.\n</p>\n<h2>Principles</h2>\n<ul>\n<li>Web for All</li>\n<li>Web on Everything</li>\n</ul>\nSee the complete <a href="http://www.w3.org/Consortium/mission.html">W3C Mission document</a>.\n</body>\n</html>\n'
>>> 
