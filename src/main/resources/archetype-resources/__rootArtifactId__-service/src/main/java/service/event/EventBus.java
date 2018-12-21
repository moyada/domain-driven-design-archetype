package ${package}.service.event;


public interface EventBus {

    EventBus addEventHandler(EventHandler handler);

    EventBus removeEventHandler(EventHandler handler);

    void onEvent(Event event);

    void shutdown();
}
