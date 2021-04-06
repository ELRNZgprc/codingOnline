package leetcode.offer;

/**
 * 80. 删除有序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
