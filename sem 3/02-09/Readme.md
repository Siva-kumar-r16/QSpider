# QSpider Python Notes

## Date: 02-09-2025

---

# Polymorphism

**Polymorphism** means **"one name, many forms."**

It allows the same function or method name to behave differently depending on the object or how it is used.

In Python, polymorphism mainly appears in:

1. Method Overriding — Runtime Polymorphism
2. Method Overloading — Compile-time Polymorphism concept, simulated in Python
3. Operator Overloading
4. Duck Typing
5. Monkey Patching

---

# 1. Method Overriding

Method overriding is a form of **runtime polymorphism**.

When a child class provides its own implementation of a method that already exists in the parent class, the child method overrides the parent method.

### Example

```python
class BankAccount:
    def interest_rate(self):
        return 4


class SavingAccount(BankAccount):
    type = "Saving Account"

    def interest_rate(self):
        return 6


s1 = SavingAccount()
print(s1.interest_rate())
```

### Output

```text
6
```

Here, `BankAccount` has `interest_rate()`, but `SavingAccount` provides its own version. Therefore, when `s1.interest_rate()` is called, the child class implementation is executed.

---

# 2. Operator Overloading

Python allows classes to define how operators such as:

- `+`
- `-`
- `*`
- `/`

behave with objects.

This is called **operator overloading**.

Special methods, also called **magic methods**, are used for this purpose.

Examples:

```python
__add__()
__str__()
```

`__add__()` can define the behavior of the `+` operator for objects.

`__str__()` can define how an object is represented as a string.

---

# 3. Duck Typing

Duck typing is a form of polymorphism where the behavior of an object is more important than its class or type.

The idea is:

> If an object provides the required method, it can be used.

### Example

```python
class SavingsAccount:
    def withdraw():
        return "Withdraw from Savings"


class CurrentAccount:
    def withdraw():
        return "Withdraw from Current"


def process_withdrawal(account_type):
    print(account_type.withdraw())


process_withdrawal(SavingsAccount)
process_withdrawal(CurrentAccount)
```

The same `process_withdrawal()` function works with both classes because both provide a `withdraw()` method.

The function does not need to check whether the class is `SavingsAccount` or `CurrentAccount`.

---

# 4. Monkey Patching

Monkey patching means changing or replacing a class or object's method during runtime.

### Example

```python
class BankAccount:
    def __init__(self, holder, balance=0):
        self.holder = holder
        self.balance = balance

    def show_balance(self):
        return f"Account Holder: {self.holder}, Balance: {self.balance}"


def hacked_method(self):
    return "Hacked!"


acc = BankAccount("LEO DAS", 1000)

print(acc.show_balance())

BankAccount.show_balance = hacked_method

print(acc.show_balance())
```

Here, `show_balance()` is replaced with `hacked_method` during runtime.

Before patching:

```text
Account Holder: LEO DAS, Balance: 1000
```

After patching:

```text
Hacked!
```

---

# 5. Method Overloading

Method overloading means having the same method name with different parameters.

Python does not support traditional compile-time method overloading in the same way as languages such as Java.

The concept can be simulated in Python using techniques such as default arguments or variable-length arguments.

The notes classify method overloading as:

**Compile-time polymorphism — simulated in Python.**

---

# Abstraction

**Abstraction** means hiding internal implementation details and showing only the essential features.

The main idea is to focus on **what an object does** rather than exposing all the internal details of **how it does it**.

In Python, abstraction can be implemented using abstraction-related class structures such as abstract classes and abstract methods.

The important idea to remember is:

```text
Abstraction → Hide implementation details
              Show only essential features
```

---

# MyBank CLI Application

A larger banking application was practiced using OOPS concepts, inheritance, method overriding, `super()`, encapsulation-style validation, polymorphism and transaction handling.

## Base Class: BankAccount

The `BankAccount` class contains common banking information and operations.

### Class Members

```python
bankname = "MyBank"
loc = "chennai"
```

### Instance Members

The constructor receives:

- `name`
- `pin`
- `balance`
- `acc_no`

and also creates:

```python
self.transactions = []
```

The transaction list stores deposit and withdrawal details.

---

## PIN Validation

A helper method `_validate_pin()` checks whether the entered PIN matches the account PIN.

```python
def _validate_pin(self, entered_pin):
    if entered_pin == self.pin:
        return True
    else:
        print("Access denied. Incorrect PIN.")
        return False
```

The banking operations use this validation before allowing access.

---

## Display Account Details

The `display()` method checks the PIN and then displays:

- Name
- Balance
- Bank Name
- Location
- Account Number

---

## Deposit

The `deposit()` method:

1. Validates the PIN.
2. Checks whether the amount is greater than zero.
3. Adds the amount to the balance.
4. Stores the transaction with its type, amount and timestamp.
5. Prints a success message.

---

## Withdraw

The `withdraw()` method:

1. Validates the PIN.
2. Checks whether the amount is positive.
3. Checks whether sufficient funds are available.
4. Subtracts the amount from the balance.
5. Stores the withdrawal transaction.
6. Prints the result.

---

## Check Balance

The `check_balance()` method displays the current balance after successful PIN validation.

---

## Transaction History

The `view_history()` method displays all stored transactions.

Each transaction contains:

```python
{
    "type": "Deposit",
    "amount": amount,
    "timestamp": ...
}
```

The timestamp is created using `datetime.now().isoformat()`.

---

# Inheritance in the Banking Application

Several account types inherit from `BankAccount`.

