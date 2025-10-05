package stack;

import java.util.*;

public class BJ_10799_쇠막대기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String bar = sc.nextLine();
    char[] arr = new char[bar.length() + 1];
    int[] accLager = new int[bar.length() + 1];
    for (int i = 1; i <= bar.length(); i++) {
      arr[i] = bar.charAt(i - 1);
    }

    for (int i = 1; i < arr.length; i++) {
      accLager[i] = accLager[i - 1];
      if (arr[i] == '(' && arr[i + 1] == ')') {
        accLager[i + 1] = accLager[i]++;
      }
    }
    int count = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == '(' && arr[i + 1] != ')') {
        stack.push(i);
      } else if (arr[i] == ')' && arr[i - 1] != '(') {
        Integer startBar = stack.pop();
        count += (accLager[i] - accLager[startBar]) + 1;
      }
    }
    System.out.println(count);

  }
}
