#wrie a program to find given no is perfect or not

n=int(input("enter a no"))
s=0
for i in range(1,n):
    if n%i==0:
        s+=i
if s==n:
    print(n,"is perfect no")
else:
    print(n,"is not perfect no")