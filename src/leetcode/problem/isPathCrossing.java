package leetcode.problem;

public class isPathCrossing {
    /**
     * 1496
     * https://leetcode-cn.com/problems/path-crossing/
     */
    public boolean isPathCrossing(String path) {
        if (path.contains("NS") || path.contains("SN") || path.contains("WE") || path.contains("EW")) {
            return true;
        }
        int n = 0;
        int s = 0;
        int w = 0;
        int e = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    n++;
                    break;
                case 'S':
                    s++;
                    break;
                case 'W':
                    w++;
                    break;
                case 'E':
                    e++;
                    break;
            }
            if ((n == s) && (w == e)) {
                return true;
            }
        }
        return false;
    }
}
