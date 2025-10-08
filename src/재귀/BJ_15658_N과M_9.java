package 재귀;

import java.io.*;
import java.util.*;

public class BJ_15658_N과M_9 {
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
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    permutation(0);
    System.out.println(sb);
  }

  private static void permutation(int depth) {

    if(depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(output[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int temp = 0;
    for(int i = 0; i < N; i++) {
      if(checkNum[i] || temp == arr[i]) continue;
      checkNum[i] = true;
      output[depth] = arr[i];
      permutation(depth+1);
      checkNum[i] = false;
      temp = arr[i];
    }
  }
}
