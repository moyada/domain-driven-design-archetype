package ${package}.service.event;


public interface PipelineEventHandler {

    void execute(Event event, Context ctx);
}
