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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCPI = -1;
        int prevCPI = -1;
        int currIndex = 1;
        ListNode curr = head.next;
        ListNode prev = head;
        int ans[] = new int[2];
        ans[0] = Integer.MAX_VALUE;

        while(curr.next != null)
        {
            ListNode nextNode = curr.next;

            if((curr.val < nextNode.val && curr.val < prev.val) || (curr.val > nextNode.val && curr.val > prev.val) )
            {
                if(prevCPI == -1)
                {  
                    firstCPI = currIndex;
                    prevCPI = currIndex;
                }
                else
                {
                    ans[0] = Math.min(ans[0] , currIndex-prevCPI);
                    prevCPI = currIndex;
                }
            }
            prev = prev.next;
            curr = curr.next;
            currIndex++;
        }
        if(firstCPI != -1 && ans[0] != Integer.MAX_VALUE)
        {
            ans[1] = prevCPI - firstCPI ;
        }
        else
        {
           ans[0] = -1;
           ans[1] = -1;
        }

        return ans;
    }
}