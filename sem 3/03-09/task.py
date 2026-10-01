#print numbers from 1 to 20 using for loop.
print("Numbers from 1 to 20 in for loop")
for i in range(1,21):
    print(i)
print("\n")

#print number from 10 to 1 using while loop
print("Numbers from 10 to 1 in while loop")
i=10
while i>0:
    print(i)
    i-=1
print("\n")

#print the multiplication table of 5 using for loop
print("Multiplication table of 5")
for i in range(1, 11):
    print(f"5 x {i} = {5 * i}")
print("\n")

#print the sum of numbers from 1 to 100 using a loop
print("Sum of numbers from 1 to 100")
sum = 0
for i in range(1, 101):
    sum += i
print(f"The sum of numbers from 1 to 100 is: {sum}")
print("\n")

#print all odd numbers between 1 and 50 using a while loop
print("Odd numbers between 1 and 50")
i = 1
while i < 50:
    print(i)
    i += 2
print("\n")

#print each character of string "python" using a for loop
print("Characters in the string 'python':")
for char in "python":
    print(char)
print("\n")

#print the factorial of a number using a for loop
print("\nFactorial of 5:")
factorial = 1
for i in range(1, 6):
    factorial *= i
print(f"The factorial of 5 is: {factorial}")
print("\n")

#use a nested loop to print a 3x3 grid of'#'
print("3x3 grid of '#'")
for i in range(3):
    for j in range(3):
        print("#", end=" ")
    print()
print()

#use break to stop a loop when the number is divisible by 7.
print("Break example to stop loop when number is divisible by 7:")
for i in range(1, 21):
    if i % 7 == 0:
        print(f"Found a number divisible by 7: {i}")
        break
print("\n")

#use continue to print number from 1 to 10 skip even numbers
print("Continue example to skip even numbers from 1 to 10:")
for i in range(1, 11):
    if i % 2 == 0:
        continue
    print(i)
print("\n")

