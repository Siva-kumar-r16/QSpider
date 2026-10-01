#reverse word in a sentence

s=input("Enter a sentence: ")
l=s.split(" ")
for i in l[::-1]:
    print(i,end=" ")