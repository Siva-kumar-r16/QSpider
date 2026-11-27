# Loops and Number Programs

Transcription of the Sem 4 scan, pages 64-79 and loop forms on page 81. Spelling and clear syntax are corrected; examples and tasks are from the scan.

## Loop patterns and number processing

The number exercises repeatedly use integer division and remainder. The last digit is `n % 10`; removing the last digit is `n /= 10`. Reverse a number by repeatedly multiplying the accumulated reverse by 10 and adding the last digit. Count digits by incrementing a counter as the number is divided by 10. Keep the original number if it is needed for comparison after processing.

## Loop forms (page 81)

- **while loop**: test the condition before executing the body; repeat the body and update while the condition is true.
- **do-while loop**: execute the body first, then test the condition, so the body runs at least once. The scan shows the trailing form `} while (condition);`.

Syntax and examples shown on page 81:

```java
while (condition) {
    statements;
    update;
}

do {
    statements;
    update;
} while (condition);
```

The `while` example begins with `i = 10`, prints `i` when `i % 2 == 0`, and decrements `i` while `i > 0`. The `do-while` example starts with `i = 20` and `n = 5`, adds `n` to `i`, decrements `n`, repeats while `n > 0`, then prints `i`.

## Method syntax and number-program examples in the scan (pages 64-79)

The pages write these tasks as methods. The method heading gives the access/modifier, return type, name, and parameter; a method that returns an answer uses `return`, and a `void` method prints its result.

### Range, sum, factors, reverse, and digit count (pages 64-66)

The page 64 examples print a range in reverse order, add the values from `0` through `n`, and print the factors of `n`:

```java
public static void rev(int s, int e) {
    for (int i = s; i >= e; i--) {
        System.out.println(i);
    }
}

public static void sumNNo(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i++) {
        sum += i;
    }
    System.out.println("Sum: " + sum);
}

public static void factors(int n) {
    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            System.out.println(i);
        }
    }
}
```

The reverse-number method repeatedly takes the last digit with `% 10`, appends it to `rev`, and removes that digit with `/= 10`. The palindrome method saves the original value, reverses its digits, then compares the two values. The natural-number sum method accumulates `1` through `n`; digit count increments a counter once per digit while dividing by `10`.

```java
public static int rev(int n) {
    int rev = 0;
    for (; n > 0; n /= 10) {
        rev = (rev * 10) + (n % 10);
    }
    return rev;
}

public static boolean palindrome(int n) {
    int rev = 0;
    int original = n;
    for (; n > 0; n /= 10) {
        rev = (rev * 10) + (n % 10);
    }
    if (original == rev) {
        return true;
    }
    return false;
}

public static int countDigits(int n) {
    int count = 0;
    for (; n > 0; n /= 10) {
        count++;
    }
    return count;
}
```

Page 66 also shows a power method that starts the product at `1` and multiplies by the base for each exponent step; a divisibility check for both 5 and 11; and an alternate digit sum that extracts digits from a number and accumulates alternating positions.

The page 66 power and divisibility syntax is:

```java
public static int pow(int base, int expo) {
    int p = 1;
    for (int i = 1; i <= expo; i++) {
        p *= base;
    }
    return p;
}

public static boolean checkDivisibility5and11(int number) {
    return (number % 5 == 0 && number % 11 == 0) ? true : false;
}
```

The alternate digit-sum notes start from the number, make a reversed copy by extracting digits, then add alternating digits. The prompt and method are on page 66.

### Digit tasks and their method logic (pages 67-71)

- **Largest digit:** repeatedly get `number % 10`, compare it with the current largest digit, and remove the last digit with `number /= 10`.
- **Second-smallest digit:** track the smallest (`s`) and second-smallest (`ss`) digits. When a new digit is smaller than `s`, move `s` into `ss` before replacing `s`; otherwise update `ss` when the digit is between the two.
- **All digits even:** if any extracted digit has `digit % 2 != 0`, return `false`; after all digits pass, return `true`.
- **Count a digit:** compare `n % 10` with the requested digit, increment the count when equal, and divide `n` by 10 on every iteration.
- **Place value of each digit:** begin with `place = 1`; print `(n % 10) * place`, remove the last digit, and multiply `place` by 10 each time. The page also shows a loop version that prints the place-value expression.
- **Factorial:** start `fact` at 1 and multiply it by each integer through `n`.
- **Factors:** test each integer from 1 through `n`; print it when `n % i == 0`. The scan shows both `for`-loop and `while`-loop forms.

The page 68 largest-digit method and second-smallest-digit method are shown in this syntax:

```java
public static int largestDigit(int number) {
    int largest = 0;
    while (number > 0) {
        if (number % 10 > largest) {
            largest = number % 10;
        }
        number = number / 10;
    }
    return largest;
}

public static int secondSmallest(int n) {
    int s = 9, ss = 9;
    for (; n > 0; n /= 10) {
        int d = n % 10;
        if (d < s) {
            ss = s;
            s = d;
        } else if (d < ss && d != s) {
            ss = d;
        }
    }
    return ss;
}
```

The page 69 method for checking whether all digits are even returns false as soon as it finds an odd digit:

```java
public static boolean allEven(int n) {
    while (n > 0) {
        if ((n % 10) % 2 != 0) {
            return false;
        }
        n /= 10;
    }
    return true;
}
```

The page 70 methods count matching digits and print the place value of every digit:

