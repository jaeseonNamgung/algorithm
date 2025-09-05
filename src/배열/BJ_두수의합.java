package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_두수의합 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int x = Integer.parseInt(br.readLine());
    Arrays.sort(arr);

    int count = 0;
    for (int i = 0; i < n; i++) {
      int temp = arr[i];
      for (int j = i+1; j < n; j++) {
        if((temp + arr[j]) == x) {
          count++;
        }
        if((temp + arr[j]) > x) break;
      }
    }

    System.out.println(count);
  }
}
