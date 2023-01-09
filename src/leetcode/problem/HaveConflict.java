package leetcode.problem;

/**
 * 2446. 判断两个事件是否存在冲突
 * https://leetcode.cn/problems/determine-if-two-events-have-conflict/
 */
public class HaveConflict {
    public boolean haveConflict(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[1]) <= 0 && event2[0].compareTo(event1[1]) <= 0;
    }
}
