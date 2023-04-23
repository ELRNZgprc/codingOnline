package leetcode.problem;

/**
 * 1105. 填充书架
 * https://leetcode.cn/problems/filling-bookcase-shelves/
 */
public class MinHeightShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i - 1] + books[i - 1][1];
            int sum = books[i - 1][0], maxHeight = books[i - 1][1];
            for (int j = i - 2; j >= 0; j--) {
                sum += books[j][0];
                maxHeight = Math.max(maxHeight, books[j][1]);
                if (sum <= shelfWidth) {
                    ans[i] = Math.min(ans[i], ans[j] + maxHeight);
                } else {
                    break;
                }
            }
        }
        return ans[n];
    }
}
