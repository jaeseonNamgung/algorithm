package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    while (n --> 0) {
      int m = Integer.parseInt(br.readLine());
      int[][] sticker = new int[2][m];
      int[][] dp = new int[2][m];
      for (int i = 0; i < 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
          sticker[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      dp[0][0] = sticker[0][0];
      dp[1][0] = sticker[1][0];
      dp[0][1] = sticker[0][1] + sticker[1][0];
      dp[1][1] = sticker[1][1] + sticker[0][0];

      for (int i = 2; i < m; i++) {
        dp[0][i] = Math.max(dp[1][i-1], dp[0][i-2]) + sticker[0][i];
        dp[1][i] = Math.max(dp[0][i-1], dp[1][i-2]) + sticker[1][i];
      }

      System.out.println(Math.max(dp[0][m-1], dp[1][m-1]));
    }
    }

}
