package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. 格雷编码
 * https://leetcode-cn.com/problems/gray-code/
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i)
            ans.add(i ^ i >> 1);
        return ans;
    }
}
