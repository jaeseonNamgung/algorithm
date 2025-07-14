package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_15649_NM {
  static StringBuilder sb = new StringBuilder();
  static int n,m;
  static int[] arr;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    visited = new boolean[n+1];
    arr = new int[m];
    backtracking(0);
    System.out.println(sb);
  }

  public static void backtracking(int depth) {

    if(depth == m) {
      for(int val : arr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int j = 1; j <= n; j++) {
      if(!visited[j]) {
        arr[depth] = j;
        visited[j] = true;
        backtracking(depth+1);
        visited[j] = false;
      }
    }
  }
}
