package 재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_부분수열의합 {
  static int N, M;
  static int[] numbers;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    numbers = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    solve(0, 0);

    System.out.println(result);

  }

  private static void solve(int i, int sum) {

    if (i == numbers.length) return;
    if (sum + numbers[i] == M) result++;

    solve(i + 1, sum + numbers[i]); // 왼쪽 재귀 (포함)
    solve(i + 1, sum);               // 오른쪽 재귀 (제외)

  }
}
