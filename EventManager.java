package com.company; /**
 * Created by jack on 12/2/2014.
 */

import com.company.CanJamEvent;
import com.company.CornHoleEvent;
import com.company.Event;

/**
 * The event manager manages the events in the application
 */
public class EventManager {
    private Event[] events;
    private Team[] teamM;

    /**
     * Construct a new com.company.EventManager
     */
    public EventManager() {
        events = new Event[] {
                new WashoosEvent(),
                new HorseshoesEvent(),
                new CornHoleEvent(),
                new CanJamEvent(),
                new LadderBallEvent(),
                new StickGameEvent()
        };
    }

    public EventManager(TeamManager teamManager){
        teamM = teamManager.getTeams();
        BracketQueue queue = new BracketQueue();
        queue.createBracketQueue(teamM);
    }
    /**
     * Retrieve the events with getevents and a single event with getoneEvent
     *
     * @return the events
     */
    public Event[] getEvents()
    {
        return events;
    }

    public Team[] getTeams(){
        return teamM;
    }

    public Event getOneEvent(int X){
        return events[X];
    }
}

