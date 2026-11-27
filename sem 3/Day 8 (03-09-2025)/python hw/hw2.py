# 2. Write a program to check if a number is odd or even without using the % operator.

a=int(input("Enter a number: "))
if a&1:
    print("Odd")
else:
    print("Even")