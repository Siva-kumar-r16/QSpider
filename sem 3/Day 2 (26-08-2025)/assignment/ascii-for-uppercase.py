#Achii value of a character  only if it is  upper case 

s=input("Enter a character: ")
if s.isupper():
    print("ASCII value of",s,"is",ord(s))
else:
    print(s,"is not an uppercase character")