import hashlib

for n in range(0,100000000000000):
    s = bytes (str (n), "ascii")
    print(s)
    h = hashlib.sha256 (s).hexdigest ()
    print(h)
    if h[0] == "0" and h[1] == "0" and h[2] == "0" and h[3] == "0" and h[4] == "0" and h[5] == "0" and h[6] == "0" and h[7] == "0" and h[8] == "0" and h[9] == "0" and h[10] == "0":
        break