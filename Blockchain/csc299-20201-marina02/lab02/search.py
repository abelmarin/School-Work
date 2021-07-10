import hashlib

# Your code goes here.
for n in range(0, 1000000):
    s = "seed"+"x"*n
    s = bytes(str(s), "ascii")
    h = hashlib.sha256 (s).hexdigest ()
    if h[0] == "f" and h[1] == "f" and h[2] == "f":
        print(n, s, h)
        break

# Your code should run when you run it from the command line using:
# 
#   python3 search.py
# 
# In particular if you put your code in a function, make sure that you call the function at the top-level of this file!


