package leetcode.problem;

/**
 * 1389. 按既定顺序创建目标数组
 * https://leetcode.cn/problems/create-target-array-in-the-given-order/
 */
public class CreateTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        for (int i = 1; i < index.length; i++) {
            for (int j = 0; j < i; j++) {
                if (index[j] >= index[i]) {
                    index[j]++;
                }
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[index[i]] = nums[i];
        }
        return res;
    }
}
