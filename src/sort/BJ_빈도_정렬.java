package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_빈도_정렬 {
  static Map<Integer, Integer> map = new LinkedHashMap<>();
  static List<Integer> list = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    while(st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      list.add(num);
      if(!map.containsKey(num)) map.put(num, 1);
      else {
        map.compute(num, (k, count) -> count + 1);
      }
    }

    List<Map.Entry<Integer, Integer>> sortedList = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(
        Collectors.toList());

    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, Integer> entry : sortedList) {
      int value = map.get(entry.getKey());
      for (int i = 0; i < value; i++) {
        sb.append(entry.getKey()).append(" ");
      }
    }
    System.out.println(sb);


  }
}
