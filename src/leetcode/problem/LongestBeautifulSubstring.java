package leetcode.problem;

/**
 * 1839. 所有元音按顺序排布的最长子字符串
 * https://leetcode.cn/problems/longest-substring-of-all-vowels-in-order/
 */
public class LongestBeautifulSubstring {
    public int longestBeautifulSubstring(String word) {
        int type=1,max=0;
        for (int i=0,j = 1; j < word.length(); j++) {
            if(word.charAt(j)<word.charAt(j-1)){
                i=j;
                type=1;
            }else if(word.charAt(j)>word.charAt(j-1)){
                type++;
            }
            if(type==5){
                max=Math.max(max, j-i+1);
            }
        }
        return max;
    }
}
