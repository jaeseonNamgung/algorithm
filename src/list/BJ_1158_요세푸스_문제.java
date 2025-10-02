package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1158_요세푸스_문제 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(i+1);
    }

    StringBuilder sb = new StringBuilder();
    boolean[] removed = new boolean[n];

    int cnt;
    int currentCnt = 0;
    sb.append("<");
    for (int i = 0; i < n; i++) {
      cnt = 0;
      while(cnt < m) {
        currentCnt = currentCnt % n;
        if(!removed[currentCnt]) {
          cnt++;
          if(cnt == m) break;
        }
        currentCnt++;
      }
      removed[currentCnt] = true;
      sb.append(arr.get(currentCnt)).append(", ");
      currentCnt++;
    }
    System.out.println(sb.delete(sb.length()-2, sb.length()).append(">"));
  }

}
