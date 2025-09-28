package binarySearch;

import java.util.*;

public class BJ_2295_세_수의_합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    List<Integer> sums = new ArrayList<>();


    for(int i = 0; i < n; i++) {
      for(int j = i; j < n; j++) {
        sums.add(arr[i] + arr[j]);
      }
    }

    int ans = 0;
    Collections.sort(sums);
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (isExist(sums, (arr[i] - arr[j]))) {
          ans = Math.max(ans, arr[i]);
        }
      }
    }

    System.out.println(ans);

  }

  public static boolean isExist(List<Integer> sums, int value) {

    int l=0, r=sums.size() - 1;
    while(l <= r) {
      int mid = (l+r)/2;

      if(sums.get(mid) < value) l = mid + 1;
      else if(sums.get(mid) > value) r = mid - 1;
      else return true;
    }

    return false;
  }
}
