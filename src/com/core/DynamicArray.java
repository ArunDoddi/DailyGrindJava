package com.core;

public class DynamicArray {
    private Object[] array;
    private int size;

    public DynamicArray(){
        this(5);
    }

    public DynamicArray(int size){
        if(size < 0) throw new IllegalArgumentException("Illegal Capacity: " + size);
        this.size = size;
        array = new Object[size];
    }

    public int getSize(){
        return array.length;
    }

    public boolean isEmpty(){
        return array.length == 0;
    }

    public void insert(int element){

    }
}
