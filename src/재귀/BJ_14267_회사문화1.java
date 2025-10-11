package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14267_회사문화1 {
  static int N, M;
  static int[]               boss;
  static List<List<Integer>> list = new ArrayList<>();
  static int[]               sum;
  static boolean[]           visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    boss = new int[N+1];
    sum = new int[N+1];
    visited = new boolean[N+1];


    for (int i = 1; i <= N; i++) {
      boss[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i <= N; i++) {
      list.add(new ArrayList<>());
    }

    for (int i = 2; i <= N; i++) {
      list.get(boss[i]).add(i);
    }


    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int j = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      sum[j] += w;
    }

    dfs(1);
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(sum[i]).append(" ");
    }
    System.out.println(sb);
  }

  private static void dfs(int a) {
    visited[a] = true;

    for (Integer k : list.get(a)) {
      sum[k] += sum[a];
      if (!visited[k]) {
        dfs(k);
      }
    }
  }
}
