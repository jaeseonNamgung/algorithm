package 입출력;

import java.util.Scanner;

public class Bj_2742_기찍N {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());

    StringBuffer sb = new StringBuffer();
    do {
      sb.append(n).append("\n");
    } while (n-- > 1);
    System.out.println(sb);
  }
}
