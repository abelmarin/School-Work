# Python program for Bellman-Ford's single source  
# shortest path algorithm. 
  
from collections import defaultdict 
  
# Class to represent a graph 
class Graph: 
  
    def __init__(self, vertices): 
        self.V = vertices # No. of vertices 
        self.graph = [] # default dictionary to store graph 
   
    # function to add an edge to graph 
    def addEdge(self, u, v, w): 
        self.graph.append([u, v, w]) 
          
    # utility function used to print the solution 
    def printArr(self, dist): 
        print("Vertex   Distance from Source") 
        for i in range(self.V): 
            print("% d \t\t % d" % (i, dist[i])) 
      
    # The main function that finds shortest distances from src to 
    # all other vertices using Bellman-Ford algorithm.  The function 
    # also detects negative weight cycle 
    def BellmanFord(self, src): 
  
        # Step 1: Initialize distances from src to all other vertices 
        # as INFINITE 
        dist = [float("Inf")] * self.V 
        dist[src] = 0 
  
  
        # Step 2: Relax all edges |V| - 1 times. A simple shortest  
        # path from src to any other vertex can have at-most |V| - 1  
        # edges 
        for i in range(self.V - 1): 
            # Update dist value and parent index of the adjacent vertices of 
            # the picked vertex. Consider only those vertices which are still in 
            # queue
            for u, v, w in self.graph: 
                if dist[u] != float("Inf") and dist[u] + w < dist[v]: 
                        dist[v] = dist[u] + w 
            print(dist)
  
        # Step 3: check for negative-weight cycles.  The above step  
        # guarantees shortest distances if graph doesn't contain  
        # negative weight cycle.  If we get a shorter path, then there 
        # is a cycle. 
  
        for u, v, w in self.graph: 
                if dist[u] != float("Inf") and dist[u] + w < dist[v]: 
                        print ("Graph contains negative weight cycle")
                        return
                          
        # print all distance 
        self.printArr(dist) 

g = Graph(10)
g.addEdge(0, 1, 7) 
g.addEdge(0, 3, 6) 
g.addEdge(0, 5, 6) 
g.addEdge(0, 6, 5) 
g.addEdge(1, 2, 4) 
g.addEdge(1, 3, -2) 
g.addEdge(2, 7, -2) 
g.addEdge(2, 8, -4)
g.addEdge(3, 4, 2) 
g.addEdge(3, 6, 1)
g.addEdge(5, 6, -2) 
g.addEdge(5, 8, 3)
g.addEdge(6, 4, 3)
g.addEdge(7, 9, -1) 
g.addEdge(8, 7, 1) 
g.addEdge(9, 8, 1) 
  
# Print the solution 
g.BellmanFord(0) 