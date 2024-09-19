public class SumaNumeros {

  public static void combinacionesSuma(int k1, int k2, int n) {
    if (k1 + k2 == n) {
      System.out.println("(" + k1 + ", " + k2 + ")");
    }
    if (k1 < n) {
      combinacionesSuma(k1 + 1, k2 - 1, n);
    }
  }

  public static void Envio_de_datos(int n) {
    combinacionesSuma(0, n, n);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println("Combinaciones que suman a " + n + ":");
    Envio_de_datos(n);
  }
}
