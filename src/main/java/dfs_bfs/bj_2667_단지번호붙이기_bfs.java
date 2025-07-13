package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_2667_단지번호붙이기_bfs {
  static int n;
  static int[][] graph;
  static boolean[][] visited;
  static int[][] pos = {{-1,0}, {1,0}, {0,-1}, {0,1}};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    graph = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        graph[i][j] = line.charAt(j) - '0';
      }
    }

    int totalComplexCount = 0;
    List<Integer> unitCounts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && graph[i][j] == 1) {
          int resultCount = bfs(i, j);
          totalComplexCount++;
          unitCounts.add(resultCount);
        }
      }
    }
    System.out.println(totalComplexCount);
    Collections.sort(unitCounts);
    unitCounts.forEach(System.out::println);
  }

  private static int bfs(int a, int b) {
    int count = 1;
    visited[a][b] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{a, b});

    while (!q.isEmpty()){
      int[] k = q.poll();
      int nowX = k[0];
      int nowY = k[1];

      for (int[] po : pos) {
        int dx = nowX + po[0];
        int dy = nowY + po[1];

        if (dx > -1 && dx < n && dy > -1 && dy < n && !visited[dx][dy] && graph[dx][dy] == 1) {
          count++;
          visited[dx][dy] = true;
          q.add(new int[] {dx, dy});
        }
      }
    }
    return count;
  }
}
