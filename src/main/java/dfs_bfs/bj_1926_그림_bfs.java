package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1926_그림_bfs {

  static boolean [][] visited;
  static int [][]     tree;
  static int n;
  static int     m;
  static int[][] pos = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    tree = new int [n][m];
    visited = new boolean[n][m];

    for(int i = 0; i < n; i++) {
      s = br.readLine();
      st = new StringTokenizer(s);
      for (int j = 0; j < m; j++){
        tree[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int count = 0;
    int resultMax = 0;
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++){
        if(tree[i][j] == 1 && !visited[i][j]) {
          int max = bfs(i, j);
          resultMax = Math.max(resultMax, max);
          count++;
        }
      }
    }
    System.out.println(count);
    System.out.println(resultMax);

  }

  public static int bfs(int a, int b) {
    visited[a][b] = true;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {a, b});
    int max = 1;
    while (!queue.isEmpty()) {
      int[] arr = queue.poll();
      int nowX = arr[0];
      int nowY = arr[1];

      for (int i = 0; i < 4; i ++){
        int nx = nowX + pos[i][0];
        int ny = nowY + pos[i][1];
        if (nx > -1 && nx < n && ny > -1 && ny < m && tree[nx][ny] == 1 && !visited[nx][ny]) {
          max += tree[nx][ny];
          visited[nx][ny] = true;
          queue.add(new int[] {nx, ny});
        }
      }
    }
    return max;
  }
}
