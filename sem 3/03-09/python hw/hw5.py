#5. Write a simple calculator program using only if-elif-else.

num1 = float(input("Enter first number: "))
num2 = float(input("Enter second number: "))
op = input("Enter operator (+, -, *, /): ")

if op == '+':
    print(f"{num1} + {num2} = {num1 + num2}")
elif op == '-':
    print(f"{num1} - {num2} = {num1 - num2}")
elif op == '*':
    print(f"{num1} * {num2} = {num1 * num2}")   
elif op == '/':
    if num2 != 0:
        print(f"{num1} / {num2} = {num1 / num2}")
    else:
        print("Error: Division by zero")
else:
    print("Invalid operator")