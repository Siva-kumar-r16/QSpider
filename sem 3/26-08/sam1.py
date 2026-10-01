l=[1,8,['abc',56]]
print(l)
a=l.copy()
l[2][0]="KBFC"
print("orginal , shallow copy")
print(l,a)