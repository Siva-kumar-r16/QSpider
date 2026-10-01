# use a nested loop to print a 3x3 grid of #

for i in range(3):
    for j in range(3):
        print("#", end=" ")
    print()
print("\n\n")

# use break to stop a loop when the no is divisible by 7
for i in range(1, 11):
    if i % 7 == 0:
        break
    print(i)
print("\n\n")

#use continue to print no from 1 to 10 but skip even no
for i in range(1, 11):
    if i % 2 == 0:
        continue
    print(i)
print("\n\n")