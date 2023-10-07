package leetcode.problem;

/**
 * 661. 图片平滑器
 * https://leetcode.cn/problems/image-smoother/
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int l1 = M.length, l2 = M[0].length;
        int[][] r = new int[l1][l2];
        for (int i = 0; i < l1; i++)
            for (int j = 0; j < l2; j++) {
                int sum = M[i][j];
                int num = 1;
                if (i > 0 && j > 0) {
                    sum += M[i - 1][j - 1];
                    num++;
                }
                if (i > 0) {
                    sum += M[i - 1][j];
                    num++;
                }
                if (i > 0 && j < l2 - 1) {
                    sum += M[i - 1][j + 1];
                    num++;
                }
                if (j > 0) {
                    sum += M[i][j - 1];
                    num++;
                }
                if (j < l2 - 1) {
                    sum += M[i][j + 1];
                    num++;
                }
                if (i < l1 - 1 && j > 0) {
                    sum += M[i + 1][j - 1];
                    num++;
                }
                if (i < l1 - 1) {
                    sum += M[i + 1][j];
                    num++;
                }
                if (i < l1 - 1 && j < l2 - 1) {
                    sum += M[i + 1][j + 1];
                    num++;
                }
                r[i][j] = sum / num;
            }
        return r;
    }
}
