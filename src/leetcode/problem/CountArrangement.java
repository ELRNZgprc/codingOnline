package leetcode.problem;

/**
 * 526. 优美的排列
 * https://leetcode.cn/problems/beautiful-arrangement/
 */
public class CountArrangement {
    int ans;

    public int countArrangement(int n) {
        int[] temp = new int[n + 1];
        ans = 0;
        findAns(n, 1, temp);
        return ans;
    }

    private void findAns(int length, int number, int[] temp) {
        for (int i = 1; i < length + 1; i++) {
            if (temp[i] == 0) {
                if ((i % number == 0) || (number % i == 0)) {
                    if (number == length) {
                        ans++;
                    } else {
                        temp[i] = number;
                        findAns(length, number + 1, temp);
                        temp[i] = 0;
                    }
                }
            }
        }
    }
}
