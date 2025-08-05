package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_9095_123더하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuffer sb = new StringBuffer();
    int count = n;
    while (count-- > 0) {
      int m = Integer.parseInt(br.readLine());
      int[] dp = new int[11];
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;

      for (int i = 4; i <= m; i++) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }
      sb.append(dp[m]).append("\n");
    }
    System.out.println(sb);
  }
}
