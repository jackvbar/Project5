package com.company; /**
 * Created by jack on 12/2/2014.
 */
/**
 * The implementation of the com.company.ICompetition interface.  This implementation allows multiple instances of a com.company.Competition
 * to be chained together in a doubly linked list.
 */
public class Competition implements ICompetition {
    private Event event;
    private Team homeTeam;
    private Team awayTeam;

    private Competition next;
    private Competition prev;

    /**
     * Construct a new com.company.Competition
     *
     * @param event the event associated with this competition
     * @param homeTeam the home team associated with this competition
     * @param awayTeam the away team associated with this competition
     */
    public Competition(Event event, Team homeTeam, Team awayTeam) {
        this.event = event;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    /**
     * Retrieve the event that this competition is taking place
     *
     * @return the event that this competition is taking place
     */
    public Event getEvent() {
        return event;
    }

    /**
     * Retrieve the home team taking part in this competition
     *
     * @return the home team taking part in this competition
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /**
     * Retrieve the away team taking part in this competition
     *
     * @return the away team taking part in this competition
     */
    public Team getAwayTeam() {
        return awayTeam;
    }

    /**
     * Retrieve the next competition linked to this competition
     *
     * @return the next competition linked to this competition
     */
    public Competition getNext() {
        return next;
    }

    /**
     * Set the next competition linked to this competition
     *
     * @param next the next competition linked to this competition
     */
    public void setNext(Competition next) {
        this.next = next;
    }

    /**
     * Retrieve the previous competition linked to this competition
     *
     * @return the previous competition linked to this competition
     */
    public Competition getPrev() {
        return prev;
    }

    /**
     * Set the previous competition linked to this competition
     *
     * @param prev the previous competition linked to this competition
     */
    public void setPrev(Competition prev) {
        this.prev = prev;
    }
}


