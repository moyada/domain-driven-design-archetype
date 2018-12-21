package ${package}.service.event;


public abstract class AbstractPipelineEventHandler<T extends Event> extends EventFilterSupport<T> implements PipelineEventHandler {

    @SuppressWarnings("unchecked")
    @Override
    public void execute(Event event, Context ctx) {
        T e = filterEvent(event);
        if (null == e) {
            return;
        }

        doExecute(e, ctx);
    }

    @Override
    @Deprecated
    public void execute(Event event) {
    }

    protected abstract void doExecute(T event, Context ctx);
}
