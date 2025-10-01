package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2805_나무_자르기 {
  static int N, M;
  static int[] heights;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    heights = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    int l = 0, r = 1000000000, ans = 0;

    while(l <= r) {
      int mid = (l+r)/2;
      if(isPossible(mid)) {
        ans = mid;
        l = mid+1;
      }else {
        r = mid-1;
      }
    }
    System.out.println(ans);
  }

  private static boolean isPossible(int cutHeight) {

    long sum = 0;
    for (int h : heights) {
      if(h > cutHeight) sum += h - cutHeight;
    }
    return sum >= M;
  }
}
