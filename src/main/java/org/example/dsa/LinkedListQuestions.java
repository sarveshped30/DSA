package org.example.dsa;

public class LinkedListQuestions {


    public static Node constructLL(int[] arr) {
        Node head = new Node();
        Node current = head;

        for(int a : arr) {
            Node node = new Node(a);
            current.next = node;
            current = node;
        }

        return head.next;
    }

    //Provided Node will never be tail (Guaranteed) because we require previous node to delete tail
    //Provided Node values are unique
    public static void deleteNode(Node node) {
        //If provided node is not tail, then it is guaranteed tha next node will br non-null
        node.data = node.next.data;
        node.next = node.next.next;
    }

    DLNode constructDLL(int arr[]) {
        DLNode dummyHead = new DLNode(0);
        DLNode prev = dummyHead;

        for(int val: arr) {
            DLNode current = new DLNode(val);
            prev.next = current;
            current.prev = prev;
            prev = current;
        }

        DLNode head = dummyHead.next;
        if(head != null) {
            head.prev = null;
        }
        return head;

    }

    DLNode addNode(DLNode head, int p, int x) {
        // Your code here

        DLNode current = head;
        int i = 0;
        while(i < p) {
            current = current.next;
            i++;
        }

        DLNode node = new DLNode(x);
        node.prev = current;
        node.next = current.next;

        current.next = node;

        return head;
    }

    static DLNode deleteNode(DLNode head, int x) {
        DLNode current = head;
        int i = 1;

        while(i < x) {
            current = current.next;
            i++;
        }

        if(current.prev == null) {
            head = current.next;
            head.prev = null;
        } else if(current.next == null) {
            current.prev.next = null;
        } else {
            DLNode prev = current.prev;
            DLNode next = current.next;
            prev.next = next;
            next.prev = prev;
        }


        return head;
    }

    static Node reverseSinglyLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while(current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            if(nextNode == null) {
                head = current;
            }
            current = nextNode;
        }

        return head;
    }

    static DLNode reverseDLL(DLNode head) {
        DLNode current = head;

        while(current != null) {
            DLNode temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            if(temp == null) {
               head = current;
            }
            current = current.prev;
        }

        return head;
    }

    static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next != null && fast.next.next == null) {
            slow = slow.next;
        }

        return slow;
    }

    static Node startOfCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            //Floyd cycle detection algorithm
            //But does not guarantee that pointers meet at start of cycle
            //In order to find start of cycle
            if(slow == fast) {
                slow = head;        // Slow reset to head
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        //Floyd cycle detection algorithm
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DLNode node = new DLNode(29);
        DLNode node1 = new DLNode(78);

        node.next = node1;
        node1.prev = node;

        deleteNode(node, 1);
    }

}


class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
    }

    Node(int data) {
        this.data = data;
    }
}

class DLNode {
    int data;
    DLNode next;
    DLNode prev;

    DLNode() {
        this.data = 0;
    }

    DLNode(int data) {
        this.data = data;
    }

}
