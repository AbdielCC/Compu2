
# Practica3

## Índice
Índice

1-Características
2-Métodos Principales
        *Constructor
        *Métodos de Arreglo Multidimensional
        *Métodos de Arreglo Unidimensional
        *Métodos Auxiliares
3-Excepciones
  
### Integrantes
| Nombre | Número de cuenta |
| --- | --- |
| Cabello Cárdenas Ulises Abdiel | 318075752 |
| Alan Blancas Ochoa | 316227364 |

1-Características

Arreglo unidimensional: Nos permite crear un arreglo de tamaño fijo, agregar elementos, eliminar el último elemento, verificar si un elemento está presente, y otras operaciones comunes.

Arreglo multidimensional: Utiliza una estructura de Vectores de Iliffe para soportar arreglos multidimensionales, proporcionando métodos para obtener y establecer valores en posiciones específicas.

2-Métodos Principales

 Constructor

    Arreglo(int capacidad): Crea un arreglo unidimensional con la capacidad especificada.
        Parámetro: capacidad (int) - La capacidad inicial del arreglo.
        Excepción: Lanza IllegalArgumentException si la capacidad es negativa.

    Arreglo(int... dimensiones): Crea un arreglo multidimensional con las dimensiones especificadas.
        Parámetro: dimensiones (int...) - Las dimensiones del arreglo.
        Excepción: Lanza IllegalArgumentException si las dimensiones son inválidas.

Métodos de Arreglo Multidimensional

    T getArreglo(int... indices): Obtiene el valor en la posición especificada del arreglo multidimensional.
        Parámetro: indices (int...) - Los índices para acceder al valor.
        Retorna: El valor en la posición especificada.
        Excepción: Lanza IndexOutOfBoundsException si el número de índices es incorrecto o está fuera de los límites.

    void setArreglo(T valor, int... indices): Establece un valor en la posición especificada del arreglo multidimensional.
        Parámetro: valor (T) - El valor a establecer.
        Parámetro: indices (int...) - Los índices para acceder a la posición.
        Excepción: Lanza IndexOutOfBoundsException si el número de índices es incorrecto o está fuera de los límites.
Métodos de Arreglo Unidimensional

    void agregar(T elemento): Agrega un nuevo elemento al final del arreglo unidimensional.
        Parámetro: elemento (T) - El elemento a agregar.
        Excepción: Lanza IllegalStateException si el arreglo está lleno.

    T eliminar(): Elimina y retorna el último elemento del arreglo unidimensional.
        Retorna: El elemento eliminado.
        Excepción: Lanza NoSuchElementException si el arreglo está vacío.

    T getArreglo(int indice): Obtiene el elemento en la posición especificada del arreglo unidimensional.
        Parámetro: indice (int) - El índice del elemento a obtener.
        Retorna: El elemento en la posición especificada.
        Excepción: Lanza IndexOutOfBoundsException si el índice está fuera de los límites.

    boolean contiene(T elemento): Verifica si el arreglo unidimensional contiene el elemento especificado.
        Parámetro: elemento (T) - El elemento a buscar.
        Retorna: true si el arreglo contiene el elemento, false en caso contrario.

    int longitud(): Retorna la cantidad de elementos actualmente en el arreglo unidimensional.
        Retorna: El número de elementos en el arreglo.

    boolean estaVacio(): Verifica si el arreglo unidimensional está vacío.
        Retorna: true si el arreglo no contiene elementos, false en caso contrario.

Métodos Auxiliares

    String toString(): Devuelve una representación en forma de cadena del arreglo unidimensional.

    String mostrarArreglo2D(Arreglo<Integer> arreglo, int filas, int columnas): Método auxiliar para mostrar el contenido de un arreglo 2D.

3-Excepciones

La clase Arreglo maneja las siguientes excepciones:

    IllegalArgumentException: Si la capacidad o las dimensiones son inválidas.
    IndexOutOfBoundsException: Si se accede a una posición fuera de los límites del arreglo.
    IllegalStateException: Si se intenta agregar un elemento a un arreglo lleno.
    NoSuchElementException: Si se intenta eliminar un elemento de un arreglo vacío.


