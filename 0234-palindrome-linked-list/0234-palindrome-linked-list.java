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
    public ListNode reverse(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;

        }
        return prevNode;
    }

    public ListNode findMiddleNode(ListNode head){
        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next !=null && hare.next.next != null){
                hare = hare.next.next;
                turtle = turtle.next;
        }
        return turtle;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        ListNode middleNode = findMiddleNode(head);
        ListNode secondHalfStart = reverse(middleNode.next);

        ListNode firstHalfstart = head;

        while(secondHalfStart != null){
            if(firstHalfstart.val != secondHalfStart.val){
                return false;
            }
            firstHalfstart = firstHalfstart.next;
            secondHalfStart = secondHalfStart.next;
        }

        return true;
    }
}