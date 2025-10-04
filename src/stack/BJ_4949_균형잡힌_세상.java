package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_4949_균형잡힌_세상 {
  static Deque<Character> stack;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      String line = br.readLine();
      stack = new ArrayDeque<>();
      if('.' == line.charAt(0)) break;

      if(isBalanced(line)) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }

  public static boolean isBalanced(String line) {
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);

      if('(' == c || '[' == c) {
        stack.push(c);
      }
      else if (')' == c) {
        if (stack.isEmpty() || '(' != stack.pop()) return false;
      }
      else if (']' == c){
        if (stack.isEmpty() || '[' != stack.pop()) return false;
      }
    }

    return stack.isEmpty();
  }
}
