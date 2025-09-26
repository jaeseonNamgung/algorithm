package programmers;

import java.util.*;
import java.io.*;

class 달리기_경주 {
  public String[] solution(String[] players, String[] callings) {
    Map<String, Integer> map = new HashMap<>();

    for(int i = 0; i < players.length; i++) {
      map.put(players[i], i);
    }

    for (int i = 0; i < callings.length; i++) {
      String nowPlayer = callings[i];
      int rank = map.get(nowPlayer);
      String prePlayer = players[rank-1];
      map.put(prePlayer, rank);
      map.put(nowPlayer, rank-1);
      swap(players,rank-1, rank);
    }
    return players;
  }

  public void swap (String[] players, int preRank, int nowRank) {
    String temp = players[preRank];
    players[preRank] = players[nowRank];
    players[nowRank] = temp;
  }
}
