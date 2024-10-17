import Node as Node
class Queue:
    def __init__(self):
        self.nodo_frontal = None
        self.nodo_trasero = None
        self._tamano = 0

    def enqueue(self, item):
        nuevo_nodo = Node(item)
        if self.nodo_trasero:
            self.nodo_trasero.next = nuevo_nodo
        self.nodo_trasero = nuevo_nodo
        if not self.nodo_frontal:
            self.nodo_frontal = nuevo_nodo
        self._tamano += 1

    def dequeue(self):
        if self.is_empty():
            raise IndexError("dequeue from empty queue")
        dato_removido = self.nodo_frontal.data
        self.nodo_frontal = self.nodo_frontal.next
        if not self.nodo_frontal:
            self.nodo_trasero = None
        self._tamano -= 1
        return dato_removido

    def front(self):
        if self.is_empty():
            raise IndexError("front from empty queue")
        return self.nodo_frontal.data

    def is_empty(self):
        return self.nodo_frontal is None

    def size(self):
        return self._tamano
# type: ignore