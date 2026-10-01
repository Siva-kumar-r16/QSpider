#prime number check optimized (till root(n))

import math

n=int(input("enter no."))

if n == 1:
        print("not a prime")
elif n == 2:
        print("it is a prime")
elif n % 2 == 0:
        print("not a prime")
    
else:
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0:
           print("not a prime")
           break

    else :
        print("it is a prime ")