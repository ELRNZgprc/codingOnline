package leetcode.problem;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * https://leetcode.cn/problems/latest-time-by-replacing-hidden-digits/
 */
public class MaximumTime {
    public String maximumTime(String time) {
        char times[] = new char[4];
        for(int i=0;i<4;i++){
            times[i] = time.charAt(i<2?i:i+1);
        }
        String res = "";
        for(int i=0;i<4;i++){
            if(times[i]=='?'){
                switch(i){
                    case 0 : times[0] = times[1]>='4'&&times[1]<='9' ? '1' : '2';break;
                    case 1 : times[1] = times[0]=='2' ? '3' : '9';break;
                    case 2 : times[2] = '5';break;
                    case 3 : times[3] = '9';break;
                }
            }
            res += times[i];
            if(i==1) res += ":";
        }
        return res;
    }
}
