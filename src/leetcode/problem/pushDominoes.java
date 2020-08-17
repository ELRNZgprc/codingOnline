package leetcode.problem;

public class pushDominoes {
    /**
     * 838
     * https://leetcode-cn.com/problems/push-dominoes/
     */
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];
        int[] right = new int[dominoes.length()];
        int force = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            if (force != 0) {
                force++;
            }
            if (dominoes.charAt(i) == 'R') {
                force = 1;
            }
            if (dominoes.charAt(i) == 'L') {
                force = 0;
            }
            right[i] = force;
        }
        force = 0;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (force != 0) {
                force++;
            }
            if (dominoes.charAt(i) == 'L') {
                force = 1;
            }
            if (dominoes.charAt(i) == 'R') {
                force = 0;
            }
            left[i] = force;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            if ((right[i] != 0) && (left[i] != 0)) {
                ans.append((right[i] < left[i]) ? 'R' : ((right[i] == left[i]) ? '.' : 'L'));
            }
            if ((right[i] != 0) && (left[i] == 0)) {
                ans.append('R');
            }
            if ((right[i] == 0) && (left[i] != 0)) {
                ans.append('L');
            }
            if ((right[i] == 0) && (left[i] == 0)) {
                ans.append('.');
            }
        }
        return ans.toString();
    }
}
