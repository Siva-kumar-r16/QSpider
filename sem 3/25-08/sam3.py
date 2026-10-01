#nested list
l=[1,2,17,8,['abc',56]]
print(l)

#changing nexted list element
l[4][0]="CSK"
print(l)

#changing nexted list datatype
l[4][0]=5
print(l)

#shallow copy for list
a=l.copy()
l[4][0]="KBFC"
print("orginal , shallow copy")
print(l,a)
