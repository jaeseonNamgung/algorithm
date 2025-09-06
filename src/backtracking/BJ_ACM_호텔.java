package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_ACM_호텔 {
  static int N, H, W, T;
  static int[][] hotel;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st;

    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      H = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      T = Integer.parseInt(st.nextToken());
      hotel = new int[H][W];
      for (int i = 0; i < H; i++) {
        int room = (i+1) * 100 + 1;
        for (int j = 0; j < W; j++) {
          hotel[i][j] = room + j;
        }
      }

      int result = checkRoom();
      System.out.println(result);
    }
  }

  private static int checkRoom() {
    int count = 1;
    for (int i = 0; i < W; i++) {
      for (int j = 0; j < H; j++) {
        if(count == T) {
          return hotel[j][i];
        }else {
          count++;
        }
      }
    }
    return 0;
  }
}