```java
public static int countDigit(int n, int digit) {
    int count = 0;
    while (n > 0) {
        if (n % 10 == digit) {
            count++;
        }
        n /= 10;
    }
    return count;
}

public static void digitValue(int n) {
    int place = 1;
    while (n > 0) {
        int digit = n % 10;
        System.out.println(digit * place);
        n /= 10;
        place *= 10;
    }
}
```

The page 71 factorial and factor examples use these loops:

```java
public static int factorial(int n) {
    int fact = 1;
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }
    return fact;
}

public static void factors(int n) {
    System.out.print("Factors: ");
    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            System.out.print(i);
        }
    }
}
```

### Number properties (pages 72-79)

- **Perfect number:** add the proper divisors (divisors below `n`) and compare the sum with `n`. The scan shows both `for` and `while` implementations. To print perfect numbers in a range, test each value with the perfect-number method and print matching values.
- **Strong number:** for each digit, calculate the digit factorial and add it to a sum; compare the sum with the original number. The scan defines factorial separately and calls it for each extracted digit.
- **Tech number:** require an even digit count, split the number into two equal halves, add the halves, square the sum, and compare with the original. For `2025`, the halves are `20` and `25`; their sum is `45`, and `45 * 45 = 2025`.
- **Neon number:** square `n`, add the digits of the square, and compare that sum with `n`.
- **Armstrong number:** count the digits, raise each digit to that count, add the results, and compare the sum with the original number.
- **Reverse only the second half:** the scan uses digit count, a power-of-10 split, and reversal of the second half. Its example is `123456` becoming `123654`.
- **Strictly increasing digits:** compare neighbouring digits as the number is processed; return false when the required increase fails and true when all adjacent digits pass.
- **Kaprekar number:** the square can be split into two parts whose sum is the original number. The example is `45² = 2025`, with `20 + 25 = 45`.
- Other written prompts: print the first `n` Fibonacci numbers; check a Buzz number (the note says a number ending in 7 or divisible by 7); sum even and odd digits separately; and reverse only the second half of a number.

The page 72 perfect-number method adds divisors below `n` and returns whether their sum equals `n`. Page 74 calls this method for every value in the requested range and prints the matching values. The strong-number example defines a factorial method, uses it for each extracted digit, adds those factorials, and compares the result with the input.

The perfect-number and range syntax shown on pages 72 and 74 is:

```java
public static boolean perfectNumber(int n) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum == n;
}

public static void printPerfect(int start, int end) {
    for (int i = start; i <= end; i++) {
        if (isPerfect(i)) {
            System.out.println(i);
        }
    }
}
```

On page 74, the range example uses a method named `isPerfect` with the same divisor-sum check:

```java
public static boolean isPerfect(int n) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum == n;
}
```

The page 74 strong-number methods use the digit factorial and add each digit's factorial:

```java
public static int factorial(int n) {
    int fact = 1;
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }
    return fact;
}

public static boolean isStrong(int n) {
    int sum = 0, temp = n;
    while (temp > 0) {
        int d = temp % 10;
        sum += factorial(d);
        temp /= 10;
    }
    return sum == n;
}
```

The page 75 Tech-number example splits the even-length number into two halves. Page 76 includes these two methods:

```java
public static boolean isNeon(int n) {
    int square = n * n;
    int sum = 0;
    while (square > 0) {
        sum += square % 10;
        square /= 10;
    }
    return sum == n;
}

public static boolean isTech(int num) {
    int digitCount = getDigitCount(num);
    if (digitCount % 2 != 0) {
        return false;
    }
    int half = digitCount / 2;
    int firstHalf = num / pow(10, half);
    int secondHalf = num % pow(10, half);
    int sum = firstHalf + secondHalf;
    return (sum * sum == num);
}
```

The page 77 Armstrong-number method counts the digits, raises each digit to the digit count, adds the powers, and compares the sum with the original number. Page 78's second-half reversal method splits the number using the digit count, reverses the second half, and combines it again with the first half. Its example is `123456` to `123654`:

```java
public static int rev2ndHalf(int n) {
    int digitCount = getDigitCount(n);
    int firstHalf = n / pow(10, digitCount / 2);
    int secHalf = n % pow(10, digitCount / 2);
    int rev = rev(secHalf);
    int res = (firstHalf * pow(10, digitCount / 2)) + rev;
    return res;
}
```

The same page compares adjacent digits for the strictly-increasing-digits check.

The scan includes tracing tables for digit extraction, place values, and the second-smallest digit. Pages 68-70 trace values while the last digit is removed; page 73 starts the even/odd digit sum method; pages 74-77 show the perfect, strong, Tech, Neon, and Armstrong methods; page 78 shows second-half reversal and strictly increasing digits; page 79 gives the Kaprekar example and the Fibonacci/reversal prompts.

Programs in this folder: [AllDigitsEven.java](AllDigitsEven.java), [AlternateSumInDigit.java](AlternateSumInDigit.java), [DigitAppear.java](DigitAppear.java), [EvenNumbers.java](EvenNumbers.java), [LargestDigit.java](LargestDigit.java), [NumberProperties.java](NumberProperties.java), [NumberPrograms.java](NumberPrograms.java), [Pateern2.java](Pateern2.java), [Pattern1.java](Pattern1.java), [Pattern3.java](Pattern3.java), [Pattern4.java](Pattern4.java), [Pattern5.java](Pattern5.java), [SecondSmallestDigit.java](SecondSmallestDigit.java) and [StrongNumber.java](StrongNumber.java).




