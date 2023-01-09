package leetcode.problem;

import java.util.Arrays;

/**
 * 2171. 拿出最少数目的魔法豆
 * https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/
 */
public class MinimumRemoval {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);

        long ans = Long.MAX_VALUE, total = 0L;

        for(int bean : beans){
            total += bean;
        }

        for(int i = 0; i < beans.length; i++){
            long take = total - (long)beans[i] * (beans.length - i);
            ans = Math.min(ans, take);
        }

        return ans;
    }
}
