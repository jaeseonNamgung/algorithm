package 입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_10818_최소최대2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int value;
    for (int i = 0; i < n; i++) {
      value = Integer.parseInt(st.nextToken());
      min = Math.min(min, value);
      max = Math.max(max, value);
    }

    System.out.println(min + " " + max);

  }
}
