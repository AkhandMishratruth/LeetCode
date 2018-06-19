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
    static Map<Integer, Integer> map;
    public List<Integer> rightSideView(TreeNode root) {
        map = new HashMap<Integer, Integer>();
        if(root!=null)
            fun(root, 1);
        ArrayList<Integer> ar = new ArrayList<Integer>(); 
        for(Map.Entry entry : map.entrySet())
            ar.add((int)entry.getValue());
        return ar;
    }
    static void fun(TreeNode root, int level){
        map.put(level, root.val);
        if(root.left!=null)
            fun(root.left, level + 1);
        if(root.right!=null)
            fun(root.right, level + 1);
    }
}
