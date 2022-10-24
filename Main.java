class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class Main {

  // Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the
  // LinkedList from position ‘p’ to ‘q’.

  public static ListNode reverseASubList(ListNode head, int p, int q) {

    if (p == q)
      return head;
    // after skipping 'p-1' nodes, current will point to 'pth' node
    ListNode current = head;
    ListNode prev = null;

    for (int i = 0; current != null && i < p - 1; i++) {
      prev = current;
      current = current.next;
    }

    // we are interested in 3 parts of linkedlist, part before index p, part between
    // index p and q, part after q
    ListNode lastNodeOfFirstPart = prev; // points to the node at p-1 index
    // after reversing the linkedlist , current will be the last node of sublist
    ListNode lastNodeOfSubList = current;
    ListNode next = null;
    // reverse nodes btw p an q
    for (int i = 0; current != null && i < q - p + 1; i++) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    // connect with the first part
    if (lastNodeOfFirstPart != null)
      lastNodeOfFirstPart.next = prev;
    else // this means p==1 -> we are changing the first node
      head = prev;

    // connect with the last part
    lastNodeOfSubList.next = current;
    return head;
  }

  public static void main(String[] args) {
        ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ListNode result = (Main.reverseASubList(head, 2, 4));
    while(result != null) {
     System.out.println(result.value + " ");
      result = result.next; 
    }
 }

// Similar Questions #

//   Problem 1: Reverse the first ‘k’ elements of a given LinkedList.

// Solution: This problem can be easily converted to our parent problem; to reverse the first ‘k’ nodes of the list, we need to pass p=1 and q=k.

// Problem 2: Given a LinkedList with ‘n’ nodes, reverse it based on its size in the following way:

// If ‘n’ is even, reverse the list in a group of n/2 nodes.
// If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes and reverse the last ‘n/2’ nodes.
// Solution: When ‘n’ is even we can perform the following steps:

// Reverse first ‘n/2’ nodes: head = reverse(head, 1, n/2)
// Reverse last ‘n/2’ nodes: head = reverse(head, n/2 + 1, n)
// When ‘n’ is odd, our algorithm will look like:

// head = reverse(head, 1, n/2)
// head = reverse(head, n/2 + 2, n)
}
