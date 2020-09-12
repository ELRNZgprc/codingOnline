package leetcode.problem;

public class SampleStats {
    /**
     * 1093. 大样本统计
     * https://leetcode-cn.com/problems/statistics-from-a-large-sample/
     */
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        int min = 0;
        while (count[min] == 0) {
            min++;
        }
        ans[0] = min;
        int max = 255;
        while (count[max] == 0) {
            max--;
        }
        ans[1] = max;
        long numberSum = 0;
        double sum = 0;
        int maxCount = min;
        for (int i = min; i <= max; i++) {
            numberSum += count[i];
            sum += i * count[i];
            if (count[i] > count[maxCount]) {
                maxCount = i;
            }
        }
        ans[2] = sum / numberSum;
        ans[4] = maxCount;

        if (numberSum % 2 == 1) {
            long s = count[min];
            int i = min;
            while (s <= numberSum / 2) {
                i++;
                s += count[i];
            }
            ans[3] = i;
        } else {
            long s = count[min];
            int i = min;
            while (s < numberSum / 2) {
                i++;
                s += count[i];
            }
            if (s > numberSum / 2) {
                ans[3] = i;
            } else {
                int ii = i + 1;
                while (count[ii] == 0) {
                    ii++;
                }
                ans[3] = (ii + i) / 2.0;
            }
        }

        return ans;
    }
}
