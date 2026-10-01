#9. Write a grade calculator program using if-elif-else.

marks=float(input("Enter your marks: "))
if marks>=90:
    print("Grade A")
elif marks>=80:
    print("Grade B")
elif marks>=70:
    print("Grade C")
elif marks>=60:
    print("Grade D")
elif marks>=50:
    print("Grade E")
else:
    print("Grade F")