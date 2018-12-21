package ${package}.service.event;

import java.util.ArrayList;
import java.util.List;

public abstract class PipelineEventHandlerExecutor<T extends Event> extends AbstractEventHandler<T> implements EventHandler {

    private List<PipelineEventHandler> pipelineHandler;

    public PipelineEventHandlerExecutor() {
        pipelineHandler = new ArrayList<>();
        initHandler(pipelineHandler);
    }

    abstract void initHandler(List<PipelineEventHandler> pipelineHandler);

    protected Context newContext() {
        return new Context() {

            private Event event;
            private boolean state = false;

            @Override
            public void terminal() {
                state = true;
            }

            @Override
            public boolean isTerminal() {
                return state;
            }

            @Override
            public void setCurrentEvent(Event event) {
                this.event = event;
            }

            @Override
            public Event getCurrentEvent() {
                return event;
            }
        };
    }

    @Override
    public void doExecute(Event event) {
        Context ctx = newContext();
        ctx.setCurrentEvent(event);

        int size = pipelineHandler.size() - 1;
        for (int i = 0; i < size; i++) {
            pipelineHandler.get(i).execute(ctx.getCurrentEvent(), ctx);
            if (ctx.isTerminal()) {
                break;
            }
        }

        pipelineHandler.get(size).execute(ctx.getCurrentEvent(), ctx);
    }
}