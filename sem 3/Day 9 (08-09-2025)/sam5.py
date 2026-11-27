#6 print each character of the string "python" using a for loop 

s="python"
for i in s:
    print(i)

#7 print the factorial of a given number using a for loop

n=int(input("enter a no"))
f=1
for i in range(1,n+1):
    f=f*i  
print("factorial of",n,"is",f)
