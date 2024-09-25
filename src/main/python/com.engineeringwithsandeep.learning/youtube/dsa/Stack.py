class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class Stack:
    def __init__(self, value):
        new_node = Node(value)
        self.top = new_node
        self.height = 1

    def push(self, value):
        new_node = Node(value)
        if self.height != 0:
            new_node.next = self.top
        self.top = new_node
        self.height += 1

    def pop(self):
        if self.is_empty():
            return None
        else:
            current = self.top
            self.top = current.next
            current.next = None
            self.height -= 1
            return current


    def peek(self):
        if self.is_empty():
            return None
        else:
            return self.top.value

    def is_empty(self):
        return self.top is None

    def size(self):
        if self.is_empty():
            return 0
        else:
            return self.height

    def print_stack(self):
        temp = self.top
        count = 0
        while temp is not None:
            count += 1
            if count > 1:
                print("|")
            print(temp.value)
            temp = temp.next

# DEMO
my_stack = Stack(5)
my_stack.push(10)
my_stack.print_stack()
my_stack.push(15)
my_stack.print_stack()
print("popped node value: ", my_stack.pop().value)
my_stack.print_stack()
print("peeked value: ", my_stack.peek())
print("size is: ", my_stack.size())