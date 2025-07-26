package 입출력;

import java.util.Scanner;

public class Bj_2440_별찍기3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
     do {
      sb.append("*".repeat(Math.max(0, n)));
      sb.append("\n");
    } while (n --> 0);
    System.out.println(sb);
  }
}
