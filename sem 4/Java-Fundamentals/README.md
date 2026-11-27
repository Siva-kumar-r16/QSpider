# Java Fundamentals

### Language and programming-language levels (pages 1-2)

- A language is a medium to communicate, pass instructions, and share knowledge.
- A programming language is a medium to communicate or interact with computers.
- Programming languages are classified into three levels:
  1. **Machine-level language:** a low-level language written in binary (`0` and `1`).
  2. **Assembly-level language:** an intermediate-level language in which instructions are written using mnemonics. The machine understands binary, so an assembler converts assembly instructions to machine-level language. When assembly language is used, an assembler is required.
  3. **High-level language:** instructions are written in English, which is common and easy for people to understand. It is classified as object-oriented or procedure-oriented. A translator is needed to convert it to machine-level language.
- Translators listed in the notes:
  - **Assembler:** assembly language to machine code.
  - **Compiler:** high-level language to bytecode or machine code.
  - **Interpreter:** bytecode to machine code.
  - **Transpiler:** one high-level language to another high-level language.
  - **Decompiler:** machine-level language to high-level language.
- Java is a high-level, object-oriented programming language used to communicate, pass instructions, and share knowledge. It uses both a compiler and an interpreter for translation, so the notes call Java a compiled and interpreted programming language.

### Features of Java (page 3)

1. **Simple:** syntax is easy to learn; complex features such as pointers and operator overloading are removed.
2. **Object-oriented:** the notes describe Java as purely object-oriented and list classes, encapsulation, inheritance, polymorphism, and abstraction.
3. **Platform-independent:** code is first converted to bytecode, which does not depend on an operating system. Bytecode can be executed on a platform with the help of the JVM.
4. **Secure:** Java exception handling helps developers handle exceptions that can occur during program execution.
5. **Scalability:** Java can handle small-to-large-scale applications and provides features such as multithreading.
6. **Multithreaded:** multiple threads can run at the same time, improving CPU utilization and application performance.
7. **High performance:** JIT compilation improves application performance.

### Structure of a Java source file (page 4)

- Java instructions are written in a file with the `.java` extension, for example `Name.java`.
- The notes list three components that can be created in a Java file: class, interface, and enum.
- `class` is the keyword used to create a class block. The form shown is `class ClassName { ... }`.
- A class name starts with a capital letter. Any name may be given to a class, and multiple classes may be written in one Java file.
- The note says the file name should be the same as the class name (for a public class, Java requires the public class name and file name to match).

```java
class ClassName {
}
```

### Compiler and interpreter (page 5)

- A **compiler** translates the entire source code at once and returns a `.class` file for execution. It checks syntax and semantics during compilation and reports errors after compilation. If there is no problem, it generates the class file; a compiler error is called a compile-time error.
- An **interpreter** reads and executes bytecode line by line. It does not produce a separate executable file. It executes line by line and stops and reports an error immediately when it encounters a problem.

### Compiling and executing a program (pages 6-8)

1. Create a source file with the `.java` extension.
2. Compile it with `javac FileName.java`. The notes' example is `javac Demo.java`, which generates `Demo.class`. The compiler checks syntax and semantics; if they are correct it generates the class file, otherwise it reports a compile-time error.
3. Execute the class using the JVM with `java ClassName`.

The command example in the scan is:

```text
javac Demo.java
java Demo
```

During execution, the `.class` file is given to the JVM. The specified class is loaded into main memory by the class loader, and memory is allocated to Java components. A program may have multiple classes; the notes say each class is executed separately. After memory is allocated, the interpreter executes bytecode line by line by converting it to machine code. A problem during execution produces a run-time exception. The notes say the run-time exception shows the line, reason, and type of the problem.

The page 8 diagram shows the Java source going to the Java compiler: if there is a problem, a compile-time error is reported; if there is no problem, bytecode is produced in the `.class` file, which is passed to interpretation; an execution problem produces a run-time error, otherwise there is output.

## Java environment and JVM

- **JDK (Java Development Kit)** contains development tools, including the compiler, and includes the JRE.
- **JRE (Java Runtime Environment)** contains core libraries used by Java programs and contains the JVM.
- **JVM (Java Virtual Machine)** executes Java programs and is called the heart of a Java program in the notes.

The JVM is shown with three components: class loader, memory spaces and execution engine. The class loader loads a class during execution into primary memory (RAM). The scan lists five memory spaces: method area/code segment, stack area, heap area, PC-register area and native-stack area. The execution engine is responsible for execution and contains the interpreter, JIT (Just-in-Time) and GC (garbage collector). The interpreter executes bytecode line by line; JIT handles frequently used bytecode and improves performance; garbage collection manages memory and automatically removes unused memory during execution.

The page 9 diagram groups the JVM as `class loader`, `memory spaces`, and `execution engine`. The memory spaces listed are method area/code segment, stack area, heap area, PC-register area, and native-stack area. The execution engine components are interpreter, JIT, and garbage collector.

## First Java program, main method and output

The source must contain a `main` method. When Java is run, the JVM searches for it; if found, execution starts there, and if not found the JVM reports a main-method-not-found error. The notes call `main` the starting and ending point of a program and give this form:

