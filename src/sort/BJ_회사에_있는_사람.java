package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_회사에_있는_사람 {
  static Map<String, Integer> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    map = new LinkedHashMap<>();

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String person = st.nextToken();
      String count = st.nextToken();
      checkLog(person, count);
    }
    List<Map.Entry<String, Integer>> ans = map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toList());

    ans.forEach(a -> {
      if(a.getValue() == 0) {
        System.out.println(a.getKey());
      }
    });
  }

  public static void checkLog(String person, String log) {
    if ("enter".equals(log)) {
      map.put(person, 0);
    } else {
      map.put(person, 1);
    }
  }
}
