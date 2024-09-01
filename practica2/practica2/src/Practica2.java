public class Practica2 {
    /**
     * Encuentra el valor máximo en un arreglo de números enteros.
     * 
     * @param arreglo de números enteros.
     * @return el valor máximo en el arreglo.
     *         Ejemplo:
     *         Input: [3, 5, 7, 2, 8]
     *         Output: 8
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
    public static int encuentraMaximo(int[] arreglo) {
        int maximo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (maximo < arreglo[i]) {
                maximo = arreglo[i];
            }
        }
        return maximo;
    }
    /**
     * Ordena un arreglo de números enteros en orden ascendente.
     * 
     * @param arreglo de números enteros a ordenar.
     * @return un nuevo arreglo con los elementos ordenados.
     *         Ejemplo:
     *         Input: [4, 2, 9, 1, 5]
     *         Output: [1, 2, 4, 5, 9]
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n*log(n)).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
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
    /**
     * Busca un elemento en un arreglo ordenado de números enteros.
     * 
     * @param arreglo  ordenado de números enteros.
     * @param elemento a buscar en el arreglo.
     * @return <code>true</code> si el elemento recibido existe en el arreglo,
     *         <code>false</code> en otro caso.
     *         Ejemplo:
     *         Input: [1, 3, 5, 7, 9], elemento = 5
     *         Output: true
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(log(n)).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n).
     */
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

    /**
     * Suma todos los elementos de un arreglo de números enteros.
     * 
     * @param arreglo de números enteros.
     * @return la suma de todos los elementos en el arreglo.
     *         Ejemplo:
     *         Input: [1, 2, 3, 4, 5]
     *         Output: 15
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
    public static int sumaElementos(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma;
    }

    /**
     * Invierte el orden de los elementos en un arreglo de números enteros.
     * 
     * @param arreglo de números enteros.
     * @return un nuevo arreglo con los elementos en orden inverso.
     *         Ejemplo:
     *         Input: [1, 2, 3, 4, 5]
     *         Output: [5, 4, 3, 2, 1]
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
    public static int[] invierteArreglo(int[] arreglo) {
        int[] arreglo_invertido = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo_invertido[arreglo.length - 1 - i] = arreglo[i];
        }
        return arreglo_invertido;
    }

    /**
     * Encuentra el valor mínimo en un arreglo de números enteros.
     * 
     * @param arreglo de números enteros.
     * @return el valor mínimo en el arreglo.
     *         Ejemplo:
     *         Input: [3, 5, 7, 2, 8]
     *         Output: 2
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
    public static int encuentraMinimo(int[] arreglo) {
        int minimo = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (minimo > arreglo[i]) {
                minimo = arreglo[i];
            }
        }
        return minimo;
    }

    /**
     * Cuenta cuántas veces aparece un elemento en un arreglo de números enteros.
     * 
     * @param arreglo  de números enteros.
     * @param elemento a contar en el arreglo.
     * @return el número de ocurrencias del elemento en el arreglo.
     *         Ejemplo:
     *         Input: [1, 2, 3, 4, 3, 2, 3], elemento = 3
     *         Output: 3
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
    public static int contarOcurrencias(int[] arreglo, int elemento) {
        int contador = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elemento) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Encuentra el segundo valor máximo en un arreglo de números enteros.
     * 
     * @param arreglo de números enteros.
     * @return el segundo valor máximo en el arreglo.
     *         Ejemplo:
     *         Input: [3, 5, 7, 2, 8]
     *         Output: 7
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
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

    /**
     * Verifica si un arreglo de números enteros está ordenado en orden ascendente.
     * 
     * @param arreglo de números enteros.
     * @return <code>true</code> si el arreglo está ordenado,
     *         <code>false</code> en otro caso.
     *         Ejemplo:
     *         Input: [1, 2, 3, 4, 5]
     *         Output: true
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     */
    public static boolean estaOrdenado(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Elimina los elementos duplicados en un arreglo de números enteros.
     * 
     * @param arreglo de números enteros.
     * @return un nuevo arreglo sin elementos duplicados.
     *         Ejemplo:
     *         Input: [1, 2, 2, 3, 4, 4, 5]
     *         Output: [1, 2, 3, 4, 5]
     * 
     *         1.0 pts : Si tu algoritmo tiene una complejidad de O(n^2).
     *         0.7 pts : Si tu algoritmo tiene una complejidad de O(n^3).
     */
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
}