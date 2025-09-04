package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static List<List<Integer>> graph;
  static boolean[]           visited;
  static int                 a, b;
  static int result = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    visited = new boolean[n + 1];
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    if (dfs(a, 0)) {
      System.out.println(result);
    } else {
      System.out.println(-1);
    }
  }

  public static boolean dfs(int a, int depth) {
    if (a == b) {;
      result = depth;
      return true;
    }
    visited[a] = true;

    for (int i = 0; i < graph.get(a).size(); i++) {
      int now = graph.get(a).get(i);
      if (!visited[now]) {
        result++;
        if(dfs(now, depth+1)) {
          return true;
        }
      }
    }
    return false;
  }
}
