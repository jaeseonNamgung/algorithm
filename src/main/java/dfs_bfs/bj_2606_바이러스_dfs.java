package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_2606_바이러스_dfs {

  static int n, m;
  static List<List<Integer>> graph;
  static boolean[] visited;
  static int max = 0;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    visited = new boolean[n+1];

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    int resultMax=0;
    for (int i = 1; i <= n; i++) {
      dfs(i);
      resultMax=Math.max(resultMax, max);
      max=0;
    }
    System.out.println(resultMax);
  }

  public static void dfs(int a) {
    visited[a]=true;

    for (Integer v : graph.get(a)) {
      if(!visited[v]) {
        visited[v]=true;
        max++;
        dfs(v);
      }
    }
  }
}
