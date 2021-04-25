package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1570. 两个稀疏向量的点积
 * https://leetcode-cn.com/problems/dot-product-of-two-sparse-vectors/
 */
public class SparseVector {
    HashMap<Integer, Integer> map = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                this.map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entrySet : vec.map.entrySet()) {
            Integer k = entrySet.getKey();
            Integer value = entrySet.getValue();
            if (this.map.get(k) != null) {
                result += this.map.get(k) * value;
            }
        }
        return result;
    }
}
