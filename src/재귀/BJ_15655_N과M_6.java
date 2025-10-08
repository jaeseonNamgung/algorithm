package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655_N과M_6 {
  static int N, M;
  static int[] arr, output;
  static boolean[] checkNum;

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

  }

  public static void permutation(int depth, int start) {

    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(output[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i < N; i++) {
      if (checkNum[i]) continue;
      checkNum[i] = true;
      output[depth] = arr[i];
      permutation(depth + 1, i + 1);
      checkNum[i] = false;
    }
  }
}
