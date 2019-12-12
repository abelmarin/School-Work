import math

stake = 1
balance = 0
for numPeople in range(1,25):
    amountPaidOut = math.floor((stake+balance) / numPeople)

class User:

    def __init__ (self, inviter, itself):
        self.inviter = inviter
        self.itself = itself
