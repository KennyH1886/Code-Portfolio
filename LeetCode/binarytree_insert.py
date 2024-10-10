class Node:
    def __init__(self, info):
        self.info = info  
        self.left = None  
        self.right = None 
        self.level = None 

    def __str__(self):
        return str(self.info) 

def preOrder(root):
    if root == None:
        return
    print (root.info, end=" ")
    preOrder(root.left)
    preOrder(root.right)
    
class BinarySearchTree:
    def __init__(self): 
        self.root = None

#Node is defined as
#self.left (the left child of the node)
#self.right (the right child of the node)
#self.info (the value of the node)

    def insert(self, val):
        # Call the recursive helper function with the root node and the value to insert
        self.root = self._insert_recursive(self.root, val)
            
        return self.root

    def _insert_recursive(self, current, val):
        # Base case: If the current node is None, create and return a new node
        if current is None:
            return Node(val)

        # If the value to be inserted is less than the current node's value, insert into the left subtree
        if val < current.info:
            current.left = self._insert_recursive(current.left, val)
    
        # If the value to be inserted is greater than the current node's value, insert into the right subtree
        elif val > current.info:
            current.right = self._insert_recursive(current.right, val)

        # Return the current node to keep the tree structure intact
        return current
            
    
        

tree = BinarySearchTree()
t = int(input())

arr = list(map(int, input().split()))

for i in range(t):
    tree.insert(arr[i])

preOrder(tree.root)