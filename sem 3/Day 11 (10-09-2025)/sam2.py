s="([{}])"

def is_valid(s):
    map={')':'(', '}':'{', ']':'['}
    if len(s)%2!=0:
        for i in range(len(s)//2):
            if map.get(s[-1-i])==s[i]:
                continue
            else:
                print("this is not valid")
                break
        else:
            print("this is valid")
is_valid(s)