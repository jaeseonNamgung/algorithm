package 입출력;

import java.util.Scanner;

public class Bj_10991_별찍기16 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= n; i++) {
      sb.append(" ".repeat(n-i));
      sb.append("* ".repeat(i));
      sb.append("\n");
    }
    System.out.println(sb);

  }
}
