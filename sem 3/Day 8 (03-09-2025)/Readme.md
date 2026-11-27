# QSpider Python Notes

## Date: 03-09-2025

---

# 1. Encapsulation

Encapsulation means wrapping **data (variables)** and **methods (functions)** together inside a class and restricting direct access to some components.

Main purposes of encapsulation:

- Data hiding
- Controlled access
- Protecting the internal state of an object
- Allowing external code to interact with the object through methods such as getters and setters

## How Python Handles Encapsulation

Python does not have strict private access control in the same way as languages such as Java or C++. Instead, Python mainly uses naming conventions and name mangling.

### 1. Public Members

Public members are accessible from anywhere.

```python
self.balance
```

### 2. Protected Members

A protected member starts with a single underscore `_`.

```python
self._account_number
```

It is a convention that the member should be treated as internal, but it can still be accessed.

### 3. Private Members

A private member starts with double underscores `__`.

```python
self.__pin
```

Python applies **name mangling** to private members, so they cannot normally be accessed directly using their original name.

---

# 2. Encapsulation Example: Bank Account

```python
class bankaccount:
    def __init__(self, account_holder, bal=0, pin=123):
        self.account_holder = account_holder
        self._bal = bal
        self.__pin = pin

    def get_balance(self, pin):
        if pin == self.__pin:
            return self._bal
        else:
            return "Invalid pin"

    def deposit(self, amount, pin):
        if pin == self.__pin:
            self._bal += amount
            return f"deposited {amount}"
        else:
            return "Invalid pin"


a = bankaccount("sam", 1000, 1234)

print(a.get_balance(1234))
print(a._bal)
print(a._bankaccount__pin)
print(a.deposit(500, 1234))
```

### Important points

- `account_holder` is a public member.
- `_bal` is a protected member.
- `__pin` is a private member.
- `get_balance()` provides controlled access to the balance.
- `deposit()` checks the PIN before modifying the balance.
- `__pin` uses name mangling. It can be accessed using `_bankaccount__pin`, but this is an internal Python mechanism rather than normal direct access.

---

# 3. Checking Whether a Number is in the Form 2^x

A number is in the form `2^x` if it can be divided by 2 repeatedly until the value becomes exactly `1`.

```python
n = int(input("Enter a number: "))

while n % 2 == 0:
    n //= 2

print(n == 1, "for 2^x")
```

### Logic

For example:

`16 → 8 → 4 → 2 → 1`

Since the final value is `1`, `16` can be written as `2^x`.

The program uses:

- `%` to check divisibility by 2
- `//` for integer division
- `while` loop for repeated division
- Boolean expression `n == 1` for the final result

---

# 4. Loop Practice

## Print Numbers from 1 to 20 Using `for`

```python
for i in range(1, 21):
    print(i)
```

`range(1, 21)` generates numbers from `1` to `20`.

---

## Print Numbers from 10 to 1 Using `while`

```python
i = 10

while i > 0:
    print(i)
    i -= 1
```

The value of `i` is decreased by `1` in every iteration.

---

## Multiplication Table of 5

```python
for i in range(1, 11):
    print(f"5 x {i} = {5 * i}")
```

Output pattern:

```text
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50
```

---

## Sum of Numbers from 1 to 100

```python
sum = 0

for i in range(1, 101):
    sum += i

print(f"The sum of numbers from 1 to 100 is: {sum}")
```

The variable `sum` stores the running total.

---

## Odd Numbers Between 1 and 50 Using `while`

```python
i = 1

while i < 50:
    print(i)
    i += 2
```

Starting from `1` and increasing by `2` produces odd numbers.

---

## Print Each Character of `"python"`

```python
for char in "python":
    print(char)
```

A `for` loop can directly iterate through each character of a string.

---

## Factorial of 5

```python
factorial = 1

for i in range(1, 6):
    factorial *= i

print(f"The factorial of 5 is: {factorial}")
```

Factorial of 5:

```text
5! = 5 × 4 × 3 × 2 × 1 = 120
```

---

# 5. Nested Loop

A nested loop means placing one loop inside another loop.

### 3 × 3 Grid

```python
for i in range(3):
    for j in range(3):
        print("#", end=" ")
    print()
```

The outer loop controls the rows and the inner loop controls the columns.

Output:

```text
# # #
# # #
# # #
```

---

# 6. `break` Statement

`break` is used to immediately stop a loop.

### Example

Stop when a number is divisible by 7:

```python
for i in range(1, 21):
    if i % 7 == 0:
        print(f"Found a number divisible by 7: {i}")
        break
```

The loop stops when it reaches the first number divisible by 7.

---

# 7. `continue` Statement

`continue` skips the current iteration and moves to the next iteration.

