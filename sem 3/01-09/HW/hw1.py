my_list = [1, 2, 4, 5, 6, 7, 8, 9, 10]
n = len (my_list) + 1
totalsum = n * (n + 1) // 2
list_sum = sum (my_list)
missing = totalsum - list_sum
print (f"The missing number is: {missing}")