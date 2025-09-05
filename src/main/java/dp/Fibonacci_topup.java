package dp;

import java.util.Scanner;

public class Fibonacci_topup {
  static int[] dp = new int[1000];
  public static int fibonacci(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;
    if(dp[n] != 0) return dp[n];
    dp [n] = fibonacci(n-1) + fibonacci(n-2);
    return dp[n];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(fibonacci(n));
  }
}
