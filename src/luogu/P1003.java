package luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1003 {
    static class Carpet {
        private int x;
        private int y;
        private int xLength;
        private int yLength;

        Carpet(int x, int y, int xl, int yl) {
            this.x = x;
            this.y = y;
            this.xLength = xl;
            this.yLength = yl;
        }

        boolean isContain(int tx, int ty) {
            return (((this.x <= tx) && (this.x + this.xLength - 1 >= tx)) && ((this.y <= ty) && (this.y + this.yLength - 1 >= ty)));
        }
    }

    public static void main(String args[]) {

        Scanner cin = new Scanner(System.in);
        int n, i;
        List<Carpet> carpetList = new ArrayList<Carpet>();

        Carpet carpet;

        int x, y, xl, yl, targetX, targetY;

        n = cin.nextInt();
        for (i = 0; i < n; i++) {
            x = cin.nextInt();
            y = cin.nextInt();
            xl = cin.nextInt();
            yl = cin.nextInt();
            carpet = new Carpet(x, y, xl, yl);
            carpetList.add(carpet);
        }

        targetX = cin.nextInt();
        targetY = cin.nextInt();

        int ans = -1;
        for (Carpet carpet1 : carpetList) {
            if (carpet1.isContain(targetX, targetY)) {
                ans = carpetList.indexOf(carpet1) + 1;
            }
        }

        System.out.println(ans);
    }
}

