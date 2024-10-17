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
