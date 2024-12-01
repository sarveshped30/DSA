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

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
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

    // Function to find the length of a loop in the linked list.
    public int countNodesInLoop(Node head) {
        int count = 0;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;

                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                do {
                    count++;
                    fast = fast.next;
                } while (slow != fast);

                return count;
            }
        }

        return count;
    }

    static boolean isPalindrome(Node head) {

        //Find Middle Node
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Second half reversal
        Node secondHead = slow;
        Node previosNode = null;

        while (secondHead != null) {
            Node next = secondHead.next;
            secondHead.next = previosNode;
            previosNode = secondHead;
            secondHead = next;
        }

        //Compare two LL's
        while(head != null && previosNode != null) {
            if(head.data != previosNode.data) return false;

            head = head.next;
            previosNode = previosNode.next;
        }

        return true;
    }

    public static void main(String[] args) {
        /*DLNode node = new DLNode(29);
        DLNode node1 = new DLNode(78);

        node.next = node1;
        node1.prev = node;

        deleteNode(node, 1);*/

        //Merge sort
        Node node = new Node(4);
        node.next = new Node(2);
        node.next.next = new Node(1);
        node.next.next.next = new Node(3);

        sortList(node);
    }

    public static Node sortList(Node head) {
        return mergeSort(head);
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node middle = middle(head);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    public static Node merge(Node left, Node right) {
        if(left == null) return right;
        if(right == null) return left;

        Node result = null;
        if(left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public static Node middle(Node node) {
        if(node == null) return node;

        Node slow = node;
        Node fast = node;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //Segregate zero's, one's and two's
    static Node segregate(Node head) {
        Node zero = new Node(-1), zeroHead = zero;
        Node one = new Node(-1), oneHead = one;
        Node two = new Node(-1), twoHead = two;

        Node node = head;

        while(node != null) {
            if(node.data == 0) {
                Node nextNode = node.next;
                node.next = null;
                zero.next = node;
                zero = zero.next;
                node = nextNode;
            } else if (node.data == 1) {
                Node nextNode = node.next;
                node.next = null;
                one.next = node;
                one = one.next;
                node = nextNode;
            } else {
                Node nextNode = node.next;
                node.next = null;
                two.next = node;
                two = two.next;
                node = nextNode;
            }
        }

        if(oneHead.next != null) {
            zero.next = oneHead.next;
            one.next = twoHead.next;
        } else {
            zero.next = twoHead.next;
        }

        return zeroHead.next;

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
