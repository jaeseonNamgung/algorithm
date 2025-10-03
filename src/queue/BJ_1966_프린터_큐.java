package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1966_프린터_큐 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    while(t --> 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      Queue<Printer> queue = new LinkedList<>();
      Queue<Printer> resultQueue = new LinkedList<>();
      List<Integer> arr = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(st.nextToken());
        arr.add(num);
        queue.add(new Printer(i, num));
      }
      arr.sort(Collections.reverseOrder());

      while(!queue.isEmpty()) {
        Printer p = queue.poll();
        int maxValue = arr.get(0);
        if (p.importance >= maxValue) {
          resultQueue.add(p);
          arr.remove(0);
        } else {
          queue.add(p);
        }
      }

      int idx = 1;
      while(!resultQueue.isEmpty()) {
        Printer p = resultQueue.poll();
        if(p.order == m) {
          System.out.println(idx);
          break;
        }
        idx++;
      }


    }

  }
  public static class Printer{
    int order;
    int importance;

    public Printer(final int order, final int importance) {
      this.order = order;
      this.importance = importance;
    }
  }
}
