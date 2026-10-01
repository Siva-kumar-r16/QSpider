# check given no is prime or not

n=int(input("Enter a number: "))
d=int(n**0.5)
for i in range(2,d+1):
    if n % i == 0:
        print(f"{n} is not a prime number.")
        break

else:
    print(f"{n} is a prime number.")

#print the sum of numbers from 1 to 100 using a loop
s=0
for i in range(1, 101):
    s += i
print(f"The sum of numbers from 1 to 100 is: {s}")


