package ${package}.service.event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class SimpleEventBus extends AbstractEventBus implements EventBus {

    private List<EventHandler> pipeline = new ArrayList<EventHandler>();

    public SimpleEventBus() {
        super(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
    }

    @Override
    public EventBus addEventHandler(EventHandler handler) {
        if (!pipeline.contains(handler)) {
            pipeline.add(handler);
        }
        return this;
    }
    
    @Override
    public EventBus removeEventHandler(EventHandler handler) {
        pipeline.remove(handler);
        return this;
    }

    @Override
    public void onEvent(final Event event) {
        for (final EventHandler eventHandler : pipeline) {
            run(new Runnable() {
                @Override
                public void run() {
                    eventHandler.execute(event);
                }
            });
        }
    }
}
