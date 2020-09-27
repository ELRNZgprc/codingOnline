package leetcode.problem;

import java.util.Arrays;

public class CanAttendMeetings {
	/**
	 * 252. 会议室
	 * https://leetcode-cn.com/problems/meeting-rooms/
	 */
	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (o1, o2) -> {
			return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
		});
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
	}
}
