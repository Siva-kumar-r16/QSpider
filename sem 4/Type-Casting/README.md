# Type Casting

Transcription of the Sem 4 scan, pages 44-46.

Type casting is the process of converting one data type to another. The scan divides it into primitive and non-primitive type casting. Primitive type casting converts one primitive data type to another and is divided into widening and narrowing.

- **Widening** converts a smaller data type to a larger one. The examples shown are byte to int, int to double and long to double. The notes say this can be implicit (performed by the compiler) or explicit (performed by the programmer with a cast operator).
- **Narrowing** converts a larger data type to a smaller one. It is performed explicitly by the programmer using a type-cast operator.

The type order drawn in the scan is `byte < short < int < long < float < double`. Moving right is widening; moving left is narrowing. The handwritten examples assign `int i = 10` to `double d`, explicitly cast `byte b = 21` to `float`, and convert `int i = 45` to `byte b = (byte) i`.

The scan states that boolean cannot be converted to another data type and vice versa.

Syntax and examples in the notes:

```java
int i = 10;
double d = i;

int j = 45;
byte b = (byte) j;
```

The handwritten example starts with `int i = 10` and assigns it to `double d`. The narrowing example starts with `int i = 45` and uses `(byte) i` to assign the result to `byte b`. The scan also writes an explicit cast when assigning a `byte` value to a `float`.

The adjacent method notes begin the modifier list: access modifiers `public`, `protected`, `private`; non-access modifiers `static`, `final`, `abstract`, `synchronized`, `volatile`, `transient`, `native` and `strictfp`. Full method notes are in [Methods and Access](../Methods-and-Access/README.md).

Related program: [IntToByte.java](IntToByte.java).



