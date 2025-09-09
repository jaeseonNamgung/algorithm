package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_행운의바퀴 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    char[] wheel = new char[N];

    for (int i = 0; i < N; i++) {
      wheel[i] = '?';
    }

    int curIndex = 0;
    while (K-- > 0) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      char str = st.nextToken().charAt(0);

      int nextIndex = ((curIndex - i) % N + N) % N;

      if (wheel[nextIndex] == '?') {
        wheel[nextIndex] = str;
      }
      else if (wheel[nextIndex] != str) {
        System.out.println("!");
        return;
      }
      curIndex = nextIndex;
    }

    boolean checkDuplicate = false;
    for (int i = 0; i < N-1; i++) {
      for (int j = i+1; j < N ; j++) {
        if (wheel[i] != '?' && wheel[i] == wheel[j]) {
          checkDuplicate = true;
          break;
        }
      }
    }
    if(checkDuplicate) {
      System.out.println("!");
    } else {
      for (int i = 0; i < wheel.length; i++) {
        System.out.print(wheel[(curIndex+i)%N]);
      }
    }

  }
}
