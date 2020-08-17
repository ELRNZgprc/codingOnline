package leetcode.problem;

public class canThreePartsEqualSum {
    /**
     * 1013
     * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int times = 0;
        sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == target) {
                times++;
                sum = 0;
            }
        }
        return (times == 3) || ((times > 3) && (target == 0));
    }
}
