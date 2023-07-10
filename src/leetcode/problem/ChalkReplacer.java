package leetcode.problem;

/**
 * 1894. 找到需要补充粉笔的学生编号
 * https://leetcode.cn/problems/find-the-student-that-will-replace-the-chalk/
 */
public class ChalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int count = 0;
        for (int j = 0; j < chalk.length; j++) {
            count += chalk[j];
            if (count > k)
                return j;
        }
        k %= count;
        while (true) {
            k -= chalk[i];
            if (k < 0) return i;
            i++;
        }
    }
}
