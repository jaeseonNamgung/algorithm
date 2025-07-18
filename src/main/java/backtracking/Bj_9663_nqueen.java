package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Queen 이 공격할 수 있는 위치
  1. 같은 행
  2. 같은 열
  3. 대각선
*/

public class Bj_9663_nqueen {

  static int N;
  static int[] arr;
  static boolean[] visited;
  static int result = 0;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    arr = new int[N];
    visited = new boolean[N];

    dfs(0);
    System.out.println(result);
  }

  public static void dfs(int depth) {

    if(depth == N) {
      result ++;
      return;
    }
    for (int col = 0; col < N; col++) {
      arr[depth] = col;
      if(possible(depth)) {
        dfs(depth + 1);
      }

    }
  }
  public static boolean possible(int row) {
    for (int i = 0; i < row; i++) {
      if(arr[i] == arr[row]) {
        return false;
      }

      if(Math.abs(i - row) == Math.abs(arr[i] - arr[row])) {
        return false;
      }
    }
    return true;
  }
}
