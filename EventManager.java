/**
 * Created by jack on 11/30/2014.
 */
/**
 * The event manager manages the events in the application
 */
public class EventManager {
    private Event[] events;

    /**
     * Construct a new EventManager
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

