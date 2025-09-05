package backtracking;

import java.util.Scanner;

public class BJ_회문인수 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();

    while(T --> 0) {
      int a = sc.nextInt();

      boolean checkValue = false;
      for (int i = 2; i <= 64; i++) {
        StringBuilder sb = new StringBuilder();
        int temp = a;
        while (temp > 0) {
          int digit = temp%i;
          if(digit < 10) sb.append(digit);
          else sb.append((char)('A' + digit - 10));
          temp /= i;
        }
        checkValue = sb.toString().contentEquals(sb.reverse().toString());
        if (checkValue) {
          break;
        }
      }
      System.out.println(checkValue ? 1 : 0);
    }
  }
}
