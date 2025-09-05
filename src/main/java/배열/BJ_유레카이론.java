package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_유레카이론 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Integer> tri = new ArrayList<>();
    for (int i = 1; i <= 45; i++) {
      int t = i * (i+1)/2;
      tri.add(t);
    }

    for (int i = 0; i < 45; i++) {
      for (int j = 0; j < 45; j++) {
        for (int k = 0; k < 45; k++) {

        }
      }
    }

  }
}
