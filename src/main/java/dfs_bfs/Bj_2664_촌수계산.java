package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_2664_촌수계산 {
  static int a, b;
  static List<List<Integer>> graph;
  static boolean[] visited;
  static int result = -1;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();
    visited = new boolean[n+1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    dfs(a, 0);
    System.out.println(result);

  }

  // dfs 백트래킹 문제
  public static void dfs(int a, int depth) {
    visited[a] = true;

    if(a == b) {
      result = depth;
      return;
    }

    for (Integer g : graph.get(a)) {
      if(!visited[g]) {
        dfs(g, depth+1);
      }
    }
  }
}
