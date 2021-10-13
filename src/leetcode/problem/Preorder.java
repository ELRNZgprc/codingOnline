package leetcode.problem;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Preorder {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        doPre(root);
        return ans;
    }

    public void doPre(Node node){
        if (node!=null){
            ans.add(node.val);
            for (Node n:node.children){
                doPre(n);
            }
        }
    }
}
