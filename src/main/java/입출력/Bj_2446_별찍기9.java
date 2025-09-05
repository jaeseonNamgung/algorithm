package 입출력;

import java.util.Scanner;

public class Bj_2446_별찍기9 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
    int count = n * 2 - 1;
    for (int i = 1; i <= n; i++) {
        sb.append(" ".repeat(i-1));
        sb.append("*".repeat(count));
        count -=2;
        sb.append("\n");
    }

    count = 3;
    for (int i = 1; i <= n-1; i++) {
        sb.append(" ".repeat(n-i-1));
        sb.append("*".repeat(count));
        count +=2;
        sb.append("\n");
    }
    System.out.println(sb);
  }
}
