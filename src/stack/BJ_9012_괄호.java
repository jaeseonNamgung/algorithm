package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_9012_괄호 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());


    while(n --> 0) {
      String str = br.readLine();
      Deque<String> bracket = new LinkedList<>();
      for (int i = 0; i < str.length(); i++) {
        bracket.addLast(String.valueOf(str.charAt(i)));
      }

      int leftCount = 0, rightCount = 0;
      while(!bracket.isEmpty()) {
        String s = bracket.removeLast();

        if(")".equals(s)) rightCount++;
        else if ("(".equals(s)) {
          leftCount++;
          if(leftCount > rightCount) {
            break;
          }
        } else {
          leftCount = 0;
          rightCount = 0;
        }

      }

      if (leftCount == rightCount) System.out.println("YES");
      else {
        System.out.println("NO");
      }

    }
  }
}
