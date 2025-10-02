package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_15828_Router {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Queue<Integer> queue = new LinkedList<>();

    while (true) {
      int num = sc.nextInt();
      if(num <= -1) break;

      if(num == 0) queue.poll();
      else {
        if(queue.size() < n) queue.add(num);
      }


    }

    if(queue.isEmpty()) System.out.println("empty");
    else {
      StringBuilder sb = new StringBuilder();
      for (Integer i : queue) {
        sb.append(i).append(" ");
      }
      System.out.println(sb);
    }
  }
}
