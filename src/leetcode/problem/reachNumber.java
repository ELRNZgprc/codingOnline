package leetcode.problem;

public class reachNumber {
    /**
     * 754
     * https://leetcode-cn.com/problems/reach-a-number/
     */
    public int reachNumber(int target) {
        int t = Math.abs(target);
        int time = 0;
        int dis = 0;
        while (dis < t) {
            time++;
            dis += time;

        }
        int dt = dis - t;
        if (dt % 2 == 0)
            return time;
        else {
            if (time % 2 == 0)
                return time + 1;
            else
                return time + 2;
        }
    }
}
