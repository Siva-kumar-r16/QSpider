# Java Class Notes

**Date:** 23 November 2026\
**Package used in examples:** `org.sem_5.day1`

## Topics Covered

1.  Finding the largest of two numbers using `if-else`
2.  Ternary operator
3.  Type casting: widening and narrowing
4.  `final` variables
5.  Methods with return values
6.  Boolean methods and the ternary operator
7.  Method overloading

------------------------------------------------------------------------

## 1. Finding the Largest of Two Numbers

**Concept:** `if-else` is used to execute one block of code when a
condition is true and another block when it is false.

### Example: `Program1.java`

``` java
public class Program1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        if (a > b) {
            System.out.print(a + " is largest number");
        } else {
            System.out.print(b + " is largest number\\n");
        }

        System.out.print(a > b ? a : b);
    }
}
```

**Explanation:** - `a` and `b` are integer variables. - `a > b` checks
whether `a` is greater than `b`. - If the condition is true, `a` is
printed. - Otherwise, the `else` block prints `b`. - The final statement
uses the ternary operator to select and print the larger value.

**Output:**

``` text
20 is largest number
20
```

### Ternary Operator

The ternary operator is a short form of `if-else`.

**Syntax:**

``` java
condition ? value_if_true : value_if_false;
```

Example:

``` java
int largest = (a > b) ? a : b;
```

If `a > b` is true, `a` is selected. Otherwise, `b` is selected.

------------------------------------------------------------------------

## 2. Type Casting

**Concept:** Type casting means converting a value from one data type to
another.

Java supports two common types of casting.

### A. Widening Type Casting

Widening converts a smaller compatible data type into a larger data
type.

-   It is performed automatically by Java.
-   It generally does not lose information.

Example:

``` java
int a = 10;
double d = a;
System.out.println(d);
```

**Output:**

``` text
10.0
```

Here, the `int` value `10` is automatically converted into the `double`
value `10.0`.

### B. Narrowing Type Casting

Narrowing converts a larger data type into a smaller data type.

-   It requires explicit casting.
-   Information may be lost.

Example:

``` java
double b = 10.5;
int c = (int) b;
System.out.print(c);
```

**Output:**

``` text
10
```

The decimal part `.5` is removed when the `double` value is converted to
`int`.

### Complete Example: `Program2.java`

``` java
public class Program2 {
    public static void main(String[] args) {
        int a = 10;
        double d = a;       // Widening type casting
        System.out.println(d);

        double b = 10.5;
        int c = (int) b;    // Narrowing type casting
        System.out.print(c);
    }
}
```

**Output:**

``` text
10.0
10
```

  Casting type   Conversion                    How it is done
  -------------- ----------------------------- ------------------------
  Widening       Smaller type to larger type   Automatically
  Narrowing      Larger type to smaller type   Explicit cast required

------------------------------------------------------------------------

## 3. `final` Keyword

**Concept:** The `final` keyword is used to prevent a variable from
being reassigned after it has been initialized.

### Example: `Program4.java`

``` java
public class Program4 {
    public static void main(String[] args) {
        int a = 10;
        a = 20;
        System.out.println(a);

        final int b = 5;
        // b = 10; // Error: a final variable cannot be reassigned
    }
}
```

**Output:**

``` text
20
```

**Explanation:** - `a` is a normal variable, so its value can be changed
from `10` to `20`. - `b` is declared using `final`. - Once `b` is
initialized with `5`, it cannot be reassigned. - Uncommenting `b = 10;`
causes a compilation error.

**Remember:** A `final` variable can be assigned only once.

------------------------------------------------------------------------

## 4. Method with a Return Value

**Concept:** A method can perform a task and send a result back to the
place where it was called using the `return` keyword.

### Example: `Program5.java`

``` java
public class Program5 {
    public static int add() {
        int a = 10;
        int b = 20;
        System.out.println("Hi");
        return a + b;
    }

    public static void main(String[] args) {
        int res = add();
        System.out.println(res);
    }
}
```

**Output:**

``` text
Hi
30
```

