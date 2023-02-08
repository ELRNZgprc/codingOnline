package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1233. 删除子文件夹
 * https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 */
public class RemoveSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(String s :folder){
            map.put(s,s.length());
        }

        for(String s :folder){
            int i = s.length()-1;
            boolean flag = true;
            for(; i>1 ;i--){
                if(s.charAt(i)=='/'){
                    if(map.get(s.substring(0,i))!=null){
                        flag = false;
                    }
                }
            }
            if(flag)
                res.add(s);
        }
        return res;
    }
}
