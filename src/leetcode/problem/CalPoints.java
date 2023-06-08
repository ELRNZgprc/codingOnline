package leetcode.problem;

/**
 * 682. 棒球比赛
 * https://leetcode.cn/problems/baseball-game/
 */
public class CalPoints {
    public int calPoints(String[] operations) {
        int[] arr = new int[operations.length];
        int i = 0;
        for (String s : operations) {
            switch (s) {
                case "+":
                    arr[i] = arr[i - 1] + arr[i - 2];
                    i++;
                    break;
                case "D":
                    arr[i] = 2 * arr[i - 1];
                    i++;
                    break;
                case "C":
                    arr[i - 1] = 0;
                    i--;
                    break;
                default:
                    arr[i] = Integer.parseInt(s);
                    i++;
            }
        }
        int sum = 0;
        for (int k : arr) {
            sum += k;
        }
        return sum;
    }
}
