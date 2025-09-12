package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_단어정렬 {
  static String[] strArr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    strArr = new String[n];
    for (int i = 0; i < n; i++) {
      strArr[i] = sc.next();
    }

    Arrays.sort(strArr, (o1, o2) -> {
      if(o1.length() == o2.length()) {
        return o1.compareTo(o2);
      }
      return Integer.compare(o1.length(), o2.length());
    });

    String prev = "";
    for(String str : strArr) {
      if(str.equals(prev)) continue;
      System.out.println(str);
      prev = str;
    }

  }

}
