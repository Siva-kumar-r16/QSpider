# QSpider Python Notes
# Date: 29-08-2025

# OOPS - Class Members, Object Members, Constructors and Methods

## Assignment

This session continues Object-Oriented Programming in Python.

### Topics Covered

1. Class Members
2. Object Members
3. Constructor
4. `__init__()` method
5. `self`
6. Instance Method
7. Class Method
8. Modifying Object Members
9. Creating objects using constructors
10. Accessing class and object data

---

# 1. Class Members

Class members are attributes that belong to the class.

Their values are common to the objects of the class unless an object creates its own value for that attribute.

### Examples

Some common examples of class-level information are:

```text
c_time
food
rules
fees
subject
hostel
transport
```

For example, school rules or fees can be common for multiple student objects.

### Example

```python
class car:
    c_model = "modely"
    c_brand = "bmw"
    c_price = 5000000

c1 = car()

print(c1.c_model)
print(c1.c_brand)
print(c1.c_price)
```

Output:

```text
modely
bmw
5000000
```

---

# 2. Modifying a Class Member Through an Object

An object can be assigned a new value for a class member.

```python
class car:
    c_model = "modely"
    c_brand = "bmw"
    c_price = 5000000

c1 = car()

c1.c_model = "mercedes"

print(c1.c_model)
print(c1.c_brand)
print(c1.c_price)
```

Output:

```text
mercedes
bmw
5000000
```

Here, `c1.c_model` gets an object-level value.

The original class property is not directly changed by this assignment.

---

# 3. Object Members

Object members are attributes that belong to a particular object.

Their values can be different for different objects.

### Examples

```text
s_name
s_id
s_phno
s_address
```

For example, every student can have a different name, ID, phone number and address.

---

## Example

```python
class college:
    c_name = ""
    c_id = ""
    c_location = ""

c1 = college()

c1.c_name = "panimalar"
c1.c_id = 102
c1.c_location = "chennai"

print(c1.c_name, c1.c_id, c1.c_location)
```

Output:

```text
panimalar 102 chennai
```

The values are assigned to the particular object `c1`.

---

# 4. Class Members vs Object Members

| Class Members | Object Members |
|---|---|
| Belong to the class | Belong to a particular object |
| Common data | Individual data |
| Same general value for objects | Can be different for each object |
| Example: college name | Example: student name |
| Can be accessed using an object | Accessed using the object |

### Easy Way to Remember

```text
Class Member
    ↓
Common information

Object Member
    ↓
Individual information
```

Example:

```text
College name → Class Member
Student name → Object Member
```

---

# 5. Constructor

A constructor is used to initialize object members when an object is created.

In Python, the constructor is:

```python
__init__()
```

The `__init__()` method is automatically called when an object is created.

### Syntax

```python
class ClassName:

    def __init__(self, arg1, arg2):
        self.arg1 = arg1
        self.arg2 = arg2
```

---

# 6. `self`

`self` refers to the current object.

It is used to store and access object members.

In an instance method, `self` is written as the first parameter.

Example:

```python
class Student:

    def __init__(self, name, age):
        self.name = name
        self.age = age
```

Here:

```python
self.name
self.age
```

are object members.

---

# 7. Constructor Example Using Laptop

```python
class Laptop:

    # class members
    brand = "hp"
    warranty = 2

    def __init__(self, model, color, processor, graphic_card):
        self.model = model
        self.color = color
        self.processor = processor
        self.graphic_card = graphic_card

lap1 = Laptop("hp15s", "silver", "intel i5", "iris 2GB")
lap2 = Laptop("hp pavilion", "black", "intel i7", "nvidia Gforce")

print(lap1.model, lap1.color, lap1.processor, lap1.graphic_card)
print(lap2.model, lap2.color, lap2.processor, lap2.graphic_card)
```

Output:

```text
hp15s silver intel i5 iris 2GB
hp pavilion black intel i7 nvidia Gforce
```

### Explanation

The class members are:

```python
brand = "hp"
warranty = 2
```

The object members are:

```python
self.model
self.color
self.processor
self.graphic_card
```

When this is executed:

```python
lap1 = Laptop("hp15s", "silver", "intel i5", "iris 2GB")
```

the constructor receives the values and stores them in `lap1`.

Similarly:

```python
lap2 = Laptop("hp pavilion", "black", "intel i7", "nvidia Gforce")
```

creates another object with different object-member values.

---

# 8. Methods in Python

A method is a function defined inside a class.

The two types practiced here are:

1. Instance Method
2. Class Method

---

# 9. Instance Method

An instance method works with object members.

`self` is the first parameter of an instance method.

### Syntax

```python
class ClassName:

    def method_name(self, arguments):
        # statements
```

The method is called using the object:

```python
object_name.method_name()
```

---

# 10. Bank Instance Method Example

```python
class Bank:

    bname = "SBI"
    loc = "chennai"

    def __init__(self, name, acc_no, ifsc):
        self.name = name
        self.acc_no = acc_no
        self.ifsc = ifsc

    def display(self):
        print(self.name, self.acc_no, self.ifsc)

    def ch_name(self, new):
        self.name = new

c1 = Bank("siva", 101, "sbi001")

c1.display()

c1.ch_name("ravi")

c1.display()
```

Output:

```text
siva 101 sbi001
ravi 101 sbi001
```

### Explanation

`display()` displays the object details.

```python
c1.display()
```

`ch_name()` changes the name of the object.

```python
c1.ch_name("ravi")
```

The statement:

```python
self.name = new
```

changes the value of the `name` member for that object.

---

# 11. Cricket Instance Method Example

