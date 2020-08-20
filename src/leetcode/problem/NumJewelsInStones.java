package leetcode.problem;

public class NumJewelsInStones {
    /**
     * 771. 宝石与石头
     * https://leetcode-cn.com/problems/jewels-and-stones/
     */
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.isEmpty()) {
            return 0;
        }
        if (S == null || S.isEmpty()) {
            return 0;
        }
        int[] hash = new int['z' - 'A' + 1];
        for (char c : S.toCharArray()) {
            hash[c - 'A']++;
        }
        int ans = 0;
        for (char c : J.toCharArray()) {
            ans += hash[c - 'A'];
        }
        return ans;
    }
}
