
from P2_MiguelOsorio.BinarySearchTree import BinarySearchTree

t = BinarySearchTree()
#Insertamos los elementos
t.insert(10)
t.insert(5)
t.insert(3)
t.insert(7)
t.insert(12)
t.insert(11)
t.insert(15)

print(t.__str__())
print ("El recorrido inorder es " +str(t.InOrder(t.root)))
