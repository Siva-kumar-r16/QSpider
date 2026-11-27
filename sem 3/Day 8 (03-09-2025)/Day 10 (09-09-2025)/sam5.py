'''def odd_even(n):
    if n%2==0:
        return "even"
    return "odd"'''

#write a program to check the given triangle is equilateral , isosceles , and scalene

def tri(a,b,c):
    if a==b and b==c:
        return "equilateral"
    elif a==b or b==c or a==c:
        return "Isoscles"
    else:
        return "scalene"
    
def checktri(a,b,c):
    if (a+b)>c and (a+c)>b and (c+b)>a:
        return tri(a,b,c)
    else:
        return "Invalid triangle"

a=int(input("enter length a of triangle"))
b=int(input("enter length b of triangle"))
c=int(input("enter length c of triangle"))

print (checktri(a,b,c))

