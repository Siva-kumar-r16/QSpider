#To check whether the given integer is single digit or two digit to three ormolu that three digits 

a=int(input("Enter an integer: "))
if a<10:
    print(a,"is a single digit.")
elif a<100:
    print(a,"is a two digit.")
else:
    print(a,"is a three digit.")