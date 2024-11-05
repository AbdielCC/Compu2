from datetime import datetime

class Empleado:
    def __init__(self, id_empleado, fecha_antiguedad):
        self.id_empleado = id_empleado
        # Convertir fecha_antiguedad a datetime al inicializar el objeto
        self.fecha_antiguedad = datetime.strptime(fecha_antiguedad, '%Y-%m-%d')
        self.izquierda = None
        self.derecha = None
        self.altura = 1
