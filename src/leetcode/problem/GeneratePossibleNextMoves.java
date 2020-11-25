package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class GeneratePossibleNextMoves {
	/**
	 * 293. 翻转游戏
	 * https://leetcode-cn.com/problems/flip-game/
	 */
	public List<String> generatePossibleNextMoves(String s) {
		List<String> ans = new ArrayList<>();

		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length - 1; i++) {
			if (chs[i] == '+' && chs[i + 1] == '+') {
				chs[i] = chs[i + 1] = '-';
				ans.add(new String(chs));
				chs[i] = chs[i + 1] = '+';
			}
		}
		return ans;
	}
}
