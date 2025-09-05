package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_진법변환2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    StringBuilder ans = new StringBuilder();
    while (N > 0) {
      int digit = N % B;

      if(digit < 10) ans.append(digit);
      else ans.append((char) ('A' + digit - 10));
      N /= B;
    }

    for (int i = ans.length()-1; i >= 0 ; i--) {
      System.out.print(ans.charAt(i));
    }
  }
}
