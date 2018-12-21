package ${package}.service.event;


public abstract class AbstractEventHandler<T extends Event> extends EventFilterSupport<T> implements EventHandler {

    @SuppressWarnings("unchecked")
    @Override
    public void execute(Event event) {
        T e = filterEvent(event);
        if (null == e) {
            return;
        }

        doExecute(e);
    }

    protected abstract void doExecute(T event);
}
