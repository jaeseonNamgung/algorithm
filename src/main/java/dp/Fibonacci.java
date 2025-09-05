package dp;

import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(naiveRecursion(n));
  }

  private static int naiveRecursion(int n) {
    if(n <= 1) return n;
    return naiveRecursion(n-1) + naiveRecursion(n-2);
  }
}
