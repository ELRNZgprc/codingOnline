package leetcode.problem;

/**
 * 2437. 有效时间的数目
 * https://leetcode.cn/problems/number-of-valid-clock-times/
 */
public class CountTime {
    public int countTime(String time) {
        int a = time.charAt(0) == '?' ? -1 : time.charAt(0) - '0',
                b = time.charAt(1) == '?' ? -1 : time.charAt(1) - '0',
                c = time.charAt(3) == '?' ? -1 : time.charAt(3) - '0',
                d = time.charAt(4) == '?' ? -1 : time.charAt(4) - '0', k = 1;
        if(a == -1){
            if(b == -1) k = 24;
            else k = b < 4 ? 3 : 2;
        } else {
            if(b == -1) k = a <= 1 ? 10 : 4;
        }
        if(c == -1) {
            k = d == -1 ? k*60 : k*6;
        } else {
            k = d == -1 ? k*10 : k;
        }
        return k;
    }
}