**Step-by-step explanation:** 1. Program execution starts from `main()`.
2. `add()` is called. 3. Inside `add()`, `a` is assigned `10` and `b` is
assigned `20`. 4. `Hi` is printed. 5. `return a + b;` sends `30` back to
the calling statement. 6. The returned value is stored in `res`. 7.
`res` is printed.

**Important points:** - `int` before the method name means the method
returns an integer. - `return` sends a value back to the caller. - The
returned value can be stored in a variable. - A `void` method does not
return a value.

------------------------------------------------------------------------

## 5. Boolean Method and Ternary Operator

**Concept:** A boolean method returns either `true` or `false`.

### Example: `Program6.java`

``` java
public class Program6 {
    public static boolean isEven(int n) {
        return n % 2 == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.print("5 is Even " + isEven(5));
    }
}
```

**Output:**

``` text
5 is Even false
```

**Step-by-step explanation:** 1. `isEven(int n)` receives an integer. 2.
`n % 2` calculates the remainder after division by `2`. 3. If the
remainder is `0`, the number is even. 4. Otherwise, the number is odd.
5. The ternary operator returns `true` or `false`.

**Examples:**

    Number   Remainder when divided by 2 Result
  -------- ----------------------------- ---------
         4                             0 `true`
         5                             1 `false`
         8                             0 `true`
         9                             1 `false`

**Simpler version:** Since `n % 2 == 0` is already a boolean expression,
the method can also be written as:

``` java
public static boolean isEven(int n) {
    return n % 2 == 0;
}
```

------------------------------------------------------------------------

## 6. Method Overloading

**Concept:** Method overloading means creating multiple methods with the
same name but different parameter lists in the same class.

The methods can differ by: - Number of parameters - Type of parameters -
Order of parameter types

Changing only the return type is not enough to overload a method.

### Example: `Flipkart.java`

``` java
public class Flipkart {
    public static void payment() {
        System.out.print("COD");
    }

    public static void payment(String id, String password) {
        System.out.println("Net banking");
    }

    public static void payment(long l) {
        System.out.print("Card Payment");
    }

    public static void main(String[] args) {
        // Call any one of the overloaded methods here
    }
}
```

**Explanation:** - `payment()` has no parameters and represents COD. -
`payment(String id, String password)` has two `String` parameters and
represents Net banking. - `payment(long l)` has one `long` parameter and
represents Card Payment. - All three methods have the same name, but
their parameter lists are different.

**Calling the overloaded methods:**

``` java
payment();
payment("user123", "pass123");
payment(123456789L);
```

**Remember:** Java selects the overloaded method based on the arguments
passed during the method call.

------------------------------------------------------------------------

## Quick Revision

  -----------------------------------------------------------------------
  Topic                   Main point              Example
  ----------------------- ----------------------- -----------------------
  `if-else`               Executes a block based  `if (a > b)`
                          on a condition          

  Ternary operator        Short form of `if-else` `a > b ? a : b`

  Widening casting        Smaller type to larger  `double d = a;`
                          type                    

  Narrowing casting       Larger type to smaller  `int c = (int) b;`
                          type                    

  `final`                 Prevents reassignment   `final int b = 5;`

  Return method           Sends a value back to   `return a + b;`
                          the caller              

  Boolean method          Returns `true` or       `return n % 2 == 0;`
                          `false`                 

  Method overloading      Same method name with   `payment()`
                          different parameters    
  -----------------------------------------------------------------------

## Important Java Reminders

1.  Java is case-sensitive. `String` and `string` are different.

2.  The correct main method declaration is:

    ``` java
    public static void main(String[] args)
    ```

3.  A method's return type must match the value returned.

4.  A method declared with `void` does not return a value.

5.  Use `(dataType)` for explicit narrowing conversion.

6.  Overloaded methods must have different parameter lists.

## Correction to Check in the Uploaded `Flipkart.java`

The uploaded file contains:

``` java
public static void main(string[] args)
```

In Java, the correct type name is `String` with a capital `S`:

``` java
public static void main(String[] args)
```

The uploaded `main` method is also empty, so the overloaded `payment()`
methods will not run unless they are called from `main()` or another
method.
