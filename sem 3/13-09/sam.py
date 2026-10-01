import pickle
with open('users.bin', 'rb') as f:
    l=pickle.load(f)
print(l)

for i in l:
    print(i)
    
'''

dummy_user = {'username': 'xyz', 'email': 'xyz@gmail.com', 'phno': '1234567890'}

with open('users.bin', 'wb') as f:
    pickle.dump([dummy_user], f)'''

    