package 입출력;

import java.util.Scanner;

public class Bj_2739_구구단 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= 9; i++) {
      sb.append(n).append(" * ").append(i).append(" = ").append(n*i).append("\n");
    }
    System.out.println(sb);
  }
}
