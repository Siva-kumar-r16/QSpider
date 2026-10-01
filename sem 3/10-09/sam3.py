i = [1, 2, 2, [2, [34, [211323, 23, 24, [232332, 2, 3], 5], 6], 7], 8]

def flatten_list(i):
    l2 = []
    
    for e in i:
        if type(e)!=list:
            l2.append(e)
        else:
            l2.extend(flatten_list(e))
            
    return l2

l2 = flatten_list(i)

print(l2)