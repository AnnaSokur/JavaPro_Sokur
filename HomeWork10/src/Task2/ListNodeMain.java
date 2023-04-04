package Task2;

public class ListNodeMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.print("Input: ");
        solution.printList(head1);
        ListNode reversedHead1 = solution.reverseList(head1);
        System.out.print("Output: ");
        solution.printList(reversedHead1);


    }
}