```java
public static void main(String[] args) {
}
```

The notes say `public`, `static` and `void` are lowercase keywords; `main` is the method name and `String[] args` is the parameter.

Printing statements display data/content in the output panel:

- `System.out.println(data)` prints data and shifts the cursor to the next line. The notes say the data may be omitted, in which case it still moves to the next line.
- `System.out.print(data)` prints data without shifting the cursor; data is required.

The personal-details example on page 13 prints the name, department, and college:

```java
System.out.println("Siva Kumar");
System.out.println("CSE department");
System.out.println("Panimalar Engineering College");
```

`println` moves the cursor to the next line after printing; `print` leaves it on the same line. The scan notes that `println` can be used without data to move to the next line, while `print` requires data.

## Tokens, keywords, identifiers and literals

Tokens are the smallest units of a programming language. The scan lists six Java token types: keywords, identifiers, literals, operators, separators and comments.

- **Keywords** are reserved words, written in lowercase, each with a task. The notes count 68 Java keywords: 48 classified and 20 conceptual.
- **Comments** describe code and are ignored by the compiler. Single-line comments use `//`; multiline comments use `/* ... */`.
- **Separators** are symbols that define code structure/organization and help the compiler distinguish code elements and logical blocks. Examples shown: `()`, `{}`, `;`.
- **Operators** are special symbols used to perform tasks on operands; an operation takes given data and returns a result. See [Operators and Expressions](../Operators-and-Expressions/README.md).
- **Identifiers** are names given by the programmer to Java components. A keyword cannot be used; an identifier cannot start with a number; the notes specify that only underscore and dollar sign may be used as special characters.
- **Literals** are data written directly in the program. The scan lists number, character, boolean, string and comments literals. Number literals are integer (examples 20, 50, 7) and decimal (7.7, 8.5, 10.0). A character literal is a single value in single quotes. Boolean literals are `true` and `false`. A string literal is a group of characters in double quotes, e.g. `"Apple"`, `"Alpha"`, `"India"`.

```java
// single-line comment
/* multi-line
   comment */
```

Literal examples written in the scan are integer literals `20`, `50`, and `7`; decimal literals `7.7`, `8.5`, and `10.0`; character values in single quotes; boolean values `true` and `false`; and string values such as `"Apple"`, `"Alpha"`, and `"India"`.

## Naming conventions

These are described as coding culture rather than mandatory rules:

- Class names start with a capital letter; each word starts with a capital letter.
- Method names start with a lowercase letter; later words start with capitals.
- Variable names use lower camel case: start lowercase, capitalize the first letter of each later word (example: `userScore`). Choose a descriptive, meaningful noun.
- Package names use lowercase letters to avoid class-name conflicts; the scan recommends reverse-domain structure for global uniqueness and dots between project layers/modules.

## Data, variables, defaults and scope

The notes distinguish primitive data and non-primitive data. A variable is a block of memory used to store data. Primitive variables store primitive data; non-primitive variables store reference data. Primitive-variable syntax is `primitiveDatatype identifier`; non-primitive-variable syntax is `nonPrimitiveDatatype identifier`. The scan shows a reference variable holding an object reference or `null`, and identifies `null` as a reserved literal.

Variable characteristics in the scan: one variable stores one data value; data is stored/fetched using its name; its value can be reassigned/updated; stored data is temporary; every variable has scope. Variables are grouped by data type (primitive/non-primitive) and scope (local, static and non-static).

A local variable is created in a method or other block (except a class block). It can be used only in the block where it is created and cannot be used before it has been assigned. The same local name cannot be declared more than once in the same scope.

The primitive type table transcribed from page 16:

| Type | Capacity in scan | Range/value in scan | Default shown |
| --- | --- | --- | --- |
| `byte` | 1 byte | -128 to 127 | 0 |
| `short` | 2 bytes | -32,768 to 32,767 | 0 |
| `int` | 4 bytes | -2,147,483,648 to 2,147,483,647 | 0 |
| `long` | 8 bytes | -2^63 to 2^63 - 1 | 0L |
| `float` | 4 bytes | approximately ±3.4 × 10^38 | 0.0f |
| `double` | 8 bytes | approximately ±1.7 × 10^308 | 0.0d |
| `char` | 2 bytes | 0 to 65,535 (Unicode) | `\\u0000` |
| `boolean` | shown as 1 bit | `true` or `false` | `false` |

The scan describes `byte` as useful for saving memory for small numbers, `short` as larger than byte and smaller than int, `int` as commonly used for integers, `long` for very large integers, `float` for single-precision decimal numbers, `double` as the default decimal-number type, `char` for one Unicode character, and `boolean` for conditions such as `if` and `while`.

The page 17 examples show default field values such as `int` as `0`, `double` as `0.0`, `float` as `0.0f`, and `char` as `\u0000`. Page 18 distinguishes primitive values from non-primitive references: a reference variable can contain an object reference or `null`.

## Related programs

[abc_basic.java](abc_basic.java), [Abc.java](Abc.java), [biodata.java](biodata.java) and [Fox.java](Fox.java) are directly in this folder.




