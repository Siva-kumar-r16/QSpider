# QSpider Python Notes

## 30-08-2025

# Assignment

This session continues **Object-Oriented Programming in Python**.

### Topics Covered

1. Static Method
2. Class Method Revision
3. Constructor in Inheritance
4. `super()`
5. Method Chaining
6. Bitwise Operators
7. Single Inheritance
8. Multi-Level Inheritance

---

# 1. Static Method

A static method is a method that does not require `self` or `cls`.

It is created using the:

```python
@staticmethod
```

decorator.

A static method is useful for a supporting operation that does not need object data or class data.

## Syntax

```python
class ClassName:

    @staticmethod
    def method_name(arguments):
        # statements
```

A static method can be called using the class name:

```python
ClassName.method_name()
```

It can also be accessed from an object method using:

```python
self.method_name(values)
```

and from a class method using:

```python
cls.method_name(values)
```

---

## Static Method Example

```python
class College:
    cname = "panimalar"
    loc = "chennai"

    @staticmethod
    def msg():
        print("Welcome to", College.cname)

College.msg()
```

Output:

```text
Welcome to panimalar
```

The `msg()` method does not need `self` or `cls`.

---

# 2. Class Method

A class method is used to access or modify class-level data.

It is created using:

```python
@classmethod
```

The first parameter is:

```python
cls
```

### Syntax

```python
class ClassName:

    @classmethod
    def method_name(cls, arguments):
        # statements
```

Example:

```python
class Hospital:
    hname = "abd"
    loc = "hyd"
    Phno = "1234567890"
    fees = 1000

    @classmethod
    def display(cls):
        print(cls.hname, cls.loc, cls.Phno, cls.fees)

    @classmethod
    def ch_Hname(cls, new_hname):
        cls.hname = new_hname

Hospital.display()

Hospital.ch_Hname("xyz")

Hospital.display()
```

The first call displays the original class information.

After:

```python
Hospital.ch_Hname("xyz")
```

the class member `hname` is changed.

---

# 3. Instance Method vs Class Method vs Static Method

| Method | First Argument | Decorator | Mainly Used For |
|---|---|---|---|
| Instance Method | `self` | None | Object members |
| Class Method | `cls` | `@classmethod` | Class members |
| Static Method | None | `@staticmethod` | General supporting operations |

### Easy Way to Remember

```text
self → Object
cls  → Class
static method → Neither self nor cls
```

---

# 4. Constructor

A constructor is used to initialize object members.

In Python, the constructor is:

```python
__init__()
```

It is automatically called when an object is created.

In inheritance, the parent class constructor can be called from the child class using:

```python
super().__init__()
```

### Syntax

```python
class Child(Parent):

    def __init__(self, arguments):
        super().__init__(arguments)
```

---

# 5. `super()`

`super()` is used to access the parent class from the child class.

One common use is calling the parent class constructor:

```python
super().__init__()
```

This allows the child class to initialize the attributes defined by the parent class.

---

# 6. Method Chaining

Method chaining in inheritance means calling a method of the parent class from a child class method using `super()`.

### Syntax

```python
super().method_name(arguments)
```

This allows the child class to reuse functionality from the parent class.

---

# 7. Bitwise Operators

Bitwise operators work on the binary representation of numbers.

The operators practiced are:

```text
&  → Bitwise AND
|  → Bitwise OR
^  → Bitwise XOR
```

The `bin()` function can be used to display a number in binary form.

Example:

```python
bin(10)
```

Output:

```text
0b1010
```

---

# 8. Bitwise AND `&`

The bitwise AND operator compares corresponding binary bits.

A bit becomes `1` only when both corresponding bits are `1`.

### Program

```python
a = 50
b = 10

print(a, bin(a))
print(b, bin(b))

result = a & b

print(f"a & b = {result}")
print(f"Binary result: {bin(result)}")
```

Output:

```text
a & b = 2
Binary result: 0b10
```

### Example

```text
50 = 110010
10 = 001010
     ------
AND  000010
```

Therefore:

```text
50 & 10 = 2
```

---

# 9. Bitwise OR `|`

The bitwise OR operator compares corresponding binary bits.

A bit becomes `1` when at least one of the corresponding bits is `1`.

### Program

```python
a = 40
b = 10

print(a, bin(a))
print(b, bin(b))

result = a | b

print(f"a | b = {result}")
print(f"Binary result: {bin(result)}")
```

Output:

```text
a | b = 42
Binary result: 0b101010
```

### Example

