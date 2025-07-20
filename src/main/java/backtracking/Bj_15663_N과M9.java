package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_15663_N과M9 {

  static StringBuffer sb = new StringBuffer();
  static int N, M;
  static int[] arr;
  static int[] result;
  static boolean []  visited;
  static Set<String> unique = new HashSet<>();
  public static void main(String[] args) throws IOException {

    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    result = new int[M];
    visited  = new boolean[N+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }


    backtrack(0);

    List<String> resultList = new ArrayList<>(unique);
    Collections.sort(resultList);
    resultList.forEach(System.out::println);

  }

  public static void backtrack(int depth){

    if(depth == M) {
      for(int val : result) {
        sb.append(val).append(" ");
      }
      if(!unique.contains(sb.toString())) {
        unique.add(sb.toString());
      }
      sb = new StringBuffer();
      return;
    }

    for (int i = 0; i < N; i++) {
      if(visited[i+1]) continue;

      visited[i+1] = true;
      result[depth] = arr[i];
      backtrack(depth+1);
      visited[i+1] = false;
    }
  }

}
