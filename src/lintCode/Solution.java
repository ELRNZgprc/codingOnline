package lintCode;

import java.util.*;

public class Solution {
    /**
     * LintCode 8
     *
     * @param str:    An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length == 0 || offset == 0) {
            return;
        }
        offset = offset % str.length;//实际偏移量
        for (int i = 0; i < offset; i++) {
            char temp = str[str.length - 1];
            for (int j = str.length - 1; j > 0; j--) {
                str[j] = str[j - 1];
            }
            str[0] = temp;
        }

    }

    /**
     * LintCode 17
     *
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        int i;
        List<Integer> ansList;


        boolean[] flag = new boolean[length];
        for (i = 0; i < length; i++) {
            flag[i] = false;
        }
        if (length > 0) {
            do {
                ansList = new ArrayList<>();
                for (i = 0; i < length; i++) {
                    if (flag[i]) {
                        ansList.add(nums[i]);
                    }
                }
                ans.add(ansList);
                plusa(flag);
            } while (!isAllTrue(flag));
        }
        ansList = new ArrayList<>();
        for (i = 0; i < length; i++) {
            if (flag[i]) {
                ansList.add(nums[i]);
            }
        }

        ans.add(ansList);

        return ans;
    }

    boolean isAllTrue(boolean[] booleans) {
        boolean ans = true;
        int i = 0;
        while (ans && (i < booleans.length)) {
            if (!booleans[i]) {
                ans = false;
            }
            i++;
        }
        return ans;
    }

    void plusa(boolean[] booleans) {
        int i = 0;
        booleans[i] = !booleans[i];
        while ((!booleans[i]) && (i < booleans.length - 1)) {
            i++;
            booleans[i] = !booleans[i];
        }
    }

    /**
     * LintCode 20
     *
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> ans = new ArrayList<>();

        int[][] sum = new int[n + 1][6 * n + 1];
        int i, j;

        for (j = 1; j <= 6; j++)
            sum[1][j] = 1;

        for (i = 2; i <= n; i++) {
            for (j = i; j <= 6 * i; j++) {
                int left = ((j - 6) > (i - 1)) ? j - 6 : i - 1;
                int right = ((j - 1) > (6 * i - 6)) ? 6 * i - 6 : j - 1;
                sum[i][j] = 0;
                for (int k = left; k <= right; k++) {
                    sum[i][j] += sum[i - 1][k];
                }
            }
        }

        int total = 0;
        for (j = n; j <= 6 * n; j++) {
            total += sum[n][j];
        }


        Map<Integer, Double> map = new HashMap<>();
        for (j = n; j <= 6 * n; j++) {
            map.put(j, ((double) sum[n][j] / total));
        }
        Iterator<Map.Entry<Integer, Double>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) ans.add(iterator.next());

        return ans;
    }
}
