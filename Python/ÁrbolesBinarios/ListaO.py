from P2_MiguelOsorio.Nodo import Nodo
class ListaO:

    def __init__(self):
        self.cabeza = None

    def estaVacia(self):
        return self.cabeza == None

    def agregar(self, item):
        temp = Nodo(item)
        temp.asignarSiguiente(self.cabeza)
        self.cabeza = temp

    def tamano(self):
        actual = self.cabeza
        contador = 0
        while actual != None:
            contador = contador + 1
            actual = actual.obtenerSiguiente()
        return contador

    def buscar(self, item):
        actual = self.cabeza
        encontrado = False
        while actual != None and not encontrado:
            if actual.obtenerDato() == item:
                encontrado = True
            else:
                actual = actual.obtenerSiguiente()

        return encontrado

    def RemoveMax(self):
        actual = self.cabeza
        encontrado = False
        mayor = actual.obtenerDato()
        while actual != None and not encontrado:
            if actual.obtenerDato() > mayor:
                mayor = actual.obtenerDato()
                self.remover(mayor)
                encontrado = True
            else:
                actual = actual.obtenerSiguiente()
        return encontrado








    def remover(self, item):
        actual = self.cabeza
        previo = None
        encontrado = False
        while not encontrado:
            if actual.obtenerDato() == item:
                encontrado = True
            else:
                previo = actual
                actual = actual.obtenerSiguiente()

        if previo == None:
            self.cabeza = actual.obtenerSiguiente()
        else:
            previo.asignarSiguiente(actual.obtenerSiguiente())

    def Promedio(self):
        actual = self.cabeza
        Sumar = 0
        while actual != None:
            Sumar += actual.obtenerDato()
            actual = actual.obtenerSiguiente()
        print(Sumar / self.tamano())