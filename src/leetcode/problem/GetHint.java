package leetcode.problem;

/**
 * 299. 猜数字游戏
 * https://leetcode-cn.com/problems/bulls-and-cows/
 */
public class GetHint {
    public String getHint(String secret, String guess) {
        char[] a1 = secret.toCharArray();
        char[] a2 = guess.toCharArray();
        int[] record = new int[10];
        int x = 0;
        int y = 0;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == a2[i]) {
                x++;
            } else {
                record[a1[i] - '0']++;
            }
        }
        for (int i = 0; i < a2.length; i++) {
            if (a1[i] != a2[i]) {
                if (record[a2[i] - '0'] > 0) {
                    y++;
                    record[a2[i] - '0']--;
                }
            }
        }
        return x + "A" + y + "B";
    }
}
