#wheather character is special or not 

a=input("Enter character : ")
if not a.isalnum():
    print(a,"is a special character")
else:
    print(a,"is not a special character")
