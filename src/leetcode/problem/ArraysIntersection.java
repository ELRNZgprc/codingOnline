package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1213. 三个有序数组的交集
 * https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays/
 */
public class ArraysIntersection {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int x = 0;
        int y = 0;
        int z = 0;
        List<Integer> ans = new ArrayList<>();
        while ((x < arr1.length) && (y < arr2.length) && (z < arr3.length)) {
            if ((arr1[x] == arr2[y]) && (arr3[z] == arr2[y])) {
                ans.add(arr1[x]);
                x++;
                y++;
                z++;
            } else if ((arr1[x] <= arr2[y]) && (arr1[x] <= arr3[z])) {
                x++;
            } else if ((arr1[x] >= arr2[y]) && (arr2[y] <= arr3[z])) {
                y++;
            } else if ((arr1[x] >= arr3[z]) && (arr2[y] >= arr3[z])) {
                z++;
            }
        }
        return ans;
    }
}
