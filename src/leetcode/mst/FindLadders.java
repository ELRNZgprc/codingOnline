package leetcode.mst;

import java.util.*;

public class FindLadders {
    /**
     * 面试题 17.22. 单词转换
     * https://leetcode-cn.com/problems/word-transformer-lcci/
     */
    private int begin;
    private int end;
    private Set<Integer>[] graph;
    private boolean[] visited;
    private List<String> ans;
    private List<String> wordList;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        begin = -1;
        end = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                begin = i;
            }
            if (wordList.get(i).equals(endWord)) {
                end = i;
            }
        }
        if (end == -1) {
            return new ArrayList<>();
        }
        if (begin == -1) {
            wordList.add(beginWord);
            begin = wordList.size() - 1;
        }
        if (end == begin) {
            ans = new ArrayList<>();
            ans.add(beginWord);
            return ans;
        }

        this.wordList = wordList;
        graph = new Set[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isOK(wordList.get(i), wordList.get(j))) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        visited = new boolean[wordList.size()];
        ans = new ArrayList<>();
        dfs(begin);
        Collections.reverse(ans);
        return ans;
    }

    private boolean isOK(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return (diff == 1);
    }

    private boolean dfs(int v) {
        visited[v] = true;
        if (v == end) {
            ans.add(wordList.get(v));
            return true;
        }
        for (int w : graph[v]) {
            if (!visited[w]) {
                if (dfs(w)) {
                    ans.add(wordList.get(v));
                    return true;
                }
            }
        }
        return false;
    }
}