### Example

Print numbers from 1 to 10 while skipping even numbers:

```python
for i in range(1, 11):
    if i % 2 == 0:
        continue
    print(i)
```

Output:

```text
1
3
5
7
9
```

---

# 8. Homework / Assignment

## 1. Largest of Three Numbers Without `max()`

```python
a = int(input("Enter first number: "))
b = int(input("Enter second number: "))
c = int(input("Enter third number: "))

if a > b and a > c:
    print("The largest number is:", a)
elif b > a and b > c:
    print("The largest number is:", b)
elif c > a and c > b:
    print("The largest number is:", c)
else:
    print("There is a tie for the largest number.")
```

Concepts:
- `if-elif-else`
- Comparison operators
- Logical `and`

---

## 2. Odd or Even Without `%`

```python
a = int(input("Enter a number: "))

if a & 1:
    print("Odd")
else:
    print("Even")
```

The bitwise AND operator `&` is used to check the last binary bit.

---

## 3. Leap Year

```python
y = int(input("Enter a year: "))

if (y % 4 == 0 and y % 100 != 0) or (y % 400 == 0):
    print("Leap year")
else:
    print("Not a leap year")
```

The conditions check divisibility by 4, 100 and 400.

---

## 4. Vowel or Consonant

```python
c = input("Enter a character: ").lower()

if c in 'aeiou':
    print("Vowel")
elif c in 'bcdfghjklmnpqrstvwxyz':
    print("Consonant")
else:
    print("Invalid input")
```

The input is converted to lowercase using `.lower()`.

---

## 5. Simple Calculator Using `if-elif-else`

```python
num1 = float(input("Enter first number: "))
num2 = float(input("Enter second number: "))
op = input("Enter operator (+, -, *, /): ")

if op == '+':
    print(f"{num1} + {num2} = {num1 + num2}")
elif op == '-':
    print(f"{num1} - {num2} = {num1 - num2}")
elif op == '*':
    print(f"{num1} * {num2} = {num1 * num2}")
elif op == '/':
    if num2 != 0:
        print(f"{num1} / {num2} = {num1 / num2}")
    else:
        print("Error: Division by zero")
else:
    print("Invalid operator")
```

Concepts:
- `float()`
- `if-elif-else`
- Nested `if`
- Arithmetic operators
- Division-by-zero check

---

## 6. Positive, Negative or Zero

```python
n = float(input("Enter a number: "))

if n > 0:
    print("Positive")
elif n < 0:
    print("Negative")
else:
    print("Zero")
```

---

## 7. Voting Eligibility

```python
age = int(input("Enter your age: "))

if age >= 18:
    print("Eligible to vote")
else:
    print("Not eligible to vote")
```

---

## 8. Divisible by Both 3 and 5

```python
num = int(input("Enter a number: "))

if num % 3 == 0 and num % 5 == 0:
    print("Divisible by both 3 and 5")
else:
    print("Not divisible by both 3 and 5")
```

---

## 9. Grade Calculator

```python
marks = float(input("Enter your marks: "))

if marks >= 90:
    print("Grade A")
elif marks >= 80:
    print("Grade B")
elif marks >= 70:
    print("Grade C")
elif marks >= 60:
    print("Grade D")
elif marks >= 50:
    print("Grade E")
else:
    print("Grade F")
```

---

## 10. Smallest of Two Numbers Without `<` or `>`

```python
a = int(input("Enter first number: "))
b = int(input("Enter second number: "))

print("Smallest number is:", min([a, b]))
```

The program uses `min()` instead of directly comparing the two numbers.

---

# Quick Revision

| Topic | Important Point |
|---|---|
| Encapsulation | Data + methods together with controlled access |
| Public | Normal member, accessible everywhere |
| Protected | `_variable`, treated as internal by convention |
| Private | `__variable`, uses name mangling |
| `while` | Repeats while condition is true |
| `for` | Used for iteration over a sequence/range |
| `break` | Immediately stops the loop |
| `continue` | Skips the current iteration |
| Nested loop | Loop inside another loop |
| `%` | Remainder operator |
| `//` | Floor/integer division |
| `&` | Bitwise AND |
| `range()` | Generates a sequence of numbers |
| `lower()` | Converts a string to lowercase |
| `min()` | Returns the smallest value |

# Key Practice Points

1. Understand public, protected and private members.
2. Practice getters and controlled access using methods.
3. Understand name mangling for private members.
4. Practice `for` and `while` loops.
5. Understand the difference between `break` and `continue`.
6. Practice nested loops.
7. Practice conditions using `if-elif-else`.
8. Practice arithmetic, comparison and logical operators.
9. Practice basic bitwise operations.
