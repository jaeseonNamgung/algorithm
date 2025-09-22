package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_문자열_찾기 {
  static int N, M;
  static String[] S;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    S = new String[N];
    for (int i = 0; i < N; i++) {
      S[i] = br.readLine();
    }
    Arrays.sort(S);
    int count = 0;
    while (M-->0) {
      count += existStr(br.readLine());
    }
    System.out.println(count);
  }

  private static int existStr(String target) {
    int l = 0, r = S.length-1;
    while(l<=r) {

      int mid = (l+r)/2;
      int cmp = S[mid].compareTo(target);

      if(cmp < 0) l = mid + 1;
      else if(cmp > 0) r = mid - 1;
      else return 1;
    }
    return 0;
  }
}
