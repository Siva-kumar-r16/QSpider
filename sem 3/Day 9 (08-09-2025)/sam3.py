#find middle  value in list

l=eval(input("enter list of some no"))
m=len(l)//2
if m%2==0:
    print(l[m-1:m+1])
else:
    print(l[m])