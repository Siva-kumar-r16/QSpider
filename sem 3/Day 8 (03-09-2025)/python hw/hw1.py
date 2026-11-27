#1. Write a program to find the largest of three numbers without using max().
a = int(input("Enter first number: "))
b = int(input("Enter second number: "))
c = int(input("Enter third number: "))

if a > b and a > c:
    print("The largest number is:", a)
elif b > a and b > c:
    print("The largest number is:", b)
elif c > a and c > b:
    print("The largest number is:", c)
else:
    print("There is a tie for the largest number.")