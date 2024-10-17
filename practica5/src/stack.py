import Node as Node

class Stack:
    def __init__(self):
        self.top = None
        self._size = 0

    # Agrega un elemento a la pila
    def push(self, item):
        new_node = Node.Node(item)
        new_node.next = self.top
        self.top = new_node
        self._size += 1

    # Elimina y devuelve el ultimo elemento agregado a la pila
    def pop(self):
        if self.is_empty():
            raise IndexError("pop from empty stack")
        item = self.top.data
        self.top = self.top.next
        self._size -= 1
        return item

    # Devuelve el elemento en la cima de la pila sin eliminarlo
    def peek(self):
        if self.is_empty():
            raise IndexError("peek from empty stack")
        return self.top.data

    # Verifica si la pila esta vacia
    def is_empty(self):
        return self.top is None

    # Devuelve el tamano de la pila
    def size(self):
        return self._size

    # Permite imprimir la pila
    def __str__(self):
        result = []
        current = self.top
        while current is not None:
            result.append(str(current.data))
            current = current.next
        return " -> ".join(result)
