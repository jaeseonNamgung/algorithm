package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Bj_7576_토마토 {

  static class Tomato {
    int x;
    int y;
    int day;

    Tomato(int x, int y, int day) {
      this.x = x;
      this.y = y;
      this.day = day;
    }
  }
  static int M, N;
  static int[][] box;
  static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static Queue<Tomato> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    box = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        if(box[i][j] == 1) {
          queue.offer(new Tomato(i, j, 0));
        }
      }
    }

    bfs();
  }

  public static void bfs() {
    int today = 0;
    while (!queue.isEmpty()) {
      Tomato now = queue.poll();
      today = now.day;
      for (int[] d : dir) {
        int nowN = now.x + d[0];
        int nowM = now.y + d[1];

        if(nowN >= 0 && nowN < N && nowM >= 0 && nowM < M && box[nowN][nowM] == 0) {
          box[nowN][nowM] = 1;
          queue.offer(new Tomato(nowN, nowM, today+1));
        }
      }
    }

    if(checkTomato()) {
      System.out.println(today);
    }else {
      System.out.println(-1);
    }
  }

  public static boolean checkTomato() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(box[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

}
