package com.company; /**
 * Created by jack on 12/2/2014.
 */

import com.company.Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * This class manages a list of competitions.
 */
public class CompetitionManager {
    private EventManager em;
    private TeamManager tm;
    private Competition head;
    private Competition tail;
    private int numCompetitions;

    /**
     * Construct a new com.company.CompetitionManager
     *
     * @param em the event manager that manages which events can be played in a competition
     * @param tm team manager.
     */
    public CompetitionManager(EventManager em, TeamManager tm)
    {
        this.em = em;
        this.tm = tm;
    }

    public void Competition(EventManager em, int EventNum){
        this.em = em;
        BracketQueue compList = new BracketQueue();
        compList.createBracketQueue(em.getTeams());
        PlacingStack placeStack = new PlacingStack();
        int[] doneComps = new int[em.getEvents().length];
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Boolean check = false;
        int i = 0;
    try {
        while (check == false) {
            System.out.println("What event would you like to play? Enter the Number 1 for Washoos, 2 for Horseshoes, 3 for Cornhole, 4 for CanJam, 5 for LadderBall, and 6 for StickBall");
            EventNum = Integer.parseInt(userInput.readLine());
            if (!Arrays.asList(doneComps).contains(EventNum)) {
                check = true;
                doneComps[i] = EventNum;
                i++;
            }
            if (EventNum > em.getEvents().length) {
                System.out.println("please enter a number between 1-8");
            } else {
                Event currEvent = em.getOneEvent(EventNum);
                System.out.println("Currently Creating a competition of " + em.getOneEvent(EventNum));
            }
            while (compList.peekNextTeams() != null){
                Team[] playingTeams = compList.dequeueTwoTeams();
                Random rn = new Random();
                Team team1;
                Team team2;
                Team[] winner = new Team[1];
                int n = 1 - 0 + 1;
                int j = rn.nextInt() % n;
                int random1 =  0 + j;
                Random rNum = new Random();
                int k = 1 - 0 + 1;
                int s = rNum.nextInt() % k;
                int random2 =  0 + s;
                if (random1>random2){
                     team1 = winner[0];
                     team2 = playingTeams[1];
                     compList.enqueue(winner);
                     placeStack.push(team2);
                }else {
                    team1 = playingTeams[1];
                    team2 = winner[0];
                    compList.enqueue(winner);
                    placeStack.push(team1);
                }
            }
            int count = 1;
            System.out.println("Competition has ended. Here are the results");
            while (!placeStack.isEmpty()) {
                System.out.println(count + ": " + placeStack.pop().toString());
                count++;
            }
        }
    }catch(IOException io) {
        System.out.println('0');
    }}

    /**
     * Start a new competition, this competition will exist until endCompetition is called
     *
     * @param event the event that this competition will be played
     * @param homeTeam the home team playing this competition
     * @param awayTeam the away team playing this competition
     */
   /* public void startCompetition(Event event, Team homeTeam, Team awayTeam)
    {
        //create the new competition object
        Competition newItem = new Competition(event, homeTeam, awayTeam);

        //if no competitions currently going on
        if(tail == null)
            head = tail = newItem;
            //otherwise, add to the end
        else
        {
            newItem.setPrev(tail);
            tail.setNext(newItem);
            tail = newItem;
        }
        numCompetitions++;
    }

    /**
     * Retrieve the currently started competitions
     *
     * @return An array of competitions that are currently going on
     */
    public ICompetition[] getCompetitions()
    {
        //convert the linked list of competitions to an array of competitions
        ICompetition[] competitions = new ICompetition[numCompetitions];
        Competition currItem = head;

        int currIdx = 0;
        while(currItem != null) {
            competitions[currIdx++] = currItem;
            currItem = currItem.getNext();
        }

        return competitions;
    }

    /**
     * End a competition.
     *
     * @param competition the competition to end
     * @param winningTeam the team that won the competition
     */
    public void endCompetition(ICompetition competition, Team winningTeam)
    {
        Competition currItem = head;

        //find the item (or find the end of the list
        while(currItem != null && currItem != competition)
            currItem = currItem.getNext();

        //if we made it to the end, competition provided is not in our list. Just return
        if(currItem == null)
            return;

        //found it, remove it
        numCompetitions--;

        if(currItem == head)
            head = currItem.getNext();
        if(currItem == tail)
            tail = currItem.getPrev();
        if(currItem.getPrev() != null)
            currItem.getPrev().setNext(currItem.getNext());
        if(currItem.getNext() != null)
            currItem.getNext().setPrev(currItem.getPrev());

        //update the stats for the winning/losing teams
        if(currItem.getHomeTeam() == winningTeam) {
            currItem.getHomeTeam().incrementWins();
            currItem.getAwayTeam().incrementLosses();
        }
        else
        {
            currItem.getHomeTeam().incrementLosses();
            currItem.getAwayTeam().incrementWins();
        }
    }

    /**
     * Retrieve the events that are currently not being played (they are open).
     *
     * @return an array of events that are open
     */
    public Event[] getFreeEvents()
    {
        Event[] allEvents = em.getEvents();
        //free events is number of events minus number of competitions (one event per competition)
        Event[] freeEvents = new Event[allEvents.length - numCompetitions];

        int currIdx = 0;

        //iterate through all events, only add ones that are free
        for(int i=0; i < allEvents.length; i++)
        {
            if(isEventFree(allEvents[i]))
                freeEvents[currIdx++] = allEvents[i];
        }

        return freeEvents;
    }

    /**
     * Retrieve the teams that are currently not playing (they are open).
     *
     * @return an array of teams that are open
     */
    public Team[] getFreeTeams()
    {
        Team[] allTeams = tm.getTeams();
        //free teams is number of teams minus 2*number of competitions (two teams per competition)
        Team[] freeTeams = new Team[allTeams.length - (numCompetitions*2)];

        int currIdx = 0;

        //iterate through all teams, only add ones that are free
        for(int i=0; i < allTeams.length; i++)
        {
            if(isTeamFree(allTeams[i]))
                freeTeams[currIdx++] = allTeams[i];
        }

        return freeTeams;
    }

    /**
     * Determine if an event is currently free
     *
     * @param event the event to check for
     *
     * @return true if the event is free, false otherwise
     */
    private boolean isEventFree(Event event)
    {
        Competition currItem = head;

        while(currItem != null)
        {
            if(currItem.getEvent() == event)
                return false;

            currItem = currItem.getNext();
        }
        return true;
    }

    /**
     * Determine if a team is currently free
     *
     * @param team the team to check for
     *
     * @return true if the team is free, false otherwise
     */
    private boolean isTeamFree(Team team)
    {
        Competition currItem = head;

        while(currItem != null)
        {
            if(currItem.getHomeTeam() == team || currItem.getAwayTeam() == team)
                return false;

            currItem = currItem.getNext();
        }
        return true;
    }
}


