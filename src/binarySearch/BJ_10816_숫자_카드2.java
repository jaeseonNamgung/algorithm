package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_10816_숫자_카드2 {
  static int[] cards, queries;
  static Set<Integer> uniqueCards = new HashSet<>();
  static List<Integer> sortedUniqueCards = new ArrayList<>();
  static Map<Integer, Integer> cardCountMap = new LinkedHashMap<>();
  static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    cards = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(st.nextToken());
      cardCountMap.put(num, cardCountMap.getOrDefault(num, 0) + 1);
      uniqueCards.add(num);
    }

    sortedUniqueCards = uniqueCards.stream().sorted().collect(Collectors.toList());

    m = Integer.parseInt(br.readLine());
    queries = new int[m];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      queries[i] = Integer.parseInt(st.nextToken());
    }

    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int count = binarySearch(queries[i]);
      results.add(count);
    }

    StringBuilder sb = new StringBuilder();
    for (Integer count : results) {
      sb.append(count).append(" ");
    }
    System.out.println(sb);
  }

  private static int binarySearch(final int target) {
    int l = 0, r = sortedUniqueCards.size() - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (sortedUniqueCards.get(mid) < target) l = mid + 1;
      else if (sortedUniqueCards.get(mid) > target) r = mid - 1;
      else return cardCountMap.get(sortedUniqueCards.get(mid));
    }
    return 0;
  }
}
