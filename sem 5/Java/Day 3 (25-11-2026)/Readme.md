# Java Class Notes: Day 3

**Package:** `pec.sem_5.day3`
**Programs covered:** 5
**Level:** Beginner

---

## Table of Contents

- [Before You Start](#before-you-start)
- [Program 1: Check Prime Number](#program-1-check-prime-number)
- [Program 2: Reverse a Number](#program-2-reverse-a-number)
- [Program 3: Check Emirp Number](#program-3-check-emirp-number)
- [Program 4: Reverse an Array](#program-4-reverse-an-array)
- [Program 5: Check Neon Number](#program-5-check-neon-number)
- [Final Revision](#final-revision)
  - [Important Java Concepts](#important-java-concepts)
  - [Important Syntax](#important-syntax)
  - [Important Differences](#important-differences)
  - [Common Mistakes](#common-mistakes)
  - [Quick Revision Table](#quick-revision-table)
  - [Practice Questions](#practice-questions)
  - [Answers to Practice Questions](#answers-to-practice-questions)

---

## Before You Start

All five programs share the same basic structure. Learn it once here.

| Term | Simple meaning |
|---|---|
| `package` | A folder-like group for related classes. It must be the first statement in the file. |
| `class` | A container that holds variables and methods. |
| `public` | Can be used from anywhere. |
| `static` | Belongs to the class itself. You can call it without creating an object. |
| Method | A named block of code that does one job. |
| Return type | The type of value a method sends back, such as `int` or `boolean`. |
| `void` | The method sends back no value. |
| Parameter | The variable written in the method definition, such as `int n`. |
| Argument | The actual value passed when calling the method, such as `7`. |
| `return` | Ends the method. It can also send a value back to the caller. |
| `main` | The method where Java starts running the program. |
| `String[] args` | An array of text values that can be given from the command line. These programs do not use it. |

### How to Compile and Run

The programs belong to the package `pec.sem_5.day3`. Open a terminal in the folder that contains the file and run:

```bash
javac -d . Program1.java
java pec.sem_5.day3.Program1
```

- `javac` compiles the source code.
- `-d .` creates the package folders inside the current folder (`.`).
- `java` runs the class. You must give the full name, including the package.

For another program, replace `Program1` with its name.

> **Program 3 note:** it contains its own copies of `isPrime` and `reverse`, so it also compiles on its own.

---

### Program 1: Check Prime Number

**Aim:** To check whether a given number is a prime number. The program tests the number `3`.

A **prime number** is a whole number greater than 1 that has exactly two divisors: `1` and itself. Examples: `2, 3, 5, 7, 11`.

**Concept Used:**

- Static method with a parameter
- `boolean` return type
- `if` and `if-else` statements
- `for` loop
- Operators `<=`, `/`, `%`, `==`, `++`
- Early `return`

**Original Program:** `Program1.java`

```java
package pec.sem_5.day3;


public class Program1 {
    public static boolean primeNumber(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        if (primeNumber(n)) 
            System.out.println("Prime Number");
            
        else
            System.out.println("Not Prime Number");
        
    }
} 
```

**Explanation:**

| Code | What it does and why |
|---|---|
| `package pec.sem_5.day3;` | Places the class in this package. |
| `public class Program1` | Declares the class. The file name must be `Program1.java`. |
| `public static boolean primeNumber(int n)` | A method that takes an integer `n` and returns `true` or `false`. |
| `if (n <= 1) return false;` | `<=` means "less than or equal to". Numbers `1`, `0` and negatives are not prime, so we stop at once. |
| `int i = 2` | Start testing divisors from `2`. We skip `1` because it divides every number. |
| `i <= n/2` | Continue while `i` is not more than half of `n`. A number cannot have a divisor between its half and itself. |
| `i++` | Adds `1` to `i` after each round. |
| `n % i == 0` | `%` gives the remainder. `==` compares two values. A remainder of `0` means `i` divides `n`. |
| `return false;` (inside loop) | A divisor was found, so `n` is not prime. No more testing is needed. |
| `return true;` | The loop ended without finding a divisor, so `n` is prime. |
| `int n = 3;` | The number to be tested. |
| `if (primeNumber(n))` | Calls the method. The returned `boolean` is used directly as the condition. |
| `System.out.println(...)` | Prints the text and moves to a new line. |

**About `/`:** when both values are integers, `/` removes the decimal part. So `3/2` is `1`, not `1.5`.

**About braces:** the inner `if` has no `{ }`. In that case only the next single statement belongs to it.

**Step-by-Step Execution:**

1. Java starts in `main`.
2. The variable `n` is set to `3`.
3. `main` calls `primeNumber(3)`. The value `3` is copied into the parameter `n`.
4. The condition `3 <= 1` is false, so the method continues.
5. The loop sets `i = 2` and checks `2 <= 3/2`, which is `2 <= 1`. This is false.
6. The loop body never runs.
7. The method returns `true`.
8. The `if` in `main` is true, so `Prime Number` is printed.

**Dry Run:** for the given input `n = 3`

| Step | n | i | Condition checked | Result |
|---:|---:|---:|---|---|
| 1 | 3 | not created yet | `3 <= 1` is false | Continue |
| 2 | 3 | 2 | `2 <= 1` is false | Loop does not run |
| 3 | 3 | not needed | none | Return `true` |

The loop does not run for `3`, so here are two more traces to show how it works. These are **not** the output of the uploaded program.

Trace for `n = 7` (`n/2 = 3`):

| Iteration | i | `i <= 3` | `7 % i` | Result |
|---:|---:|---|---:|---|
| 1 | 2 | true | 1 | No divisor, continue |
| 2 | 3 | true | 1 | No divisor, continue |
| End | 4 | false | not checked | Return `true` (prime) |

Trace for `n = 9` (`n/2 = 4`):

| Iteration | i | `i <= 4` | `9 % i` | Result |
|---:|---:|---|---:|---|
| 1 | 2 | true | 1 | Continue |
| 2 | 3 | true | 0 | Return `false` (not prime) |

**Output:**

```text
Prime Number
```

**Important Points:**

- A `boolean` method is useful for yes-or-no questions.
- `return false` inside the loop ends the whole method, not only the loop.
- `return true` must be **after** the loop. We can be sure a number is prime only after all tests are done.
- For `n = 2` and `n = 3`, the loop does not run and the answer is correctly `true`.

**Possible Improvement (the original is correct):**

The original gives correct answers but does more checks than needed. Divisors come in pairs. For `36`: `2×18`, `3×12`, `4×9`, `6×6`. One number in each pair is never larger than the square root. So we only need to test up to the square root.

```java
public class Program1Improved {
    public static boolean primeNumber(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        if (primeNumber(n))
            System.out.println("Prime Number");
        else
            System.out.println("Not Prime Number");
    }
}
```

- **What changed:** `i <= n/2` became `i <= n / i`.
- **Why:** `i <= n / i` means the same as "`i × i` is not more than `n`". It avoids a very large multiplication. For `n = 97`, the original tests `i` from 2 to 48. The improved version tests only 2 to 9.
- **Output:** still `Prime Number`.

**Additional Example:** finding a divisor with `%`

```java
public class DivisorExample {
    public static void main(String[] args) {
        System.out.println(10 % 2);
        System.out.println(10 % 3);
    }
}
```

Output:

```text
0
1
```

`2` divides `10` exactly. `3` does not.

[Back to Table of Contents](#table-of-contents)

---

### Program 2: Reverse a Number

**Aim:** To reverse the digits of an integer. The program reverses `12345` to get `54321`.

**Concept Used:**

- Static method with parameter and `int` return value
- `while` loop
- Digit extraction using `% 10`
- Digit removal using `/ 10`
- Operators `!=`, `%`, `*`, `+`, `/=`
- String concatenation

**Original Program:** `Program2.java`

```java
package pec.sem_5.day3;

public class Program2 {
    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Reversed Number: " + reverse(num));
    }
}
```

**Explanation:**

| Code | What it does and why |
|---|---|
| `public static int reverse(int n)` | Takes an integer and returns an integer, which is the reversed number. |
| `int rev = 0;` | `rev` will store the reversed number. It starts at `0` because nothing is added yet. |
| `while (n != 0)` | `!=` means "not equal to". Repeat while digits remain. |
| `int digit = n % 10;` | The remainder after dividing by 10 is the **last digit**. `12345 % 10` is `5`. |
| `rev = rev * 10 + digit;` | `* 10` shifts the digits of `rev` one place left. `+ digit` puts the new digit at the end. |
| `n /= 10;` | Short form of `n = n / 10`. It removes the last digit. `12345 / 10` is `1234`. |
| `return rev;` | Sends the reversed number back. |
| `int num = 12345;` | The number to reverse. |
| `"Reversed Number: " + reverse(num)` | `+` with a string joins the text and the returned number. |

**The three key lines:**

1. **Take** the last digit: `n % 10`
2. **Add** it to the answer: `rev * 10 + digit`
3. **Remove** it from the number: `n /= 10`

**Step-by-Step Execution:**

1. `main` sets `num = 12345`.
2. Inside `println`, the method `reverse(num)` is called first.
3. The value `12345` is copied into the parameter `n`.
4. `rev` is set to `0`.
5. The loop runs five times, once for each digit.
6. After the fifth round, `n` becomes `0`, so `n != 0` is false.
7. The method returns `54321`.
8. The text and the number are joined and printed.

The variable `num` in `main` is still `12345`. The method changed only its own copy, `n`.

**Dry Run:**

| Iteration | n (before) | `n != 0` | digit | Calculation of rev | rev | n (after) |
|---:|---:|---|---:|---|---:|---:|
| 1 | 12345 | true | 5 | 0 × 10 + 5 | 5 | 1234 |
| 2 | 1234 | true | 4 | 5 × 10 + 4 | 54 | 123 |
| 3 | 123 | true | 3 | 54 × 10 + 3 | 543 | 12 |
| 4 | 12 | true | 2 | 543 × 10 + 2 | 5432 | 1 |
| 5 | 1 | true | 1 | 5432 × 10 + 1 | 54321 | 0 |
| End | 0 | false | none | none | 54321 | 0 |

**Output:**

```text
Reversed Number: 54321
```

**Important Points:**

- `% 10` gets the last digit.
- `/ 10` removes the last digit.
- `digit` is declared inside the loop, so it exists only inside the loop.
- **Trailing zeros disappear.** `reverse(100)` returns `1`, because an `int` does not keep leading zeros such as `001`.
- **Negative numbers work.** `reverse(-123)` returns `-321`.

**Possible Improvement: very large numbers**

The program is correct for `12345`. But an `int` can hold values only up to `2147483647`. If the reversed number is larger, it **overflows** (goes beyond the limit) and gives a wrong value without any error. For example, the original `reverse(1000000009)` returns `410065409`. The expected reverse is `9000000001`.

Corrected version using `long`, which holds much larger numbers:

```java
public class Program2Improved {
    public static long reverse(int n) {
        long rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num = 1000000009;
        System.out.println("Reversed Number: " + reverse(num));
    }
}
```

- **What changed:** the return type and `rev` are now `long`. The test input was also changed to show the fix.
- **Why:** `long` has enough room for the reverse of any `int`.
- **Output of this corrected version:**

```text
Reversed Number: 9000000001
```

**Additional Example:** one round of digit handling

```java
public class DigitExample {
    public static void main(String[] args) {
        int n = 678;
        System.out.println(n % 10);
        System.out.println(n / 10);
    }
}
```

Output:

```text
8
67
```

[Back to Table of Contents](#table-of-contents)

---

### Program 3: Check Emirp Number

**Aim:** To check whether a number is an emirp number. The program tests the number `25`.

An **emirp** ("prime" spelled backwards) is a number that:

1. is prime,
2. gives another prime when its digits are reversed, and
3. is different from its reverse.

Example: `13` is prime, its reverse `31` is prime, and `13` is not equal to `31`. So `13` is an emirp.

**Concept Used:**

- Multiple static methods in one class
- Calling one method from another
- Reusing the logic of Programs 1 and 2
- `if`, `else if`
- `for` and `while` loops
- Operators `==`, `&&`, `%`, `/`, `++`, `/=`, `!=`, `<=`

**Original Program:** `Program3.java`

```java
package pec.sem_5.day3;

public class Program3 {
	
	public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
	
	public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }
	
	public static boolean emirp(int n) {
		int rev=reverse(n);
		
		if (n==rev)
			return false;
		
		else if(isPrime(n)==isPrime(rev)&& isPrime(rev))
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		int n=25;
		if (emirp(n))
			System.out.print("Emirp number");
		else
			System.out.print("Not Emirp number");

	}
	

}
```

**Explanation:**

**Block 1: `isPrime(int n)`**

This is the same logic as Program 1, with a different method name.

- Numbers `1` or less return `false`.
- The loop tests divisors from `2` to `n/2`. `i++` adds 1 each time.
- If `n % i == 0` (remainder is zero), a divisor exists, so it returns `false`.
- Otherwise it returns `true`.

**Block 2: `reverse(int n)`**

This is the same logic as Program 2.

- `n % 10` takes the last digit.
- `rev * 10 + digit` builds the reversed number.
- `n /= 10` removes the last digit.
- `n != 0` keeps the loop running while digits remain.

**Block 3: `emirp(int n)`**

| Code | What it does and why |
|---|---|
| `int rev=reverse(n);` | Stores the reversed number so it can be used again. |
| `if (n==rev) return false;` | A number equal to its reverse (such as `11`) cannot be an emirp. |
| `else if(isPrime(n)==isPrime(rev) && isPrime(rev))` | `==` checks that both prime tests give the same answer. `&&` means "and": both sides must be true. |
| `return true;` | The number is an emirp. |
| `return false;` | Runs when neither condition returned a value. |

**Understanding the difficult condition**

`isPrime(n)==isPrime(rev) && isPrime(rev)`

Java first does `==`, then `&&`.

| `isPrime(n)` | `isPrime(rev)` | Are they equal? | Equal `&& isPrime(rev)` | Emirp? |
|---|---|---|---|---|
| true | true | true | true | Yes |
| true | false | false | false | No |
| false | true | false | false | No |
| false | false | true | false | No |

The result is `true` only when **both** numbers are prime. The extra `&& isPrime(rev)` is needed to reject the last row, where both are `false` and therefore "equal".

**Block 4: `main`**

`n` is `25`. If `emirp(n)` returns `true`, it prints `Emirp number`. Otherwise it prints `Not Emirp number`. `print` does not move to a new line.

**Step-by-Step Execution:**

1. `main` sets `n = 25`.
2. `main` calls `emirp(25)`.
3. `emirp` calls `reverse(25)`, which returns `52`. So `rev = 52`.
4. `25 == 52` is false, so Java moves to the `else if`.
5. `isPrime(25)` returns `false`, because `25 % 5 == 0`.
6. `isPrime(52)` returns `false`, because `52 % 2 == 0`.
7. `false == false` is `true`.
8. Because the left side of `&&` is true, Java checks the right side: `isPrime(52)` again. It returns `false`.
9. `true && false` is `false`.
10. `emirp` reaches the last line and returns `false`.
11. `main` prints `Not Emirp number`.

**Dry Run:**

Part A: `reverse(25)`

| Iteration | n (before) | digit | rev | n (after) |
|---:|---:|---:|---:|---:|
| 1 | 25 | 5 | 5 | 2 |
| 2 | 2 | 2 | 52 | 0 |

Part B: `isPrime(25)` (`n/2 = 12`)

| Iteration | i | `25 % i` | Result |
|---:|---:|---:|---|
| 1 | 2 | 1 | Continue |
| 2 | 3 | 1 | Continue |
| 3 | 4 | 1 | Continue |
| 4 | 5 | 0 | Return `false` |

Part C: `isPrime(52)` (`n/2 = 26`)

| Iteration | i | `52 % i` | Result |
|---:|---:|---:|---|
| 1 | 2 | 0 | Return `false` |

Part D: decision in `emirp(25)`

| Step | Condition checked | Value |
|---:|---|---|
| 1 | `n == rev` (`25 == 52`) | false |
| 2 | `isPrime(25) == isPrime(52)` | `false == false`, so true |
| 3 | `true && isPrime(52)` | `true && false`, so false |
| 4 | Final return | `false` |

Extra trace (not the uploaded input):

| n | rev | `n == rev` | `isPrime(n)` | `isPrime(rev)` | Result |
|---:|---:|---|---|---|---|
| 13 | 31 | false | true | true | Emirp |
| 11 | 11 | true | not checked | not checked | Not emirp |
| 23 | 32 | false | true | false | Not emirp |

**Output:**

```text
Not Emirp number
```

**Important Points:**

- Breaking a problem into small methods makes code easier to read and reuse.
- `&&` uses **short-circuit evaluation**: if the left side is false, Java does not check the right side.
- Method names usually start with a verb, such as `isPrime`. A name such as `isEmirp` would be a clearer choice than `emirp`.
- The first few emirps are `13, 17, 31, 37, 71, 73, 79, 97`.

**Possible Improvement (the original gives correct results):**

The condition can be written in a simpler way, and `isPrime(rev)` does not need to be called twice.

```java
public class Program3Improved {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    public static boolean emirp(int n) {
        int rev = reverse(n);
        if (n == rev)
            return false;
        return isPrime(n) && isPrime(rev);
    }

    public static void main(String[] args) {
        int n = 25;
        if (emirp(n))
            System.out.print("Emirp number");
        else
            System.out.print("Not Emirp number");
    }
}
```

- **What changed:** the `else if` and the two final returns became `return isPrime(n) && isPrime(rev);`.
- **Why:** it says directly "both must be prime". It is shorter and avoids a repeated method call.
- **Output:** still `Not Emirp number`.

**Additional Example:** how `&&` works

```java
public class AndExample {
    public static void main(String[] args) {
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false == false);
    }
}
```

Output:

```text
true
false
true
```

[Back to Table of Contents](#table-of-contents)

---

### Program 4: Reverse an Array

**Aim:** To reverse the order of the elements in an array. The class shows two methods, and `main` uses the in-place method `revArrayFast`.

An **array** stores many values of the same type under one name. Each value has a position called an **index**. Indexes start at `0`.

| Index | 0 | 1 | 2 | 3 | 4 |
|---|---:|---:|---:|---:|---:|
| Value | 10 | 20 | 30 | 40 | 50 |

**Concept Used:**

- One-dimensional integer array
- `arr.length`
- Passing an array to a method
- Returning an array from a method
- `void` method
- `for` loop with two variables
- Swapping using a temporary variable
- Enhanced `for` loop (for-each)
- Operators `-`, `>=`, `<`, `++`, `--`

**Original Program:** `Program4.java`

```java
package pec.sem_5.day3;

public class Program4{
    public static int[] revArray(int[] arr) {
        int[] revarr = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            revarr[j] = arr[i];
        }
        return revarr;
    }
    
    public static void revArrayFast(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        revArrayFast(arr);
        
        for(int i:arr)
        	System.out.println(i);
        
    }
}
```

**Explanation:**

**Block 1: `revArray` (creates a new reversed array)**

| Code | What it does and why |
|---|---|
| `public static int[] revArray(int[] arr)` | Takes an integer array and returns an integer array. |
| `int[] revarr = new int[arr.length];` | `new` creates a new array of the same size. All values start as `0`. |
| `int i = arr.length - 1, j = 0` | `i` starts at the last index of `arr`. `j` starts at the first index of `revarr`. |
| `i >= 0` | `>=` means "greater than or equal to". Continue until index `0` is copied. |
| `i--, j++` | `--` subtracts 1. `++` adds 1. So `i` moves left and `j` moves right. |
| `revarr[j] = arr[i];` | Copies one element into its reversed position. |
| `return revarr;` | Sends the new array back. |

> `main` does **not** call `revArray`. It is available in the class, but it has no effect on the output. This is not an error.

**Block 2: `revArrayFast` (reverses the same array)**

| Code | What it does and why |
|---|---|
| `public static void revArrayFast(int[] arr)` | `void` means nothing is returned. The method changes the array directly. |
| `int i = 0, j = arr.length - 1` | `i` starts at the left end and `j` at the right end. |
| `i < j` | Continue while the left position is before the right position. |
| `i++, j--` | Both positions move towards the middle. |
| `int temp = arr[i];` | Saves the left value so it is not lost. |
| `arr[i] = arr[j];` | Puts the right value on the left. |
| `arr[j] = temp;` | Puts the saved left value on the right. |

Why do we need `temp`? Suppose `a = 10` and `b = 50`. If you write `a = b`, then `a` becomes `50` and the old value `10` is lost. `temp` keeps it safe.

**Block 3: `main`**

| Code | What it does and why |
|---|---|
| `int[] arr = {10, 20, 30, 40, 50};` | Creates an array with five values. |
| `revArrayFast(arr);` | Reverses the array. No variable is needed to receive a result. |
| `for(int i:arr)` | Read as "for each value `i` in `arr`". Here `i` is the **value**, not the index. |
| `System.out.println(i);` | Prints each value on its own line. |

**Why does `main` see the change?** An array variable holds a **reference**, which points to the array in memory. The method receives a copy of that reference. Both references point to the same array.

**Step-by-Step Execution:**

1. `main` creates `arr` as `{10, 20, 30, 40, 50}`.
2. `main` calls `revArrayFast(arr)`.
3. Inside the method, `i = 0` and `j = 4`, because `arr.length - 1` is `4`.
4. Since `0 < 4`, the values at indexes 0 and 4 are swapped.
5. `i` becomes `1` and `j` becomes `3`.
6. Since `1 < 3`, the values at indexes 1 and 3 are swapped.
7. `i` becomes `2` and `j` becomes `2`.
8. `2 < 2` is false, so the loop stops. The middle value `30` stays where it is.
9. The method ends and control returns to `main`.
10. The for-each loop prints all five values in the new order.

**Dry Run:**

Part A: `revArrayFast`

| Iteration | i | j | `i < j` | temp | Action | Array after step |
|---:|---:|---:|---|---:|---|---|
| Start | 0 | 4 | not checked yet | none | none | `[10, 20, 30, 40, 50]` |
| 1 | 0 | 4 | true | 10 | Swap indexes 0 and 4 | `[50, 20, 30, 40, 10]` |
| 2 | 1 | 3 | true | 20 | Swap indexes 1 and 3 | `[50, 40, 30, 20, 10]` |
| End | 2 | 2 | false | none | Stop | `[50, 40, 30, 20, 10]` |

Part B: for-each loop

| Iteration | Value of i | Printed |
|---:|---:|---:|
| 1 | 50 | 50 |
| 2 | 40 | 40 |
| 3 | 30 | 30 |
| 4 | 20 | 20 |
| 5 | 10 | 10 |

Part C: how `revArray` would work if it were called on the original array (the uploaded `main` does not call it)

| Iteration | i | j | `arr[i]` | revarr after step |
|---:|---:|---:|---:|---|
| Start | 4 | 0 | not read yet | `[0, 0, 0, 0, 0]` |
| 1 | 4 | 0 | 50 | `[50, 0, 0, 0, 0]` |
| 2 | 3 | 1 | 40 | `[50, 40, 0, 0, 0]` |
| 3 | 2 | 2 | 30 | `[50, 40, 30, 0, 0]` |
| 4 | 1 | 3 | 20 | `[50, 40, 30, 20, 0]` |
| 5 | 0 | 4 | 10 | `[50, 40, 30, 20, 10]` |
| End | -1 | 5 | not read | Loop stops because `-1 >= 0` is false |

**Output:**

```text
50
40
30
20
10
```

**Important Points:**

- The last index is always `arr.length - 1`.
- `length` is written **without** brackets for arrays.
- Using an index outside `0` to `length - 1` causes `ArrayIndexOutOfBoundsException`.
- `revArrayFast` is called "fast" because it does only `length / 2` swaps and creates no new array. `revArray` copies every element into a second array.
- Both methods still take time that grows in proportion to the array size.
- Calling `revArrayFast(arr)` twice brings back the original order.
- A `for` loop can have two variables of the same type, separated by commas.

**Additional Example:** using `revArray`, which keeps the original array unchanged

This is a separate example, not the uploaded program.

```java
public class RevArrayExample {
    public static int[] revArray(int[] arr) {
        int[] revarr = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            revarr[j] = arr[i];
        }
        return revarr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] result = revArray(arr);

        System.out.println("Original first element: " + arr[0]);
        System.out.println("Reversed first element: " + result[0]);
    }
}
```

Output:

```text
Original first element: 1
Reversed first element: 3
```

[Back to Table of Contents](#table-of-contents)

---

### Program 5: Check Neon Number

**Aim:** To check whether a number is a neon number. The program tests the number `7`.

A **neon number** is a number where the sum of the digits of its square equals the number itself.

Example: `9 × 9 = 81`, and `8 + 1 = 9`. So `9` is a neon number.

**Concept Used:**

- Static method with `boolean` return type
- Declaring two variables in one statement
- `while` loop
- Digit sum using `% 10` and `/ 10`
- Operators `*`, `!=`, `%`, `+=`, `/=`, `==`, `+`
- `if-else`
- `print` and string concatenation

**Original Program:** `Program5.java`

```java
package pec.sem_5.day3;

public class Program5 {
    public static boolean isNeonNumber(int n) {
        int sq = n*n, sum = 0;
        
        while (sq != 0) {
            int digit = sq % 10;
            sum += digit;
            sq /= 10;
        }
        return sum == n;
    }
    public static void main(String[] args) {
		int n=7;
		if(isNeonNumber(n))
			System.out.print(n+" is Neon Number");
		else
			System.out.print(n+" is not Neon Number");
	}
}
```

**Explanation:**

| Code | What it does and why |
|---|---|
| `public static boolean isNeonNumber(int n)` | Takes an integer and returns `true` if it is a neon number. |
| `int sq = n*n, sum = 0;` | `sq` stores the square of `n`. `sum` starts at `0` and will collect the digits. |
| `while (sq != 0)` | Repeat while the square still has digits. |
| `int digit = sq % 10;` | Takes the last digit of `sq`. |
| `sum += digit;` | Short form of `sum = sum + digit`. |
| `sq /= 10;` | Removes the last digit of `sq`. |
| `return sum == n;` | The comparison gives `true` or `false`, and that value is returned directly. |
| `int n=7;` | The number to be tested. |
| `if(isNeonNumber(n))` | Calls the method and checks the answer. |
| `n+" is Neon Number"` | `+` joins the number and the text. |
| `System.out.print(...)` | Prints without moving to a new line. |

**Why compare with `n` and not `sq`?** The loop keeps changing `sq` until it becomes `0`. The parameter `n` is never changed, so it can be used for the final comparison.

**Step-by-Step Execution:**

1. `main` sets `n = 7`.
2. `main` calls `isNeonNumber(7)`.
3. `sq` becomes `7 * 7 = 49`, and `sum` becomes `0`.
4. First round: the digit is `9`, `sum` becomes `9`, and `sq` becomes `4`.
5. Second round: the digit is `4`, `sum` becomes `13`, and `sq` becomes `0`.
6. `0 != 0` is false, so the loop stops.
7. `13 == 7` is false, so the method returns `false`.
8. The `else` part runs and prints `7 is not Neon Number`.

**Dry Run:**

| Iteration | sq (before) | `sq != 0` | digit | sum | sq (after) |
|---:|---:|---|---:|---:|---:|
| Start | 49 | not checked yet | none | 0 | 49 |
| 1 | 49 | true | 9 | 0 + 9 = 9 | 4 |
| 2 | 4 | true | 4 | 9 + 4 = 13 | 0 |
| End | 0 | false | none | 13 | 0 |

Final check: `13 == 7` is `false`.

Extra trace for `n = 9` (not the uploaded input), where `sq = 81`:

| Iteration | sq (before) | digit | sum | sq (after) |
|---:|---:|---:|---:|---:|
| 1 | 81 | 1 | 1 | 8 |
| 2 | 8 | 8 | 9 | 0 |

`9 == 9` is `true`.

**Output:**

```text
7 is not Neon Number
```

**Important Points:**

- `return sum == n;` is shorter than writing `if` with `return true` and `return false`.
- `=` assigns a value. `==` compares two values.
- The only non-negative neon numbers that fit this program's safe range are `0`, `1` and `9`.
- The `if-else` has no braces, so each branch can have only one statement.

**Possible Improvement (the original is correct for `7`):**

1. For `n` larger than `46340`, `n * n` is too big for an `int` and overflows.
2. `print` leaves the cursor on the same line. `println` gives cleaner console output.

```java
public class Program5Improved {
    public static boolean isNeonNumber(int n) {
        long sq = (long) n * n;
        int sum = 0;

        while (sq != 0) {
            int digit = (int) (sq % 10);
            sum += digit;
            sq /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 7;
        if (isNeonNumber(n))
            System.out.println(n + " is Neon Number");
        else
            System.out.println(n + " is not Neon Number");
    }
}
```

- **What changed:** `sq` is now `long`, and `print` became `println`.
- `(long) n * n` converts `n` to `long` **before** multiplying. This conversion is called **casting**.
- `(int) (sq % 10)` converts the single digit back to `int`.
- **Output:** the same text, `7 is not Neon Number`, followed by a new line.

**Additional Example:** adding the digits of a number

```java
public class DigitSumExample {
    public static void main(String[] args) {
        int n = 123, sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println(sum);
    }
}
```

Output:

```text
6
```

[Back to Table of Contents](#table-of-contents)

---

## Final Revision

### Important Java Concepts

| Concept | Simple summary | Programs |
|---|---|---|
| Package | Groups related classes | 1 to 5 |
| Static method | Called without creating an object | 1 to 5 |
| `boolean` method | Answers a yes-or-no question | 1, 3, 5 |
| `int` method | Returns a whole number | 2, 3 |
| `int[]` method | Returns an array | 4 |
| `void` method | Performs a job and returns nothing | 4, and `main` in all |
| `if-else` | Chooses between two paths | 1, 3, 5 |
| `else if` | Checks another condition | 3 |
| `for` loop | Repeats with a counter | 1, 3, 4 |
| `while` loop | Repeats while a condition is true | 2, 3, 5 |
| for-each loop | Visits every value in an array | 4 |
| Digit processing | Uses `% 10` and `/ 10` | 2, 3, 5 |
| Arrays | Many values of one type | 4 |
| Swapping | Exchanges two values using `temp` | 4 |
| Method reuse | One method calls another | 3 |

### Important Syntax

**Method definition and call**

```java
public static int square(int x) {   // x is the parameter
    return x * x;                   // value sent back
}

int result = square(5);             // 5 is the argument
```

**Decision**

```java
if (condition) {
    // runs when condition is true
} else if (otherCondition) {
    // runs when the second condition is true
} else {
    // runs when all conditions are false
}
```

**Loops**

```java
for (int i = 0; i < n; i++) { }                        // counter loop

for (int i = 0, j = n - 1; i < j; i++, j--) { }        // two counters

while (n != 0) { }                                     // condition loop

for (int value : arr) { }                              // for-each loop
```

**Arrays**

```java
int[] a = {10, 20, 30};        // create with values
int[] b = new int[5];          // create with size 5, all zeros
int size = a.length;           // number of elements
int last = a[a.length - 1];    // last element
```

**Printing**

```java
System.out.println("text");    // prints, then new line
System.out.print("text");      // prints, stays on same line
```

**Operators**

| Operator | Meaning | Example | Result |
|---|---|---|---|
| `+` | Add, or join strings | `2 + 3` | `5` |
| `-` | Subtract | `5 - 1` | `4` |
| `*` | Multiply | `7 * 7` | `49` |
| `/` | Divide (integers drop decimals) | `7 / 2` | `3` |
| `%` | Remainder | `7 % 2` | `1` |
| `=` | Assign a value | `n = 5` | `n` holds `5` |
| `==` | Is equal to | `5 == 5` | `true` |
| `!=` | Is not equal to | `5 != 0` | `true` |
| `<` | Less than | `1 < 3` | `true` |
| `<=` | Less than or equal to | `3 <= 3` | `true` |
| `>=` | Greater than or equal to | `-1 >= 0` | `false` |
| `&&` | Logical AND | `true && false` | `false` |
| `++` | Increase by 1 | `i++` | `i` goes up by 1 |
| `--` | Decrease by 1 | `j--` | `j` goes down by 1 |
| `+=` | Add and assign | `sum += 4` | `sum = sum + 4` |
| `/=` | Divide and assign | `n /= 10` | `n = n / 10` |

> The `!` operator (logical NOT) turns `true` into `false`. On its own it is **not used** in these five programs. It appears only as part of `!=`.

### Important Differences

**`/` and `%`**

| `/` | `%` |
|---|---|
| Gives the quotient | Gives the remainder |
| `12345 / 10` is `1234` | `12345 % 10` is `5` |
| Used to remove a digit | Used to get a digit |

**`=` and `==`**

| `=` | `==` |
|---|---|
| Stores a value | Compares two values |
| `rev = 0` | `n == rev` |

**`for` loop and `while` loop**

| `for` | `while` |
|---|---|
| Start, condition and update are in one line | Only the condition is in the header |
| Good when a counter moves in a known pattern | Good when repeating until something happens |
| Programs 1, 3, 4 | Programs 2, 3, 5 |

**Normal `for` loop and for-each loop**

| Normal `for` | for-each |
|---|---|
| Uses an index | Gives each value directly |
| Can move backwards or skip | Goes from first to last |
| Can change array elements using the index | Assigning to the loop variable does not change the array |

**`revArray` and `revArrayFast`**

| Point | `revArray` | `revArrayFast` |
|---|---|---|
| Return type | `int[]` | `void` |
| New array | Yes | No |
| Original array | Unchanged | Changed |
| Loop rounds for 5 elements | 5 | 2 |
| Called in `main` | No | Yes |

**`print` and `println`**

| `print` | `println` |
|---|---|
| No new line after output | New line after output |
| Programs 3 and 5 | Programs 1, 2 and 4 |

**Passing an `int` and passing an array**

| `int` | Array |
|---|---|
| Method gets a copy of the value | Method gets a copy of the reference |
| Changing it does not affect the caller | Changing elements affects the caller's array |
| `reverse(num)` leaves `num` as `12345` | `revArrayFast(arr)` changes `arr` |

**Prime, Emirp and Neon numbers**

| Type | Rule | Example |
|---|---|---|
| Prime | Exactly two divisors | `7` |
| Emirp | Prime, reverse is a different prime | `13` |
| Neon | Digit sum of the square equals the number | `9` |

### Common Mistakes

1. Writing `=` instead of `==` in a condition.
2. Forgetting `n /= 10` in a `while` loop. The loop then never ends (unless `n` is already `0`).
3. Mixing up `%` and `/`.
4. Starting the prime loop at `i = 1`. Every number is divisible by `1`, so every number above 1 would be reported as not prime.
5. Putting `return true` inside the prime loop. The method would decide too early.
6. Forgetting the `n <= 1` check. Then `0` and `1` would be reported as prime.
7. Starting `rev` or `sum` without setting it to `0`. Java will not compile a local variable that is used before it has a value.
8. In the emirp check, forgetting that `isPrime(n) == isPrime(rev)` is also true when **both are false**.
9. Forgetting to reject numbers equal to their reverse, such as `11`, in the emirp check.
10. Using `arr.length` as the last index. The last index is `arr.length - 1`.
11. Swapping without a `temp` variable and losing a value.
12. Looping over the whole array while swapping (for example `i < arr.length`). Every pair is swapped twice, so the array returns to its original order.
13. Thinking `i` in `for(int i:arr)` is an index. It is the element value.
14. Writing `arr.length()` for an array. The correct form is `arr.length`.
15. Using the original number after a loop has already reduced it to `0`. Keep a separate copy when you need it.
16. Writing `javac` and `java` commands without considering the package name.

### Quick Revision Table

| Program number | Program name | Main concept | Important logic | Output for given input |
|---:|---|---|---|---|
| 1 | Check Prime Number | `for` loop, `boolean` method | If `n % i == 0` for any `i` from 2 to `n/2`, it is not prime | `Prime Number` |
| 2 | Reverse a Number | `while` loop, digits | `rev = rev * 10 + n % 10`, then `n /= 10` | `Reversed Number: 54321` |
| 3 | Check Emirp Number | Method reuse, `&&` | `n != rev`, and both are prime | `Not Emirp number` |
| 4 | Reverse an Array | Arrays, swapping | Swap `arr[i]` and `arr[j]` while `i < j` | `50 40 30 20 10` (one per line) |
| 5 | Check Neon Number | Digit sum | Sum of digits of `n * n` equals `n` | `7 is not Neon Number` |

### Practice Questions

Try these before reading the answers.

1. What are the values of `987 % 10` and `987 / 10`?
2. How many times does the loop in `primeNumber` run when `n = 5`? What does the method return?
3. Dry run `reverse(406)`. What is the result?
4. What does `reverse(500)` return, and why?
5. Is `17` an emirp? Give the reason.
6. Is `11` an emirp? Give the reason.
7. Is `1` a neon number? Show the calculation.
8. Is `12` a neon number? Show the calculation.
9. What will `revArrayFast` produce for `{1, 2, 3, 4}`? How many swaps happen?
10. What is the difference between a `void` method and an `int` method?
11. Write a method `isPalindrome(int n)` that returns `true` when a number equals its reverse. Use the `reverse` method.
12. Write a method `countDigits(int n)` for a positive number, using a `while` loop.
13. Write a method `sumArray(int[] arr)` that returns the total of all elements using a for-each loop.

### Answers to Practice Questions

**1.** `987 % 10` is `7`. `987 / 10` is `98`.

**2.** `n/2` is `2`, so the loop runs once, with `i = 2`. `5 % 2` is `1`. The method returns `true`.

**3.** The result is `604`.

| Iteration | n (before) | digit | rev | n (after) |
|---:|---:|---:|---:|---:|
| 1 | 406 | 6 | 6 | 40 |
| 2 | 40 | 0 | 60 | 4 |
| 3 | 4 | 4 | 604 | 0 |

**4.** It returns `5`. The first two digits taken are zeros, so `rev` stays `0`. An integer does not store leading zeros.

**5.** Yes. `17` is prime, its reverse `71` is prime, and the two numbers are different.

**6.** No. Its reverse is also `11`, so the condition `n == rev` returns `false`.

**7.** Yes. `1 × 1 = 1`, and the digit sum is `1`.

**8.** No. `12 × 12 = 144`, and `1 + 4 + 4 = 9`. `9` is not equal to `12`.

**9.** The result is `{4, 3, 2, 1}` with `2` swaps.

**10.** A `void` method returns no value. An `int` method must return a whole number.

**11.**

```java
public class PalindromeAnswer {
    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    public static boolean isPalindrome(int n) {
        return n == reverse(n);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
```

Output: `true`

**12.**

```java
public class CountDigitsAnswer {
    public static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(12345));
    }
}
```

Output: `5`

**13.**

```java
public class SumArrayAnswer {
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(sumArray(arr));
    }
}
```

Output: `60`

[Back to Table of Contents](#table-of-contents)
