package leetcode.problem;

/**
 * 1147. 段式回文
 * https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/
 */
public class LongestDecomposition {
    public int longestDecomposition(String text) {
        if(text.length()==0) return 0;
        if(text.length()==1) return 1;
        int l=0;
        char cur=text.charAt(l);
        int r=text.length()-1;
        while (r>l){
            if(text.charAt(r)==cur){
                if(text.substring(l,text.length()-r).equals(text.substring(r))){
                    break;
                }
            }
            r--;
        }
        if(r==l) return 1;
        return 2+longestDecomposition(text.substring(text.length()-r,r));
    }
}
