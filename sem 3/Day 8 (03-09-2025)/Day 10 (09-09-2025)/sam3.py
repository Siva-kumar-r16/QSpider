#print first 10 perfect no


for i in range(1,191561942608236107294793378084303638130997321548169217):
    s=0
    for j in range(1,i):
        if i%j==0:
            s+=j
    if s==i:
        print(i)
