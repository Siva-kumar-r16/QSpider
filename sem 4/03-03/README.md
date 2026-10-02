# QSpider Notes – 03-03

## Topic Practiced

### Basic Java Output

The program practiced on this day is `Fox.java`.

```java
class Fox{
    public static void main(String[] args){
        System.out.println("Hi guys");
        System.out.print("name : Siva");
        System.out.println();
        System.out.print("hobby : watching crikcet");
        System.out.println("Fav game : Red  dead redemption");
        System.out.println("moto : Outlaws for life");
    }
}
```

## Concepts

### `System.out.println()`

`println()` prints the given text and moves the cursor to the next line.

Example:

```java
System.out.println("Hi guys");
```

### `System.out.print()`

`print()` prints text without automatically moving to the next line.

Example:

```java
System.out.print("name : Siva");
```

### `System.out.println()`

A separate empty `println()` can be used to move to the next line:

```java
System.out.println();
```

## Important Observation

The program demonstrates the difference between `print()` and `println()`.

When two `print()` statements are used one after another, their output continues on the same line unless a newline is added.

---

# Assignment / Homework

1. Write a Java program to print your name, age, department, and college.
2. Print your hobbies on separate lines.
3. Use both `print()` and `println()` in the same program.
4. Write a program that prints five lines of personal information.
5. Explain the difference between `print()` and `println()`.

---

# Quick Revision

```java
System.out.print("Hello");
```

Prints without automatically moving to a new line.

```java
System.out.println("Hello");
```

Prints and moves to the next line.

The `main()` method is the starting point for executing a Java application.
