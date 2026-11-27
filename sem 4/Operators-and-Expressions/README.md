# Operators and Expressions

Transcription of the Sem 4 scan, pages 20-44 (including the assignment examples on pages 40-42). Spelling and clear Java syntax are corrected; explanations and examples follow the scan.

## Operator and operand

An operator is a predefined symbol used to perform an operation on operands. Operands are the data/variables on which the operator performs its task. The scan says an operator returns data after the task, and the result can be stored in a variable or used in a printing statement. Operators have precedence and associativity.

Associativity is shown as left-to-right or right-to-left. Examples in the notes: `10 + 20 + 30` groups left-to-right; assignments such as `a = b = c = 10` group right-to-left. Parentheses are used to make expression grouping explicit.

The operand-based groups named on page 23 are unary, binary and ternary operators. The task-based groups are arithmetic, relational, logical, conditional, assignment, increment/decrement, compound assignment, bitwise and type-cast operators.

## Assignment and arithmetic

Assignment `=` assigns data to a variable and is binary. The notes say the assignment expression returns the data assigned. Example: `a = 10`; `a = b`; or `a = 10 / 5`.

Arithmetic operators shown are `+`, `-`, `*`, `/` and `%`. They are binary. In Java, `+` has two uses: addition when both operands are numeric/character values, and concatenation when an operand is a string. Division examples in the scan: `10 / 2` gives 5, `5 / 2` gives 2, `2 / 5` gives 0 and `'a' / 'a'` gives 1. Modulus examples: `10 % 2` gives 0, `5 % 2` gives 1, `2 % 5` gives 2 and `'a' % 97` gives 0.

The precedence examples show parentheses first, then `*`, `/`, `%`, then `+` and `-`. The notes evaluate `10 + 20 - (40 * 1) + (7 / 2) + (5 % 2)` as `30 - 40 + 3 + 1 = -6`.

The page 26 relational examples include `10.0 == 10.0` (`true`), `10 != 10` (`false`), `10 == 20` (`false`), `'a' != 'b'` (`true`), `'a' == 97` (`true`), `true != false` (`true`), and equality comparison of string literals. The page 27 concatenation trace is evaluated left-to-right: `(10 + 20) * 2 + "Hello" + 'a' + 25 / 5 + 'a'` produces `60Hello5a`. The other trace applies `-` after a string has been produced and marks the expression as a compile-time error.

## Relational and logical operators

Relational operators compare data. The notes classify them as binary operators, and each returns a boolean value: `==` equality, `!=` inequality, `<` less than, `<=` less than or equal, `>` greater than, and `>=` greater than or equal. Examples compare numeric values, characters, booleans with `==`/`!=`, and strings with `==`/`!=`; comparisons the notes mark incompatible, such as ordering booleans or strings, are compile-time errors.

Logical operators combine conditions and return boolean data. The scan lists AND `&&`, OR `||` and NOT `!`; logical operators work with boolean data.

- AND (`&&`) is true only when both conditions are true. If the first condition is false, the second condition is not evaluated (short-circuit behavior).
- OR (`||`) is true when at least one condition is true. If the first condition is true, the second condition is not evaluated (short-circuit behavior).
- NOT negates a boolean: `!true` is false and `!false` is true.

Truth values shown in the notes:

| First condition | Second condition | `&&` | `||` |
| --- | --- | --- | --- |
| `true` | `true` | `true` | `true` |
| `true` | `false` | `false` | `true` |
| `false` | `true` | `false` | `true` |
| `false` | `false` | `false` | `false` |

## Increment and decrement

`++` is a unary operator that increments a variable by one; the scan says it is used with a variable name and avoids repeated code. Prefix form `++a` updates first and returns the updated value. Postfix form `a++` returns the old value and then updates it. Decrement `--` reduces by one and follows the same prefix/postfix distinction. Pages 32-33 trace expressions using `a++`, `++a`, `b--`, `--b` and arithmetic precedence.

The page 30 examples show the difference in the value used by the next expression:

