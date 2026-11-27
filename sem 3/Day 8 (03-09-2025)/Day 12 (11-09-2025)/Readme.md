# QSpider Python Notes — 11-09-2025

## Date: 11-09-2025

## Programs Practiced

### `sam1.py`

```python
#reverse word in a sentence

s=input("Enter a sentence: ")
l=s.split(" ")
for i in l[::-1]:
    print(i,end=" ")
```

### `sam2.py`

```python
#print hello world without using print

import sys
sys.stdout.write("hello world \n")


sys.stdout.write("enter something: \n")
a = sys.stdin.read()
sys.stdout.write("\nYou entered:")
sys.stdout.write(a)
```

### `sam3.py`

```python
#remove duplicate from a list while maintaining order

l=[1,2,3,4,5,1,2,3,4,5,6,7,8,9,10]
l2=[]
for i in l:
    if i not in l2:
        l2.append(i)
print(l2)
```

### `sam4.py`

```python
#write a program to check largest no in a list without built in function

l=[1,2,3,4,5,6,16,8,9,10]
m=l[0]
for i in l:
    if i>m:
        m=i
print(m)
```

### `sam5.py`

```python
#find missiong number in a sequence
#input: [1,2,4,6,5] output: 3

l=[1,2,4,6,5]
l.sort()
for i in range(l[0],l[-1]):
    if i not in l:
        print(i)
        break
```

### `sam6.py`

```python
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
```

### `sam7.py`

```python
#count frequency of character in a string

s="programming"
d={}
for i in s:
    if i in d:
        d[i]+=1
    else:
        d[i]=1
print(d)
```

### `sam8.py`

```python
import sys

def hello(*args,gap=" ",last='\n',file=sys.stdout,flush):
    n=gap.join(args)+last
    file.write(n)

hello("bad ass ma","leo das ma ",gap='❤️‍🔥',last="leo")
```

## Topics Covered

- Loops
- Functions
- Lists / Nested Lists
- String Processing
- File / System I/O
- Dictionaries

## Assignment / Homework

The programs practiced on this date are included above as the day's assignment/practice work.

## Quick Revision

- Review the logic of each program and understand why each condition, loop, function, or class member is used.
- Practice writing the programs again without copying the code.
- Test the programs with different inputs and boundary cases.
