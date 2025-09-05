package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_14503_로봇청소기 {

  static int N, M;
  static int[][] rooms;
  static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
  static int[] dc = { 0, 1, 0, -1 };
  static int result = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    rooms = new int[N][M];

    st = new StringTokenizer(br.readLine());
    int r, c, d;
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        rooms[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    simulation(r, c, d);
    System.out.println(result);

  }

  public static void simulation(int r, int c, int d) {


    while(true) {
      // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
      if(rooms[r][c] == 0) {
        rooms[r][c] = 2; // 청소 완료 표시
        result++;
      }

      boolean moved = false;
      for (int i = 0; i < 4; i++) {
        d = (d+3) % 4;
        int nr = r + dr[d];
        int nc = c + dc[d];

        if(inRange(nr, nc) && rooms[nr][nc] == 0) {
          moved = true;
          r = nr;
          c = nc;
          break;
        }
      }
      if(moved) {
        continue;
      }

      int back = (d+2) % 4;
      int nr = r + dr[back];
      int nc = c + dc[back];
      if(inRange(nr, nc) && rooms[nr][nc] != 1) {
        r = nr;
        c = nc;
      }else {
        break;
      }

    }

  }
  private static boolean inRange(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M;
  }
}
