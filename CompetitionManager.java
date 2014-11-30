/**
 * Created by jack on 11/30/2014.
 */
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
     * Construct a new CompetitionManager
     *
     * @param em the event manager that manages which events can be played in a competition
     * @param tm the team manager that manages the teams that can participate in a competition
     */
    public CompetitionManager(EventManager em, TeamManager tm)
    {
        this.em = em;
        this.tm = tm;
    }

    /**
     * Start a new competition, this competition will exist until endCompetition is called
     *
     * @param event the event that this competition will be played
     * @param homeTeam the home team playing this competition
     * @param awayTeam the away team playing this competition
     */
    public void startCompetition(Event event, Team homeTeam, Team awayTeam)
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

