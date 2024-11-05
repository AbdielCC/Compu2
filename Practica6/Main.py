from src.ArbolAVL import ArbolAVL

# Crear el árbol AVL
arbol_avl = ArbolAVL()
raiz = None

# Insertar empleados en el árbol AVL
empleados = [
    (1, '2020-01-01'),
    (2, '2019-06-02'),
    (3, '2021-03-03'),
    (4, '2018-07-04'),
    (5, '2022-09-05')
]

for id_empleado, fecha in empleados:
    raiz = arbol_avl.insertar(raiz, id_empleado, fecha)

# Imprimir el árbol en postorden
print("Jerarquía de empleados (Postorden):")
print("postorden")
arbol_avl.postorden(raiz)
print("preorden")
arbol_avl.preorden(raiz)
print("inorden")
arbol_avl.inorden(raiz)