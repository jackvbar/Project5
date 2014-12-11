package com.company;

/**
 * Created by jack on 12/3/2014.
 */
public class Placing {
        //Node class which contains actual payload. Keeping this class private to avoid exposing node object structure.
        //it stores reference to next item in the stack
        public Placing next = null;
        //Node can store data as integer but code can be tweaked to store ArrayList or any other java object.
        public Team teamData;

        public Placing(Team value) {
            this.teamData = value;
        }

        public Team getTeam(){
            return this.teamData;
        }

        public void setTeam(Team team){
            this.teamData = team;
        }

        public Placing getNext(){
            return this.next;
        }

        public void setNext(Placing nextPlace){
            this.next = nextPlace;
        }

}
