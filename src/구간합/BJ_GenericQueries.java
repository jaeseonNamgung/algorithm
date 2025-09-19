package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_GenericQueries {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());
    int[] arr = new int[N + 1];
    int[] xor = new int[N + 1];

    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      xor[i] = arr[i] ^ xor[i - 1];
    }

    int result = 0;
    for (int i = 0; i < Q; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      result ^= xor[b] ^ xor[a-1];
    }
    System.out.println(result);
  }
}
