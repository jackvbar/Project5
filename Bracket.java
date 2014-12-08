package com.company;

/**
 * Created by jack on 12/3/2014.
 */
public class Bracket {

        private Bracket next;
        private int value;
        private Team teams;

        public Bracket() {
        }

        public Bracket(Team teams) {
            this.next=null;
            this.teams = teams;
        }

        public Bracket(int v) {
            this.next = null;
            this.value = v;
        }

        public Bracket getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Bracket next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

