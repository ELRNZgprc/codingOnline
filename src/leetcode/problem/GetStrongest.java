package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1471. 数组中的 k 个最强值
 * https://leetcode.cn/problems/the-k-strongest-values-in-an-array/
 */
public class GetStrongest {
    public int[] getStrongest(int[] arr, int k) {
        int l = arr.length;
        Arrays.sort(arr);
        int m = arr[(l-1)/2];
        Integer[] ARR = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(ARR, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                int A = Math.abs(a-m);
                int B = Math.abs(b-m);
                if(A > B) return -1;
                if(A == B && a > b) return -1;
                return 1;
            }
        });
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = ARR[i];
        }
        return res;
    }
}
