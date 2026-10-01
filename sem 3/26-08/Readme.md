# QSpider Python Notes

## 26-08-2025


# Assignment

## Date: 26-08-2025

The placement-cell assignment for this session contains basic Python programs focused on conditions, numbers, strings, loops, and basic problem-solving practice.

### Assignment Programs

1. `ascii-for-uppercase`
2. `check`
3. `check-digit`
4. `digit-or-not`
5. `divisible-by-6,9`
6. `insta`
7. `multi table`
8. `mutable-or-not`
9. `natural no`
10. `palindrome`
11. `relation between`
12. `rev`
13. `reverse`
14. `special or not`
15. `sum of ind digit`
16. `toggle string`
17. `while loop`

### Assignment Practice

The assignment is meant to practice basic Python programming and improve problem-solving using:

- `if`
- `if-else`
- `if-elif-else`
- Nested `if`
- `while` loop
- Arithmetic operators
- Modulo operator `%`
- Comparison operators
- Logical conditions
- String operations
- Number-based logic
- Input and output
- Basic problem-solving

The programs are kept simple and are intended for regular placement practice.

---


## 1. Copying in Python

Copying is used when we want to create another variable or object from an existing object.

There are two important types of copying:

1. Shallow Copy
2. Deep Copy

---

## 2. Shallow Copy

A shallow copy creates a new outer object, but nested objects inside it are still shared.

### Syntax

```python
new_variable = old_variable.copy()
```

### Example

```python
l = [1, 8, ['abc', 56]]

a = l.copy()

l[2][0] = "KBFC"

print("original, shallow copy")
print(l, a)
```

Here:

```python
a = l.copy()
```

creates a shallow copy.

But the nested list:

```python
['abc', 56]
```

is still shared.

So when we change:

```python
l[2][0] = "KBFC"
```

the change is also visible through `a`.

### Important Point

```text
Shallow Copy
     ↓
New outer list
     ↓
Nested objects can still be shared
```

---

## 3. Deep Copy

A deep copy creates a completely independent copy, including the nested objects.

### Syntax

```python
import copy

new_variable = copy.deepcopy(old_variable)
```

### Example

```python
import copy

l = [1, 8, ['abc', 56]]

print(l)

a = copy.deepcopy(l)

l[2][0] = "KBFC"

print("original, deep copy")
print(l, a)
```

### Output

```text
[1, 8, ['abc', 56']]
original, deep copy
[1, 8, ['KBFC', 56]] [1, 8, ['abc', 56]]
```

The nested value in `l` changes, but the nested value in `a` remains unchanged.

### Important Point

```text
Deep Copy
     ↓
New outer object
     ↓
New nested objects
     ↓
Changes are independent
```

---

## 4. Shallow Copy vs Deep Copy

| Shallow Copy | Deep Copy |
|---|---|
| `a = l.copy()` | `a = copy.deepcopy(l)` |
| Creates a new outer object | Creates a completely independent copy |
| Nested objects can be shared | Nested objects are also copied |
| No `copy` module needed for `copy()` | Requires `import copy` |

### Easy Example

```python
# Shallow copy
a = l.copy()
```

```python
# Deep copy
import copy
a = copy.deepcopy(l)
```

---

# Conditional Statements

Conditional statements are used to execute statements based on conditions.

The main types are:

1. Simple `if`
2. `if-else`
3. `if-elif-else`
4. Nested `if`

---

## 5. Simple if

The `if` statement executes a block only when the condition is true.

### Syntax

```python
if condition:
    statement
```

### Example

```python
if a > 10:
    print("a is greater than 10")
```

If `a > 10` is true, the message is printed.

---

## 6. if-else

`if-else` is used when there are two possible cases.

### Syntax

```python
if condition:
    statement_1
else:
    statement_2
```

### Example

```python
if a > 10:
    print("a is greater than 10")
else:
    print("a is not greater than 10")
```

If the condition is true, the `if` block runs.

If the condition is false, the `else` block runs.

---

## 7. if-elif-else

This is used when there are multiple conditions.

### Syntax

```python
if condition_1:
    statement_1
elif condition_2:
    statement_2
else:
    statement_3
```

### Example

```python
if a > 10:
    print("A")
elif a < 5:
    print("B")
else:
    print("C")
```

The conditions are checked one by one.

---

## 8. Nested if

A nested `if` means using an `if` statement inside another `if` statement.

### Syntax

```python
if condition_1:
    if condition_2:
        statement
```

### Example

```python
if a > 5:
    if a < 10:
        print("a is between 5 and 10")
```

The second condition is checked only if the first condition is true.

---

# Programs

## 9. Square of a Number Only When It Is Even

### Problem

Write a program to print the square of a number only when the number is even.

### Program

```python
a = int(input("Enter a no:"))

if a % 2 == 0:
    print("Square of", a, "is", a**2)
else:
    print(a, "is not an even no")
```

### Explanation

The `%` operator gives the remainder.

For an even number:

```python
a % 2 == 0
```

is true.

Then:

```python
a**2
```

calculates the square.

For an odd number, the `else` block executes.

### Example

For input:

```text
4
```

Output:

```text
Square of 4 is 16
```

For input:

```text
5
```

Output:

```text
5 is not an even no
```

---

# 10. Vowel or Consonant

### Problem

Check whether the entered character is a vowel or consonant.

### Program

```python
a = input("Enter character")

if a in 'aeiouAEIOU':
    print(a, "is a vowel")
else:
    print(a, "is a consonant")
```

### Explanation

The `in` operator checks whether the entered character exists in:

```text
aeiouAEIOU
```

If it is present, it is treated as a vowel.

Otherwise, the program prints that it is a consonant.

### Example

Input:

```text
a
```

Output:

```text
a is a vowel
```

Input:

```text
b
```

Output:

```text
b is a consonant
```

---

# 11. Important Operators

## Modulo `%`

Returns the remainder.

```python
10 % 2
```

Result:

```text
0
```

It is useful for checking whether a number is even or odd.

### Even Number

```python
a % 2 == 0
```

### Odd Number

```python
a % 2 != 0
```

---

## Power `**`

Used to calculate powers.

```python
5 ** 2
```

Result:

```text
25
```

For finding the square:

```python
a ** 2
```

---

## Membership `in`

Checks whether a value is present in a sequence.

Example:

```python
'a' in 'aeiouAEIOU'
```

Result:

```text
True
```

---

# 12. Input Function

The `input()` function is used to get input from the user.

Example:

```python
a = input("Enter character")
```

Input obtained using `input()` is treated as a string.

For numerical input, type conversion can be used:

```python
a = int(input("Enter a no:"))
```

Now `a` is an integer.

---

# Quick Revision

### Shallow Copy

```python
a = l.copy()
```

New outer object, but nested objects can be shared.

### Deep Copy

```python
import copy
a = copy.deepcopy(l)
```

Creates an independent copy including nested objects.

### Simple if

```python
if condition:
    statement
```

### if-else

```python
if condition:
    statement
else:
    statement
```

### if-elif-else

```python
if condition:
    statement
elif condition:
    statement
else:
    statement
```

### Nested if

```python
if condition:
    if condition:
        statement
```

### Even Check

```python
a % 2 == 0
```

### Square

```python
a ** 2
```

### Vowel Check

```python
a in 'aeiouAEIOU'
```

---

# Programs to Practice

1. Shallow copy
2. Deep copy
3. Simple `if`
4. `if-else`
5. `if-elif-else`
6. Nested `if`
7. Square of a number only when it is even
8. Check whether a character is a vowel or consonant
