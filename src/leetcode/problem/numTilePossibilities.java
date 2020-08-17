package leetcode.problem;

public class numTilePossibilities {
    /**
     * 1079
     * https://leetcode-cn.com/problems/letter-tile-possibilities/
     */
    int ans1079;

    public int numTilePossibilities(String tiles) {
        int[] chars = new int[26];
        ans1079 = 0;
        for (int i = 0; i < tiles.length(); i++) {
            chars[tiles.charAt(i) - 'A']++;
        }
        work1079(chars);
        return ans1079;
    }

    void work1079(int[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                ans1079++;
                chars[i]--;
                work1079(chars);
                chars[i]++;
            }
        }
    }
}
