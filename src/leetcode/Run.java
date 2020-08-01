package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        nums.add(list);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        nums.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        nums.add(list2);
        int[] ans =solution.smallestRange(nums);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
