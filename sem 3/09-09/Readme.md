# QSpider Python Notes — 09-09-2025

## Date: 09-09-2025

## Notes

#### **Function in python**



Definition of function



* a function is a name given to a block of memory where a set of memory where a set of instructuion are stored which are meant to perform a specific task whenever called



* it helps in code reusability , modularity and readability.



\[         ]        ----------------------

\[         ]         var space| Val space

\[         ]            a     |    a

\[\_\_\_\_\_\_\_\_\_]           0x12   |    10



Types of function in python



1.Built in function



2.user defines function







#### single value data types

single-value types store only one literal values at a time.



**int(integer)**

* represents whole no without decimal points. Immutable
* eg:- 10,-5,0
* definite value : 0
* non-default value : 42



#### 

#### SETS



* A Python set can only contain immutable (unchangeable) data types.
* Mutable types like a list or another set cannot be added as elements, which causes a TypeError.
* This is because set elements must be hashable, meaning their value never changes.
* Immutable types like a tuple, int, or str are hashable and can be elements in a set.
* If you need to store a set inside another set, you must use its immutable version, the frozenset.



eg:-

*{{1,2}}*

*Traceback (most recent call last):*

*File "<pyshell#32>", line 1, in <module>*

    \*{{1,2}}\*



*TypeError: unhashable type: 'set'*

*{\[1,2]}*

*Traceback (most recent call last):*

*File "<pyshell#33>", line 1, in <module>*

    \*{\\\[1,2]}\*



*TypeError: unhashable type: 'list'*

*{(1,2)}*

*{(1, 2)}*

*{1,2}*

*{1, 2}*

## Programs Practiced

### `sam1.py`

```python
# use a nested loop to print a 3x3 grid of #

for i in range(3):
    for j in range(3):
        print("#", end=" ")
    print()
print("\n\n")

# use break to stop a loop when the no is divisible by 7
for i in range(1, 11):
    if i % 7 == 0:
        break
    print(i)
print("\n\n")

#use continue to print no from 1 to 10 but skip even no
for i in range(1, 11):
    if i % 2 == 0:
        continue
    print(i)
print("\n\n")
```

### `sam2.py`

```python
#wrie a program to find given no is perfect or not

n=int(input("enter a no"))
s=0
for i in range(1,n):
    if n%i==0:
        s+=i
if s==n:
    print(n,"is perfect no")
else:
    print(n,"is not perfect no")
```

### `sam3.py`

```python
#print first 10 perfect no


for i in range(1,191561942608236107294793378084303638130997321548169217):
    s=0
    for j in range(1,i):
        if i%j==0:
            s+=j
    if s==i:
        print(i)
```

### `sam4.py`

```python
#find given no is amstrong or not

n=input("enter no:")
s=0

for i in n:
    s+=int(i)**len(n)
    
if s==int(n):
    print(n,"is armstrong no")
else:
    print(n,"is not armstrong no")
```

### `sam5.py`

```python
'''def odd_even(n):
    if n%2==0:
        return "even"
    return "odd"'''

#write a program to check the given triangle is equilateral , isosceles , and scalene

def tri(a,b,c):
    if a==b and b==c:
        return "equilateral"
    elif a==b or b==c or a==c:
        return "Isoscles"
    else:
        return "scalene"
    
def checktri(a,b,c):
    if (a+b)>c and (a+c)>b and (c+b)>a:
        return tri(a,b,c)
    else:
        return "Invalid triangle"

a=int(input("enter length a of triangle"))
b=int(input("enter length b of triangle"))
c=int(input("enter length c of triangle"))

print (checktri(a,b,c))
```

## Topics Covered

- Loops
- Functions
- Sets
- Lists / Nested Lists

## Assignment / Homework

The programs practiced on this date are included above as the day's assignment/practice work.

## Quick Revision

- Review the logic of each program and understand why each condition, loop, function, or class member is used.
- Practice writing the programs again without copying the code.
- Test the programs with different inputs and boundary cases.
