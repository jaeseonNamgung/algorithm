package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_15650_NM_2 {

  static int N, M;
  static int[] result;
  static boolean[] visited;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[N+1];
    visited = new boolean[N+1];

    backtrack(0, 1);
    System.out.println(sb);
  }

  public static void backtrack(int depth, int start) {
    if(depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = start; i <= N; i++) {
      if(!visited[i]) {
        visited[i] = true;
        result[depth] = i;
        backtrack(depth+1, i + 1);
        visited[i] = false;
      }
    }
  }
}
