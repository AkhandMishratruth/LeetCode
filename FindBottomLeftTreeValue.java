/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static int curL=0;
    static int curV=-1;
    public int findBottomLeftValue(TreeNode root) {
        curL=0;
        curV=-1;
        fun(root, 1);
        return curV;
    }
    static void fun(TreeNode root, int level){
        if(root==null)
            return;
        if(level>curL){
            curV = root.val;
            curL = level;
        }
        fun(root.left, level+1);
        fun(root.right, level+1);
        return;
    }
}
