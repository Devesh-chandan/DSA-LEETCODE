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
        ArrayList<Integer> local=new ArrayList<>();
        int ans[]={-1,-1};
       ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        int index = 1;

        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;
        while(next!=null){
           if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {
           if (first == -1) {
                    first = index;
                } else{
                    minDistance = Math.min(minDistance, index - last);
                }
                last = index;
    }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
   
        }
        if(first==-1 || last==first){
            return ans;
        }
        ans[0]=minDistance;
        ans[1]=last-first;
         return ans;
    }
   


}