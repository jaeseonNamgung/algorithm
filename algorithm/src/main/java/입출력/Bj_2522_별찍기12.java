package 입출력;

import java.util.Scanner;

public class Bj_2522_별찍기12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    StringBuffer sb = new StringBuffer();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if(j <= n-i) {
          sb.append(" ");
        }else {
          sb.append("*");
        }
      }
      sb.append("\n");
    }
    for (int i = n-1; i >= 1; i--) {
      for (int j = 1; j <= n; j++) {
        if(j<= n-i) {
          sb.append(" ");
        }else {
          sb.append("*");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
