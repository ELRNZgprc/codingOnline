package leetcode.mst;

/**
 * 1823. 找出游戏的获胜者
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinner {
    public int findTheWinner(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }
}
