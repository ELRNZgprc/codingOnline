package leetcode.problem;

/**
 * 1588. 所有奇数长度子数组的和
 * https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        if(arr==null || arr.length==1) return arr[0];
        int n=arr.length;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i]*((i/2+1)*((n-i-1)/2+1)+((i+1)/2)*((n-i)/2));
        }
        return sum;
    }
}
