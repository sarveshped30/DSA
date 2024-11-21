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
