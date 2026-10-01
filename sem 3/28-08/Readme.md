# QSpider Python Notes

## 28-08-2025

# Assignment

This session covers the basics of **Object-Oriented Programming (OOP/OOPS)** in Python.

The main topics practiced are:

1. OOPS
2. Class
3. Object
4. Class properties
5. Creating objects from a class
6. Accessing properties using objects

---

# 1. OOPS

OOPS stands for **Object-Oriented Programming System**.

OOPS is a programming approach where programs are organized using **classes and objects**.

### Why OOPS?

OOPS helps us to:

- Use code without repetition
- Achieve code reusability
- Maintain proper structure
- Make collaboration easier

The basic idea is:

```text
Class
  ↓
Object
  ↓
Access data and methods
```

---

# 2. Class

A **class** is a blueprint or structure used to create objects.

A class can contain:

- Attributes
- Methods

### Syntax

```python
class ClassName:
    # class attributes and methods
    pass
```

### Example

```python
class Dog:
    def bark(self):
        print("Woof!")
```

Here:

```python
Dog
```

is the class.

The `bark()` function is a method of the class.

---

# 3. Object

An **object** is an instance of a class.

After creating a class, we can create objects from it.

### Syntax

```python
object_name = ClassName()
```

### Example

```python
class Dog:
    def bark(self):
        print("Woof!")

my_dog = Dog()
my_dog.bark()
```

Output:

```text
Woof!
```

Here:

```python
my_dog = Dog()
```

creates an object of the `Dog` class.

```python
my_dog.bark()
```

calls the `bark()` method using the object.

---

# 4. Class Properties

A class can contain properties or attributes.

For example:

```python
class panimalar:
    dept = "CSE"
    year = 2024
    section = "j"
```

Here:

```text
dept
year
section
```

are class properties.

---

# 5. Creating Objects from a Class

Objects are created by calling the class name.

### Example

```python
class panimalar:
    dept = "CSE"
    year = 2024
    section = "j"

c1 = panimalar()
c2 = panimalar()

print(c1.dept)
print(c2.year)
print(c2.section)
```

Output:

```text
CSE
2024
j
```

Both `c1` and `c2` are objects of the `panimalar` class.

The properties can be accessed using:

```python
object_name.property
```

Examples:

```python
c1.dept
c2.year
c2.section
```

---

# 6. Accessing Class Properties

The general way to access a property using an object is:

```python
object_name.property
```

For example:

```python
c1.dept
```

If:

```python
class panimalar:
    dept = "CSE"
```

then:

```python
c1 = panimalar()
print(c1.dept)
```

gives:

```text
CSE
```

---

# 7. Library Class Example

A class can be created to represent a library or a book.

### Program

```python
class library:
    book = "harry potter"
    author = "j.k rowling"
    v = 1
    ry = 1997

lib = library()

print(lib.book)
print(lib.author)
print(lib.v)
print(lib.ry)
```

### Output

```text
harry potter
j.k rowling
1
1997
```

### Explanation

The class is:

```python
class library:
```

The class properties are:

```python
book
author
v
ry
```

The object is created using:

```python
lib = library()
```

The properties are accessed using:

```python
lib.book
lib.author
lib.v
lib.ry
```

---

# 8. Company Class Example

A class can also represent information about a company and an employee.

### Program

```python
class Accenture:
    ename = "john"
    salary = 100000
    location = "bangalore"
    designation = "developer"

a = Accenture()

print(a.ename)
print(a.salary)
print(a.location)
print(a.designation)
```

### Output

```text
john
100000
bangalore
developer
```

### Explanation

The class contains four properties:

```python
ename
salary
location
designation
```

An object is created:

```python
a = Accenture()
```

The properties are accessed through the object:

```python
a.ename
a.salary
a.location
a.designation
```

---

# 9. Important Syntax

## Creating a Class

```python
class ClassName:
    pass
```

## Creating an Object

```python
object_name = ClassName()
```

## Creating a Class with Properties

```python
class Student:
    name = "John"
    age = 20
```

## Accessing Properties

```python
s = Student()

print(s.name)
print(s.age)
```

---

# 10. Class and Object Difference

| Class | Object |
|---|---|
| Blueprint | Instance of a class |
| Defines properties and methods | Uses the properties and methods |
| Does not represent one particular instance | Represents a particular instance |
| Example: `Student` | Example: `s = Student()` |

### Simple Way to Remember

```text
Class = Blueprint
Object = Real instance created from the blueprint
```

---

# 11. Example Flow

```python
class Student:
    name = "John"
    department = "CSE"

s1 = Student()

print(s1.name)
print(s1.department)
```

Flow:

```text
Create Class
     ↓
Add Properties
     ↓
Create Object
     ↓
Access Properties
```

---

# Quick Revision

### OOPS

Object-oriented programming approach used to organize programs using classes and objects.

### Class

A blueprint for creating objects.

```python
class Student:
    name = "John"
```

### Object

An instance of a class.

```python
s = Student()
```

### Property Access

```python
s.name
```

### Class Property

```python
class Student:
    name = "John"
```

### Object Creation

```python
s = Student()
```

### Method

A function defined inside a class.

```python
class Dog:
    def bark(self):
        print("Woof!")
```

### Calling a Method

```python
d = Dog()
d.bark()
```

---

# Programs Practiced

1. Creating a basic class
2. Creating an object
3. Accessing class properties
4. Creating a `panimalar` class
5. Creating a `library` class
6. Creating an `Accenture` class
7. Creating multiple objects from the same class
8. Calling a class method using an object

---

# Placement Practice

Practice writing these without looking at the notes:

```python
class Student:
    name = "John"
    department = "CSE"

s = Student()

print(s.name)
print(s.department)
```

Then practice creating classes for:

```text
Student
Employee
Company
Library
Book
Car
```

For each class, add a few properties, create an object, and access the properties using:

```python
object_name.property
```
