package leetcode.problem;

/**
 * 1399. 统计最大组的数目
 * https://leetcode.cn/problems/count-largest-group/
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int[] arr = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int t = i;
            while (t > 0) {
                sum += t % 10;
                t = t / 10;
            }
            arr[sum] += 1;
        }
        int count = 0;
        int cur = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == cur) {
                count++;
            } else if (arr[i] > cur) {
                cur = arr[i];
                count = 1;
            }
        }
        return count;
    }
}
