package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_2606_바이러스_bfs {

  static int n, m;
  static List<List<Integer>> graph;
  static boolean[] visited;
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

    int max = 0;
    for (int i = 1; i <= n; i++){
      int result = bfs(i);
      max = Math.max(max, result);
    }
    System.out.println(max);

  }

  public static int bfs(int a) {
    int result = 0;
    Queue<Integer> queue = new LinkedList<>();
    visited[a] = true;
    queue.add(a);

    while (!queue.isEmpty()) {
      Integer p = queue.poll();
      for (Integer v : graph.get(p)) {
        if(!visited[v]) {
          result ++;
          visited[v] = true;
          queue.add(v);
        }
      }
    }
    return result;
  }
}
