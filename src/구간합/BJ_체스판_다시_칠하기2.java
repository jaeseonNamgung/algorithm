package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_체스판_다시_칠하기2 {
  static int N, M, K;
  static char[][] boards;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    boards = new char[N][M];

    for (int i = 0; i < N; i++) {
      boards[i] = br.readLine().toCharArray();
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i <= N - K; i++) {
      for (int j = 0; j <= M - K; j++) {
          min = Math.min(min, checkChess(i, j));
      }
    }
    System.out.println(min);
  }
  private static int checkChess(int x, int y) {

    int cnt1=0, cnt2=0;
    for (int i = x; i < x+K; i++) {
      for (int j = y; j < y+K; j++) {
        char expected1 = (i+j)%2 == 0 ? 'B' : 'W';
        char expected2 = (i+j)%2 == 0 ? 'W' : 'B';

        if(boards[i][j] != expected1) cnt1++;
        if(boards[i][j] != expected2) cnt2++;
       }
    }
    return Math.min(cnt1, cnt2);
  }
}
