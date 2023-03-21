package leetcode.problem;

/**
 * 2469. 温度转换
 * https://leetcode.cn/problems/convert-the-temperature/
 */
public class ConvertTemperature {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.8 + 32.0};
    }
}
