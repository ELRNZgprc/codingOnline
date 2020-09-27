package leetcode.problem;

public class HIndex {
    /**
     * 275. H 指数 II
     * https://leetcode-cn.com/problems/h-index-ii/
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) >> 1;
            int paperCnt = len - mid;
            if (paperCnt <= citations[mid]) {
                ans = paperCnt;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }
}
