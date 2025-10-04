package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BJ_9012_괄호2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());


    while(n --> 0) {
      String str = br.readLine();
      Deque<String> ps = new LinkedList<>();

      boolean isValid = true;
      for (int i = 0; i < str.length(); i++) {
        String s = String.valueOf(str.charAt(i));

        if ("(".equals(s)) ps.addLast(s);
        else {
          if (ps.isEmpty()) {
            isValid = false;
            break;
          }
          ps.removeLast();
        }
      }
      if(!isValid || !ps.isEmpty()) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
      }
    }
  }
}
