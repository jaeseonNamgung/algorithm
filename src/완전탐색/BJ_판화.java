package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
* 1. 상하좌우 체크
* 2. 상 또는 하에서 좌우 이동하는지 체크
* 3. 좌 또는 우에서 상하로 이동하는지 체크
* */
public class BJ_판화 {
  static int N;
  static char[][] passVertical;
  static char[][] passHorizon;
  static char[][] result;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    String moveStr = br.readLine();
    passVertical = new char[N][N];
    passHorizon = new char[N][N];
    result = new char[N][N];

    int c = 0, r = 0;
    for(char move : moveStr.toCharArray()) {
      if(move == 'U') {
        if(c == 0) continue;
        passVertical[c][r] = '|';
        passVertical[c-1][r] = '|';
        c--;
      } else if(move == 'D') {
        if(c == N-1) continue;
        passVertical[c][r] = '|';
        passVertical[c+1][r] = '|';
        c++;
      } else if(move == 'L') {
        if(r == 0) continue;
        passHorizon[c][r] = '-';
        passHorizon[c][r-1] = '-';
        r--;
      } else {
        if(r == N-1) continue;
        passHorizon[c][r] = '-';
        passHorizon[c][r+1] = '-';
        r++;
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if(passVertical[i][j] == '|' && passHorizon[i][j] == '-') {
          result[i][j] = '+';
        } else if (passVertical[i][j] == '|') {
          result[i][j] = '|';
        } else if (passHorizon[i][j] == '-') {
          result[i][j] = '-';
        }else {
          result[i][j] = '.';
        }
        System.out.print(result[i][j]);
      }
      System.out.println();

    }


  }

}
