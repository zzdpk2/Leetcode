
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode root = new ListNode(-1);
    root.next = head;
    ListNode res = root;
    ListNode temp = head;
    int i = 0;
    while(temp != null){
        i++;
        temp = temp.next;
    }  
    while(i >= k){
        for(int j = 0 ; j < k-1; j++){  
            ListNode node = root.next;  
            root.next = head.next;         
            head.next = root.next.next;
            root.next.next = node;
        }  
        root = head;  
        head = head.next;   
        i-=k;                    
    }
    return res.next;
