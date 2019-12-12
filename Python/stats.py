from ast import literal_eval
from math import sqrt

def main():
    lst = literal_eval(input('Enter the dataset:\n'))
    lst.sort()
    print('Sorted List: {}'.format(lst))
    print('Sum: {}'.format(round(sum(lst),5)))
    print('Number of Data Points: {}'.format(len(lst)))
    print('Occurrences: {}'.format(occurrences(lst)))
    print('Mean: {}'.format(round(sum(lst)/len(lst),5)))
    print('IQR: {}'.format(q3(lst)-q1(lst)))
    print('Outliers (1.5 IQR Rule): {}'.format(outliers(lst)))
    print('5-Number Summary: {}, {}, {}, {}, {}'.format(round(min(lst),5),q1(lst),median(lst),q3(lst),round(max(lst),5)))
    try:
        type(sd(lst)) == int
    except:
        print('Not a normal distribution.\nStandard Deviation, Varience, and z-score cannot be calculated')
        return mainEnd()
    print('Standard Deviation: {}'.format(sd(lst)))
    print('Varience: {}'.format(sd(lst)**2))
    print(zScore(lst))
    return mainEnd()

def mainEnd():
    answer = input('Do you want to restart the program? (y/n): ')
    if answer == 'y':
        return main()
    return

def median(lst):
    if len(lst)%2 == 0:
        return round((lst[int(len(lst)/2)]+lst[int(len(lst)/2-1)])/2,5)
    return lst[int(((len(lst)+1)/2)-1)]

def q1(lst):
    return median(lst[0:int(len(lst)/2)])

def q3(lst):
    return median(lst[int(len(lst)/2):int(len(lst))])

def outliers(lst):
    lstOutliers = []
    iqr1 = (q3(lst)-q1(lst))*1.5
    for i in lst:
        if i > iqr1+q3(lst) or i < q1(lst)-iqr1:
            lstOutliers.append(i)
    return lstOutliers

def occurrences(lst):
    n = dict()
    for i in lst:
        if i in n:
            n[i] += 1
        else:
            n[i] = 1
    return n

def sd(lst):
    mean = round(sum(lst)/len(lst),5)
    sumN = 0
    for i in lst:
        sumN += i - mean
    varience = sumN/(len(lst)-1)
    return sqrt(varience)

def zScore(lst):
    n = literal_eval(input('Enter value to calculate z-score:\n'))
    if n not in lst:
        print('Value not in dataset')
        return zScoreHelp(lst)
    print('z-score: {}'.format((n - (round(sum(lst)/len(lst),5)))/sd(lst)))
    return zScoreHelp(lst)

def zScoreHelp(lst):
    response = input('Do you want to continue? (y/n): ')
    if response == 'n':
        return ''
    return zScore(lst)

if __name__ == "__main__":
    main()