```text
BankAccount
│
├── SavingsAccount
│   └── ChildrensAccount
│       └── ...
│
├── CurrentAccount
│
└── LoanAccount
    ↑
 SavingsAccount
```

The actual classes used are:

- `BankAccount`
- `SavingsAccount`
- `ChildrensAccount`
- `CurrentAccount`
- `LoanAccount`

---

# SavingsAccount

`SavingsAccount` inherits from `BankAccount`.

It adds:

```python
self.interest_rate = interest_rate
```

Its `display()` method uses:

```python
super().display(entered_pin)
```

and then displays the interest rate.

This demonstrates:

- Inheritance
- Method overriding
- `super()`

---

# ChildrensAccount

`ChildrensAccount` inherits from `SavingsAccount`.

It adds:

- `age`
- `guardian_name`

The account is created only when:

```python
age <= 18
```

Otherwise, a `ValueError` is raised.

Its `display()` method calls the parent implementation using `super().display()` and then displays the guardian name.

---

# CurrentAccount

`CurrentAccount` inherits from `BankAccount`.

It adds:

```python
self.overdraft_limit = overdraft_limit
```

The `withdraw()` method is overridden.

Unlike the normal account, it allows the balance to go negative up to the specified overdraft limit.

This is another example of **method overriding**.

---

# LoanAccount

`LoanAccount` inherits from `SavingsAccount`.

It adds:

```python
self.loan_amount = loan_amount
```

Its `display()` method calls the inherited display behavior and then displays the loan amount.

---

# `super()` in the Banking Application

`super()` is used to access methods or constructors of the parent class.

For example:

```python
super().__init__(name, pin, balance, acc_no)
```

calls the parent constructor.

Another example:

```python
super().display(entered_pin)
```

calls the parent version of `display()`.

This avoids rewriting the same parent functionality in the child class.

---

# Polymorphism in the Banking Application

Different account classes have methods with the same names but different behavior.

For example:

```python
display()
```

exists in multiple account classes.

`CurrentAccount` also provides its own:

```python
withdraw()
```

implementation.

The application can work with different account objects while calling common method names.

This demonstrates polymorphism through inheritance and method overriding.

---

# `isinstance()`

The application checks the type of an account using:

```python
isinstance(user_account, LoanAccount)
```

This is used to identify whether the current account is a `LoanAccount`.

The menu changes based on the account type.

For a loan account, the menu provides loan information and logout.

For other accounts, the menu provides:

- Check Balance
- Deposit
- Withdraw
- View Transaction History
- Display Account Info
- Logout

---

# Finding an Account

The application stores multiple account objects in:

```python
all_accounts = [...]
```

The `find_account()` function searches for an account using the username and PIN.

```python
def find_account(name, pin):
    for account in all_accounts:
        if account.name.lower() == name.lower() and account.pin == pin:
            return account
    return None
```

The username comparison is case-insensitive using:

```python
.lower()
```

---

# Main CLI Flow

The application starts with:

```text
MyBank CLI Application
```

The user enters:

1. Username
2. PIN

If the account is found, the user is welcomed and shown the appropriate menu.

The user can perform operations until choosing logout.

Entering:

```text
exit
```

at the username prompt exits the application.

---

# Important Concepts Learned

| Concept | Meaning |
|---|---|
| Polymorphism | One name, many forms |
| Method Overriding | Child class provides its own implementation |
| Operator Overloading | Defining operator behavior for objects |
| Duck Typing | Object behavior matters more than exact type |
| Monkey Patching | Changing/replacing behavior during runtime |
| Abstraction | Hiding implementation details |
| Inheritance | Reusing parent class features |
| `super()` | Accessing parent class functionality |
| `isinstance()` | Checking an object's class/type |
| Encapsulation-style validation | Controlling access through methods such as PIN validation |

---

# Quick Revision

### Polymorphism

```text
One name → Many forms
```

### Method Overriding

```text
Parent method
     ↓
Child provides its own implementation
```

### Operator Overloading

```text
Operators → Magic methods
```

Examples:

```python
__add__()
__str__()
```

### Duck Typing

```text
If the object has the required method,
it can be used.
```

### Monkey Patching

```text
Replace/change a method during runtime.
```

### Abstraction

```text
Hide internal details
Show essential features
```

---

# Assignment / Homework

## Practice Programs

1. Implement method overriding using a parent and child class.
2. Create two classes with the same method and demonstrate duck typing.
3. Demonstrate monkey patching by replacing a class method at runtime.
4. Practice operator overloading using magic methods.
5. Create a small program demonstrating abstraction.
6. Practice inheritance with multiple account types.
7. Implement a banking application using inheritance and polymorphism.
8. Add deposit, withdrawal and balance-checking operations.
9. Maintain transaction history for account operations.
10. Use `super()` to call parent constructors and methods.
11. Use `isinstance()` to identify different account types.

## Main Topics to Revise

- Polymorphism
- Method Overriding
- Method Overloading concept
- Operator Overloading
- Duck Typing
- Monkey Patching
- Abstraction
- Inheritance
- `super()`
- `isinstance()`
- Banking application using OOPS

---

# Placement Revision Points

For interviews and placement practice, remember:

```text
Polymorphism
    ↓
Same method name
    ↓
Different behavior
```

```text
Method Overriding
    ↓
Child class changes parent method behavior
```

```text
Duck Typing
    ↓
Required behavior matters
    ↓
Exact class type is less important
```

```text
Monkey Patching
    ↓
Modify behavior at runtime
```

```text
Abstraction
    ↓
Hide implementation
    ↓
Expose essential functionality
```

These concepts are important for understanding Python OOPS and writing reusable object-oriented programs.
