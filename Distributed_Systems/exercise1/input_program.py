import sys, getopt

# Standard input
print("Standard Input:")
text = sys.stdin.readline()
while text:
    print(text.strip())
    text = sys.stdin.readline()


# Command line arguments
opts, args = getopt.getopt(sys.argv[1:], "o:t:h")
print("Command line arguments:")
opt1 = ""
opt2 = ""
opt3 = ""

for opt, arg in opts:
    if opt in ["-o"]:
        opt1 = "option 1: {}\n".format(arg)
    elif opt in ["-t"]:
        opt2 = "option 2: {}\n".format(arg)
    elif opt in ["-h"]:
        opt3 = "option 3"

print(opt1+opt2+opt3)