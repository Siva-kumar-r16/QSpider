# QSpider Notes

## Date: 25-08-2025

### Topics Covered

1. ID of an Object
2. Normal Copy vs Shallow Copy
3. Nested Lists
4. Shallow Copy with Nested Lists

---

# 1. ID of an Object

## Concept

Python provides the `id()` function to get the unique identity of an object.

The `id()` function returns an integer representing the identity of the object during its lifetime.

## Program

```python
a = 10
print(id(a))
```

## Example Output

```text
140730076166432
```

> The exact number returned by `id()` can vary between executions and systems.

## Key Point

```python
id(variable)
```

is used to check the identity of the object referenced by the variable.

---

# 2. Normal Copy vs Shallow Copy

## Concept

There are two different ways of assigning or copying a list:

### Normal Copy / Reference Assignment

When we write:

```python
b = l
```

both variables refer to the same list object.

Therefore, changing the list through `b` also changes the list seen through `l`.

### Shallow Copy

When we write:

```python
a = l.copy()
```

a new outer list is created.

For a simple list containing normal values, changes made to the copied list do not affect the original list.

## Program

```python
# normal copy
l = [7, 18, 22]

b = l              # normal copy
a = l.copy()       # shallow copy

print(l, b, a)

b[2] = 7           # changes in normal copy

print(l, b, a)
```

## Output

```text
[7, 18, 22] [7, 18, 22] [7, 18, 22]

[7, 18, 7] [7, 18, 7] [7, 18, 22]
```

## Explanation

Initially:

```text
l → [7, 18, 22]
b → [7, 18, 22]
a → [7, 18, 22]
```

`b = l` means `b` refers to the same list as `l`.

Therefore:

```python
b[2] = 7
```

changes the same list, so both `l` and `b` show:

```text
[7, 18, 7]
```

But:

```python
a = l.copy()
```

creates a separate outer list. Therefore `a` remains:

```text
[7, 18, 22]
```

## Important Difference

| Statement | Meaning |
|---|---|
| `b = l` | Both variables refer to the same list |
| `a = l.copy()` | Creates a shallow copy of the list |

---

# 3. Nested Lists

## Concept

A nested list is a list that contains another list as one of its elements.

Example:

```python
l = [1, 2, 17, 8, ['abc', 56]]
```

Here, the last element is another list:

```text
['abc', 56]
```

The nested list can be accessed using multiple indexes.

## Program

```python
# nested list
l = [1, 2, 17, 8, ['abc', 56]]

print(l)

# changing nested list element
l[4][0] = "CSK"
print(l)

# changing nested list datatype
l[4][0] = 5
print(l)
```

## Output

```text
[1, 2, 17, 8, ['abc', 56]]

[1, 2, 17, 8, ['CSK', 56]]

[1, 2, 17, 8, [5, 56]]
```

## Accessing a Nested Element

For:

```python
l = [1, 2, 17, 8, ['abc', 56]]
```

the nested list is at index `4`.

Therefore:

```python
l[4]
```

gives:

```text
['abc', 56]
```

To access `abc`:

```python
l[4][0]
```

To access `56`:

```python
l[4][1]
```

## Changing a Nested Element

```python
l[4][0] = "CSK"
```

changes:

```text
['abc', 56]
```

to:

```text
['CSK', 56]
```

The value can also be changed to another datatype:

```python
l[4][0] = 5
```

Result:

```text
[5, 56]
```

---

# 4. Shallow Copy with Nested Lists

## Concept

A shallow copy creates a new outer list, but nested objects inside the list can still be shared.

This is important when working with nested lists.

## Program

```python
# nested list
l = [1, 2, 17, 8, ['abc', 56]]

print(l)

# changing nested list element
l[4][0] = "CSK"
print(l)

# changing nested list datatype
l[4][0] = 5
print(l)

# shallow copy for list
a = l.copy()

l[4][0] = "KBFC"

print("original, shallow copy")
print(l, a)
```

## Output

```text
[1, 2, 17, 8, ['abc', 56]]

[1, 2, 17, 8, ['CSK', 56]]

[1, 2, 17, 8, [5, 56]]

original, shallow copy

[1, 2, 17, 8, ['KBFC', 56]] [1, 2, 17, 8, ['KBFC', 56]]
```

## Explanation

After:

```python
a = l.copy()
```

the outer list is copied.

However, the nested list is still shared between `l` and `a`.

Therefore:

```python
l[4][0] = "KBFC"
```

also changes the nested list visible through `a`.

Both lists therefore become:

```text
[1, 2, 17, 8, ['KBFC', 56]]
```

## Important Point

A shallow copy does **not** independently copy every nested object.

It creates a new outer list while nested references can remain shared.

---

# Quick Revision

## `id()`

```python
id(variable)
```

Used to obtain the identity of an object.

---

## Normal Copy / Reference Assignment

```python
b = l
```

Both variables refer to the same list.

Changing one changes the other.

---

## Shallow Copy

```python
a = l.copy()
```

Creates a new outer list.

For a simple list, changes to the copied list do not affect the original.

For a nested list, nested objects can still be shared.

---

## Nested List

```python
l = [1, 2, 17, 8, ['abc', 56]]
```

Access the nested list:

```python
l[4]
```

Access the first nested element:

```python
l[4][0]
```

Access the second nested element:

```python
l[4][1]
```

---

# Programs Practiced

| No. | Topic | Program |
|---:|---|---|
| 1 | ID of an Object | `id(a)` |
| 2 | Normal Copy | `b = l` |
| 3 | Shallow Copy | `a = l.copy()` |
| 4 | Nested List | Accessing and modifying `l[4][0]` |
| 5 | Nested List + Shallow Copy | Demonstrating shared nested references |

---

# Important Placement Notes

- `id()` is used to identify an object.
- `b = l` does not create a new list.
- `l.copy()` creates a shallow copy.
- A shallow copy creates a new outer list.
- Nested objects can remain shared in a shallow copy.
- Nested list elements can be accessed using multiple indexes.
- A list can contain values of different datatypes.
