package 입출력;

import java.util.Scanner;

public class Bj_2438_별찍기1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= n; i++) {
      int value = i;
      while (value-->0) {
        sb.append("*");
      }
      sb.append("\n");
    }
    System.out.println(sb);

  }
}
