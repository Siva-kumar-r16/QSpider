import copy #copy variable library

l=[1,8,['abc',56]] 
print(l)
a=copy.deepcopy(l) #deep copy for list
l[2][0]="KBFC"
print("original , deep copy")
print(l,a)