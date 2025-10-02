package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1158_요세푸스_문제_Queue {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      queue.add(i+1);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (!queue.isEmpty()) {
        for (int j = 0; j < m-1; j++) {
          queue.add(queue.poll());
        }
        sb.append(queue.poll()).append(", ");
    }
    System.out.println(sb.delete(sb.length()-2, sb.length()).append(">"));
  }

}
