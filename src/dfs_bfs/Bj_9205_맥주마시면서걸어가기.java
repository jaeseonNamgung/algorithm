package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_9205_맥주마시면서걸어가기 {
  static class Position {
    int x;
    int y;
    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public boolean distance(int x, int y) {
      return Math.abs(this.x - x) + Math.abs(this.y - y) <= 1000;
    }
  }
  static int N;
  static Position[] positions;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t --> 0) {
      N = Integer.parseInt(br.readLine());
      visited = new boolean[N+2];
      positions = new Position[N+2];

      for (int i = 0; i < N + 2; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        positions[i] = new Position(x, y);
      }
      System.out.println(bfs() ? "happy" : "sad");
    }

  }
  public static boolean bfs() {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      Position current = positions[now];

      if (now == N + 1) return true;

      for (int i = 0; i < positions.length; i++) {
        if(!visited[i] && current.distance(positions[i].x, positions[i].y)) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
    return false;
  }
}
