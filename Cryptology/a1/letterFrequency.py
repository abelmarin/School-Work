from collections import defaultdict
 
filename = "cyphertext.txt"
file = open(filename, encoding="utf8")

 
def countletters(file):
    results = defaultdict(int)
    total = 0
    for line in file:
        for char in line:
            c = char.lower()
            results[c] += 1
            if char != '\n' and char != ' ':
                total += 1
    print(total)
    return results
print(countletters(file))
