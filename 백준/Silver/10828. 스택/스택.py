class Stack() :
    def __init__(self) :
        self.my_stack = []

    def push(self, num) :
        self.my_stack.append(num)

    def pop(self) :
        if self.size() == 0 :
            return  -1
        else :
            return self.my_stack.pop()

    def size(self) :
        return len(self.my_stack)

    def empty(self) :
        if self.size() == 0 :
            return 1
        else :
            return 0

    def top(self) :
        if self.empty() == 1 :
            return -1
        else :
            return self.my_stack[-1]

import sys

if __name__ == "__main__" :
    n = int(sys.stdin.readline())
    my_stack = Stack()

    for i in range(n) :
        word = sys.stdin.readline().split()
        order = word[0]

        if order == "push" :
            my_stack.push(word[1])
        elif order == "pop" :
            print(my_stack.pop())
        elif order == "size" :
           print( my_stack.size())
        elif order == "empty" :
            print(my_stack.empty())
        elif order == "top" :
            print(my_stack.top())      