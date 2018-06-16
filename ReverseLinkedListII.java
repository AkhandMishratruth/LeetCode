/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode cur = head, prev=null, next, last;
        int ind = 1;
        while(ind!=m){
            prev = cur;
            cur = cur.next;
            ind++;
        }
        System.out.println(cur.val);
        last = prev;
        next = cur.next;
        while(ind!=n+1){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next!=null)
               next = next.next;
            ind++;
        }
        if(last!=null){      
            last.next.next = cur;
            last.next = prev;
        }
        else{
            head.next = cur;
            head = prev;
        }
        return head;
    }
}
