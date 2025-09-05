package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_성지키기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    String[][] arr = new String[a][b];

    for (int i = 0; i < a; i++) {
       st = new StringTokenizer(br.readLine());
       String s = st.nextToken();
      for (int j = 0; j < b; j++) {
        arr[i][j] = String.valueOf(s.charAt(j));
      }
    }

    boolean hasGuard = false;
    int rowCount = 0;
    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        if("X".equals(arr[i][j])) {
          hasGuard = true;
          break;
        }
      }
      if(!hasGuard){
        rowCount ++;
      }else {
        hasGuard = false;
      }
    }

    int colCount = 0;
    for (int j = 0; j < b; j++) {
      for (int i = 0; i < a; i++) {
        if("X".equals(arr[i][j])) {
          hasGuard = true;
          break;
        }
      }
      if(!hasGuard){
        colCount ++;
      }else {
        hasGuard = false;
      }
    }

    System.out.println(Math.max(colCount, rowCount));

  }
}
