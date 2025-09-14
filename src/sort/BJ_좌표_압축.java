package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_좌표_압축 {
  static List<Integer> coordList = new ArrayList<>();
  static Set<Integer> coordSet = new HashSet<>();
  static int[] arrCoord;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    while(n --> 0) {
      int x = Integer.parseInt(st.nextToken());
      coordList.add(x);
      coordSet.add(x);
    }

    Map<Integer, Integer> coordMap = new LinkedHashMap<>();
    int index = 0;
    for(int i : coordSet.stream().sorted().collect(Collectors.toList())) {
      coordMap.put(i, index++);
    }

    StringBuilder sb = new StringBuilder();
    for (Integer coord : coordList) {
      sb.append(coordMap.get(coord)).append(" ");
    }
    System.out.println(sb);
  }
}
