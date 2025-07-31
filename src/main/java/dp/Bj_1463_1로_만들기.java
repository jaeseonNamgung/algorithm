package dp;

import java.util.Scanner;

public class Bj_1463_1로_만들기 {
  static int[] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    dp = new int[n+1];

    for (int i = 0; i <= n; i++) {
      dp[i] = -1;
    }

    System.out.println(topup(n));

  }

  public static int topup(int n) {
    if(n == 1) return 0;
    if(dp[n] != -1) return dp[n];

    // 기본값 1씩 증가
    dp[n] = topup(n-1) + 1;

    if(n%2 == 0) {
      dp[n] = Math.min(dp[n], topup(n/2) + 1);
    }
    if(n%3 == 0) {
      dp[n] = Math.min(dp[n], topup(n/3) + 1);
    }
    return dp[n];
  }
}
