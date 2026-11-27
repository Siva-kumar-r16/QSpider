#Write a function to check if a string has balanced brackets "(){[]}".

test_strings = ["()[]{}", "([{}])", "({[}])", "((("]

for s in test_strings:
    stack = []
    mapping = {")": "(", "}": "{", "]": "["}
    is_balanced = True
    
    for char in s:
        if char in mapping.values():
            stack.append(char)
        elif char in mapping.keys():
            if not stack or mapping[char] != stack.pop():
                is_balanced = False
                break
    
    if is_balanced and not stack:
        print(f"'{s}' is balanced: True")
    else:
        print(f"'{s}' is balanced: False")