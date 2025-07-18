package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_15651_NM_3 {

  static int N, M;
  static int[] result;
  static StringBuffer sb = new StringBuffer();
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    result = new int[N+1];

    backtrack(0);
    System.out.println(sb);
  }

  public static void backtrack(int depth) {
    if(depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
        result[depth] = i;
        backtrack(depth+1);
    }
  }
}
