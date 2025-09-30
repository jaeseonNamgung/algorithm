package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470_두_용액 {
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int left = 0, right = arr.length-1;
    int minAbs = Integer.MAX_VALUE;
    int ans1 = 0, ans2 = 0;

    while(left < right) {
      int sum = arr[left] + arr[right];
      int absSum = Math.abs(sum);

      if(absSum < minAbs) {
        minAbs = absSum;
        ans1 = arr[left];
        ans2 = arr[right];
      }

      if(sum < 0) left++;
      else right--;
    }

    System.out.println(ans1 + " " + ans2);
  }


}
