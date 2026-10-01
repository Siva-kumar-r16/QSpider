#write a program to find given no is odd or even without using % operator

a=int(input("enter a no"))

if a&1:
    print(a,"no is odd")
else:
    print(a,"no is even")