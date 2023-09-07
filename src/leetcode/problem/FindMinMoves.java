package leetcode.problem;

/**
 * 517. 超级洗衣机
 * https://leetcode.cn/problems/super-washing-machines/description/
 */
public class FindMinMoves {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int m : machines) {
            sum += m;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        sum /= machines.length;
        for (int i = 0; i < machines.length; i++) {
            machines[i] -= sum;
        }
        int ans = 0;
        for (int i = 0; i < machines.length - 1; i++) {
            ans = Math.max(ans, Math.abs(machines[i]));
            ans = Math.max(ans, machines[i + 1]);
            machines[i + 1] += machines[i];
        }
        return Math.max(ans, machines[machines.length - 1]);
    }
}