```python
class Cricket:

    team = "India"
    jersey = "Blue"

    def __init__(self, name, age, role):
        self.name = name
        self.age = age
        self.role = role

    def display(self):
        print(self.name, self.age, self.role)

    def ch_name(self, new):
        self.name = new

c1 = Cricket("Dhoni", 40, "batsman")

c1.display()

c1.ch_name("Kohli")

c1.display()
```

Output:

```text
Dhoni 40 batsman
Kohli 40 batsman
```

This example shows how instance methods can display and modify object members.

---

# 12. Class Method

A class method is used to access or modify class members.

A class method is created using:

```python
@classmethod
```

The first parameter is:

```python
cls
```

`cls` represents the class.

### Syntax

```python
class ClassName:

    property = value

    @classmethod
    def method_name(cls, arguments):
        # statements
```

The class method can be called using the class name:

```python
ClassName.method_name()
```

---

# 13. Class Method Example

```python
class panimalar:

    college_name = "Panimalar Engineering College"
    location = "Chennai"

    @classmethod
    def display_info(cls):
        print(cls.college_name, cls.location)

panimalar.display_info()
```

Output:

```text
Panimalar Engineering College Chennai
```

### Explanation

The method:

```python
display_info()
```

works with class members.

The class members are:

```python
college_name
location
```

Inside the class method, they are accessed using:

```python
cls.college_name
cls.location
```

The method is called using:

```python
panimalar.display_info()
```

---

# 14. Instance Method vs Class Method

| Instance Method | Class Method |
|---|---|
| Works mainly with object members | Works with class members |
| Uses `self` | Uses `cls` |
| Does not require `@classmethod` | Uses `@classmethod` |
| Called using an object | Can be called using the class |
| Example: `c1.display()` | Example: `panimalar.display_info()` |

### Easy Way to Remember

```text
self → object
cls  → class
```

---

# 15. Constructor vs Method

| Constructor | Method |
|---|---|
| `__init__()` | Any method name |
| Used to initialize object data | Used to perform an operation |
| Called automatically during object creation | Usually called explicitly |
| Uses `self` | Instance methods use `self` |
| Example: `def __init__(...)` | Example: `def display(self)` |

Example:

```python
class Student:

    def __init__(self, name):
        self.name = name

    def display(self):
        print(self.name)
```

When:

```python
s = Student("John")
```

the constructor runs automatically.

Then:

```python
s.display()
```

calls the instance method.

---

# 16. Bank Class with Multiple Objects

A class can create multiple objects with different object-member values.

```python
class bank:

    bank_name = "Smith Bank"
    location = "mulakumoodu"

    def __init__(self, a_no, a_ho_na, bal):
        self.a_no = a_no
        self.a_ho_na = a_ho_na
        self.bal = bal

acc1 = bank(101, "shane jashwin", 1000)
acc2 = bank(102, "sanjay", 2000)

print(acc1.a_no, acc1.a_ho_na, acc1.bal)
print(acc2.a_no, acc2.a_ho_na, acc2.bal)
```

Output:

```text
101 shane jashwin 1000
102 sanjay 2000
```

Here:

```python
bank_name
location
```

are class members.

These are object members:

```python
a_no
a_ho_na
bal
```

Each object has its own values.

---

# 17. Important Keywords and Symbols

## `class`

Used to create a class.

```python
class Student:
    pass
```

## `self`

Represents the current object.

```python
self.name = name
```

## `__init__`

Constructor method used to initialize object members.

```python
def __init__(self, name):
    self.name = name
```

## `@classmethod`

Used to define a class method.

```python
@classmethod
def display(cls):
    print(cls.data)
```

## `cls`

Represents the class inside a class method.

---

# Quick Revision

### Class Member

```python
class Student:
    college = "ABC College"
```

Common class-level information.

### Object Member

```python
self.name = name
```

Information specific to an object.

### Constructor

```python
def __init__(self, name):
    self.name = name
```

Initializes object members.

### Instance Method

```python
def display(self):
    print(self.name)
```

Works with object data.

### Class Method

```python
@classmethod
def display(cls):
    print(cls.college)
```

Works with class data.

### Calling an Instance Method

```python
s.display()
```

### Calling a Class Method

```python
Student.display()
```

---

# Important Points for Placement

1. A class is a blueprint for creating objects.
2. An object is an instance of a class.
3. Class members contain common class-level data.
4. Object members contain individual object-level data.
5. `__init__()` is automatically called when an object is created.
6. `self` represents the current object.
7. Instance methods use `self`.
8. Class methods use `cls`.
9. `@classmethod` is used to create a class method.
10. An instance method is generally called using an object.
11. A class method can be called using the class.
12. Multiple objects can be created from the same class.
13. Each object can have different object-member values.
14. Assigning a value through an object can create or modify that object's instance attribute.

---

# Programs to Practice

1. Create a class with class members.
2. Create an object and access class members.
3. Modify a class member through an object.
4. Create object members.
5. Use `__init__()` to initialize object members.
6. Create multiple objects with different values.
7. Create and call an instance method.
8. Modify an object member using an instance method.
9. Create and call a class method.
10. Access class members using `cls`.

---

# Practice Template

```python
class Student:

    college = "ABC College"

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def display(self):
        print(self.name, self.age)

    @classmethod
    def college_info(cls):
        print(cls.college)


s1 = Student("John", 20)
s2 = Student("Alex", 21)

s1.display()
s2.display()

Student.college_info()
```

### Flow

```text
Create Class
      ↓
Define Class Members
      ↓
Define Constructor
      ↓
Create Object
      ↓
Initialize Object Members
      ↓
Create Instance Method
      ↓
Call Method Using Object
      ↓
Create Class Method
      ↓
Call Class Method Using Class
```
