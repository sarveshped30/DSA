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

    public static void main(String[] args) {

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
