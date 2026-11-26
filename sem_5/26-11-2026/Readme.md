# Q-Spider

## Java

26/11/26

## Object Oriented Fundementals

### Object

- It is a block of memory which can have collection of variables & methods in it.
- Every object will have reference (address)
- Object is a real world entity that has its own state & behaviour.

### Why do we need object

- Used to represent a real world object entity

### Step to create an object & purpose of object

**(S1)** To create an object blue print of the object is necessary.

**(S2)** If blue print exist we can create object, if blue print does not exist then design blueprint & create object.

### Blue Print

- The specification of the object present inside the blue print.
- Specification of object contains number of variables, type of variables, how many methods will be there etc.

### How to create a blueprint in Java

- In Java we can create blue print using class

### Class

- Component in Java
- Java class is a definition block used to define the state & behaviour of an object
- A class contain members, members are classified into 2 types
  - data member (variable)
  - member function.

### Object Creation Steps

1. Create a class or use existing class.
2. Create an object ~~or c~~ for the class by using new operator, constructor

**Syntax :-**

```text
   new className ();
    |       |
    |       +----------> constructor
    v
 operator
```

### new Keyword

- It is unary operator.
- Creates block of memory inside the heap area during execution of Java program.
- Run time memory allocation.
- new operator returns reference (address) of an object.

**eg:-**

```java
package pec.sem_5.day4;

public class Program1 {
	
	int age;
	String name;
	
	void study() {
		System.out.println("Studing");
	}
	
	public static void main(String[] args) {
		Program1 s1 = new Program1();
		System.out.println(s1);
	}

}
```

### Reference Variable / Non-Primitive Variable

- A variable that is declared using non-primitive datatype is called as non-primitive variable.
- Generally reference variable is declard using class name, inerface name, e-num name
- Reference variable will contain either address of an object or null value

**eg**

```java
package pec.sem_5.day4;

public class Program2 {
	
	int age;
	String name;
	
	void study() {
		System.out.println("Studing");
	}
	
	public static void main(String[] args) {
		Program2 s1 = new Program2();
		Program2 s2 = new Program2();

		System.out.println(s1.age);
		System.out.println(s1.name);
		System.out.println(s1==s2);//false
	}

}
```

### Non Static Variable.

The variable which is declared without using static keyword is known as non-static variable.

#### Characteristics

- Memory is allocated inside the object
- We cannot use non static variable without object of the class
- Non-static variable will be allocated in every object once.
- We can use non-static variable only with help of object reference.
- Non static variable are initiallised with default values.

### Constructor

- It is special non-static member of class which is used to load & inistialise object
- Constructor will always have same name as the class name
- Every class in Java will have a constructor either it can be created by programmer or compiler
- Constructor will get executed during object creation.
- Constructor are classified into 2 type
  1. Default Constructor
  2. User defined constructor.
