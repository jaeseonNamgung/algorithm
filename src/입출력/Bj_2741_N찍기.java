package 입출력;

import java.util.Scanner;

public class Bj_2741_N찍기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= n; i++) {
      sb.append(i).append("\n");
    }
    System.out.println(sb);
  }
}
