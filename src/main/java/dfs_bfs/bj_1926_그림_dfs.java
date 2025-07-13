package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1926_그림_dfs {

  static int n, m;
  static int[][] canvas;
  static boolean[][] visited;
  static int currentArea;
  static final int[][] directions = {
      {-1, 0}, {1, 0}, {0, -1}, {0, 1}  // 상하좌우
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    canvas = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        canvas[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int pictureCount = 0;
    int maxArea = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (canvas[i][j] == 1 && !visited[i][j]) {
          currentArea = 0;
          dfs(i, j);
          pictureCount++;
          maxArea = Math.max(maxArea, currentArea);
        }
      }
    }

    System.out.println(pictureCount);
    System.out.println(maxArea);
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    currentArea++;

    for (int[] dir : directions) {
      int nx = x + dir[0];
      int ny = y + dir[1];

      if (isInBounds(nx, ny) && !visited[nx][ny] && canvas[nx][ny] == 1) {
        dfs(nx, ny);
      }
    }
  }

  private static boolean isInBounds(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }
}
