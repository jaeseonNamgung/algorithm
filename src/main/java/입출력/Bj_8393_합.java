package 입출력;

import java.util.Scanner;

public class Bj_8393_합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.next());

    int result = 0;
    for (int i = 1; i <= n; i++) {
      result += i;
    }
    System.out.println(result);
  }
}
