#To print the reversed string only if it is starting with vowel , ending with consonant and having a middle value

a=input("Enter a string: ")
if a[0].lower() in ['a', 'e', 'i', 'o', 'u'] and a[-1].lower() not in ['a', 'e', 'i', 'o', 'u'] and len(a) > 2:
    print("Reversed string:", a[::-1])
else:
    print("Conditions not met.")