package com.company; /**
 * Created by jack on 12/2/2014.
 */

import com.company.Event;

/**
 * The com.company.ICompetition interface provides the contract for exploiters to retrieve information about a competition.
 */
public interface ICompetition {

    /**
     * Retrieve the event that this competition is taking place
     *
     * @return the event that this competition is taking place
     */
    public Event getEvent();

    /**
     * Retrieve the home team taking part in this competition
     *
     * @return the home team taking part in this competition
     */
    public Team getHomeTeam();

    /**
     * Retrieve the away team taking part in this competition
     *
     * @return the away team taking part in this competition
     */
    public Team getAwayTeam();
}
