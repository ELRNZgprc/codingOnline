package leetcode.problem;

public class FindLonelyPixel {
    /**
     * 531. 孤独像素 I
     * https://leetcode-cn.com/problems/lonely-pixel-i/
     */
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length;
        int m = picture[0].length;
        int[] xCount = new int[n];
        int[] yCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 'B') {
                    xCount[i]++;
                    yCount[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((picture[i][j] == 'B') && (xCount[i] == 1) && (yCount[j] == 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
