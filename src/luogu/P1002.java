package luogu;

import java.util.Scanner;

public class P1002 {
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int bx = cin.nextInt();
        int by = cin.nextInt();
        int mx = cin.nextInt();
        int my = cin.nextInt();

        int i, j;
        long ma[][] = new long[21][21];
        for (i = 0; i < 21; i++) {
            for (j = 1; j < 21; j++) {
                ma[i][j] = 0;
            }
        }

        ma[0][0] = 1;

        ma[mx][my] = -1;
        if (mx - 2 > -1) {
            if (my + 1 < 21) {
                ma[mx - 2][my + 1] = -1;
            }
            if (my - 1 > -1) {
                ma[mx - 2][my - 1] = -1;
            }
        }
        if (mx - 1 > -1) {
            if (my + 2 < 21) {
                ma[mx - 1][my + 2] = -1;
            }
            if (my - 2 > -1) {
                ma[mx - 1][my - 2] = -1;
            }
        }
        if (mx + 2 < 21) {
            if (my + 1 < 21) {
                ma[mx + 2][my + 1] = -1;
            }
            if (my - 1 > -1) {
                ma[mx + 2][my - 1] = -1;
            }
        }
        if (mx + 1 < 21) {
            if (my + 2 < 21) {
                ma[mx + 1][my + 2] = -1;
            }
            if (my - 2 > -1) {
                ma[mx + 1][my - 2] = -1;
            }
        }

        for (j = 1; j <= by; j++) {
            if (ma[0][j] != -1) {
                ma[0][j] = ma[0][j - 1];
            }
        }

        for (i = 1; i <= bx; i++) {
            if (ma[i][0] != -1) {
                ma[i][0] = ma[i - 1][0];
            }
        }

        for (i = 1; i <= bx; i++) {
            for (j = 1; j <= by; j++) {
                if (ma[i][j] != -1) {
                    ma[i][j] = (ma[i - 1][j] > 0 ? ma[i - 1][j] : 0) + (ma[i][j - 1] > 0 ? ma[i][j - 1] : 0);
                }
            }
        }

        System.out.println(ma[bx][by]);


//        for (i=0;i<=bx;i++)
//        {
//            for (j=0;j<=by;j++){
//                System.out.print(ma[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
