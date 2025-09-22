package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_수_찾기 {
  static int N, M;
  static int[] A;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(A);
    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    while (M-->0) {
      int num = Integer.parseInt(st.nextToken());
      System.out.println(existNum(num));
    }
  }

  private static int existNum(int num) {

    int l = 0, r = A.length - 1;
    while (l<=r) {
      int mid = (l+r)/2;

      if(A[mid] < num) l = mid + 1;
      else if(A[mid] > num) r = mid - 1;
      else return 1;
    }
    return 0;
  }
}
