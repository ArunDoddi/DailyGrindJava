package com.rough;

public class CustomLinkedList {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }

    private CustomLinkedList insertNode(CustomLinkedList list, int data){
        Node nd = new Node(data);

        if(list.head == null){
            list.head = nd;
        }else {
            Node lastNode = list.head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = nd;
        }
        return list;
    }

    private void printList(CustomLinkedList list){
        Node currNode = list.head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    private int listSize(CustomLinkedList list){
        int count = 0;

        Node currentNode = list.head;
        while (currentNode != null){
            count ++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public static void main(String[] args){
        CustomLinkedList list = new CustomLinkedList();

        list.insertNode(list, 8);
        list.insertNode(list, 10);
        System.out.println(list.listSize(list));
    }
}
