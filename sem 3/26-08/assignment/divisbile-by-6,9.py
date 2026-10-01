#The code of a number only if it is divisible by 9 or 6 

a=int(input("Enter a number: "))
if a%9==0 or a%6==0:
    print(a,"is divisible by 9 or 6")
else:
    print(a,"is not divisible by 9 or 6")
