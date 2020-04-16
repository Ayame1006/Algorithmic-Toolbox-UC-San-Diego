import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1) return n;
    int[] nums = new int[n + 1];
    nums[0] = 0;
    nums[1] = 1;
    for(int i = 2; i < n + 1; i++){
    	nums[i] = nums[i-2] + nums[i-1];
    }
    return nums[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
