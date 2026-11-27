#check wheather the input number can be written in the foorm of 2^x

n=int(input("Enter a number: "))

while n % 2 == 0:
    n //= 2
print(n == 1,"for 2^x")