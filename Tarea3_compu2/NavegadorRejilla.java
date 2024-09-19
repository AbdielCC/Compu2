public class NavegadorRejilla {

  public static boolean moverNavegador(int[][] R, int[] posicion, String mov) {
    if (mov.isEmpty()) {
      return true;
    }

    int x = posicion[0];
    int y = posicion[1];
    char movimiento = mov.charAt(0);
    int nuevoX = x;
    int nuevoY = y;

    switch (movimiento) {
      case 'U':
        nuevoX = x - 1;
        break;
      case 'D':
        nuevoX = x + 1;
        break;
      case 'L':
        nuevoY = y - 1;
        break;
      case 'R':
        nuevoY = y + 1;
        break;
      case 'a':
        nuevoX = x - 1;
        nuevoY = y - 1;
        break;
      case 'b':
        nuevoX = x - 1;
        nuevoY = y + 1;
        break;
      case 'c':
        nuevoX = x + 1;
        nuevoY = y - 1;
        break;
      case 'd':
        nuevoX = x + 1;
        nuevoY = y + 1;
        break;
      default:
        System.out.println("Movimiento no válido: " + movimiento);
        return false;
    }

    if (nuevoX < 0 || nuevoX >= R.length || nuevoY < 0 || nuevoY >= R[0].length) {
      System.out.println("Movimiento fuera de límites. Posición: (" + nuevoX + ", " + nuevoY + ")");
      return false;
    }

    if (R[nuevoX][nuevoY] == 1) {
      System.out.println("Movimiento inválido debido a un obstáculo en la posición: (" + nuevoX + ", " + nuevoY + ")");
      return false;
    }

    posicion[0] = nuevoX;
    posicion[1] = nuevoY;

    return moverNavegador(R, posicion, mov.substring(1));
  }

  public static void main(String[] args) {
    int[][] R = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 1},
      {1, 0, 0, 0}
    };
    int[] posicion = {0, 0};
    String movimientos = "RDDDRR";
    boolean exito = moverNavegador(R, posicion, movimientos);

    if (exito) {
      System.out.println("El navegador terminó en la posición: (" + posicion[0] + ", " + posicion[1] + ")");
    } else {
      System.out.println("El navegador no pudo completar todos los movimientos.");
    }
  }
}
