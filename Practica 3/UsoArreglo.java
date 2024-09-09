public class UsoArreglo {
    public static void main(String[] args) {
        // Crear una instancia de Arreglo unidimensional
        Arreglo<Integer> arreglo1D = new Arreglo<>(5);
        
        // Mostrar el contenido inicial del arreglo unidimensional
        System.out.println("Contenido inicial del arreglo 1D: " + arreglo1D);
        
        // Agregar elementos al arreglo unidimensional
        arreglo1D.agregar(1);
        arreglo1D.agregar(2);
        arreglo1D.agregar(3);
        
        // Mostrar el contenido del arreglo unidimensional después de agregar elementos
        System.out.println("Contenido del arreglo 1D después de agregar elementos: " + arreglo1D);

        // Crear una instancia de Arreglo multidimensional (2D)
        Arreglo<Integer> arreglo2D = new Arreglo<>(3, 3);
        
        // Mostrar el contenido inicial del arreglo multidimensional
        System.out.println("Contenido inicial del arreglo 2D: \n" + arreglo2D.mostrarArreglo2D(arreglo2D, 3, 3));
        
        // Establecer valores en el arreglo 2D usando Vectores de Iliffe
        arreglo2D.setArreglo(1, 0, 0);
        arreglo2D.setArreglo(2, 1, 1);
        arreglo2D.setArreglo(3, 2, 2);
        
        // Obtener y mostrar valores del arreglo 2D después de setArreglo elementos
        System.out.println("Valor en [0,0]: " + arreglo2D.getArreglo(0, 0));
        System.out.println("Valor en [1,1]: " + arreglo2D.getArreglo(1, 1));
        System.out.println("Valor en [2,2]: " + arreglo2D.getArreglo(2, 2));
        System.out.println("Contenido del arreglo 2D después de agregar elementos: \n" + arreglo2D.mostrarArreglo2D(arreglo2D, 3, 3));
    }
}
