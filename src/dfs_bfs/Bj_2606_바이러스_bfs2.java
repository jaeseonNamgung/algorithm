package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_2606_바이러스_bfs2 {
  static List<Integer>[] graph;
  static boolean[]           visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    graph = new ArrayList[n+1];
    visited = new boolean[n+1];

    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a].add(b);
      graph[b].add(a);
    }

    int count  = bfs(1);
    System.out.println(count);
  }

  private static int bfs(int a) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(a);
    visited[a] = true;

    int count = 0;
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      for (int i = 0; i < graph[poll].size(); i++) {
        Integer k = graph[poll].get(i);
        if(!visited[k]) {
          queue.add(k);
          visited[k] = true;
          count++;
        }
      }
    }
    return count;
  }
}
