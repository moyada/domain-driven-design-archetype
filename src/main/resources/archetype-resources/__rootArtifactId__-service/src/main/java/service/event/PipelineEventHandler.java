package ${package}.service.event;


public interface PipelineEventHandler extends EventHandler {

    void execute(Event event, Context ctx);
}
