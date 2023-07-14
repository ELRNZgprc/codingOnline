package leetcode.problem;

/**
 * 2190. 数组中紧跟 key 之后出现最频繁的数字
 * https://leetcode.cn/problems/most-frequent-number-following-key-in-an-array/
 */
public class MostFrequent {
    public int mostFrequent(int[] nums, int key) {
        int[] ints = new int[1024];
        int max = 0;
        int p = nums[0];
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==key){
                if(++ints[nums[i+1]-1]>max){
                    max = ints[nums[i+1]-1];
                    p=nums[i+1];
                }
            }
        }
        return p;
    }
}
