package leetcode.problem;

/**
 * 1925. 统计平方和三元组的数目
 * https://leetcode-cn.com/problems/count-square-sum-triples/
 */
public class CountTriples {
    public int countTriples(int n) {
        int ans = 0;
        for (int i = 3; i <= n / Math.sqrt(2); i++) {
            for (int j = i + 1; j < n; j++) {
                if (i * i + j * j <= n * n) {
                    int temp = (int) Math.sqrt((long) i * i + (long) j * j);
                    if ((temp <= n) && (temp * temp == i * i + j * j)) {
                        ans++;
                    }
                }
            }
        }
        return ans * 2;
    }
}
