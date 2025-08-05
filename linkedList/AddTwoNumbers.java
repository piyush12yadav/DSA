package linkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int sum = 0;
        int carry = 0;

        while(l1 != null || l2 != null){
            sum = carry;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;
        }

        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }

        return dummy.next;
    }
}
