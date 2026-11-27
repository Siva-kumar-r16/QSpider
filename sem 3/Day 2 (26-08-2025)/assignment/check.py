#To check whether the char is uppercase , lower case , digit or special char 

a=input("Enter a character: ")
if a.isupper():
    print(a, "is uppercase.")
elif a.islower():
    print(a, "is lowercase.")
elif a.isdigit():
    print(a, "is a digit.")
else:
    print(a, "is a special character.")
