# Decision Making

Transcription of the Sem 4 scan, pages 59-63.

Decision-making statements decide whether a set of statements is executed or skipped. The scan lists four forms: `if`, `if-else`, `else-if` ladder and `switch`.

## `if`

`if` is a keyword used for decision-making. The condition returns a boolean value. If true, the statement/block executes; if false, it is skipped. Syntax shown: `if (condition) { statements; }`. The notes say braces are optional for a single statement. The page 59 voting example checks an age against 18 and prints eligibility, then prints that the main program ended; the output illustrates that execution continues after the if block.

```java
if (condition) {
    statements;
}
```

The page 59 example's condition is `age >= 18`; it prints voting eligibility in the `if` block and then prints the main-program-ended message after the block.

## `if-else`

`else` represents the false block and cannot be used without an `if` block. It executes when the `if` condition is false. The flow chart shows the true and false paths joining after their respective statement blocks. The example prints “Eligible to vote” when age is at least 18; otherwise it prints the number of years to wait.

```java
if (condition) {
    statements;
} else {
    statements;
}
```

## `else-if` ladder

The ladder verifies multiple conditions in order. The flow chart tests condition 1, then condition 2 and subsequent conditions; the matching statement executes, and if none is true the final else block runs. The syntax shown is an `if` followed by one or more `else if` clauses and an optional `else`.

```java
if (condition1) {
    statements;
} else if (condition2) {
    statements;
} else {
    statements;
}
```

## `switch`

The scan gives the structure `switch (expression) { case value1: statements; break; ... case valueN: statements; break; default: statements; }`. Its example begins with `switch (100)` and `case 0`. The handwritten scan does not include a complete worked output for that example.

```java
switch (expression) {
    case value1:
        statements;
        break;
    case valueN:
        statements;
        break;
    default:
        statements;
}
```

The page 62 practice prompt asks for a program to check whether a character is a vowel, consonant or number; the page begins a Scanner-based solution. The programs in this folder include [CheckCharacter.java](CheckCharacter.java), [CheckNumber.java](CheckNumber.java), [CheckUppercase.java](CheckUppercase.java), [DecisionPrograms.java](DecisionPrograms.java), [EvenOdd.java](EvenOdd.java), [LargeNumber.java](LargeNumber.java), [LoginAccess.java](LoginAccess.java), [NumberCheck.java](NumberCheck.java), [SpecialDiscount.java](SpecialDiscount.java), [StudentPassFail.java](StudentPassFail.java) and [ValidLogin.java](ValidLogin.java).