```text
40 = 101000
10 = 001010
     ------
OR   101010
```

Therefore:

```text
40 | 10 = 42
```

---

# 10. Bitwise XOR `^`

The bitwise XOR operator gives `1` when the two corresponding bits are different.

If both bits are the same, the result is `0`.

### Program

```python
a = 30
b = 10

print(a, bin(a))
print(b, bin(b))

result = a ^ b

print(f"a ^ b = {result}")
print(f"Binary result: {bin(result)}")
```

Output:

```text
a ^ b = 20
Binary result: 0b10100
```

### Example

```text
30 = 011110
10 = 001010
     ------
XOR  010100
```

Therefore:

```text
30 ^ 10 = 20
```

---

# 11. Bitwise Operators Quick Revision

| Operator | Name | Rule |
|---|---|---|
| `&` | AND | `1` only if both bits are `1` |
| `|` | OR | `1` if at least one bit is `1` |
| `^` | XOR | `1` if the bits are different |

Useful function:

```python
bin(number)
```

converts an integer to its binary representation.

---

# 12. Inheritance

Inheritance allows one class to use properties and methods from another class.

The existing class is called the **parent class**.

The new class is called the **child class**.

```text
Parent Class
     ↓
Child Class
```

Inheritance helps in code reuse.

---

# 13. Single Inheritance

Single inheritance means one child class inherits from one parent class.

### Syntax

```python
class Parent:
    # parent code

class Child(Parent):
    # child code
```

The child can use members available from the parent and can also have its own members.

---

# 14. Single Inheritance Example

```python
class Bank:
    bank_name = "My Bank"
    loc = "chennai"

    def __init__(self, name, acc_no, bal):
        self.name = name
        self.acc_no = acc_no
        self.bal = bal

    def display(self):
        print(self.name, self.acc_no, f"${self.bal:,.2f}")


class Customer(Bank):

    def deposit(self, amount):
        if amount > 0:
            self.bal += amount
            print(f"Successfully deposited ${amount:,.2f}.")
            print(f"New balance is ${self.bal:,.2f}.")
        else:
            print("Error: Deposit amount must be positive.")

    def withdraw(self, amount):
        if amount <= 0:
            print("Error: Withdrawal amount must be positive.")
        elif self.bal >= amount:
            self.bal -= amount
            print(f"Successfully withdrew ${amount:,.2f}.")
            print(f"New balance is ${self.bal:,.2f}.")
        else:
            print(
                f"Error: Insufficient funds. "
                f"Current balance is ${self.bal:,.2f}."
            )

    def ch_bal(self, bal):
        self.bal = bal


c1 = Customer(name="Siva", acc_no="12345", bal=5000)

c1.display()

c1.deposit(1500)
c1.withdraw(300)
c1.withdraw(7000)

print("\nAfter transactions:")
c1.display()
```

### Output

```text
Siva 12345 $5,000.00
Successfully deposited $1,500.00.
New balance is $6,500.00.
Successfully withdrew $300.00.
New balance is $6,200.00.
Error: Insufficient funds. Current balance is $6,200.00.

After transactions:
Siva 12345 $6,200.00
```

### Explanation

`Customer` inherits from:

```python
Bank
```

So:

```python
class Customer(Bank):
```

means `Customer` is the child class and `Bank` is the parent class.

The `Customer` object can use the constructor and `display()` method defined in `Bank`.

The child class also has its own methods:

```python
deposit()
withdraw()
ch_bal()
```

---

# 15. Multi-Level Inheritance

Multi-level inheritance occurs when inheritance happens in a chain.

Example:

```text
Grandparent
     ↓
   Parent
     ↓
   Child
```

### Syntax

```python
class Grandparent:
    pass

class Parent(Grandparent):
    pass

class Child(Parent):
    pass
```

---

# 16. Multi-Level Inheritance Example

```python
class Grandfather:

    def __init__(self, g_name):
        self.g_name = g_name

    def house(self):
        print(f"This is {self.g_name}'s house.")


class Father(Grandfather):

    def __init__(self, f_name, g_name):
        super().__init__(g_name)
        self.f_name = f_name

    def house(self):
        print(f"This is {self.f_name}'s house.")


class Son(Father):

    def __init__(self, s_name, f_name, g_name):
        super().__init__(f_name, g_name)
        self.s_name = s_name

    def car(self):
        print(f"This is {self.s_name}'s car.")


son = Son("Siva", "Raj", "Kumar")

son.house()
son.car()
```

Output:

```text
This is Raj's house.
This is Siva's car.
```

