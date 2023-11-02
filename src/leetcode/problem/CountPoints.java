package leetcode.problem;

/**
 * 2103. 环和杆
 * https://leetcode.cn/problems/rings-and-rods/
 */
public class CountPoints {
    public int countPoints(String rings) {
        int n = rings.length() / 2;
        char c;
        int d;
        short[] array = new short[10];

        for (int i = 0; i < n; i++) {
            c = rings.charAt(2 * i);
            d = rings.charAt(2 * i + 1) - '0';
            switch (c) {
                case 'R' -> array[d] |= (1 << 2);
                case 'G' -> array[d] |= (1 << 1);
                case 'B' -> array[d] |= 1;
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 7) {
                count++;
            }
        }
        return count;
    }
}
