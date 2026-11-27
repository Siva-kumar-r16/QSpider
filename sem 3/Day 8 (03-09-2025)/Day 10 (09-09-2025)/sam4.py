#find given no is amstrong or not

n=input("enter no:")
s=0

for i in n:
    s+=int(i)**len(n)
    
if s==int(n):
    print(n,"is armstrong no")
else:
    print(n,"is not armstrong no")
