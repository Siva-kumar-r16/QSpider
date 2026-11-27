# Methods and Access

Transcription of the Sem 4 scan, pages 45-59. Spelling and clear Java syntax are corrected; examples and explanations follow the scan.

## Method declaration and return type

A method is a set of instructions used to perform a specific task. The scan gives the form `[modifiers] returnType identifier(formalArguments) { ... return data; }`. A method declaration combines modifiers, return type and method signature. The method block runs from the opening to the closing brace and contains the implementation/statements. A method call uses the method identifier and actual arguments.

Method syntax shown in the notes:

```java
[modifiers] returnType methodName(formalArguments) {
    statements;
    return data;
}
```

For a `void` method, the method performs its task without returning a value. The declaration and call use the method name and any required arguments.

The page 49 `m1` example declares and calls a method inside `Alpha`:

```java
class Alpha {
    public static void m1() {
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        m1();
    }
}
```

Methods are classified by modifier and by arguments. Java modifiers are split into access and non-access modifiers. Access modifiers specify visibility/security: `public`, `protected`, `private`, and the default when no modifier is written. The scan orders visibility as public > protected > default > private, and security in reverse. Non-access modifiers change member behavior; those named include `static`, `final`, `abstract`, `synchronized`, `volatile`, `transient`, `native` and `strictfp`.

Return type specifies the data returned to the call statement; the scan lists primitive, non-primitive and `void` return types. A non-void method returns data after execution and needs a return statement as its last line. A void method does not need a return statement. The return statement transfers control out of the method.

## Formal arguments and method signature

Formal arguments are variables declared in the method declaration. When a method has formal arguments, the call must provide data for them. Data passed to the method is an actual argument. The method signature is the combination of method identifier and formal arguments; it is used to call a method.

The page 50 examples overload `sum` by changing the argument list. The same method name can be used more than once in one class when the formal argument list differs by number, type or order. The scan notes that return type and modifiers may differ, but changing only those does not distinguish the parameter list.

The scan's overload examples distinguish methods by argument count and argument order:

```java
public static void sum(int i) {
    System.out.println("1st method");
}

public static void sum(int i, int j) {
    System.out.println("2nd method");
}

public static void sum(int i, String str) {
    System.out.println("1st method");
}

public static void sum(String str, int i) {
    System.out.println("2nd method");
}
```

## Method binding and overloading

Method binding connects a method call statement with a method definition. The notes list compile-time and run-time binding. Compile-time binding checks the number, type and order of arguments and is also called static binding; method overloading is the example. Overloading means defining multiple methods with the same name in the same class and different formal argument lists. The scan lists differences in argument count, type and order.

## Class members, static/non-static access and constructors

The scan calls properties created inside a class block class members. It lists variables, methods, constructors and initializers. Variables, methods and initializers may be static or non-static; constructors are non-static. A static member is declared with the `static` modifier. A non-static member is declared without it. Constructor form shown: `[access modifier] ClassName()`.

Constructor syntax shown in the notes:

```java
[access modifier] ClassName() {
}
```

Static members can be accessed in the same class directly by member name, by class name, or by object reference; the notes say using an object reference for a static member is not recommended. Across classes in the same package, the scan shows access by class name. Across packages, import the class and then use its class name, or use the fully qualified class name without importing. The import statement loads a class from one package for use in another; syntax is `import fully.qualified.ClassName;`.

Built-in classes provided by the JRE are called built-in classes. Examples in the scan include Java `Object` and `Scanner`; it says some classes/packages such as `java.lang` are automatically imported and can be used directly, while other classes need an import statement.

## Scanner and user input

The `Scanner` class is shown as a built-in class in the `java.util` package. Import it to use it. It provides non-static methods, requests input from the user, converts the input to the desired form and returns data to the program. The notes show importing `Scanner`, creating a Scanner object initialized with `System.in`, and reading input. The scan describes `in` as a static variable in `System` holding the input-memory address.

The Scanner syntax shown in the notes is:

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
sc.nextInt();
```

## Programs in this folder

[Alpha.java](Alpha.java), [Beta.java](Beta.java), [Beta_AcessingMembers2.java](Beta_AcessingMembers2.java), [Gamma.java](Gamma.java), [Demo.java](Demo.java), [Driver.java](Driver.java), [PetDetails.java](PetDetails.java) and [Swap.java](Swap.java).



