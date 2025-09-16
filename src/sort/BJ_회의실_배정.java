package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ_회의실_배정 {

  static List<MeetingRoom> meetingRooms = new ArrayList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      meetingRooms.add(new MeetingRoom(start, end));
    }

    meetingRooms.sort(Comparator.comparing((MeetingRoom meetingRoom) -> meetingRoom.end)
                                                 .thenComparing((MeetingRoom meetingRoom) -> meetingRoom.start));

    int ans = 0;
    int lastEnd = 0;
    for (MeetingRoom meetingRoom : meetingRooms) {
      if(meetingRoom.start >= lastEnd) {
        lastEnd = meetingRoom.end;
        ans++;
      }
    }
    System.out.println(ans);

  }

  public static class MeetingRoom {
    int start;
    int end;

    public MeetingRoom(final int start, final int end) {
      this.start = start;
      this.end = end;
    }
  }
}
