package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11725_부모의_트리_찾기 {
  static int N;
  static List<List<Integer>> tree = new ArrayList<>();
  static boolean[] visited;
  static int[] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    result = new int[N+1];
    visited = new boolean[N+1];
    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }

    for (int i = 0; i < N-1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    dfs(1);

    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= N; i++) {
      sb.append(result[i]).append("\n");
    }
    System.out.println(sb);
  }

  public static void dfs(int a) {

    visited[a] = true;

    for (Integer b : tree.get(a)) {
      if(!visited[b]) {
        result[b] = a;
        dfs(b);
      }
    }
  }
}
