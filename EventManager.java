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

    /**
     * Retrieve the events
     *
     * @return the events
     */
    public Event[] getEvents() {
        return events;
    }
}

