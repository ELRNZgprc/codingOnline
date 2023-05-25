package leetcode.problem;

/**
 * 2451. 差值数组不同的字符串
 * https://leetcode.cn/problems/odd-string-difference/
 */
public class OddString {
    public String oddString(String[] words) {
        for(int i=1;i<words[0].length();i++){
            int curr0=words[0].charAt(i)-words[0].charAt(i-1);
            int curr1=words[1].charAt(i)-words[1].charAt(i-1);
            int curr2=words[2].charAt(i)-words[2].charAt(i-1);
            if(curr2==curr1&&curr0!=curr1) return words[0];

        }

        for(int i=1;i<words[0].length();i++){
            int curr=words[0].charAt(i)-words[0].charAt(i-1);
            for(int j=0;j<words.length;j++){
                int dif=words[j].charAt(i)-words[j].charAt(i-1);
                if(dif!=curr) return words[j];
            }
        }
        return words[0];
    }
}
