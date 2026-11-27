# QSpider Python Notes — 10-09-2025

## Date: 10-09-2025

## Programs Practiced

### `sam1.py`

```python
'''def add(*arg):
    return sum(arg)

print(add(*tuple(range(1, 101))))'''

def login(**k):
    if k["username"] == "admin" and k["password"] == "123456":
        print("login")
    else:
        print("failed")

login(username="admin", password="123456")
```

### `sam2.py`

```python
s="([{}])"

def is_valid(s):
    map={')':'(', '}':'{', ']':'['}
    if len(s)%2!=0:
        for i in range(len(s)//2):
            if map.get(s[-1-i])==s[i]:
                continue
            else:
                print("this is not valid")
                break
        else:
            print("this is valid")
is_valid(s)
```

### `sam3.py`

```python
i = [1, 2, 2, [2, [34, [211323, 23, 24, [232332, 2, 3], 5], 6], 7], 8]

def flatten_list(i):
    l2 = []
    
    for e in i:
        if type(e)!=list:
            l2.append(e)
        else:
            l2.extend(flatten_list(e))
            
    return l2

l2 = flatten_list(i)

print(l2)
```

### `sam4.py`

```python
#factorial using recursion

def factorial(n): 
    if n == 0 or n == 1: 
        return 1
    else: 
        return n * factorial(n - 1)
    
num = int(input("Enter a number: "))
result = factorial(num)
print(f"The factorial of {num} is {result}")
```

## Topics Covered

- Loops
- Functions
- Recursion
- Lists / Nested Lists

## Assignment / Homework

The programs practiced on this date are included above as the day's assignment/practice work.

## Quick Revision

- Review the logic of each program and understand why each condition, loop, function, or class member is used.
- Practice writing the programs again without copying the code.
- Test the programs with different inputs and boundary cases.
