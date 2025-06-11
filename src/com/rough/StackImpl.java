package com.rough;

public class StackImpl {
    private int[] arr;
    private int capacity;
    private int top;

    StackImpl(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x){
        if(isFull()){
            System.out.println("The stack is full. Terminating the program");
            System.exit(1);
        }
        arr[++top] = x;
    }

    private int peek(){
        return arr[capacity - 1];
    }

    public Boolean isFull(){
        return top == capacity - 1;
    }

    public Boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        StackImpl stmpl = new StackImpl(5);

        stmpl.push(3);
        stmpl.push(4);
        stmpl.push(5);stmpl.push(32);stmpl.push(34);
        System.out.println(stmpl.top);
        System.out.println(stmpl.peek());
    }
}
