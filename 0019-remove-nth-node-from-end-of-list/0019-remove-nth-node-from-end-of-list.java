/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        if(head.next == null) return null;

        ListNode fast = head;
        ListNode slow = null;

        int diff = 0;
        while( fast != null){
            if(diff<n){
                fast = fast.next;
                diff++;
            }else{
                if(slow == null){
                    slow = head;
                }else{
                    slow = slow.next;
                }
                fast = fast.next;
            }
        }

        if(slow == null){
            return head.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}