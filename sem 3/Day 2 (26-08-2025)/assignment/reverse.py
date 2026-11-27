#wap to reverse the given number

a=int(input("Enter a number: "))
r = 0
while a > 0:
    digit = a % 10
    r = r * 10 + digit
    a //= 10
print("Reversed number:", r)
