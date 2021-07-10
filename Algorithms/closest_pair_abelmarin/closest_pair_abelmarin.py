import math

def closest_point(s):
    length = int(len(s))
    left = s[0:int(length/2)]
    right = s[int(length/2):]
    mid = (left[-1][0]+right[0][0])/2.0

    if len(left) > 2:
        lmin = closest_point(left)    
    else:
        lmin = left

    if len(right) > 2:
        rmin = closest_point(right)   
    else:
        rmin = right

    if len(lmin) >1:
        dis_l = distance(lmin)
    else:
        dis_l = float("inf")
    if len(rmin) >1:
        dis_2 = distance(rmin)
    else:
        dis_2 = float("inf")

    d = min(dis_l, dis_2) 

    mid_min=[]
    for i in left:
        if mid-i[0]<=d :   
            for j in right:
                if abs(i[0]-j[0])<=d and abs(i[1]-j[1])<=d:
                    if distance((i,j))<=d:
                        mid_min.append([i,j])   
    if mid_min:
        l=[]
        for i in mid_min:
            l.append({distance(i):i})
        l.sort(key=lambda x: x.keys())
        return (l[0].values())[0]
    elif dis_l > dis_2:
        return rmin
    else:
        return lmin
    
def distance(min):
    return math.sqrt((min[0][0]-min[1][0])**2 + (min[0][1]-min[1][1])**2)
    
def divideAndConquer(s):
    sorted(s,key=lambda l:l[1])
    cpp = closest_point(s)
    print ("The minimum distance is:")
    print (distance(cpp))
    print (cpp)



def convertToInt(test):
    for i in range(0,len(test)):
        if test[i] == '':
            test.remove(test[i])
    for j in range(0,len(test)):
        test[j] = test[j].split(" ")
        test[j][0] = int(test[j][0])
        test[j][1] = int(test[j][1])
    return test

file1 = open("tests&solution/10points.txt")
file1 = file1.read()
test1 = file1.split('\n')
test1 = convertToInt(test1)
file2 = open("tests&solution/100points.txt")
file2 = file2.read()
test2 = file2.split('\n')
test2 = convertToInt(test2)
file3 = open("tests&solution/1000points.txt")
file3 = file3.read()
test3 = file3.split('\n')
test3 = convertToInt(test3)

# print(test1)
# print(test2)
# print(test3)

divideAndConquer(test2)
