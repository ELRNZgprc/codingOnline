package leetcode.problem;

/**
 * 2475. 数组中不等三元组的数目
 * https://leetcode.cn/problems/number-of-unequal-triplets-in-array/
 */
public class UnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int ans=0;
        int n=nums.length;
        int[] cnt=new int[1001];
        int[] pre=new int[1001];
        for(int i=0;i<n;i++){
            cnt[nums[i]]++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]==nums[j]) continue;
                ans+=(n-cnt[nums[i]]-cnt[nums[j]])-(i-pre[nums[i]]-pre[nums[j]]);
            }
            pre[nums[i]]++;
        }
        return ans;
    }
}
