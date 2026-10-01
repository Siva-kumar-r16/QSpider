#Find the longest common prefix among a list of strings.


list_of_strings = [["flower", "flow", "flight"], ["dog", "racecar", "car"], ["a"], ["", "b"]]

for strs in list_of_strings:
    if not strs:
        prefix = ""
    else:
        strs.sort()
        first_str = strs[0]
        last_str = strs[-1]
        
        i = 0
        while i < len(first_str) and i < len(last_str) and first_str[i] == last_str[i]:
            i += 1
        
        prefix = first_str[:i]

    print(f"LCP of {strs}: {prefix}")