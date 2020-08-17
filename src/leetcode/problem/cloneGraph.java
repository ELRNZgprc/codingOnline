package leetcode.problem;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class cloneGraph {
    /**
     * 133
     * https://leetcode-cn.com/problems/clone-graph/
     */
    HashMap<Node, Node> visited = new HashMap();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<Node>());
        visited.put(node, copy);
        for (Node next : node.neighbors) {
            copy.neighbors.add(dfs(next));
        }
        return copy;
    }
}
