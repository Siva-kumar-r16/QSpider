#normal copy
l=[7,18,22]
b=l #normal copy
a=l.copy() #shallow copy

print(l,b,a)

b[2]=7 #changes in normal copy
print(l,b,a)