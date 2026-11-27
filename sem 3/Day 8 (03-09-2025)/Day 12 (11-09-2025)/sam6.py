#create a range function f without range and for loop

def range1(start, stop=None, step=1):
    l=[]
    if stop is None:
        stop = start
        start = 0
    if step > 0:
        while start < stop:
            l.append(start)
            start += step
    elif step < 0:
        while start > stop:
            l.append(start)
            start += step
    return l

print(range1(10))
print(range1(2, 10))
print(range1(10, 2, -2))