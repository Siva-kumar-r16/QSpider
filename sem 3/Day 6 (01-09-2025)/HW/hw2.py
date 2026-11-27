n = 5
triangle = []
if n > 0:
    triangle.append([1])
    for i in range(1, n):
        prev_row = triangle[-1]
        new_row = [1]
        for j in range(1, len(prev_row)):
            new_row.append(prev_row[j - 1] + prev_row[j])
        new_row.append(1)
        triangle.append(new_row)
        
for row in triangle:
    print(row)
