#To check the relation between two integer numbers

a=int(input("Enter first integer: "))
b=int(input("Enter second integer: "))
if a==b:
    print(a,"is equal to",b)
elif a>b:
    print(a,"is greater than",b)
else:
    print(a,"is less than",b)