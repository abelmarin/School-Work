import sys

sys.setrecursionlimit(2000)

def mergeSort(A):
    if len(A) >1: 
        middle = len(A)//2
        Left = A[:middle] 
        Right = A[middle:]
        mergeSort(Left)
        mergeSort(Right)
        i = j = k = 0
        while i < len(Left) and j < len(Right): 
            if Left[i] < Right[j]: 
                A[k] = Left[i] 
                i+=1
            else: 
                A[k] = Right[j] 
                j+=1
            k+=1
        while i < len(Left): 
            A[k] = Left[i] 
            i+=1
            k+=1
        while j < len(Right): 
            A[k] = Right[j] 
            j+=1
            k+=1
    return A


def quickSort(A,p,r):
    if p < r:
        i = partition(A,p,r)
        quickSort(A, p, i-1) 
        quickSort(A, i+1, r)
    return A

def partition(A,p,r):
    pivot = A[r]
    i = p-1
    for j in range(p , r): 
        if A[j] <= pivot:
            i = i+1 
            A[i],A[j] = A[j],A[i]
    A[i+1],A[r] = A[r],A[i+1] 
    return i+1


def insertionSort(A):
    for i in range(1,len(A)):
        key = A[i]
        j = i-1
        while j>=0 and key<A[j]:
            A[j+1] = A[j]
            j -= 1
        A[j+1] = key
    return A


def convertToInt(test):
    for j in range(0,len(test)):
        if test[j] == '':
            test.remove(test[j])
            break
        test[j] = int(test[j])
    return test

file1 = open("SortingTestFiles/10_Random.txt")
file1 = file1.read()
test1 = file1.split('\n')
test1 = convertToInt(test1)
file2 = open("SortingTestFiles/10_Reverse.txt")
file2 = file2.read()
test2 = file2.split('\n')
test2 = convertToInt(test2)
file3 = open("SortingTestFiles/10_Sorted.txt")
file3 = file3.read()
test3 = file3.split('\n')
test3 = convertToInt(test3)

file4 = open("SortingTestFiles/100_Random.txt")
file4 = file4.read()
test4 = file4.split('\n')
test4 = convertToInt(test4)
file5 = open("SortingTestFiles/100_Reverse.txt")
file5 = file5.read()
test5 = file5.split('\n')
test5 = convertToInt(test5)
file6 = open("SortingTestFiles/100_Sorted.txt")
file6 = file6.read()
test6 = file6.split('\n')
test6 = convertToInt(test6)

file7 = open("SortingTestFiles/1000_Random.txt")
file7 = file7.read()
test7 = file7.split('\n')
test7 = convertToInt(test7)
file8 = open("SortingTestFiles/1000_Reverse.txt")
file8 = file8.read()
test8 = file8.split('\n')
test8 = convertToInt(test8)
file9 = open("SortingTestFiles/1000_Sorted.txt")
file9 = file9.read()
test9 = file9.split('\n')
test9 = convertToInt(test9)

print("Insertion Sort 10_Random.txt: {}\n".format(insertionSort(test1.copy())))
print("Insertion Sort 10_Reverse.txt: {}\n".format(insertionSort(test2.copy())))
print("Insertion Sort 10_Sorted.txt: {}\n".format(insertionSort(test3.copy())))
print("Insertion Sort 100_Random.txt: {}\n".format(insertionSort(test4.copy())))
print("Insertion Sort 100_Reverse.txt: {}\n".format(insertionSort(test5.copy())))
print("Insertion Sort 100_Sorted.txt: {}\n".format(insertionSort(test6.copy())))
print("Insertion Sort 1000_Random.txt: {}\n".format(insertionSort(test7.copy())))
print("Insertion Sort 1000_Reverse.txt: {}\n".format(insertionSort(test8.copy())))
print("Insertion Sort 1000_Sorted.txt: {}\n".format(insertionSort(test9.copy())))

print("QuickSort 10_Random.txt: {}\n".format(quickSort(test1.copy(),0,9)))
print("QuickSort 10_Reverse.txt: {}\n".format(quickSort(test2.copy(),0,9)))
print("QuickSort 10_Sorted.txt: {}\n".format(quickSort(test3.copy(),0,9)))
print("QuickSort 100_Random.txt: {}\n".format(quickSort(test4.copy(),0,99)))
print("QuickSort 100_Reverse.txt: {}\n".format(quickSort(test5.copy(),0,99)))
print("QuickSort 100_Sorted.txt: {}\n".format(quickSort(test6.copy(),0,99)))
print("QuickSort 1000_Random.txt: {}\n".format(quickSort(test7.copy(),0,999)))
print("QuickSort 1000_Reverse.txt: {}\n".format(quickSort(test8.copy(),0,999)))
print("QuickSort 1000_Sorted.txt: {}\n".format(quickSort(test9.copy(),0,999)))

print("MergeSort 10_Random.txt: {}\n".format(mergeSort(test1.copy())))
print("MergeSort 10_Reverse.txt: {}\n".format(mergeSort(test2.copy())))
print("MergeSort 10_Sorted.txt: {}\n".format(mergeSort(test3.copy())))
print("MergeSort 100_Random.txt: {}\n".format(mergeSort(test4.copy())))
print("MergeSort 100_Reverse.txt: {}\n".format(mergeSort(test5.copy())))
print("MergeSort 100_Sorted.txt: {}\n".format(mergeSort(test6.copy())))
print("MergeSort 1000_Random.txt: {}\n".format(mergeSort(test7.copy())))
print("MergeSort 1000_Reverse.txt: {}\n".format(mergeSort(test8.copy())))
print("MergeSort 1000_Sorted.txt: {}\n".format(mergeSort(test9.copy())))