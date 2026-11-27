# QSpider Python Notes

## Date: 01-09-2025

## Topics Covered

- Python built-in function recreation
- Mathematical operations
- String slicing
- Type conversion and input handling
- Nested list access and modification
- Pattern printing
- Number reversal using strings
- Optimized prime number checking
- Class, object, constructor, instance method, class method and static method
- Inheritance
- Finding missing numbers
- Pascal's Triangle
- Balanced brackets
- Grouping anagrams
- Longest Common Prefix
- Spiral Matrix Traversal

---

# 1. Creating a Custom `len()` Function

Python provides the `len()` function to find the number of elements in a sequence. The same idea can be implemented manually using a counter.

```python
def len1(s):
    c = 0
    for i in s:
        c += 1
    return c

s = "python"
print(len1(s))
```

### Logic

1. Start the counter at `0`.
2. Traverse each character in the string.
3. Increase the counter by `1` for every character.
4. Return the final count.

---

# 2. Square and Cube of a Number

The square and cube of a number can be calculated using the exponent operator `**`.

```python
n = int(input("Enter no."))
print("Sq :", n**2, "cube :", n**3)
```

### Operators

- `n**2` → square
- `n**3` → cube

---

# 3. String Slicing

String slicing is used to extract a part of a string.

For the string:

```python
s = "pythonprogramming"
```

the following operations are used:

```python
print(s[:6])
print(s[-6:])
print(s[::2])
```

### Meaning

- `s[:6]` → first 6 characters
- `s[-6:]` → last 6 characters
- `s[::2]` → every second character

### General Syntax

```python
string[start:stop:step]
```

---

# 4. Taking Two Inputs and Finding Their Sum

`input()` returns a string. Therefore, the values are converted to integers before performing addition.

```python
a = input("Enter first number:")
b = input("Enter second number:")
print("Sum:", int(a) + int(b))
```

### Important Point

```python
int(a)
```

converts the input string into an integer.

---

# 5. Accessing and Modifying a Nested List

A list can contain another list. This is called a nested list.

```python
a = [1, 2, 3, [4, 5, 6]]

a[3][1] = 4
print(a)

a[3] += [7, 8, 9]
print(a)
```

### Accessing the Nested List

```python
a[3]
```

accesses the inner list.

```python
a[3][1]
```

accesses the second element of the inner list.

---

# 6. Pyramid Pattern Using Stars

A pyramid pattern can be printed using a `for` loop and string multiplication.

```python
rows = 4

for i in range(1, rows + 1):
    print(f"{'* '*i:^10}")
```

### Concepts Used

- `for` loop
- `range()`
- String multiplication
- f-string
- Center alignment using `:^10`

---

# 7. Reverse a Number Without Direct Number Logic

A number can be reversed by converting it to a string and using slicing.

```python
n = int(input("enter no."))
n = str(n)
n = n[::-1]
n = int(n)
print(n)
```

### Steps

1. Take the number as an integer.
2. Convert it to a string.
3. Reverse the string using `[::-1]`.
4. Convert it back to an integer.
5. Print the result.

---

# 8. Optimized Prime Number Checking

A prime number is checked by testing divisibility only up to the square root of the number.

```python
import math

n = int(input("enter no."))

if n == 1:
    print("not a prime")
elif n == 2:
    print("it is a prime")
elif n % 2 == 0:
    print("not a prime")
else:
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0:
            print("not a prime")
            break
    else:
        print("it is a prime ")
```

### Logic

- `1` is treated as not prime.
- `2` is prime.
- Other even numbers are not prime.
- For odd numbers, checking starts from `3`.
- The loop increases by `2`, so only odd divisors are checked.
- The check stops at `sqrt(n)`.

### Important Concept

The `else` belongs to the `for` loop. It executes when the loop completes without encountering `break`.

---

# 9. Class With Instance, Class and Static Methods

A class can contain different types of members and methods.

```python
class school:
    sname = "eben"
    pname = "JJ"
    no_of_pg = 3
    loc = "kalyan"

    def __init__(self, name, roll_no, age, std):
        self.name = name
        self.roll_no = roll_no
        self.age = age
        self.std = std

    def display(self):
        print(self.name, self.roll_no, self.age, self.std)

    @classmethod
    def sdisplay(cls):
        print(cls.sname)

    @staticmethod
    def wel():
        print("Welcome to the school")

s1 = school("sam", 101, 15, 10)

s1.wel()
s1.display()
s1.sdisplay()
```

