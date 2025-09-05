package backtracking;

import java.util.Scanner;

public class Bj_유레카이론 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] tj = new int[46];

        for(int i = 1; i <= 45; i++) {
            tj[i] = i * (i + 1) / 2;
        }

        boolean possible = false;
        while(N --> 0) {

            int value = sc.nextInt();
            outer:
            for(int i = 1; i <= 45; i++) {
                for (int j = 1; j <= 45; j++) {
                    for (int k = 1; k <= 45; k++) {
                        if(tj[i] + tj[j] + tj[k] == value) {
                            possible = true;
                            break outer;
                        }
                    }
                }
            }

            if(possible) {
                System.out.println(1);
                possible = false;
            }else {
                System.out.println(0);
            }
        }

    }
}
