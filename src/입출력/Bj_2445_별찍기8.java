package 입출력;
import java.util.Scanner;

public class Bj_2445_별찍기8 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= n; i++) {
      sb.append("*".repeat(i));
      sb.append(" ".repeat((n*2)-(i*2)));
      sb.append("*".repeat(i));
      sb.append("\n");
    }
    for (int i = n-1; i >= 1; i--) {
      sb.append("*".repeat(i));
      sb.append(" ".repeat((n*2)-(i*2)));
      sb.append("*".repeat(i));
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
