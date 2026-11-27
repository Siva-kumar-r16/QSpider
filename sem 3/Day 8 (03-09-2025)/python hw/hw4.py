#4. Write a program to check whether a given character is a vowel or consonant.

c=input("Enter a character: ").lower()
if c in 'aeiou':
    print("Vowel")
elif c in 'bcdfghjklmnpqrstvwxyz':
    print("Consonant")
else:
    print("Invalid input")  