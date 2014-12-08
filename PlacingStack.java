package com.company;

/**
 * Created by jack on 12/2/2014.
 */
public class PlacingStack {
    //Keeps track of stack size
    private int length = 0;

    //Keep track of node on top of the stack
    private Placing top = null;

    //Push node on top of the stack
    public void push(int item) {
        Placing node = new Placing(item);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }

        length++;
    }

    //Pop (Remove and return) node on top if the stack
    public int pop() {
        int result = -1;
        if (top != null) {
            result = top.data;
            top = top.next;
            length--;
        }
        return result;
    }

    //Returns node what is on top of the stack but does remove that node from the stack
    public int peek() {
        return (top == null) ? -1 : top.data;
    }
}