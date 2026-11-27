# Arrays

Transcription of the Sem 4 scan, pages 80-91. Spelling and clear syntax are corrected; content and exercise topics follow the scan.

## Array definition and characteristics (page 80)

- An array is a continuous block of memory used to store multiple values.
- It has a fixed size, supplied when the array is created, and is homogeneous: its elements have the declared data type.
- An element is stored or fetched through the array reference and an index. The first index is `0`; the last is `size - 1`.
- The notes show both declaration forms:

Array declaration forms shown:

```java
datatype[] identifier;
datatype identifier[];
```

The array variable is a reference variable: it stores the reference to the array and can hold `null` when it has not been assigned an array.

## Creating and initializing arrays (pages 82-84)

The scan shows creating an array with the `new` operator: `new datatype[size]`. This allocates a fixed number of elements of the specified type, initializes them to their default values, and returns the array reference. Examples use `new int[5]` and `new char[3]`. The reference is stored in an array variable.

An array can also be created and initialized with an initializer list, for example `int[] a = {10, 20, 30};`. The notes also show dynamic initialization: read values using a `Scanner` and store each value at an array index. The `length` property gives the number of elements; the examples use `i < array.length` as the loop condition to visit every index and print every value. The page 82 practice prompt reads three inputs and checks how many are even; it also asks for the even value when one is even, the sum of two values, the product of three values, and `0` where none of the stated cases applies.

The declaration, initializer-list, and dynamic-input forms written in the scan are:

```java
int[] a = {10, 20, 30};
```

The input example imports `Scanner` before the class:

```java
import java.util.Scanner;
```

Then it creates the array and reads into each index:

```java
int[] arr = new int[4];
Scanner sc = new Scanner(System.in);
arr[0] = sc.nextInt();
arr[1] = sc.nextInt();
arr[2] = sc.nextInt();
arr[3] = sc.nextInt();
```

To read three values for the even-number exercise, the notes create a three-element `int` array, create a `Scanner` with `System.in`, and read each input into the array. They count the even inputs and select the output based on whether the count is one, two, three, or zero.

Page 83 describes an array reference variable as a variable that stores the array reference. The `new` expression creates an array of the stated type and size, initializes each element to its default value, and returns the array reference. Examples shown are `new int[5]` and `new char[3]`.

Page 84 shows the `length` property and traversal:

```java
int[] a = {10, 20, 30, 40};
for (int i = 0; i < a.length; i++) {
    System.out.println(a[i]);
}
```

## Array operations and examples from the scan (pages 85-91)

The scan traverses arrays with indexed `for` loops and enhanced `for` loops. The method examples use an array parameter such as `int[] arr`; a method returning an array uses an array return type and returns an array reference.

### Sum, average, largest, and smallest (page 85)

```java
public static int sumArray(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum;
}

public static double avgArray(int[] arr) {
    double avg;
    avg = sumArray(arr) / arr.length;
    return avg;
}

public static int largeArray(int[] arr) {
    int large = 0;
    for (int i = 0; i < arr.length; i++) {
        if (large < arr[i]) {
            large = arr[i];
        }
    }
    return large;
}

public static int smallArray(int[] arr) {
    int small = 9;
    for (int i : arr) {
        if (small > i) {
            small = i;
        }
    }
    return small;
}
```

The average example uses the sum method and divides by `arr.length`. The maximum example compares each element with `large`; the minimum example uses an enhanced `for` loop and compares each value with `small`.

### Reverse traversal, first/last checks, and counting (pages 86-88)

```java
public static void printReverse(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
        System.out.print(arr[i] + " ");
    }
}

public static boolean firstLast6(int[] nums) {
    if (nums[0] == 6 || nums[nums.length - 1] == 6) {
        return true;
    }
    return false;
}

public static int countElements(int[] arr) {
    int count = 0;
    for (int i : arr) {
        count++;
    }
    return count;
}

public static int index(int[] arr, int b) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == b) {
            return i;
        }
    }
    return -1;
}

public static boolean sameFirstLast(int[] arr) {
    if (arr.length >= 1 && arr[0] == arr[arr.length - 1]) {
        return true;
    }
    return false;
}
```

Page 86 also notes that a method returning an array must declare an array return type and return the array. Page 87's `firstLast6` task checks whether the first **or** last value is 6. Page 88 separately checks whether the first and last values are the same. Searching returns the matching index; if no element matches, the method returns `-1`.

The array-return method form in the notes is `datatype[] methodName() { return array; }`.

### Copy, replace, and contains (page 89)

```java
public static void copyArray(int[] a) {
    int b[] = new int[a.length];
    for (int i = 0; i < a.length; i++) {
        b[i] = a[i];
    }
    System.out.println(b);
}

public static void replaceNegative(int[] a) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] < 0) {
            a[i] = 0;
        }
    }
}

public static boolean isContain(int[] a, int b) {
    for (int i = 0; i < a.length; i++) {
        if (a[i] == b) {
            return true;
        }
    }
    return false;
}
```

### Index-based tasks (pages 90-91)

- Page 90 multiplies the values at even indices by 5, then finds the second-smallest value. The second-smallest method keeps `min` and `second` values and updates them as each array element is checked.

The even-index traversal shown on page 90 checks the index and multiplies the element at that index:

```java
for (int i = 0; i < arr.length; i++) {
    if (i % 2 == 0) {
        arr[i] = arr[i] * 5;
    }
}
```

```java
public static int secondSmallestNo(int[] arr) {
    int min = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] < min) {
            second = min;
            min = arr[i];
        } else if (arr[i] < second && arr[i] != min) {
            second = arr[i];
        }
    }
    return second;
}
```

- Page 91 swaps each odd-indexed element with the immediately following even-indexed element, beginning at index 1 and advancing by 2.
- To print the second half in reverse, set `mid = arr.length / 2`, then print from `arr.length - 1` down through `mid`.
- To find the sum of the first half, add elements beginning at index 0 while `i < arr.length / 2`.

```java
for (int i = 1; i < arr.length - 1; i += 2) {
    int temp = arr[i];
    arr[i] = arr[i + 1];
    arr[i + 1] = temp;
}

int mid = arr.length / 2;
System.out.println("Second half in reverse");
for (int i = arr.length - 1; i >= mid; i--) {
    System.out.print(arr[i] + " ");
}

int sum = 0;
for (int i = 0; i < arr.length / 2; i++) {
    sum += arr[i];
}
System.out.println("Sum of first half = " + sum);
```

The page 82 input exercise reads three values and counts how many are even: if one is even, print that value; if two are even, print their sum; if all three are even, print their product; if none is even, print `0`.

Programs already in this folder: [ArrayMaster.java](ArrayMaster.java), [arrayOperation.java](arrayOperation.java), [ArrayOperations.java](ArrayOperations.java), [ArrayOperations_arrayarrayarray.java](ArrayOperations_arrayarrayarray.java), [Frequency.java](Frequency.java), [SecondSmallest.java](SecondSmallest.java) and [sumOfEvenIndices.java](sumOfEvenIndices.java).



