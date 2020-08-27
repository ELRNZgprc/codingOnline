package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    /**
     * 1200. 最小绝对差
     * https://leetcode-cn.com/problems/minimum-absolute-difference/
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        List<Integer> node = new ArrayList<>();
        node.add(arr[0]);
        node.add(arr[1]);
        ans.add(node);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < min) {
                ans = new ArrayList<>();
                min = arr[i + 1] - arr[i];
                node = new ArrayList<>();
                node.add(arr[i]);
                node.add(arr[i + 1]);
                ans.add(node);
            } else if (arr[i + 1] - arr[i] == min) {
                node = new ArrayList<>();
                node.add(arr[i]);
                node.add(arr[i + 1]);
                ans.add(node);
            }
        }
        return ans;
    }
}
