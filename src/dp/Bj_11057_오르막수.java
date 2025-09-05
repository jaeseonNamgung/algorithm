package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Bj_11057_오르막수 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] dp = new int[n+1][11];

    for (int i = 0; i <= 10; i++) {
      dp[1][i] = i;
    }

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= 10; j++) {
        for (int k = 0; k <= j; k++) {
          dp[i][j] += dp[i-1][k] % 10007;
        }
      }
    }

    System.out.println(Arrays.stream(dp[n-1]).sum()%10007);

  }
}
