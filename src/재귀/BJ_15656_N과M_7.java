package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15656_N과M_7 {
  static int N, M;
  static int[] arr, output;
  static boolean[] checkNum;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    output = new int[N];
    checkNum = new boolean[N];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    permutation(0);

    System.out.println(sb);
  }

  public static void permutation(int depth) {

    if(depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(output[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      output[depth] = arr[i];
      permutation(depth+1);
    }
  }
}
