#count frequency of character in a string

s="programming"
d={}
for i in s:
    if i in d:
        d[i]+=1
    else:
        d[i]=1
print(d)
