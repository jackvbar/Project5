package com.company;

/**
 * Created by jack on 12/3/2014.
 */
public class Bracket {

        private Bracket next;
        private Team value;
        private Team[] teams;

        public Bracket() {
            this.next = null;
            this.value = null;
        }

        public Bracket(Team[] teams) {
            this.next=null;
            this.teams = teams;

        }

        public Bracket(Team v) {
            this.next = null;
            this.value = v;
        }

        public Bracket getNext() {
            return next;
        }

        public Team getValue() {
            return value;
        }

        public void setNext(Bracket next) {
            this.next = next;
        }

        public void setValue(Team value) {
            this.value = value;
        }

    }

