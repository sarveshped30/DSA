package org.example.dsa;

import java.util.ArrayList;
import java.util.List;

public class LinkedListQuestions {

    //Understanding of Equals and hashCode is very imp to solve this question
    public Node getIntersectionNode(Node headA, Node headB) {

        int lengthA = length(headA);
        int lengthB = length(headB);

        if(lengthA > lengthB) {
            headA = moveHead(headA, lengthA - lengthB);
        } else if (lengthB > lengthA) {
            headB = moveHead(headB, lengthB - lengthA);
        }

        while(headA != null && headB != null) {
            if(headA == headB) return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    //Doubly LinkedList delete all occurrence
    static DLNode deleteAllOccurOfX(DLNode head, int x) {
        DLNode dummyHead = new DLNode();
        dummyHead.data = -1;
        dummyHead.next = head;

        DLNode current = dummyHead.next;

        DLNode prev = dummyHead;
        while(current != null) {
            current.prev = prev;
            if(current.data == x) {
                current.prev.next = current.next;
                //prev = current.prev;        //Redundant as current is removed hence prev remains same
            } else {
                prev = current;
            }

            current = current.next;
        }

        if(dummyHead.next != null) {
            dummyHead.next.prev = null;
        }

        return dummyHead.next;
    }

    public Node moveHead(Node head, int count) {
        while (count > 0) {
            head = head.next;
            count--;
        }

        return head;
    }

    public int length(Node head) {
        int count = 0;
        Node node = head;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

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

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DLNode head) {
        ArrayList<ArrayList<Integer>> pairList = new ArrayList<>();

        DLNode tail = head;

        while(tail.next != null) {
            tail = tail.next;
        }

        while (head != null && tail != null && head != tail && tail.next != head) {
            int sum = head.data + tail.data;

            if(sum > target) {
                tail = tail.prev;
            } else if(sum < target) {
                head = head.next;
            } else {
                pairList.add(new ArrayList<Integer>(List.of(head.data, tail.data)));
                head = head.next;
                tail = tail.prev;
            }
        }

        return pairList;
    }

    public static void main(String[] args) {
        /*DLNode node = new DLNode(29);
        DLNode node1 = new DLNode(78);

        node.next = node1;
        node1.prev = node;

        deleteNode(node, 1);*/

        //Merge sort
        /*Node node = new Node(4);
        node.next = new Node(2);
        node.next.next = new Node(1);
        node.next.next.next = new Node(3);

        sortList(node);*/

        Node node1 = new Node(1);
        Node node2 = new Node(1);

        //default implements checks hashCode
        System.out.println(node1.equals(node2));
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

    //Add one to LinkedList (recursion)
    public Node addOne(Node head) {

        int remainder = add(head);

        if(remainder > 0) {
            Node node = new Node(remainder);
            node.next = head;
            head = node;
        }

        return head;
    }

    public int add(Node head) {
        if(head == null) return 1;

        int remainder = add(head.next);

        int sum = head.data + remainder;
        head.data = sum % 10;   //if sum is 10 then remainder will be 0
        return sum / 10;        //if sum is 10, quotient will be 1 else 0
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
