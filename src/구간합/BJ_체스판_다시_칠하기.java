package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_체스판_다시_칠하기 {
  static char[][] board;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    board = new char[N][M];

    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= N-8; i++) {
      for (int j = 0; j <= M-8; j++) {
        min = Math.min(min, countRepaint(i, j));
      }
    }
    System.out.println(min);
  }

  private static int countRepaint(int x, int y) {
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        char expected1 = (i+j)%2 == 0 ? 'B' : 'W';
        char expected2 = (i+j)%2 == 0 ? 'W' : 'B';
        if(board[x+i][y+j] == expected1) cnt1++;
        if(board[x+i][y+j] == expected2) cnt2++;
      }
    }

    return Math.min(cnt1, cnt2);

  }
}
