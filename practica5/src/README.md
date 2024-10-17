# practica de pilas y colas

![img](https://lh3.googleusercontent.com/ZX6QtuP7xer0M5-ov_vw7K4qgjER0j_CnV5XoQ2KZU6DD2F4eRg2OyCeknEjvO-Uoyjk7_x5ljPJQe1e7F85aAdgMQ=s1280-w1280-h800)

| Nombre | Número de cuenta |
| --- | --- |
| Cabello Cárdenas Ulises Abdiel | 318075752 |
| Alan Blancas Ochoa | 316227364 |
## Implementaciones de la practica
- Node.py
```py
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
```
Esta clase represantara el nodo generico donde se almacenara el valor y se implementaran las referencias par hacer uso en las pilas y en la cola.

- Queue.py
```py
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
```
En esta parte del codigo implementamos la estructura de cola, se importo la clase nodo, y se implementaron los metodos que tenia como requisito.

- Stack.py
```py
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
```
En esta parte del codigo igual se implementa la pila con uso de la clase node, con los requisitos que require.
La función `_str_` se encarga de convertir la pila en una representación de cadena para facilitar su visualización.

- main.py
```py
import stack

# Creando una calculadora haciendo uso de las pilas
def calculadora():
    pila = stack.Stack()
    while True:
        print("Ingrese un número o un operador ('exit' para salir):")
        entrada = input()
        if entrada == "exit":
            break
        elif entrada == "+":
            if pila.size() >= 2:
                pila.push(pila.pop() + pila.pop())
            else:
                print("No hay suficientes elementos en la pila")
        elif entrada == "-":
            if pila.size() >= 2:
                pila.push(pila.pop() - pila.pop())
            else:
                print("No hay suficientes elementos en la pila")
        elif entrada == "*":
            if pila.size() >= 2:
                pila.push(pila.pop() * pila.pop())
            else:
                print("No hay suficientes elementos en la pila")
        elif entrada == "/":
            if pila.size() >= 2:
                divisor = pila.pop()
                if divisor == 0:
                    print("Error: División por cero")
                    pila.push(divisor)  # Devolvemos el divisor a la pila
                else:
                    pila.push(pila.pop() / divisor)
            else:
                print("No hay suficientes elementos en la pila")
        else:
            try:
                pila.push(float(entrada))
            except ValueError:
                print("Entrada no válida. Ingrese un número o un operador válido.")
        
        print("Pila: ", pila)
    
    if not pila.is_empty():
        print("Resultado: ", pila.pop())
    else:
        print("La pila está vacía.")


calculadora()
```
En esta funcion vemos una implementacion de una calculadora haciendo uso de las pilas y cumple:
 * La calculadora permite realizar operaciones básicas como suma, resta, multiplicación y división.
 * Utiliza una pila para almacenar los operandos y operadores, evaluando las expresiones en notación postfija.