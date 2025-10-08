package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_15664_N과M_10 {
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

    permutation(0, 0);
    System.out.println(sb);
  }

  private static void permutation(int depth, int start) {

    if(depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(output[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int prev = 0;
    for (int i = start; i < N; i++) {
      if(prev == arr[i]) continue;
      output[depth] = arr[i];
      prev = arr[i];
      permutation(depth+1, i+1);
    }
  }
}
