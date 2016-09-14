package leetcode;
   class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
 }
 
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode l3 = new ListNode(0);
        int temp = 0;
        while(l1.next!=null || l2.next!=null){
            temp = l1.val + l2.val;
            if(temp>=10){
                l3 = new ListNode((temp-10)+l3.val);
                l3.next = new ListNode(1);//½øÎ»1
            }
            else{
                l3 = new ListNode(temp+l3.val);
                l3.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l3;
    }
    
    public static void main(String[] args){
    	//new AddTwoNumbers().addTwoNumbers(l1, l2)
    }
}