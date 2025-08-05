package linkedList;

public class Main {
    public static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print the list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Example: 342 + 465 = 807
        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};

        ListNode l1 = buildList(num1);
        ListNode l2 = buildList(num2);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        System.out.println("Input: ");
        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        System.out.println("Output: ");
        printList(result);
    }

}
