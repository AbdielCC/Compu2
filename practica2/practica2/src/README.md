# Practica2
![img](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSM_xVKfLwUQliHvPzZoriPa18l-_JZj2Tbug&s)
## Índice
- [Encuentra máximo](#encuentra-máximo)
- [Ordenar Arreglo](#ordenar-arreglo)
- [Buscar Elemento Ordenado](#buscar-elemento-ordenado)
- [Suma Elementos](#suma-elementos)
- [Invierte Arreglo](#invierte-arreglo)
- [Encuentra Mínimo](#encuentra-mínimo)
- [Contar Ocurrencias](#contar-ocurrencias)
- [Encuentra Segundo Máximo](#encuentra-segundo-máximo)
- [Está Ordenado](#está-ordenado)
- [Eliminar Duplicados](#eliminar-duplicados)

### Integrantes
| Nombre | Número de cuenta |
| --- | --- |
| Cabello Cárdenas Ulises Abdiel | 318075752 |
| Alan Blancas Ochoa | 316227364 |

# Encuentra máximo
## `encuentraMaximo(int[] arreglo)`
### Descripción
Encuentra el valor máximo en un arreglo de números enteros.

### Complejidad Temporal
- **O(n)**: Utiliza un ciclo `for` para recorrer cada elemento del arreglo una vez, comparando cada elemento con el valor máximo actual y actualizándolo si es necesario.
```java
    public static int encuentraMaximo(int[] arreglo) {
        int maximo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (maximo < arreglo[i]) {
                maximo = arreglo[i];
            }
        }
        return maximo;
    }
```
## Ordenar Arreglo
### `ordenarArreglo(int[] arreglo)`
#### Descripción
Ordena un arreglo de números enteros en orden ascendente utilizando el método de Merge Sort.

#### Complejidad Temporal
- **O(n log n)**: El algoritmo divide el arreglo en dos mitades (recursivamente) hasta que los subarreglos tienen un solo elemento, luego los mezcla. La división es logarítmica respecto al tamaño del arreglo y la mezcla es lineal, lo que resulta en una complejidad O(n log n).
```java
    public static int[] ordenarArreglo(int[] arreglo) {
        if (arreglo.length <= 1) {
            return arreglo;
        }
        int medio = arreglo.length / 2;
        int[] izquierda = new int[medio];
        int[] derecha = new int[arreglo.length - medio];
        for (int i = 0; i < medio; i++) {
            izquierda[i] = arreglo[i];
        }
        for (int i = medio; i < arreglo.length; i++) {
            derecha[i - medio] = arreglo[i];
        }
        izquierda = ordenarArreglo(izquierda);
        derecha = ordenarArreglo(derecha);
        return mezclar(izquierda, derecha);
    }
    private static int[] mezclar(int[] izquierda, int[] derecha) {
        int[] resultado = new int[izquierda.length + derecha.length];
        int i = 0, j = 0, k = 0;
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                resultado[k++] = izquierda[i++];
            } else {
                resultado[k++] = derecha[j++];
            }
        }
        while (i < izquierda.length) {
            resultado[k++] = izquierda[i++];
        }
        while (j < derecha.length) {
            resultado[k++] = derecha[j++];
        }
        return resultado;
    }    
```
## Buscar Elemento Ordenado
### `buscarElementoOrdenado(int[] arreglo, int elemento)`
#### Descripción
Busca un elemento en un arreglo ordenado de números enteros utilizando búsqueda binaria.

#### Complejidad Temporal
- **O(log n)**: La búsqueda se divide a la mitad en cada iteración (división binaria), reduciendo significativamente el número de comparaciones necesarias.
```java
    public static boolean buscarElementoOrdenado(int[] arreglo, int elemento) {
        int inicio = 0, fin = arreglo.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arreglo[medio] == elemento) {
                return true;
            } else if (arreglo[medio] < elemento) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return false;
    }
```
## Suma Elementos
### `sumaElementos(int[] arreglo)`
#### Descripción
Suma todos los elementos de un arreglo de números enteros.

#### Complejidad Temporal
- **O(n)**: Recorre todos los elementos del arreglo una sola vez sumando cada valor a un acumulador.
```java
    public static int sumaElementos(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma;
    }
```
## Invierte Arreglo
### `invierteArreglo(int[] arreglo)`
#### Descripción
Invierte el orden de los elementos en un arreglo de números enteros.

#### Complejidad Temporal
- **O(n)**: Un solo ciclo `for` recorre el arreglo y coloca cada elemento en una nueva posición en un arreglo de salida, desde el final hacia el principio.
```java
    public static int[] invierteArreglo(int[] arreglo) {
        int[] arreglo_invertido = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo_invertido[arreglo.length - 1 - i] = arreglo[i];
        }
        return arreglo_invertido;
    }
```
## Encuentra Mínimo
### `encuentraMinimo(int[] arreglo)`
#### Descripción
Encuentra el valor mínimo en un arreglo de números enteros.

#### Complejidad Temporal
- **O(n)**: Similar a `encuentraMaximo`, recorre el arreglo una vez para encontrar el valor mínimo.
```java
    public static int encuentraMinimo(int[] arreglo) {
        int minimo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (minimo > arreglo[i]) {
                minimo = arreglo[i];
            }
        }
        return minimo;
    }
```
## Contar Ocurrencias
### `contarOcurrencias(int[] arreglo, int elemento)`
#### Descripción
Cuenta cuántas veces aparece un elemento en un arreglo de números enteros.

#### Complejidad Temporal
- **O(n)**: Recorre el arreglo una vez, contando las veces que un elemento especificado aparece.
```java
    public static int contarOcurrencias(int[] arreglo, int elemento) {
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                contador++;
            }
        }
        return contador;
    }
```
## Encuentra Segundo Máximo
### `encuentraSegundoMaximo(int[] arreglo)`
#### Descripción
Encuentra el segundo valor máximo en un arreglo de números enteros.

#### Complejidad Temporal
- **O(n)**: Recorre el arreglo una vez manteniendo registro de los dos valores más altos encontrados.
```java
    public static int encuentraSegundoMaximo(int[] arreglo) {
        if (arreglo.length < 2) {
            return Integer.MIN_VALUE;
        }
        int maximo1 = arreglo[0], maximo2 = Integer.MIN_VALUE;
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > maximo1) {
                maximo2 = maximo1;
                maximo1 = arreglo[i];
            } else if (arreglo[i] > maximo2 && arreglo[i] != maximo1) {
                maximo2 = arreglo[i];
            }
        }
        return maximo2;
    }
```
## Está Ordenado
### `estaOrdenado(int[] arreglo)`
#### Descripción
Verifica si un arreglo de números enteros está ordenado en orden ascendente.

#### Complejidad Temporal
- **O(n)**: Revisa secuencialmente si cada elemento es menor o igual al siguiente, deteniéndose al encontrar cualquier desorden.
```java
    public static boolean estaOrdenado(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1]) {
                return false;
            }
        }
        return true;
    }
```
## Eliminar Duplicados
### `eliminarDuplicados(int[] arreglo)`
#### Descripción
Elimina los elementos duplicados en un arreglo de números enteros.

#### Complejidad Temporal
- **O(n^2)**: Utiliza dos ciclos anidados para revisar cada elemento contra todos los elementos ya procesados, eliminando duplicados.
```java
    public static int[] eliminarDuplicados(int[] arreglo) {
        int n = arreglo.length;
        int[] resultado = new int[n];
        int indiceResultado = 0;
        for (int i = 0; i < n; i++) {
            boolean esDuplicado = false;
            for (int j = 0; j < indiceResultado; j++) {
                if (arreglo[i] == resultado[j]) {
                    esDuplicado = true;
                    break;
                }
            }
            if (!esDuplicado) {
                resultado[indiceResultado++] = arreglo[i];
            }
        }
        int[] arrayFinal = new int[indiceResultado];
        for (int i = 0; i < indiceResultado; i++) {
            arrayFinal[i] = resultado[i];
        }
        return arrayFinal;
    }
```