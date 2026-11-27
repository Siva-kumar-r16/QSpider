'''def add(*arg):
    return sum(arg)

print(add(*tuple(range(1, 101))))'''

def login(**k):
    if k["username"] == "admin" and k["password"] == "123456":
        print("login")
    else:
        print("failed")

login(username="admin", password="123456")