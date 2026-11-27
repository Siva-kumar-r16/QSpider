#write a program to check largest no in a list without built in function

l=[1,2,3,4,5,6,16,8,9,10]
m=l[0]
for i in l:
    if i>m:
        m=i
print(m)