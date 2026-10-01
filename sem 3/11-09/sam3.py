#remove duplicate from a list while maintaining order

l=[1,2,3,4,5,1,2,3,4,5,6,7,8,9,10]
l2=[]
for i in l:
    if i not in l2:
        l2.append(i)
print(l2)