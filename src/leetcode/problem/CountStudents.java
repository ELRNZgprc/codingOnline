package leetcode.problem;

/**
 * 1700. 无法吃午餐的学生数量
 * https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class CountStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int s : students) {
            count[s]++;
        }
        for (int s : sandwiches) {
            if (count[s] > 0) {
                count[s]--;
            } else {
                return count[0] + count[1];
            }
        }
        return count[0] + count[1];
    }
}
