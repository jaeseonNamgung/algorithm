package 입출력;

import java.util.Scanner;

public class Bj_2442_별찍기5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n-i ; j++) {
        sb.append(" ");
      }
      for (int j = 1; j <= (2*i)-1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    };
    System.out.println(sb);
  }
}
