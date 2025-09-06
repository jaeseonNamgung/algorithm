package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 1. 교환 가능한 사탕인지 체크
*   1-1. 인접한 사탕이 다른 사탕일 경우 스왑
*   1-2. 인접한 사탕이 같은 사탕일 경우 연속된 사탕의 크기를 검사
* 2. 크기를 비교하며 가장 긴 사탕을 검사
*
* */

public class BJ_사탕게임 {
  static String[][] arr;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(sb.readLine());

    arr = new String[N][N];
    for (int i = 0; i < N; i++) {
      String str = sb.readLine();
      for (int j = 0; j < str.length(); j++) {
        arr[i][j] = String.valueOf(str.charAt(j));
      }
    }

    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(i+1 < N && !arr[i][j].equals(arr[i+1][j])) {
          swapCandy(i, j, i+1, j);
          ans = Math.max(ans, Math.max(findColumn(), findRow()));
          swapCandy(i+1, j, i, j);
        }
        if(j+1 < N && !arr[i][j].equals(arr[i][j+1])) {
          swapCandy(i, j, i, j+1);
          ans = Math.max(ans, Math.max(findColumn(), findRow()));
          swapCandy(i, j+1, i, j);
        }
      }
    }

    System.out.println(ans);
  }
  private static void swapCandy(int i, int j, int changeI, int changeJ) {
    String temp = arr[i][j];
    arr[i][j] = arr[changeI][changeJ];
    arr[changeI][changeJ] = temp;
  }
  private static int findRow() {
    int maxRow = 0;
    for (int i = 0; i < N; i++) {   // 행 고정
      int len = 1;
      for (int j = 1; j < N; j++) {  // 열 이동
        if (arr[i][j].equals(arr[i][j - 1])) {
          len++;
        } else {
          maxRow = Math.max(maxRow, len);
          len = 1;
        }
      }
      maxRow = Math.max(maxRow, len);
    }
    return maxRow;
  }

  private static int findColumn() {
    int maxCol = 0;
    for (int j = 0; j < N; j++) {   // 열 고정
      int len = 1;
      for (int i = 1; i < N; i++) {  // 행 이동
        if (arr[i][j].equals(arr[i - 1][j])) {
          len++;
        } else {
          maxCol = Math.max(maxCol, len);
          len = 1;
        }
      }
      maxCol = Math.max(maxCol, len);
    }
    return maxCol;
  }
}
