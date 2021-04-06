package leetcode.problem;

/**
 * 551. 学生出勤记录 I
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        return s.indexOf("A") == s.lastIndexOf("A") && !s.contains("LLL");
    }
}
