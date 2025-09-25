package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {
  static int N, M;
  static int[][]     earth;
  static int[][]     melt;
  static boolean[][] visited;

  static int[][]     dist    = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    earth = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        earth[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int year = 0;
    while(true) {
      int cnt = countComponents();

      if(cnt == 0) {
        System.out.println(0);
        return;
      }

      if(cnt >= 2) {
        System.out.println(year);
        return;
      }

      melt = new int[N][M];

      for (int i = 1; i < N-1; i++) {
        for (int j = 1; j < M-1; j++) {
          if(earth[i][j] == 0) continue;

          int seas = 0;
          for (int k = 0; k < 4; k++) {
            int x = i + dist[k][0];
            int y = j + dist[k][1];
            if(earth[x][y] == 0) seas++;
          }
          melt[i][j] = seas;
        }
      }

      for (int i = 1; i < N-1; i++) {
        for (int j = 1; j < M-1; j++) {
          if(earth[i][j] != 0) {
            earth[i][j] = Math.max(0, earth[i][j] - melt[i][j]);
          }
        }
      }

      year++;
    }


  }

  public static int countComponents() {
    visited = new boolean[N][M];
    int cnt = 0;
    for (int i = 1; i < N-1; i++) {
      for (int j = 1; j < M-1; j++) {
        if(earth[i][j] != 0 && !visited[i][j]) {
          cnt ++;
          dfs(i, j);
        }
      }
    }
    return cnt;
  }

  public static void dfs(int col, int row) {
    visited[col][row] = true;
    for (int i = 0; i < 4; i++) {
      int x = col + dist[i][0];
      int y = row + dist[i][1];

      if (x < 0 || x >= N || y < 0 || y >= M) continue; // 경계 체크
      if (visited[x][y]) continue;
      if (earth[x][y] == 0) continue;
      dfs(x, y);
    }
  }

}
