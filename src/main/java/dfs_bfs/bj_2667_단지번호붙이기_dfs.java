package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 입력:
  7
  0110100
  0110101
  1110101
  0000111
  0100000
  0111110
  0111000

 출력:
  3
  7
  8
  9
* */
public class bj_2667_단지번호붙이기_dfs {

  static int n, count;
  static int[][] graph;
  static boolean[][] visited;
  static int[][] pos = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    // graph, visited 초기화
    graph = new int[n][n];
    visited = new boolean[n][n];

    // n개의 자료 입력
    for(int i = 0; i < n; i++){
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        graph[i][j] = line.charAt(j) - '0';
      }
    }

    // 총 단지의 수
    int totalComplexCount = 0;
    List<Integer> unitCounts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(!visited[i][j] && graph[i][j] == 1){
          count = 1;
          dfs(i, j);
          totalComplexCount++;
          unitCounts.add(count);
        }
      }
    }
    System.out.println(totalComplexCount);
    Collections.sort(unitCounts);
    unitCounts.forEach(System.out::println);
  }

  private static void dfs(int a, int b) {
    visited[a][b] = true;

    for (int i = 0; i < pos.length; i++) {
      int dx = a + pos[i][0];
      int dy = b + pos[i][1];

      if(dx > -1 && dx < n && dy > -1 && dy < n && !visited[dx][dy] && graph[dx][dy] == 1){
        count++;
        dfs(dx, dy);
      }
    }
  }
}
