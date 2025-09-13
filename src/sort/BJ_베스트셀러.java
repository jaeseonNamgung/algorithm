package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BJ_베스트셀러 {
  static Map<String, Integer> map = new LinkedHashMap<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    for(int i = 0; i < n; i++) {
      String book = br.readLine();

      if(!map.containsKey(book)) map.put(book, 1);
      else {
        Integer count = map.get(book) + 1;
        map.put(book, count);
      }
    }

    List<Map.Entry<String, Integer>> ansMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());

    int max = 0;
    String bestSeller = "";
    for (Map.Entry<String, Integer> ans : ansMap) {
      if(max < ans.getValue()){
          max = ans.getValue();
          bestSeller = ans.getKey();
      }
    }
    System.out.println(bestSeller);

  }


}
