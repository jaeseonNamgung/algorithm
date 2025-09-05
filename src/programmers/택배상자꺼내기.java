package programmers;

/*
* 1. 홀수: 왼쪽 -> 오른쪽
* 2. 짝수: 오른쪽 -> 왼쪽
* 3. num 발견할 경우 그 row를 저장
* */

class Solution {
  public int solution(int n, int w, int num) {

    int row = (int) Math.ceil((double) n/w);
    int[][] arr = new int[row][w];

    int answer = 0;
    int value = 1;
    int targetRow = 0;
    int targetCol = 0;
    for(int i = 0; i < row; i++) {
      if(i%2 == 0) {
        for (int j = 0; j < w; j++) {
          if(value > n) break;
          if(value == num) {
            targetRow = i;
            targetCol = j;
          }
          arr[i][j] = value++;

        }
      }else {
        for(int j=w-1; j>=0; j--) {
          if(value > n) break;
          if(value == num) {
            targetRow = i;
            targetCol = j;
          }
          arr[i][j] = value ++;
        }
      }
    }

    for(int i = targetRow; i < row; i++) {
        answer++;
    }


    return answer;
  }
}
