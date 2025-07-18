package backtracking;


/*
1. A가 5승일 경우 적어도 5개 팀에 1패가 무조건 있어야함
2. A가 4승일 경우 적어도 5개 팀 중 4개 팀에 1패가 무조건 있어야함
3. A가 1무가 있을 경우 적어도 5개 팀 중 1개 팀에 1무가 있어야함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj_6987_월드컵 {

  static List<int[]> games  = new ArrayList<>();
  static int[][]     score  = new int[6][3];
  static boolean     possible;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < 6; i++) {
      for (int j = i + 1; j < 6; j++) {
        games.add(new int[] {i, j});
      }
    }

    for (int tc = 0; tc < 4; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      possible = false;

      int totalW = 0, totalD = 0, totalL = 0;
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 3; j++) {
          score[i][j] = Integer.parseInt(st.nextToken());
        }

        totalW += score[i][0];
        totalD += score[i][1];
        totalL += score[i][2];
      }

      if (totalW == totalL && totalD % 2 == 0 && totalW + totalD + totalL == 30) {
        dfs(0);
      }
      sb.append(possible ? "1":"0").append(" ");
    }
    System.out.println(sb);

  }

  public static void dfs(int depth) {
    if(possible){
      return;
    }
    if(depth == games.size()) {
      possible = true;
      return;
    }

    int[] g = games.get(depth);
    int a = g[0], b = g[1];

    if(score[a][0] > 0 && score[b][2] > 0) {
      score[a][0]--;
      score[b][2]--;
      dfs(depth+1);
      score[a][0]++;
      score[b][2]++;
    }

    if(score[a][1] > 0 && score[b][1] > 0) {
      score[a][1]--;
      score[b][1]--;
      dfs(depth+1);
      score[a][1]++;
      score[b][1]++;
    }
    if(score[a][2] > 0 && score[b][0] > 0) {
      score[a][2]--;
      score[b][0]--;
      dfs(depth+1);
      score[a][2]++;
      score[b][0]++;
    }

  }
}
