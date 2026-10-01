#check given no is palindrome without type casting

n=int(input("enter a no"))
r=0
t=n
while n>0:
    rem=n%10
    r=r*10+rem
    n=n//10
if t==r:
    print(t,"is palindrome")
else:
    print(t,"is not palindrome")