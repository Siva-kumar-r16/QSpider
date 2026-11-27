# Java Class Notes -- Day 2

**Date:** 24 November 2026\
**Package:** `pec.sem_5.day2`

## Topics Covered

1.  Static and non-static methods
2.  Calling methods from another class
3.  Package importing and Scanner
4.  `Math.max()`
5.  Method calling and execution flow
6.  Arrays and array length
7.  Normal and enhanced `for` loops
8.  Searching an array

------------------------------------------------------------------------

## 1. Static and Non-Static Methods

A method is a block of code that performs a task.

### Static method

-   Belongs to the class.
-   Can be called directly inside the same class.
-   Can be called from another class using the class name.

### Non-static method

-   Belongs to an object.
-   An object must be created to call it from a static method such as
    `main()`.

### Example: Program1.java

``` java
public class Program1 {
    public static void test() {
        System.out.println("Test is running");
    }

    public void run() {
        System.out.println("Running");
    }

    public static void main(String[] args) {
        test();

        // run(); // Cannot call directly from static main()

        Program1 obj = new Program1();
        obj.run();
    }
}
```

**Output**

``` text
Test is running
Running
```

**Explanation** 1. `test()` is static, so it can be called directly from
`main()`. 2. `run()` is non-static, so an object is required. 3.
`Program1 obj = new Program1();` creates an object. 4. `obj.run();`
calls the non-static method through that object.

------------------------------------------------------------------------

## 2. Calling Methods from Another Class

### Example: Program2.java

``` java
public class Program2 {
    public static void main(String[] args) {
        Program1.test();

        // Program1.run(); // Invalid: run() is non-static

        Program1 obj = new Program1();
        obj.run();
        obj.test();
    }
}
```

**Output**

``` text
Test is running
Running
Test is running
```

**Explanation** - `Program1.test();` calls the static method using the
class name. - `Program1.run();` is invalid because `run()` is
non-static. - `obj.run();` calls the non-static method using an
object. - `obj.test();` calls a static method through an object. Java
permits this, but calling it through the class name (`Program1.test()`)
is the recommended style.

  Method       Belongs to   Calling syntax
  ------------ ------------ --------------------
  Static       Class        `Program1.test();`
  Non-static   Object       `obj.run();`

------------------------------------------------------------------------

## 3. Package Import, Scanner and Math Class

### Importing a package

An import statement allows a program to use a class from another
package.

``` java
import java.util.Scanner;
```

### Scanner

`Scanner` is used to receive input from the keyboard.

``` java
Scanner sc = new Scanner(System.in);
int number = sc.nextInt();
sc.close();
```

-   `System.in` represents keyboard input.
-   `nextInt()` reads an integer.
-   `close()` closes the Scanner.

### Math.max()

The `Math` class provides built-in mathematical methods.

``` java
System.out.println(Math.max(10.0, 20.00));
```

**Output**

``` text
20.0
```

`Math.max(a, b)` returns the greater of the two values. The `java.lang`
package, which contains `Math`, is imported automatically.

### Example: Program3.java

``` java
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();

        System.out.println(Math.max(10.0, 20.00));

        sc.close();
    }
}
```

**Explanation** 1. `Scanner` is imported from `java.util`. 2. A Scanner
object is created to read keyboard input. 3. `sc.nextInt()` reads an
integer. 4. `Math.max(10.0, 20.00)` returns the larger number. 5. The
Scanner is closed.

**Note about the given program:** The integer read by `sc.nextInt()` is
not stored or printed. The program waits for an integer input and then
prints `20.0`.

------------------------------------------------------------------------

## 4. Method Calling and Execution Flow

A method can call another method. After the called method finishes,
execution returns to the statement after the method call.

### Example: Program4.java

``` java
public class Program4 {
    public static void m1() {
        System.out.println("m1 is executing");
        m3();
    }

    public static void m2() {
        System.out.println("M2 is executing");
        m1();
        System.out.println("hi");
    }

    public static void m3() {
        System.out.println("M3 is executing");
    }

    public static void main(String[] args) {
        System.out.println("Program start");
        m2();
        System.out.println("Program ends");
    }
}
```

**Output**

``` text
Program start
M2 is executing
m1 is executing
M3 is executing
hi
Program ends
```

### Step-by-step execution

1.  Execution starts from `main()`.
2.  `Program start` is printed.
3.  `m2()` is called and prints `M2 is executing`.
4.  `m2()` calls `m1()`.
5.  `m1()` prints `m1 is executing`.
6.  `m1()` calls `m3()`.
7.  `m3()` prints `M3 is executing` and finishes.
8.  Execution returns to `m1()`, then to `m2()`.
9.  `hi` is printed.
10. Execution returns to `main()` and prints `Program ends`.

### Execution flow

``` text
main()
  |
  |-- Print "Program start"
  |
  |-- m2()
        |
        |-- Print "M2 is executing"
        |
        |-- m1()
              |
              |-- Print "m1 is executing"
              |
              |-- m3()
                    |
                    |-- Print "M3 is executing"
        |
        |-- Print "hi"
  |
  |-- Print "Program ends"
```

------------------------------------------------------------------------

## 5. Arrays in Java

An array stores multiple values of the same data type in one variable.

### Creating an array

``` java
int arr[] = new int[5];
```

This creates an integer array with five elements. Array indexing starts
from `0`.

