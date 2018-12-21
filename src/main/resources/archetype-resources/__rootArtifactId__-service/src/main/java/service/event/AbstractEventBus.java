package ${package}.service.event;


import java.util.concurrent.ExecutorService;


public abstract class AbstractEventBus implements EventBus {

    private final ExecutorService executorService;

    protected AbstractEventBus(ExecutorService executorService) {
        this.executorService = executorService;
    }

    protected void run(Runnable task) {
        executorService.execute(task);
    }

    @Override
    public void shutdown() {
        executorService.shutdown();
    }
}
