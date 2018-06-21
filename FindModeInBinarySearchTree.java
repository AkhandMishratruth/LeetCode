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
    static HashMap<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<Integer, Integer>();
        fun(root);
        int len=0, freq=0;
        for(Map.Entry<Integer, Integer> ent : map.entrySet()){
            if(freq<ent.getValue()){
                freq = ent.getValue();
                len = 1;
            }
            else if(freq==ent.getValue()){
                len++;
            }
        }
        int[] ar = new int[len];
        len = 0;
        for(Map.Entry<Integer, Integer> ent : map.entrySet()){
            if(ent.getValue()==freq)
                ar[len++] = ent.getKey();
        }
        return ar;
    }
    static void fun(TreeNode root){
        if(root==null)
            return;
        if(map.containsKey(root.val))
            map.put(root.val, map.get(root.val) + 1);
        else
            map.put(root.val, 1);
        if(root.left!=null)
            fun(root.left);
        if(root.right!=null)
            fun(root.right);
    }
}
