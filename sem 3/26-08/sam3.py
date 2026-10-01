#Write a program to print the square of a no only when it is even 

a=int(input("Enter a no:"))
if a%2==0:
    print("Square of",a,"is",a**2)
else:  
    print(a,"is not an even no")
    