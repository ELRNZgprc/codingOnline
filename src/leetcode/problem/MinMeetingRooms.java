package leetcode.problem;

import java.util.Arrays;

public class MinMeetingRooms {
    /**
     * 253. 会议室 II
     * https://leetcode-cn.com/problems/meeting-rooms-ii/
     */
    public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        if (length == 0) {
            return 0;
        }
        int[] begins = new int[length];
        int[] ends = new int[length];
        for (int i = 0; i < length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(begins);
        Arrays.sort(ends);
        int b = 0;
        int e = 0;
        int max = 0;
        int num = 0;
        for (int i = begins[0]; i <= ends[length - 1]; i++) {
            while ((e < length) && (ends[e] == i)) {
                num--;
                e++;
            }
            while ((b < length) && (begins[b] == i)) {
                num++;
                max = Math.max(max, num);
                b++;
            }
        }
        return max;
    }
}
