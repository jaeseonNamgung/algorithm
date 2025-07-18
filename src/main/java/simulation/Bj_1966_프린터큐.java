package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj_1966_프린터큐 {
  static class Document {
    int index;
    int priority;

    Document(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      Queue<Document> queue = new LinkedList<>();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        int priority = Integer.parseInt(st.nextToken());
        Document document = new Document(j, priority);
        queue.add(document);
        pq.add(priority);
      }

      int printOrder = 0;
      while (!queue.isEmpty()) {
        Document doc = queue.poll();
        if(doc.priority == pq.peek()) {
          pq.poll();
          printOrder++;
          if(doc.index == m) {
            System.out.println(printOrder);
            break;
          }
        }else {
          queue.add(doc);
        }


      }

    }


  }
}
