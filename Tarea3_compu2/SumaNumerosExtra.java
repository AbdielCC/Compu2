public class SumaNumerosExtra {

  public static void combinar(int[] nums, int m, int n) {
    if (m == 1) {
      nums[nums.length - 1] = n;
      imprimir(nums);
      return;
    }

    for (int i = 0; i <= n; i++) {
      nums[nums.length - m] = i;
      combinar(nums, m - 1, n - i);
    }
  }

  private static void imprimir(int[] nums) {
    System.out.print("(");
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]);
      if (i < nums.length - 1) System.out.print(", ");
    }
    System.out.println(")");
  }

  public static void main(String[] args) {
    int m = 3;
    int n = 10;

    int[] nums = new int[m];

    System.out.println("Combinaciones de " + m + " números que suman a " + n + ":");
    combinar(nums, m, n);
  }
}
