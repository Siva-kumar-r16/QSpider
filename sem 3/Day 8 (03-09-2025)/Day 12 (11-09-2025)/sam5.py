#find missiong number in a sequence
#input: [1,2,4,6,5] output: 3

l=[1,2,4,6,5]
l.sort()
for i in range(l[0],l[-1]):
    if i not in l:
        print(i)
        break