### Types Used

#### Class Members

```python
sname = "eben"
pname = "JJ"
no_of_pg = 3
loc = "kalyan"
```

These belong to the class.

#### Constructor

```python
def __init__(self, name, roll_no, age, std):
```

The constructor initializes object-specific data.

#### Instance Method

```python
def display(self):
```

Uses `self` and works with object data.

#### Class Method

```python
@classmethod
def sdisplay(cls):
```

Uses `cls` and works with class-level data.

#### Static Method

```python
@staticmethod
def wel():
```

Does not require `self` or `cls`.

---

# 10. Basic Inheritance

Inheritance allows a child class to use members of a parent class.

```python
class parent:
    height = 5.5
    a = 10
    b = 20

class child(parent):
    c = 30
    d = 40

obj1 = parent()
obj2 = child()
```

Here:

- `parent` is the parent/base class.
- `child` is the child/derived class.
- `child` inherits the members of `parent`.

The child class has its own members `c` and `d` and can also access inherited members such as `height`, `a`, and `b`.

---

# 11. Finding the Missing Number in a List

The sum of numbers from `1` to `n` can be calculated using:

```text
n × (n + 1) / 2
```

The program uses the difference between the expected total and the actual list sum.

```python
my_list = [1, 2, 4, 5, 6, 7, 8, 9, 10]

n = len(my_list) + 1
totalsum = n * (n + 1) // 2
list_sum = sum(my_list)

missing = totalsum - list_sum

print(f"The missing number is: {missing}")
```

### Logic

1. Find the expected value of `n`.
2. Calculate the total sum from `1` to `n`.
3. Calculate the actual sum of the list.
4. Subtract the actual sum from the expected sum.
5. The result is the missing number.

---

# 12. Pascal's Triangle

Pascal's Triangle can be generated row by row.

```python
n = 5
triangle = []

if n > 0:
    triangle.append([1])

    for i in range(1, n):
        prev_row = triangle[-1]
        new_row = [1]

        for j in range(1, len(prev_row)):
            new_row.append(prev_row[j - 1] + prev_row[j])

        new_row.append(1)
        triangle.append(new_row)

for row in triangle:
    print(row)
```

### Logic

- The first row is `[1]`.
- Each new row starts and ends with `1`.
- The middle values are calculated by adding two adjacent values from the previous row.
- `triangle[-1]` gives the previous row.

---

# 13. Balanced Brackets

A stack can be used to check whether brackets are correctly balanced.

Example bracket types:

```text
()
[]
{}
```

Program:

```python
test_strings = ["()[]{}", "([{}])", "({[}])", "((("]

for s in test_strings:
    stack = []
    mapping = {")": "(", "}": "{", "]": "["}
    is_balanced = True

    for char in s:
        if char in mapping.values():
            stack.append(char)

        elif char in mapping.keys():
            if not stack or mapping[char] != stack.pop():
                is_balanced = False
                break

    if is_balanced and not stack:
        print(f"'{s}' is balanced: True")
    else:
        print(f"'{s}' is balanced: False")
```

### Logic

- Opening brackets are pushed into the stack.
- When a closing bracket is found, the top opening bracket is checked.
- If the pair does not match, the string is not balanced.
- At the end, the stack must also be empty.

---

# 14. Grouping Words Into Anagrams

Anagrams are words that contain the same characters in a different order.

Example:

```text
eat
tea
ate
```

These words are anagrams.

```python
from collections import defaultdict

word_list = ["eat", "tea", "tan", "ate", "nat", "bat"]

anagrams_dict = defaultdict(list)

for word in word_list:
    sorted_word = "".join(sorted(word))
    anagrams_dict[sorted_word].append(word)

grouped = list(anagrams_dict.values())

print(grouped)
```

### Logic

For each word:

```python
sorted_word = "".join(sorted(word))
```

creates a common key for words containing the same characters.

For example:

```text
eat → aet
tea → aet
ate → aet
```

