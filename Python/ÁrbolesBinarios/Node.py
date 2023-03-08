# Declaramos la clase "Node"
class Node:

    def __init__(self, label, parent):
        self.label = label
        self.left = None
        self.right = None
        self.parent = parent

        # Métodos para asignar nodos
    def getLabel(self):
        return self.label

    def setLabel(self, label):
        self.label = label

    def getLeft(self):
        return self.left

    def setLeft(self, left):
        self.left = left

    def getRight(self):
        return self.right

    def setRight(self, right):
        self.right = right

    def getParent(self):
        return self.parent

    def setParent(self, parent):
        self.parent = parent