```java
int a = 10;
int b = ++a;

int c = 10;
int d = c++;
```

With prefix increment, `a` and `b` are 11; with postfix increment, `d` is 10 and `c` becomes 11.

The decrement operator follows the same prefix/postfix behavior: `--a` updates before its value is used, while `a--` returns the existing value before decrementing.

## Conditional (ternary) operator

The conditional operator makes a decision and is a ternary operator. Syntax shown: `condition ? value2 : value3`. The first operand is the condition; the second and third are values/variables/expressions. Examples choose `"Hi"` or `"Hello"` based on comparisons. The resulting type depends on the second and third operands. The notes also show character tests for lowercase (`'a'` through `'z'`), uppercase (`'A'` through `'Z'`) and digits (`'0'` through `'9'`).

## Bitwise operators and shifts

Bitwise operators perform operations on binary bits. The scan names `&` AND, `|` OR, `^` XOR and `~` complement, followed by shifts `<<`, `>>` and `>>>`. The notes list `int`, `char`, and `boolean` for AND, OR, and XOR; `int` and `char` for complement and shift operations; and state that bitwise results are `int` or `long`. The AND truth table has result `1` only for `1 & 1`; all other input pairs produce `0`. The XOR table has result `1` when the bits differ and `0` when they are the same. Examples shown include `10 & 15 = 10`, `5 & 12 = 4`, `5 & 5 = 5`, `10 | 5 = 15`, `5 ^ 7 = 2`, `5 ^ 0 = 5`, `5 ^ 5 = 0`, `~5 = -6`, and `~(-5) = 4`.

| Bit 1 | Bit 2 | `&` | `^` |
| --- | --- | --- | --- |
| `0` | `0` | `0` | `0` |
| `0` | `1` | `0` | `1` |
| `1` | `0` | `0` | `1` |
| `1` | `1` | `1` | `0` |

- Left shift `x << y` moves bits left by `y` positions; the notes give the rule `x × 2^y`, with `4 << 1 = 8` and `8 << 2 = 32`.
- Signed right shift `x >> y` moves bits right; the notes give `x / 2^y`, with `8 >> 1 = 4`.
- Unsigned right shift `>>>` shifts right and fills the leftmost vacancies with zeros regardless of the original sign. The scan traces `30 >>> 2` and `-12 >>> 3`.

The bitwise precedence sketch orders complement, shifts, AND, XOR and OR from higher to lower in the bitwise group. Page 42 traces `a = 10`, `b = 6`, `c = 3`, `a & b | c` (result 3), and `(a & b) & (b << 1)` (result 12).

## Compound assignment

Compound assignments are binary operators used to avoid repeated code:

| Form | Meaning shown in scan |
| --- | --- |
| `op1 += op2` | `op1 = op1 + op2` |
| `op1 -= op2` | `op1 = op1 - op2` |
| `op1 *= op2` | `op1 = op1 * op2` |
| `op1 /= op2` | `op1 = op1 / op2` |
| `op1 %= op2` | `op1 = op1 % op2` |

The transaction example begins with balance 5000 and applies transfer 500, credit 700, debit 1000 and recharge 750. Assignment practice examples on pages 40-41 start with score 50 and apply +40, -15, +30 and -10 for a final score of 95; and start with 120 books and apply +30, -25, +10 and -5 for a final count of 130.

## Programs in this folder

[BankAccountOperations.java](BankAccountOperations.java), [CalculateArea.java](CalculateArea.java), [CalculateTotalAndAverageMarks.java](CalculateTotalAndAverageMarks.java), [Calculator.java](Calculator.java), [CalculatorMenu.java](CalculatorMenu.java), [CheckInRange.java](CheckInRange.java), [FinalScore.java](FinalScore.java), [IntMax.java](IntMax.java), [LibraryBooks.java](LibraryBooks.java), [ScannerOperstion.java](ScannerOperstion.java), [StudentPass.java](StudentPass.java) and [VotingEligibilityVoting.java](VotingEligibilityVoting.java).



