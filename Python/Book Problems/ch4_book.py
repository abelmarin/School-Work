def p1():
    s = '0123456789'
    print(s[2:5])
    print(s[7:9])
    print(s[1:8])
    print(s[0:4])
    print(s[7:])

def p2():
    forecast = 'It will be a sunny day today'
    count = forecast.count('day')
    print(count)
    weather = forecast.find('sunny')
    print(weather)
    change = forecast.replace('sunny', 'cloudy')
    print(change)

def p3():
    last = 'Smith'
    first = 'John'
    middle = 'Paul'
    print(last, first, middle, sep='\t')

def p4(n):
    for i in range(2, n+1):
        if i % 2 == 0 or i % 3 == 0:
            print(i, end=', ')

def p5():
    first = 'John'
    last = 'Doe'
    street = 'Main Street'
    number = 123
    city = 'Plano'
    state = 'IL'
    zipcode = '60545'
    print('{} {}\n{} {}\n{}, {} {}'.format(first, last, number, street, city, state, zipcode))

def p6():
    students = [ ]
    students.append(['DeMoines', 'Jim', 'Sophomore', 3.45])
    students.append(['Pierre', 'Sophie', 'Sophomore', 4.0])
    students.append(['Columbus', 'Maria', 'Senior', 2.5])
    students.append(['Phoenix', 'River', 'Junior', 2.45])
    students.append(['Olympis', 'Edger', 'Junior', 3.99])
    print('Last      First     Class     Average Grade')
    formatstr = '{0:6} {1:6} {2:6} {3:6}'
    for i in students:
        print('{:10}{:10}{:10}{:8.2f}'.format(i[0], i[1], i[2], i[3]))

def p7():
    pass

#infile = open('newfile.txt')


def p8(infile, line):
    infile = open(infile)
    content = infile.read()
    amount = content.count(line)
    wrdlst = content.split()
    infile.close()
    print(wrdlst)
    return amount

def p9(file):
    file = open(file, 'r')
    content = file.read()
    file.close()
    table = str.maketrans("'!,.:;?", 7*' ')
    content = content.translate(table)
    content = content.lower()
    return content.split()

def p10():
    pass

def pll():
    pass

def p12():
    pass

def p13():
    pass

def p14():
    pass

def p15():
    pass

def p16():
    pass

def p17():
    pass

def p18():
    pass

def p19():
    pass

def p20():
    pass

def p21():
    pass
