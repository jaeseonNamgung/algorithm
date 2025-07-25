package 입출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_11721_열개씩끊어출력하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    String[] strArr = new String[str.length()];
    for (int i = 0; i < str.length(); i++) {
      strArr[i] = String.valueOf(str.charAt(i));
    }

    if(strArr.length <= 10) {
      System.out.println(str);
      return;
    }
    System.out.println(str.substring(0, 10));
    StringBuffer sb = new StringBuffer();
    int add = 19;
    for (int i = 10; i < strArr.length; i++) {
      sb.append(strArr[i]);
      if(i == add){
        add += 10;
        sb.append("\n");
      }
    }
    System.out.println(sb);

  }
}