### Assigning values

``` java
arr[0] = 5;
arr[1] = 7;
arr[2] = 4;
arr[3] = 9;
arr[4] = 1;
```

### Example: Program5.java

``` java
public class Program5 {
    public static void main(String[] args) {
        int arr[] = new int[5];

        arr[0] = 5;
        arr[1] = 7;
        arr[2] = 4;
        arr[3] = 9;
        arr[4] = 1;

        System.out.println(arr.length);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "--> ");
    }
}
```

**Output**

``` text
5
5--> 7--> 4--> 9--> 1-->
```

### Array index table

    Index   Value
  ------- -------
        0       5
        1       7
        2       4
        3       9
        4       1

### Array length

`arr.length` gives the total number of elements in an array.

``` java
System.out.println(arr.length);
```

For this array, the length is `5`. The last valid index is
`arr.length - 1`.

------------------------------------------------------------------------

## 6. Enhanced For Loop

The enhanced `for` loop is also called the for-each loop. It accesses
array elements one by one without requiring an index variable.

### Syntax

``` java
for (dataType variable : arrayName) {
    // Statements
}
```

### Example: Program6.java

``` java
public class Program6 {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40};
        int sum = 0;

        for (int i : arr)
            sum += i;

        System.out.print("Sum of array is " + sum);
    }
}
```

**Output**

``` text
Sum of array is 100
```

### Step-by-step explanation

1.  The array contains `10, 20, 30, 40`.
2.  `sum` starts at `0`.
3.  The enhanced loop takes each value from the array.
4.  `sum += i` adds the current value to `sum`.
5.  The final sum is printed.

    Iteration   `i` value   Sum
  ----------- ----------- -----
            1          10    10
            2          20    30
            3          30    60
            4          40   100

`sum += i` is shorthand for `sum = sum + i`.

------------------------------------------------------------------------

## 7. Searching for an Element in an Array

Searching means checking whether a particular value exists in an array
and finding its index.

The program uses: - `Scanner` to receive the search value. - A normal
`for` loop to visit each array element. - `if` to compare the current
element with the search value.

### Example: Program7.java as provided

``` java
import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {2, 5, 8, 13, 11};

        System.out.print("Enter the value to find index : ");
        int f = sc.nextInt(), found = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == f) {
                System.out.println("index of " + f + " is " + i);
            }
        }

        if (found == 0)
            System.out.print("Number not Found!!");

        sc.close();
    }
}
```

### Explanation

1.  The array contains `2, 5, 8, 13, 11`.
2.  The user enters a value to search.
3.  `f` stores the entered value.
4.  The loop checks each array element.
5.  `arr[i] == f` checks whether the current element matches the search
    value.
6.  If a match is found, its index is printed.

### Important issue in the provided program

The variable `found` is initialized to `0`, but it is never changed when
a match is found. Therefore, `if (found == 0)` remains true even when
the value exists. The program may print `Number not Found!!` after
printing a successful match.

### Corrected version

``` java
import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = {2, 5, 8, 13, 11};

        System.out.print("Enter the value to find index: ");
        int f = sc.nextInt();
        int found = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == f) {
                System.out.println("Index of " + f + " is " + i);
                found = 1;
                break;
            }
        }

        if (found == 0) {
            System.out.println("Number not Found!!");
        }

        sc.close();
    }
}
```

**Sample output when the value exists**

``` text
Enter the value to find index: 8
Index of 8 is 2
```

**Sample output when the value does not exist**

``` text
Enter the value to find index: 6
Number not Found!!
```

**Why use `found = 1`?** - `found = 0` means the value has not been
found yet. - `found = 1` means a match has been found. - After the loop,
if `found` is still `0`, the value does not exist in the array. -
`break` stops the loop after the first match.

------------------------------------------------------------------------

## Quick Revision

  Topic                    Important syntax or point
  ------------------------ ----------------------------------------
  Static method            `static void test()`
  Non-static method        `void run()`
  Create an object         `Program1 obj = new Program1();`
  Call static method       `Program1.test();`
  Call non-static method   `obj.run();`
  Import Scanner           `import java.util.Scanner;`
  Create Scanner           `Scanner sc = new Scanner(System.in);`
  Read integer             `sc.nextInt();`
  Close Scanner            `sc.close();`
  Find maximum             `Math.max(a, b)`
  Create array             `int arr[] = new int[5];`
  Initialize array         `int arr[] = {10, 20, 30};`
  Array length             `arr.length`
  Access element           `arr[0]`
  Normal for loop          `for (int i = 0; i < arr.length; i++)`
  Enhanced for loop        `for (int i : arr)`
  Add to sum               `sum += i;`
  Compare array value      `arr[i] == f`
  Stop a loop              `break;`

## Important Points to Remember

1.  A static method belongs to the class.
2.  A non-static method belongs to an object.
3.  Use `new` to create an object.
4.  `Scanner` is available in the `java.util` package.
5.  The `java.lang` package is imported automatically.
6.  `Math.max()` returns the greater of two values.
7.  Array indexes start from `0`.
8.  `arr.length` gives the number of elements.
9.  Use a normal `for` loop when the index is required.
10. Use an enhanced `for` loop to access each element directly.
11. Use a flag such as `found` to track whether a search succeeded.
12. Use `break` to stop searching after the first match.
