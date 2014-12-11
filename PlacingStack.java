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
    public void push(Team item) {
        Placing place = new Placing(item);
        if (top == null) {
            top = place;
        } else {
            place.next = top;
            top = place;
        }
        length++;
    }

    //Pop (Remove and return) node on top if the stack
    public Team pop() {
        Team result = null;
        if (top != null) {
            result = top.teamData;
            top = top.next;
            length--;
        }
        return result;
    }

    public Boolean isEmpty(){
        if (top == null)
                return true;
        else{
            return false;
        }
    }
}

