/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;
        boolean hasCycle = false;

        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
            if(hare == turtle){
                hasCycle = true;
                break;
            }
            
        }

        if(!hasCycle){
            return null;
        }
        
        turtle = head;
        while(hare != turtle){
            hare = hare.next;
            turtle = turtle.next;
        }
        return hare;
    }
}