package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15681_트리와쿼리 {
  static int N, R, Q;
  static List<List<Integer>> tree = new ArrayList<>();
  static boolean[] visited;
  static int[] result;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());

    result = new int[N+1];
    visited = new boolean[N+1];

    for (int i = 0; i <= N; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < N-1; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      tree.get(a).add(b);
      tree.get(b).add(a);
    }

    dfs(R);
    while(Q --> 0) {
      System.out.println(result[Integer.parseInt(br.readLine())]);
    }

  }

  public static int dfs(int a) {
    visited[a] = true;
    int sum = 1;
    for (Integer t : tree.get(a)) {
      if(!visited[t]){
        sum += dfs(t);
      }
    }
    result[a] = sum;
    return result[a];
  }
}
