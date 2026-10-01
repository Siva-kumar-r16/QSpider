# wheather the given string is palindrome or not

s=input("Enter a string : ")
if s==s[::-1]:
    print(s,"is a palindrome")
else:
    print(s,"is not a palindrome")
