#Whether the data is mutable or not 

a=eval(input("Enter a data: "))
if type(a).__name__ in ["list", "dict", "set"]:
    print(a, "is mutable")
else:
    print(a, "is not mutable")