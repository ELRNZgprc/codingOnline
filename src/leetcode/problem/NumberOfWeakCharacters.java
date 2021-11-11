package leetcode.problem;

import java.util.Arrays;

/**
 * 1996. 游戏中弱角色的数量
 * https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
 */
public class NumberOfWeakCharacters {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        int cnt = 0;
        int max = -1;
        int n = properties.length;
        for (int i = 0; i < n; i++) {
            if (max > properties[i][1]) {
                cnt++;
            } else {
                max = properties[i][1];
            }
        }
        return cnt;
    }
}
