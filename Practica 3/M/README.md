# Practica 3
![img](https://www.muycomputerpro.com/wp-content/uploads/2019/01/programaci%C3%B3n-portada.jpg)

<audio controls>
  <source src="https://github.com/AbdielCC/AbdielCC/blob/af9a5bfdf8de1c78440a22c86422e9607b88f039/Imagine-Dragons-Natural.mp3?raw=true" type="audio/mpeg">
  Tu navegador no soporta la etiqueta de audio.
</audio>

# Indice
- [Integrantes del equipo](#integrantes)
- [Explicacion de codigo](#explicacion-del-codigo)
- [Constructor de arreglo unidimensional](#constructor-de-arreglo-unidimensional)
- [Constructor de arreglo multidimensional](#constructor-del-arreglo-multidimensional)
# Integrantes
| Nombre | Numero de cuenta |
| --- | --- |
| Cabello Cardenas Ulises Abdiel | 318075752 |


## Explicacion del codigo
### Constructor de arreglo unidimensional
En este codigo se decidio ocupar este metodo ya que primero se verifica, al momento de crear un arreglo unidimensional si la longitud que se desea crear ese nuevo arreglo es positiva, ya que no hay arreglos negativos, posteriormente se crean los elementos con la capacidad de cada arreglo y por omision la longitud del arreglo se queda en 0
```java
    /**
     * Constructor de la clase Arreglo.
     * 
     * @param capacidad La capacidad del arreglo.
     * @throws IllegalArgumentException Si la capacidad es negativa.
     */
    public Arreglo(int capacidad) {
        if (capacidad < 0) {
            throw new IllegalArgumentException("Capacidad inválida");
        }else{
            elementos = (T[]) new Object[capacidad];
            longitud = 0;
        }
    }
```
### constructor del arreglo multidimensional
En esta parte del codigo se verifica si primero la dimension es mayor que cero por que no tendria sentido tener un arreglo de longitud cero, posteriormente se desarrolla la asignacion del valor de las dimensiones y se crea un ilifevector de dimension inicial 0
```java
    /**
     * Constructor para crear un arreglo multidimensional con las dimensiones especificadas.
     *
     * @param dimensiones Las dimensiones del arreglo.
     * @throws IllegalArgumentException Si las dimensiones son inválidas.
     */
    public Arreglo(int... dimensiones) {
        if (dimensiones.length == 0) {
            throw new IllegalArgumentException("Dimensiones inválidas");
        }else{
            this.dimensiones = dimensiones;
            iliffeVector = crearIliffeVector(dimensiones, 0);
        }
    }
```


# Documentación de la Clase Arreglo

Esta clase implementa la interfaz `Coleccion` utilizando un arreglo. La clase proporciona métodos para manejar arreglos unidimensionales y multidimensionales, incluyendo soporte para **Vectores de Iliffe** en arreglos multidimensionales.

## Declaración de la Clase

```java
public class Arreglo<T> implements Coleccion<T> {
    private T[] elementos;
    private Object[] iliffeVector;
    private int longitud;
    private int[] dimensiones;
}
```
### Atributos:
- `T[] elementos`: Arreglo unidimensional de tipo `T` para almacenar elementos.
- `Object[] iliffeVector`: Arreglo multidimensional implementado usando Vectores de Iliffe.
- `int longitud`: Número de elementos en el arreglo unidimensional.
- `int[] dimensiones`: Dimensiones para arreglos multidimensionales.

## Constructores

### Constructor Unidimensional

```java
public Arreglo(int capacidad) {
    if (capacidad < 0) {
        throw new IllegalArgumentException("Capacidad inválida");
    }
    elementos = (T[]) new Object[capacidad];
    longitud = 0;
    dimensiones = new int[]{capacidad};
}
```
Crea un arreglo unidimensional con una capacidad inicial especificada. Lanza una excepción si la capacidad es negativa.

### Constructor Multidimensional

```java
public Arreglo(int... dimensiones) {
    if (dimensiones.length == 0 || dimensiones[0] <= 0) {
        throw new IllegalArgumentException("Dimensiones inválidas");
    }
    this.dimensiones = dimensiones;
    iliffeVector = crearIliffeVector(dimensiones, 0);
}
```
Crea un arreglo multidimensional con las dimensiones especificadas. Lanza una excepción si las dimensiones no son válidas.

## Métodos Principales

### Método `crearIliffeVector`

```java
private Object[] crearIliffeVector(int[] dims, int nivel) {
    int dim = dims[nivel];
    Object[] vector = new Object[dim];
    if (nivel == dims.length - 1) {
        return vector;
    }
    for (int i = 0; i < dim; i++) {
        vector[i] = crearIliffeVector(dims, nivel + 1);
    }
    return vector;
}
```
Crea y retorna un vector de Iliffe para la representación de un arreglo multidimensional.

### Método `getArreglo` para arreglos multidimensionales

```java
@SuppressWarnings("unchecked")
public T getArreglo(int... indices) {
    if (indices.length != dimensiones.length) {
        throw new IndexOutOfBoundsException("Número incorrecto de índices");
    }
    Object actual = iliffeVector;
    for (int i = 0; i < indices.length; i++) {
        actual = ((Object[]) actual)[indices[i]];
    }
    return (T) actual;
}
```
Obtiene el valor en la posición especificada del arreglo multidimensional. Verifica que el número de índices sea correcto.

### Método `setArreglo` para arreglos multidimensionales

```java
@SuppressWarnings("unchecked")
public void setArreglo(T valor, int... indices) {
    if (indices.length != dimensiones.length) {
        throw new IndexOutOfBoundsException("Número incorrecto de índices");
    }
    Object actual = iliffeVector;
    for (int i = 0; i < indices.length - 1; i++) {
        actual = ((Object[]) actual)[indices[i]];
    }
    ((Object[]) actual)[indices[indices.length - 1]] = valor;
}
```
Establece un valor en la posición especificada del arreglo multidimensional.

### Método `agregar` para un arreglo unidimensional

```java
@Override
public void agregar(T elemento) {
    if (longitud >= elementos.length) {
        throw new IllegalStateException("El arreglo está lleno");
    }
    elementos[longitud++] = elemento;
}
```
Agrega un nuevo elemento al final del arreglo unidimensional. Lanza una excepción si el arreglo está lleno.

### Método `eliminar` para un arreglo unidimensional

```java
@Override
public T eliminar() {
    if (longitud == 0) {
        throw new NoSuchElementException("El arreglo está vacío");
    }
    T elemento = elementos[--longitud];
    elementos[longitud] = null;
    return elemento;
}
```
Elimina y retorna el último elemento del arreglo unidimensional.

### Método `getArreglo` para un arreglo unidimensional

```java
@Override
public T getArreglo(int indice) {
    if (indice < 0 || indice >= longitud) {
        throw new IndexOutOfBoundsException("Índice fuera de los límites");
    }
    return elementos[indice];
}
```
Obtiene el elemento en una posición específica del arreglo unidimensional.

### Otros métodos

- `contiene`: Verifica si el arreglo contiene un elemento.
- `longitud`: Retorna el número de elementos en el arreglo.
- `estaVacio`: Verifica si el arreglo está vacío.
- `toString`: Devuelve una representación del arreglo en forma de cadena.
- `mostrarArreglo2D`: Muestra el contenido de un arreglo 2D.

## Ejemplo de Uso

```java
Arreglo<Integer> arreglo1D = new Arreglo<>(10);
arreglo1D.agregar(5);
System.out.println(arreglo1D.getArreglo(0));  // Imprime: 5

Arreglo<Integer> arreglo2D = new Arreglo<>(3, 3);
arreglo2D.setArreglo(1, 0, 0);
System.out.println(arreglo2D.getArreglo(0, 0));  // Imprime: 1
```
Este ejemplo muestra cómo crear y usar arreglos unidimensionales y multidimensionales utilizando la clase `Arreglo`.
