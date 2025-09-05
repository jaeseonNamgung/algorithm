package 입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1924_2007년 {
  static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  static String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int totalDays = 0;
    for (int i = 0; i < x-1; i++) {
      totalDays += days[i];
    }
    System.out.println(week[(totalDays + y) % 7]);

  }
}
