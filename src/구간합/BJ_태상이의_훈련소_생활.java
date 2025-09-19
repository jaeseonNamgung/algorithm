package 구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_태상이의_훈련소_생활 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] grounds = new int[N+1];
    int[] sum = new int[N+2];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      grounds[i] = Integer.parseInt(st.nextToken());
    }


    while(M-->0) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      sum[a] += k;
      sum[b+1] += (-k);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i-1] + sum[i];
      sb.append(grounds[i] + sum[i]).append(" ");
    }
    System.out.println(sb);

  }
}
