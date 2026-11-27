l=[1,2,3,[1,23,4],5,6,[7,8,9]]

l2=[]
for i in l:
    if type(i)==list:
        for j in i:
            l2.append(j)
    else:
        l2.append(i)
print(l2)