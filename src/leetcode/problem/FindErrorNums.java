package leetcode.problem;

/**
 * 645. 错误的集合
 * https://leetcode.cn/problems/set-mismatch/
 */
public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int[] resule = new int[2];
        int[] temp = new int[nums.length + 1];
        for (int num : nums) {
            temp[num]++;
        }

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 1)
                continue;
            if (temp[i] == 2)
                resule[0] = i;
            else
                resule[1] = i;
        }
        return resule;
    }
}
