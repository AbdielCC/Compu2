public class UsoPractica2 {

    /**
     * Método principal para probar las funciones de la clase Practica2.
     */
    public static void main(String[] args) {

        // Ejercicio 1: Encontrar el Máximo Valor en un Arreglo
        int[] arreglo1 = {3, 5, 7, 2, 8};
        int maximo = Practica2.encuentraMaximo(arreglo1);
        System.out.println("El máximo valor es: " + maximo);
        // Esperado: 8

        // Ejercicio 2: Ordenar un Arreglo de Números Enteros
        int[] arreglo2 = {4, 2, 9, 1, 5};
        int[] arregloOrdenado = Practica2.ordenarArreglo(arreglo2);
        System.out.println("Arreglo ordenado: " + java.util.Arrays.toString(arregloOrdenado));
        // Esperado: [1, 2, 4, 5, 9]

        // Ejercicio 3: Buscar un Elemento en un Arreglo Ordenado
        int[] arreglo3 = {1, 3, 5, 7, 9};
        boolean encontrado = Practica2.buscarElementoOrdenado(arreglo3, 5);
        System.out.println("Elemento encontrado: " + encontrado);
        // Esperado: true

        // Ejercicio 4: Sumar los Elementos de un Arreglo
        int[] arreglo4 = {1, 2, 3, 4, 5};
        int suma = Practica2.sumaElementos(arreglo4);
        System.out.println("Suma de los elementos: " + suma);
        // Esperado: 15

        // Ejercicio 5: Invertir un Arreglo
        int[] arreglo5 = {1, 2, 3, 4, 5};
        int[] arregloInvertido = Practica2.invierteArreglo(arreglo5);
        System.out.println("Arreglo invertido: " + java.util.Arrays.toString(arregloInvertido));
        // Esperado: [5, 4, 3, 2, 1]

        // Ejercicio 6: Encontrar el Mínimo Valor en un Arreglo
        int[] arreglo6 = {3, 5, 7, 2, 8};
        int minimo = Practica2.encuentraMinimo(arreglo6);
        System.out.println("El mínimo valor es: " + minimo);
        // Esperado: 2

        // Ejercicio 7: Contar las Ocurrencias de un Elemento
        int[] arreglo7 = {1, 2, 3, 4, 3, 2, 3};
        int ocurrencias = Practica2.contarOcurrencias(arreglo7, 3);
        System.out.println("Número de ocurrencias: " + ocurrencias);
        // Esperado: 3

        // Ejercicio 8: Encontrar el Segundo Valor Máximo en un Arreglo
        int[] arreglo8 = {3, 5, 7, 2, 8};
        int segundoMaximo = Practica2.encuentraSegundoMaximo(arreglo8);
        System.out.println("El segundo máximo valor es: " + segundoMaximo);
        // Esperado: 7

        // Ejercicio 9: Comprobar si un Arreglo está Ordenado
        int[] arreglo9 = {1, 2, 3, 4, 5};
        boolean ordenado = Practica2.estaOrdenado(arreglo9);
        System.out.println("¿El arreglo está ordenado?: " + ordenado);
        // Esperado: true

        // Ejercicio 10: Eliminar Duplicados en un Arreglo
        int[] arreglo10 = {1, 2, 2, 3, 4, 4, 5};
        int[] sinDuplicados = Practica2.eliminarDuplicados(arreglo10);
        System.out.println("Arreglo sin duplicados: " + java.util.Arrays.toString(sinDuplicados));
        // Esperado: [1, 2, 3, 4, 5]
    }
}
