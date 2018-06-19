/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while(l1!=null || l2!=null){
            int temp = 0;
            if(l1!=null){
                temp += l1.val;
                //System.out.print(l1.val+" ");
                l1 = l1.next;
            }
            
            if(l2!=null){
                temp += l2.val;
                //System.out.print(l2.val+" ");
                l2 = l2.next;
            }
            
            temp += carry;
            carry = (temp - temp%10)/10;
            //System.out.print(carry+" \n");
            cur.next = new ListNode(temp%10);
            cur = cur.next;
        }
        if(carry!=0)
            cur.next = new ListNode(carry);
        return head.next;
    }
}
