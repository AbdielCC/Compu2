from datetime import datetime
from src.Empleado import Empleado

class ArbolAVL:
    def __init__(self):
        self.raiz = None

    def insertar(self, raiz, id_empleado, fecha_antiguedad):
        # Convertir fecha_antiguedad a un objeto datetime para hacer comparaciones
        fecha_antiguedad = datetime.strptime(fecha_antiguedad, '%Y-%m-%d')
        
        if not raiz:
            # Crear un nuevo nodo Empleado con fecha_antiguedad en formato string
            return Empleado(id_empleado, fecha_antiguedad.strftime('%Y-%m-%d'))
        elif fecha_antiguedad < raiz.fecha_antiguedad:
            raiz.izquierda = self.insertar(raiz.izquierda, id_empleado, fecha_antiguedad.strftime('%Y-%m-%d'))
        else:
            raiz.derecha = self.insertar(raiz.derecha, id_empleado, fecha_antiguedad.strftime('%Y-%m-%d'))

        raiz.altura = 1 + max(self.obtener_altura(raiz.izquierda), self.obtener_altura(raiz.derecha))
        balance = self.obtener_balance(raiz)

        # Balancear el árbol si es necesario
        if balance > 1 and fecha_antiguedad < raiz.izquierda.fecha_antiguedad:
            return self.rotar_derecha(raiz)
        if balance < -1 and fecha_antiguedad > raiz.derecha.fecha_antiguedad:
            return self.rotar_izquierda(raiz)
        if balance > 1 and fecha_antiguedad > raiz.izquierda.fecha_antiguedad:
            raiz.izquierda = self.rotar_izquierda(raiz.izquierda)
            return self.rotar_derecha(raiz)
        if balance < -1 and fecha_antiguedad < raiz.derecha.fecha_antiguedad:
            raiz.derecha = self.rotar_derecha(raiz.derecha)
            return self.rotar_izquierda(raiz)

        return raiz

    def rotar_izquierda(self, z):
        y = z.derecha
        T2 = y.izquierda

        y.izquierda = z
        z.derecha = T2

        z.altura = 1 + max(self.obtener_altura(z.izquierda), self.obtener_altura(z.derecha))
        y.altura = 1 + max(self.obtener_altura(y.izquierda), self.obtener_altura(y.derecha))

        return y

    def rotar_derecha(self, z):
        y = z.izquierda
        T3 = y.derecha

        y.derecha = z
        z.izquierda = T3

        z.altura = 1 + max(self.obtener_altura(z.izquierda), self.obtener_altura(z.derecha))
        y.altura = 1 + max(self.obtener_altura(y.izquierda), self.obtener_altura(y.derecha))

        return y

    def obtener_altura(self, nodo):
        return nodo.altura if nodo else 0

    def obtener_balance(self, nodo):
        if not nodo:
            return 0
        return self.obtener_altura(nodo.izquierda) - self.obtener_altura(nodo.derecha)

    def buscar(self, raiz, id_empleado):
        if not raiz or raiz.id_empleado == id_empleado:
            return raiz
        if id_empleado < raiz.id_empleado:
            return self.buscar(raiz.izquierda, id_empleado)
        return self.buscar(raiz.derecha, id_empleado)

    def eliminar(self, raiz, fecha_antiguedad):
        if not raiz:
            return raiz
        fecha_antiguedad = datetime.strptime(fecha_antiguedad, '%Y-%m-%d')

        if fecha_antiguedad < raiz.fecha_antiguedad:
            raiz.izquierda = self.eliminar(raiz.izquierda, fecha_antiguedad.strftime('%Y-%m-%d'))
        elif fecha_antiguedad > raiz.fecha_antiguedad:
            raiz.derecha = self.eliminar(raiz.derecha, fecha_antiguedad.strftime('%Y-%m-%d'))
        else:
            if raiz.izquierda is None:
                return raiz.derecha
            elif raiz.derecha is None:
                return raiz.izquierda
            temp = self.obtener_nodo_menor(raiz.derecha)
            raiz.fecha_antiguedad = temp.fecha_antiguedad
            raiz.id_empleado = temp.id_empleado
            raiz.derecha = self.eliminar(raiz.derecha, temp.fecha_antiguedad.strftime('%Y-%m-%d'))

        if raiz is None:
            return raiz

        raiz.altura = 1 + max(self.obtener_altura(raiz.izquierda), self.obtener_altura(raiz.derecha))
        balance = self.obtener_balance(raiz)

        if balance > 1 and self.obtener_balance(raiz.izquierda) >= 0:
            return self.rotar_derecha(raiz)
        if balance < -1 and self.obtener_balance(raiz.derecha) <= 0:
            return self.rotar_izquierda(raiz)
        if balance > 1 and self.obtener_balance(raiz.izquierda) < 0:
            raiz.izquierda = self.rotar_izquierda(raiz.izquierda)
            return self.rotar_derecha(raiz)
        if balance < -1 and self.obtener_balance(raiz.derecha) > 0:
            raiz.derecha = self.rotar_derecha(raiz.derecha)
            return self.rotar_izquierda(raiz)

        return raiz

    def obtener_nodo_menor(self, nodo):
        if nodo is None or nodo.izquierda is None:
            return nodo
        return self.obtener_nodo_menor(nodo.izquierda)

    def postorden(self, nodo):
        if not nodo:
            return
        self.postorden(nodo.izquierda)
        self.postorden(nodo.derecha)
        print(f"ID Empleado: {nodo.id_empleado}, Fecha Antigüedad: {nodo.fecha_antiguedad.strftime('%Y-%m-%d')}")
    def inorden(self, nodo):
        if not nodo:
            return
        self.inorden(nodo.izquierda)
        print(f"ID Empleado: {nodo.id_empleado}, Fecha Antigüedad: {nodo.fecha_antiguedad.strftime('%Y-%m-%d')}")
        self.inorden(nodo.derecha)
    def preorden(self, nodo):
        if not nodo:
            return
        print(f"ID Empleado: {nodo.id_empleado}, Fecha Antigüedad: {nodo.fecha_antiguedad.strftime('%Y-%m-%d')}")
        self.preorden(nodo.izquierda)
        self.preorden(nodo.derecha)