Therefore, they are placed in the same group.

---

# 15. Longest Common Prefix

The longest common prefix is the longest starting part shared by all strings.

Example:

```text
flower
flow
flight
```

The common prefix is:

```text
fl
```

Program:

```python
list_of_strings = [
    ["flower", "flow", "flight"],
    ["dog", "racecar", "car"],
    ["a"],
    ["", "b"]
]

for strs in list_of_strings:
    if not strs:
        prefix = ""
    else:
        strs.sort()
        first_str = strs[0]
        last_str = strs[-1]

        i = 0

        while (
            i < len(first_str)
            and i < len(last_str)
            and first_str[i] == last_str[i]
        ):
            i += 1

        prefix = first_str[:i]

    print(f"LCP of {strs}: {prefix}")
```

### Logic

1. Sort the list of strings.
2. Take the first and last strings after sorting.
3. Compare their characters from the beginning.
4. The common prefix of these two strings is also the common prefix of the complete list.
5. Stop when characters differ.

---

# 16. Spiral Order Traversal of a Matrix

Spiral traversal prints the matrix by moving:

1. Left to right across the top.
2. Top to bottom along the right side.
3. Right to left across the bottom.
4. Bottom to top along the left side.
5. Repeat until all elements are visited.

```python
matrix_list = [
    [[1, 2, 3], [4, 5, 6], [7, 8, 9]],
    [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
]

for matrix in matrix_list:
    if not matrix or not matrix[0]:
        print([])
        continue

    result = []
    top, bottom = 0, len(matrix) - 1
    left, right = 0, len(matrix[0]) - 1

    while top <= bottom and left <= right:

        for i in range(left, right + 1):
            result.append(matrix[top][i])
        top += 1

        for i in range(top, bottom + 1):
            result.append(matrix[i][right])
        right -= 1

        if top <= bottom:
            for i in range(right, left - 1, -1):
                result.append(matrix[bottom][i])
            bottom -= 1

        if left <= right:
            for i in range(bottom, top - 1, -1):
                result.append(matrix[i][left])
            left += 1

    print(f"Spiral traversal of matrix: {result}")
```

### Boundary Variables

- `top` → top row boundary
- `bottom` → bottom row boundary
- `left` → left column boundary
- `right` → right column boundary

The boundaries are moved inward after each traversal.

---

# Assignment / Homework

## Practice Programs

### Basic Python

1. Create a custom `len()` function.
2. Find the square and cube of a number.
3. Use string slicing to print the first 6, last 6 and every second character.
4. Take two string inputs, convert them to integers and print their sum.
5. Access and modify elements of a nested list.
6. Print a pyramid pattern using stars.
7. Reverse a number using string conversion.
8. Check whether a number is prime using an optimized approach.

### OOPS and Inheritance

9. Create a class containing instance, class and static methods.
10. Create a parent and child class to understand inheritance.

### Problem Solving

11. Find the missing number in a list.
12. Generate Pascal's Triangle.
13. Check whether brackets are balanced.
14. Group a list of words into anagrams.
15. Find the longest common prefix.
16. Print the spiral order traversal of a matrix.

---

# Quick Revision

| Concept | Main Idea |
|---|---|
| `len()` logic | Count elements using a loop |
| `**` | Exponent / power operator |
| Slicing | Extract characters using `start:stop:step` |
| `int()` | Convert a value to integer |
| Nested list | Access using multiple indexes |
| `[::-1]` | Reverse a sequence |
| Prime optimization | Check divisors up to `sqrt(n)` |
| Instance method | Uses `self` |
| Class method | Uses `cls` |
| Static method | Uses neither `self` nor `cls` |
| Inheritance | Child class gets parent members |
| Stack | Useful for bracket matching |
| `defaultdict` | Useful for grouping values |
| `sorted()` | Creates sorted characters for anagram keys |
| Matrix boundaries | Used for spiral traversal |

# Key Placement Practice

The main focus of this practice is to become comfortable with:

- Loops
- Conditions
- String slicing
- Type conversion
- Lists and nested lists
- Functions
- Classes and objects
- Instance, class and static methods
- Inheritance
- Stack-based problem solving
- Sorting-based grouping
- Matrix traversal
- Basic problem-solving logic
