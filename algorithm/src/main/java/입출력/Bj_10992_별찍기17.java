package 입출력;

import java.util.Scanner;

public class Bj_10992_별찍기17 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
    sb.append(" ".repeat(n-1)).append("*").append("\n");
    int count = 1;
    for (int i = 2; i < n; i++) {
        sb.append(" ".repeat(n-i));
        sb.append("*");
        sb.append(" ".repeat(count));
        sb.append("*");
        sb.append("\n");
        count +=2;
    }
    if(n != 1) {
      sb.append("*".repeat(n*2-1));
    }

    System.out.println(sb);
  }
}
