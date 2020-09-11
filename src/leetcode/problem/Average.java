package leetcode.problem;

public class Average {
    /**
     * 1491. 去掉最低工资和最高工资后的工资平均值
     * https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
     */
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0.0;
        for (int s : salary) {
            sum += s;
            max = Math.max(max, s);
            min = Math.min(min, s);
        }
        return (sum - max - min) / (salary.length - 2);
    }
}
