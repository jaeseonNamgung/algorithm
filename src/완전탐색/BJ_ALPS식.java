package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_ALPS식 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int X = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    List<Staff> staffs = new ArrayList<>();
    List<Score> scores = new ArrayList<>();

    int k = 0;
    while (N --> 0){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int vote = Integer.parseInt(st.nextToken());

      // 0.05% 보다 적은 스태프 제외
      if(vote < X*0.05) continue;

      staffs.add(new Staff(name, vote));

      // 1, 2, 3, ..., 14 로 나는 투표값
      for (int j = 0; j < 14; j++) {
        int v = staffs.get(k).vote/(j+1);
        staffs.get(k).arr.add(v);
      }
      k++;
    }

    // 이름순 정렬
    staffs.sort((Comparator.comparing(o -> o.name)));

    // 모든 스태프의 투표를 하나의 리스트에 통일
    for (Staff staff : staffs) {
      for (int j = 0; j < 14; j++) {
        String name = staff.name;
        int result = staff.arr.get(j);
        scores.add(new Score(name, result));
      }
    }

    // 하나로 모은 스태프 투표를 내림차순으로 정렬
    scores.sort((Comparator.comparing((Score o)-> o.chip).reversed()));

    // 상위 14개에 스태프에 이름으로 chip 갯수 출력
    for (Staff staff : staffs) {
      String name = staff.name;
      int count = 0;
      for (int j = 0; j < 14; j++) {
        if (name.equals(scores.get(j).name)) {
          count++;
        }
      }
      System.out.println(name + " " + count);
    }
  }

  public static class Score {
    String name;
    int    chip;
    public Score(final String name, final int chip) {
      this.name = name;
      this.chip = chip;
    }
  }

  public static class Staff{
    String name;
    int vote;
    List<Integer> arr = new ArrayList<>();

    public Staff(final String name, final int vote) {
      this.name = name;
      this.vote = vote;
    }
  }
}


