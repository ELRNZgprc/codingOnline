package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1166. 设计文件系统
 * https://leetcode-cn.com/problems/design-file-system/
 */
public class FileSystem {
    private Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        String parent = path.substring(0, path.lastIndexOf("/"));
        if (map.containsKey(path))
            return false;
        if (!parent.equals("") && !map.containsKey(parent))
            return false;
        map.put(path, value);
        return true;
    }

    public int get(String path) {
        if (map.containsKey(path)) {
            return map.get(path);
        } else {
            return -1;
        }
    }
}
