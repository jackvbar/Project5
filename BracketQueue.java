package com.company;

/**
 * Created by jack on 12/2/2014.
 */
public class BracketQueue {

        private Bracket first;
        private Bracket last;
        private Bracket currItem;
        private int i = 0;

        public BracketQueue() {
            first = last = currItem = new Bracket();

        }

        public void enqueue(Team[] teams) {
            Bracket q = new Bracket(teams);
            if (first == null || first.getValue() == null) {
                first = q;
                last = q;
                currItem = q;
                i++;

            } else {
                last = q;
                currItem.setNext(q);
                currItem = q;
                i++;
            }
        }

        public Team dequeue() {
            if (first == null) {
                return null;
            } else {
                Team returnTeam = first.getValue();
                first = first.getNext();
                i--;
                return returnTeam;
            }
        }

        public void isEmpty(){
            if(first == null){
                System.out.println("queue is empty");
            }else{
                System.out.println("queue is not empty");
            }
        }

    public Team[] peekNextTeams(){
        if (first == null)
                return null;
        else {
            Team temp1 = first.getValue();
            Team temp2 = first.getNext().getValue();
            Team[] teamArray = new Team[2];
            teamArray[0]=temp1;
            teamArray[1]=temp2;
            return teamArray;
        }
    }

    public Team[] dequeueTwoTeams(){
        if(first == null)
            return null;
        else{
            Team t1 = dequeue();
            Team t2 = dequeue();
            Team[] nextTeams = new Team[2];
            nextTeams[0] = t1;
            nextTeams[1] = t2;
            i = i-2;
            return nextTeams;
        }
    }

    public void createBracketQueue(Team[] teams){
        //enqueue all of the teams onto the bracketQueue, randomize!.
        BracketQueue queue = new BracketQueue();
        for (int i=0; i<teams.length; i++){
            queue.enqueue(teams);
        }
    }

        public Bracket getFirst() {
            return first;
        }

        public int getTeamNum(){
            return i;
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

