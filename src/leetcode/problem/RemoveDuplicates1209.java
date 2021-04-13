package leetcode.problem;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveDuplicates1209 {
    public String removeDuplicates(String s, int k) {
        if (s.length()<k){
            return s;
        }
        for (int i=1, len=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                len++;
            }else{
                len=1;
            }
            if(len==k){
                return removeDuplicates(s.substring(0,i-k+1)+s.substring(i+1),k);
            }
        }
        return s;
    }
}
