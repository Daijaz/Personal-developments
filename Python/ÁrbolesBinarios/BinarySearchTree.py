from P2_MiguelOsorio.Node import Node
class BinarySearchTree:
    def __init__(self):
        self.root = None

    def insert(self, label):
        # Creamos un nuevo nodo
        new_node = Node(label, None)
        # Si el árbol esta vacio
        if self.empty():
            self.root = new_node
        else:
            # Si el árbol no esta vacio
            curr_node = self.root
            while curr_node is not None:
                parent_node = curr_node
                if new_node.getLabel() < curr_node.getLabel():
                    curr_node = curr_node.getLeft()
                else:
                    curr_node = curr_node.getRight()
            if new_node.getLabel() < parent_node.getLabel():
                parent_node.setLeft(new_node)
            else:
                parent_node.setRight(new_node)
            new_node.setParent(parent_node)

            # Operación de borrado

    def delete(self, label):
        if (not self.empty()):
            node = self.getNode(label)
            if (node is not None):
                if (node.getLeft() is None and node.getRight() is None):
                    self.__reassignNodes(node, None)
                    node = None
                elif (node.getLeft() is None and node.getRight() is not None):
                    self.__reassignNodes(node, node.getRight())
                elif (node.getLeft() is not None and node.getRight() is None):
                    self.__reassignNodes(node, node.getLeft())
                else:
                    tmpNode = self.getMax(node.getLeft())
                    self.delete(tmpNode.getLabel())
                    node.setLabel(tmpNode.getLabel())

    def getNode(self, label):
        curr_node = None
        if (not self.empty()):
            curr_node = self.getRoot()
            while curr_node is not None and curr_node.getLabel() is not label:
                if label < curr_node.getLabel():
                    curr_node = curr_node.getLeft()
                else:
                    curr_node = curr_node.getRight()
        return curr_node

    def getMax(self, root=None):
        if (root is not None):
            curr_node = root
        else:
            curr_node = self.getRoot()
        if (not self.empty()):
            while (curr_node.getRight() is not None):
                curr_node = curr_node.getRight()
        return curr_node

    def getMin(self, root=None):
        if (root is not None):
            curr_node = root
        else:
            curr_node = self.getRoot()
        if (not self.empty()):
            curr_node = self.getRoot()
            while (curr_node.getLeft() is not None):
                curr_node = curr_node.getLeft()
        return curr_node

    def empty(self):
        if self.root is None:
            return True
        return False

    def __InOrderTraversal(self, curr_node):
        nodeList = []
        if curr_node is not None:
            nodeList.insert(0, curr_node)
            nodeList = nodeList + self.__InOrderTraversal(curr_node.getLeft())
            nodeList = nodeList + self.__InOrderTraversal(curr_node.getRight())
        return nodeList

    def getRoot(self):
        return self.root

    def __isRightChildren(self, node):
        if (node == node.getParent().getRight()):
            return True
        return False

    def __reassignNodes(self, node, newChildren):
        if (newChildren is not None):
            newChildren.setParent(node.getParent())
        if (node.getParent() is not None):
            if (self.__isRightChildren(node)):
                node.getParent().setRight(newChildren)
            else:
                node.getParent().setLeft(newChildren)

    def traversalTree(self, traversalFunction=None, root=None):
        if (traversalFunction is None):
            return self.__InOrderTraversal(self.root)
        else:
            #print(traversalFunction[1])
            #return traversalFunction[self.root]
            return traversalFunction[1]

    def __str__(self):
        list = self.__InOrderTraversal(self.root)
        str = ""
        for x in list:
            str = str + " " + x.getLabel().__str__()
        return str

    def InPreOrder(self, curr_node):
        nodeList = []
        if curr_node is not None:
            nodeList = nodeList + self.InPreOrder(curr_node.getLeft())
            nodeList.insert(0, curr_node.getLabel())
            nodeList = nodeList + self.InPreOrder(curr_node.getRight())
        return nodeList

    def InOrder(self, curr_node):
        finalarbol = self._IOrder(curr_node)
        finalarbol.reverse()
        return finalarbol

    def _IOrder(self, curr_node):
        nodeList = []
        if curr_node is not None:
            nodeList += self._IOrder(curr_node.getRight())
            nodeList.insert(3, curr_node.getLabel())
            nodeList += self._IOrder(curr_node.getLeft())
        return nodeList
