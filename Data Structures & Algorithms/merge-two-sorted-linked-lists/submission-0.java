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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1Pointer = list1;
        ListNode l2Pointer = list2;
        ListNode newList = new ListNode();
        ListNode newListAdder = newList;
        while (l1Pointer != null && l2Pointer != null) {
            // can't use ternary operator - need to do more things depedning on condition
            if (l1Pointer.val <= l2Pointer.val) {
                newListAdder.next = l1Pointer;
                l1Pointer = l1Pointer.next;
                newListAdder = newListAdder.next;
            } else {
                newListAdder.next = l2Pointer;
                l2Pointer = l2Pointer.next;
                newListAdder = newListAdder.next;
            }
        } 
        // adding rest of lists
        if (l1Pointer == null) {
            newListAdder.next = l2Pointer;
        } else if (l2Pointer == null) {
            newListAdder.next = l1Pointer;
        }
        return newList.next;
    }
}