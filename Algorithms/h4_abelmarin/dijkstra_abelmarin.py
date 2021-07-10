from heapq import *
from collections import defaultdict
from string import ascii_uppercase

def dijkstra(edges, source, target):
    g = defaultdict(list)
    for l,r,c in edges:
        g[l].append((c,r))

    q, seen, mins = [(0,source,())], set(), {source: 0}
    while q:
        cost,v1,path = heappop(q)
        if v1 not in seen:
            seen.add(v1)
            path = (v1, path)
            if (v1 == target):
                path = formatOutput(path)
                print(cost)
                print(path)
                break

            for c, v2 in g.get(v1, ()):
                if v2 in seen: continue
                prev = mins.get(v2, None)
                next = cost + c
                if prev is None or next < prev:
                    mins[v2] = next
                    heappush(q, (next, v2, path))

    return float("inf")


''' Helper Functions and Classes '''
class Graph:
    def __init__(self, V):
        self.V = V # number of vertices
        self.edges = [] # list of edges

    def addEdge(self, u, v, w):
        self.edges.append((u,v,w))

# Cleans up the output
def formatOutput(path):
    output = "" # Output
    path = str(path)
    for i in range(0, len(path)):
        if path[i] in list(ascii_uppercase):
            output = output + path[i]
    stringlength = len(output)
    output = output[stringlength::-1]
    output = " ".join(output)
    return output

# formats the data
def format(test):
    for i in range(0,len(test)):
        if test[i] == '':
            test.remove(test[i])
            break
        test[i] = test[i].split(" ")
        if len(test[i]) == 3:
            test[i][2] = int(test[i][2])
        elif len(test[i]) == 1:
            test[i][0] = int(test[i][0])
    g = Graph(test[0][0])
    test.pop(0)
    for i in range(0,len(test)):
        g.addEdge(test[i][0], test[i][1], test[i][2])
    return g


file1 = open("Djikstra's Algorithm Input Files/Case1.txt")
file1 = file1.read()
case1 = file1.split('\n')
case1 = format(case1)
file2 = open("Djikstra's Algorithm Input Files/Case2.txt")
file2 = file2.read()
case2 = file2.split('\n')
case2 = format(case2)
file3 = open("Djikstra's Algorithm Input Files/Case3.txt")
file3 = file3.read()
case3 = file3.split('\n')
case3 = format(case3)

dijkstra(case1.edges, 'A', 'B')
dijkstra(case2.edges, 'A', 'B')
dijkstra(case3.edges, 'A', 'B')
