#Given a list of words, group them into anagrams.

from collections import defaultdict

word_list = ["eat", "tea", "tan", "ate", "nat", "bat"]
anagrams_dict = defaultdict(list)

for word in word_list:
    sorted_word = "".join(sorted(word))
    anagrams_dict[sorted_word].append(word)
    
grouped = list(anagrams_dict.values())
print(grouped)