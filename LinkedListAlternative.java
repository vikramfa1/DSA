class LinkedNode {
    int data;
    LinkedNode next = null;
    public LinkedNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedListAlternative {

    public static void reorder(LinkedNode head) {
        if(head==null) return;

        LinkedNode slowPtr = head; LinkedNode fastPtr = head;

        while(slowPtr!=null && fastPtr!=null && fastPtr.next!=null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        LinkedNode frontPtr = head;
        LinkedNode reversePtr = reverse(slowPtr);
        LinkedNode current = frontPtr;
        while(current!=null) {
            System.out.println("fe"+current.data);
            current = current.next;
        }
        current = reversePtr;
        while(current!=null) {
            System.out.println("be:"+current.data);
            current = current.next;
        }
        while(frontPtr!=null && reversePtr!=null) {
            LinkedNode frontNext = frontPtr.next;
            frontPtr.next = reversePtr;
            frontPtr = frontNext;
            LinkedNode reversePtrNext = reversePtr.next;
            reversePtr.next = frontPtr;
            reversePtr = reversePtrNext;
        }

        if(frontPtr!=null) {
            frontPtr.next = null;
        }


    }

    private static LinkedNode reverse(LinkedNode head) {
        System.out.println("reverse start :"+head.data);
        LinkedNode prev = null;
        LinkedNode current = head;
        while(current!=null) {
            LinkedNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
    public static void main(String args[]) {
        LinkedNode head = new LinkedNode(2);
        head.next = new LinkedNode(4);
        head.next.next = new LinkedNode(6);
        head.next.next.next = new LinkedNode(8);
        head.next.next.next.next = new LinkedNode(10);
        head.next.next.next.next.next = new LinkedNode(12);
        LinkedListAlternative.reorder(head);
        LinkedNode current = head;
        while(current!=null) {
            System.out.println("val:"+current.data);
            current = current.next;
        }
    }

}
