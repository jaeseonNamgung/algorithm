package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_문자열_찾기_Set {
  static int N, M;
  static Set<String> set = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }
    int count = 0;
    while (M-->0) {
      count += existStr(br.readLine());
    }
    System.out.println(count);
  }

  private static int existStr(String str) {
    if(set.contains(str)) {
      return 1;
    }
    return 0;
  }
}
