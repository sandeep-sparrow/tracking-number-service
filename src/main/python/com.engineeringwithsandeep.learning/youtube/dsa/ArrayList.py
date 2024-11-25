# Initialization
# store elements of multiple types
numbers = list({1, 2, 3, 4, 5})

print(numbers)
print(len(numbers))

# Insertion - allows duplicate, insertion order
numbers.append(2)
print(numbers)
print(len(numbers))

# Insert a index
numbers.insert(4, 10)
print(numbers)
print(len(numbers))

print(numbers[4])

# Traversal O(n)
for i in numbers:
    print(i)

# reverse
def reverse(array):
    for index in range(len(array) // 2):
        other = len(array) - index - 1
        temp = array[index]
        array[index] = array[other]
        array[other] = temp
    return array

print("Reversing")
print(reverse(numbers))