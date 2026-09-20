class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode l:lists){
            if(l!=null){
                pq.offer(l);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            curr.next=node;
            curr=curr.next;

            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