### Explanation

The inheritance chain is:

```text
Grandfather
     ↓
   Father
     ↓
    Son
```

The `Father` class calls the `Grandfather` constructor:

```python
super().__init__(g_name)
```

The `Son` class calls the `Father` constructor:

```python
super().__init__(f_name, g_name)
```

Therefore, the constructors are connected through the inheritance chain.

---

# 17. Method Overriding in the Example

Both `Grandfather` and `Father` contain:

```python
def house(self):
```

The `Father` class provides its own version of `house()`.

Therefore, when:

```python
son.house()
```

is called, the inherited `Father` version is used.

This is an example of method overriding.

---

# 18. `super()` in Multi-Level Inheritance

In the example:

```python
class Father(Grandfather):

    def __init__(self, f_name, g_name):
        super().__init__(g_name)
```

`super()` refers to the parent class, which is `Grandfather`.

Similarly:

```python
class Son(Father):

    def __init__(self, s_name, f_name, g_name):
        super().__init__(f_name, g_name)
```

Here `super()` refers to the parent class, which is `Father`.

---

# 19. Static vs Class vs Instance Methods

```text
Instance Method
      ↓
     self
      ↓
Object data

Class Method
      ↓
      cls
      ↓
Class data

Static Method
      ↓
No self
No cls
      ↓
Supporting operation
```

---

# 20. Important Concepts

### `self`

Represents the current object.

```python
self.name = name
```

### `cls`

Represents the class in a class method.

```python
cls.location
```

### `super()`

Used to access the parent class.

```python
super().__init__()
```

or:

```python
super().method_name()
```

### `@staticmethod`

Creates a static method.

```python
@staticmethod
def msg():
    pass
```

### `@classmethod`

Creates a class method.

```python
@classmethod
def display(cls):
    pass
```

---

# Quick Revision

## Static Method

```python
@staticmethod
def method():
    pass
```

Does not require `self` or `cls`.

## Class Method

```python
@classmethod
def method(cls):
    pass
```

Works with class-level data.

## Instance Method

```python
def method(self):
    pass
```

Works with object-level data.

## Constructor

```python
def __init__(self):
    pass
```

Used to initialize an object.

## Parent Constructor

```python
super().__init__()
```

## Parent Method

```python
super().method_name()
```

## Single Inheritance

```python
class Child(Parent):
    pass
```

## Multi-Level Inheritance

```python
class Grandparent:
    pass

class Parent(Grandparent):
    pass

class Child(Parent):
    pass
```

## Bitwise AND

```python
a & b
```

## Bitwise OR

```python
a | b
```

## Bitwise XOR

```python
a ^ b
```

## Binary Representation

```python
bin(a)
```

---

# Important Placement Points

1. A static method does not require `self` or `cls`.
2. `@staticmethod` is used to define a static method.
3. A class method uses `cls`.
4. `@classmethod` is used to define a class method.
5. An instance method uses `self`.
6. `__init__()` is used to initialize object members.
7. `super()` can be used to call a parent constructor.
8. `super()` can also be used to call a parent method.
9. Single inheritance has one parent and one child relationship.
10. Multi-level inheritance creates an inheritance chain.
11. `&` performs bitwise AND.
12. `|` performs bitwise OR.
13. `^` performs bitwise XOR.
14. `bin()` displays the binary representation of an integer.
15. A child class can have its own methods in addition to inherited methods.
16. A child class can override a method inherited from the parent class.

---

# Programs to Practice

1. Create a static method.
2. Call a static method using a class.
3. Create a class method.
4. Modify a class member using a class method.
5. Create an instance method.
6. Use `super()` to call a parent constructor.
7. Use `super()` to call a parent method.
8. Perform bitwise AND.
9. Perform bitwise OR.
10. Perform bitwise XOR.
11. Create a single inheritance program.
12. Create a multi-level inheritance program.
13. Practice method overriding.
14. Create a program combining instance, class and static methods.

---

# Practice Template

```python
class Parent:

    def __init__(self, name):
        self.name = name

    def display(self):
        print(self.name)


class Child(Parent):

    def __init__(self, name, age):
        super().__init__(name)
        self.age = age

    def show(self):
        print(self.name, self.age)


c = Child("John", 20)

c.display()
c.show()
```

### Flow

```text
Create Parent Class
       ↓
Create Child Class
       ↓
Use Inheritance
       ↓
Call Parent Constructor using super()
       ↓
Initialize Child Object
       ↓
Call Methods
```
