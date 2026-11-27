# QSpider Python Notes — 08-09-2025

## Date: 08-09-2025

## Notes

**break** statement



The break statement is used to immediately **terminate the loop** it is inside. When the program encounters a `break` statement, it will exit the current loop entirely and continue executing the code that follows the loop. It is commonly used to stop a loop when a specific condition is met, even if the loop would normally continue.





*# Example: Stopping a loop when a specific number is found*

*for i in range(1, 10):*

&nbsp;   if i == 5:

        break  # Exit the loop entirely

    print(i)






*# The output will be 1, 2, 3, 4*





**continue** statement



The continue statement is used to **skip the current iteration** of a loop. When the program encounters a `continue` statement, it skips the rest of the code in the current loop block and moves on to the next iteration.







*# Example: Skipping a specific number in a loop*

*for i in range(1, 6):*

&nbsp;   if i == 3:

        continue  # Skip the print statement for this iteration

    print(i)






*# The output will be 1, 2, 4, 5*





**pass** statement



The pass statement is a null operation. It does nothing and is used as a **placeholder** where a statement is syntactically required but you don't want any code to run. It's useful for avoiding syntax errors when you are still planning out your code.





*# Example: Using pass in an if statement and a function definition*

*if 10 > 5:*

&nbsp;   pass  # This block does nothing but is syntactically correct






*def my\_function():*

&nbsp;   pass  # This function does nothing yet

## Programs Practiced

### `sam1.py`

```python
#check greatest no in given no without using greater than operator

a=int(input("enter first no"))
b=int(input("enter second no"))

c=a//b

if c:
    print("a is greater",a)
else:   
    print("b is greater",b)
```

### `sam10.py`

```python
from abc import ABC, abstractmethod
class bank(ABC):
    roi=4

    @abstractmethod
    def withdraw(self,amount):
        pass

class saving(bank):
    roi=5
    def withdraw(self, amount):
        print("hello")

obj=saving()
#obj2=bank()  # we cannot create object of abstract class
```

### `sam2.py`

```python
#write a program to find given no is odd or even without using % operator

a=int(input("enter a no"))

if a&1:
    print(a,"no is odd")
else:
    print(a,"no is even")
```

### `sam3.py`

```python
#find middle  value in list

l=eval(input("enter list of some no"))
m=len(l)//2
if m%2==0:
    print(l[m-1:m+1])
else:
    print(l[m])
```

### `sam4.py`

```python
#print numbers from 1 to 20 using a while loop

i=1
while i<=20:
    print(i)
    i=i+1

#2. print numbers from 10 down to 1 using a while loop

i=10
while i>=1:
    print(i)
    i=i-1

#3. print the multiplication table of 5 using a while loop

i=1
while i<=10:
    print("5 *",i,"=",5*i)
    i=i+1
```

### `sam5.py`

```python
#6 print each character of the string "python" using a for loop 

s="python"
for i in s:
    print(i)

#7 print the factorial of a given number using a for loop

n=int(input("enter a no"))
f=1
for i in range(1,n+1):
    f=f*i  
print("factorial of",n,"is",f)
```

### `sam6.py`

```python
#check given no is palindrome without type casting

n=int(input("enter a no"))
r=0
t=n
while n>0:
    rem=n%10
    r=r*10+rem
    n=n//10
if t==r:
    print(t,"is palindrome")
else:
    print(t,"is not palindrome")
```

### `sam7.py`

```python
l=[1,2,3,[1,23,4],5,6,[7,8,9]]

l2=[]
for i in l:
    if type(i)==list:
        for j in i:
            l2.append(j)
    else:
        l2.append(i)
print(l2)
```

### `sam8.py`

```python
# check given no is prime or not

n=int(input("Enter a number: "))
d=int(n**0.5)
for i in range(2,d+1):
    if n % i == 0:
        print(f"{n} is not a prime number.")
        break

else:
    print(f"{n} is a prime number.")

#print the sum of numbers from 1 to 100 using a loop
s=0
for i in range(1, 101):
    s += i
print(f"The sum of numbers from 1 to 100 is: {s}")
```

### `sam9.py`

```python
#print all odd no. from 1 to 50 using while loop

i = 1
while i <= 50:
    if i % 2 != 0:
        print(i, end=' ')
    i += 1
```

## Topics Covered

- Loops
- Functions
- Abstraction
- Lists / Nested Lists
- String Processing
- OOP / Classes

## Assignment / Homework

The programs practiced on this date are included above as the day's assignment/practice work.

## Quick Revision

- Review the logic of each program and understand why each condition, loop, function, or class member is used.
- Practice writing the programs again without copying the code.
- Test the programs with different inputs and boundary cases.
