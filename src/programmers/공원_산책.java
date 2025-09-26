package programmers;
import java.util.*;
import java.io.*;

public class 공원_산책 {
  public static void main(String[] args) {
    String[] park = new String[] {"SOO", "OXX", "OOO"};
    String[] routes = new String[] {"E 2", "S 2", "W 1"};

    Arrays.stream(solution(park, routes)).forEach(System.out::println);
  }
  public static int[] solution(String[] park, String[] routes) {

    int x = park.length;
    int y = park[0].length();
    String[][] parks = new String[x][y];

    int nowX = 0;
    int nowY = 0;
    for(int i = 0; i < x; i++) {
      for(int j = 0; j < y; j++) {
        String p = String.valueOf(park[i].charAt(j));
        if("S".equals(p)) {
          nowX = i;
          nowY = j;
        }
        parks[i][j] = p;
      }
    }

    for (String route : routes) {
      StringTokenizer st = new StringTokenizer(route);
      String op = st.nextToken();
      int n = Integer.parseInt(st.nextToken());

      if ("X".equals(op)) continue;

      if ("N".equals(op) && nowX - n >= 0) {
        if (checkXObstacle(parks, nowX-n, nowX, nowY)) continue;
        nowX -= n;
      } else if ("S".equals(op) && nowX + n < x) {
        if (checkXObstacle(parks, nowX, nowX+n, nowY)) continue;
        nowX += n;
      } else if ("W".equals(op) && nowY - n >= 0) {
        if (checkYObstacle(parks, nowX, nowY-n, nowY)) continue;
        nowY -= n;
      } else if ("E".equals(op) && nowY + n < y) {
        if (checkYObstacle(parks, nowX, nowY, nowY+n)) continue;
        nowY += n;
      }
    }

    return new int[] {nowX, nowY};
  }

  public static boolean checkXObstacle(String[][] parks, int startX, int endX, int y) {
    for (int i = startX; i <= endX; i++) {
      if("X".equals(parks[i][y])) return true;
    }
    return false;
  }
  public static boolean checkYObstacle(String[][] parks, int x, int startY, int endY) {
    for (int i = startY; i <= endY; i++) {
      if("X".equals(parks[x][i])) return true;
    }
    return false;
  }
}
