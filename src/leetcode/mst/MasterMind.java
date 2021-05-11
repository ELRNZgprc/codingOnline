package leetcode.mst;

/**
 * 面试题 16.15. 珠玑妙算
 * https://leetcode-cn.com/problems/master-mind-lcci/
 */
public class MasterMind {
    public int[] masterMind(String solution, String guess) {
        int sr = 0, sy = 0, sg = 0, sb = 0, gr = 0, gy = 0, gg = 0, gb = 0;
        int[] ans = new int[2];
        for (int i = 0; i < solution.length(); i++) {
            char s = solution.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                ans[0]++;
            } else {
                switch (s) {
                    case 'R':
                        sr++;
                        break;
                    case 'G':
                        sg++;
                        break;
                    case 'B':
                        sb++;
                        break;
                    case 'Y':
                        sy++;
                        break;
                }
                switch (g) {
                    case 'R':
                        gr++;
                        break;
                    case 'G':
                        gg++;
                        break;
                    case 'B':
                        gb++;
                        break;
                    case 'Y':
                        gy++;
                        break;
                }
            }
        }
        ans[1] = Math.min(gr, sr) + Math.min(gg, sg) + Math.min(gb, sb) + Math.min(gy, sy);
        return ans;
    }
}
