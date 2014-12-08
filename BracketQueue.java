package com.company;

/**
 * Created by jack on 12/2/2014.
 */
public class BracketQueue{

        private Bracket first;
        private Bracket last;
        private Bracket currItem;

        public BracketQueue() {
            first = last = currItem = new Bracket();
        }

        public void enqueue(Team teams) {
            Bracket q = new Bracket(teams);
            if (first == null || first.getValue() == -1) {
                first = q;
                last = q;
                currItem = q;
            } else {
                last = q;
                currItem.setNext(q);
                currItem = q;
            }
        }

        public int dequeue() {
            if (first == null) {
                return -1;
            } else {
                int returnInt = first.getValue();
                first = first.getNext();
                return returnInt;
            }
        }

        public void isEmpty(){
            if(first == null){
                System.out.println("queue is empty");
            }else{
                System.out.println("queue is not empty");
            }
        }

        public void createBracket(Team[] teams){
            BracketQueue bracket = new BracketQueue();
            for( int i = 0; i< teams.length; i++){
                bracket.enqueue(teams[i]);
            }
        }

        public void dequeueTwoTeams(Team team1, Team team2){
            BracketQueue removeTwoItems = new BracketQueue();
            for (int i = 0; i<1; i++){
                removeTwoItems.dequeue(team1)
            }
        }

        public void enqueueWinner(Team team1){
        //might have to take in an int instead of team because of the endcompetition.
        }


        public Bracket getFirst() {
            return first;
        }

        public Bracket getLast() {
            return last;
        }

        public Bracket getCurrItem() {
            return currItem;
        }

        public void setFirst(Bracket first) {
            this.first = first;
        }

        public void setLast(Bracket last) {
            this.last = last;
        }

        public void setCurrItem(Bracket currItem) {
            this.currItem = currItem;
        }

    }

