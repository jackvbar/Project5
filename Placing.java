package com.company;

/**
 * Created by jack on 12/3/2014.
 */
public class Placing {
    //Node class which contains actual payload. Keeping this class private to avoid exposing node object structure.
         //it stores reference to next item in the stack
        private Placing next = null;
        //Node can store data as integer but code can be tweaked to store ArrayList or any other java object.
        private int data = 0;

        public Placing(int value) {
            this.data = value;
        }
    }