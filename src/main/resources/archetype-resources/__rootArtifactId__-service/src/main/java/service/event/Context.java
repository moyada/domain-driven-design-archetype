package ${package}.service.event;

public interface Context {

    void terminal();

    boolean isTerminal();

    void setCurrentEvent(Event event);

    Event getCurrentEvent();
}
