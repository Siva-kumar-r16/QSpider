#wap to find the sum of individual digits of a number.

a=int(input("Enter a number: "))
sum = 0
while a > 0:
    d = a % 10
    sum += d
    a //= 10
print("Sum of digits:", sum)
