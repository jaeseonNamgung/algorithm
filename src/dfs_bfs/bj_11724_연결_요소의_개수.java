package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_11724_연결_요소의_개수 {
  static List<Integer>[] graph;
  static boolean[]       visited;
  static int             N, M;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N+1];
    visited = new boolean[N+1];

    for (int i = 0; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u);
    }

    int result = 0;
    for (int i = 1; i <= N; i++) {

      if(!visited[i]) {
        result++;
        dfs(i);
      }
    }
    System.out.println(result);
  }

  public static void dfs(int a) {
    visited[a] = true;
    for (int i = 0; i < graph[a].size(); i++) {
      Integer b = graph[a].get(i);
      if(!visited[b]) {
        dfs(b);
      }
    }
  }
}
