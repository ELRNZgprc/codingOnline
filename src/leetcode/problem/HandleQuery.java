package leetcode.problem;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * 2569. 更新数组后处理求和查询
 * https://leetcode.cn/problems/handling-sum-queries-after-update/
 */
public class HandleQuery {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        BitSet bitSet = new BitSet();
        long sum = 0;
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums1[i] == 1) {
                bitSet.set(i);
            }
            sum += nums2[i];
        }
        for (int[] query : queries) {
            if (query[0] == 1) {
                bitSet.flip(query[1], query[2] + 1);
            } else if (query[0] == 2) {
                sum += (long) bitSet.cardinality() * query[1];
            } else {
                res.add(sum);
            }
        }
        return res.stream().mapToLong(Long::longValue).toArray();
    }
}
