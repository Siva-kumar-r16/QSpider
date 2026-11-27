#wap to toggle a string

a=input("Enter a string: ")
toggled_string = ""
i=0
while i<len(a):
    if a[i].islower():
        toggled_string += a[i].upper()
    else:
        toggled_string += a[i].lower()
    i+=1
print("Toggled string:", toggled_string)
