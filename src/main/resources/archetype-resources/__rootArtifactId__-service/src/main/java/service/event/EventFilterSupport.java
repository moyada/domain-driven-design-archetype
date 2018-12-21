package ${package}.service.event;

import java.lang.reflect.ParameterizedType;


public class EventFilterSupport<T extends Event> {

    private final Class eventType;

    @SuppressWarnings("unchecked")
    public EventFilterSupport() {
        ParameterizedType type = (ParameterizedType) this.getClass()
                .getGenericSuperclass();
        this.eventType = (Class<T>) type.getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    protected T filterEvent(Event event) {
        if (!eventType.isInstance(event)) {
            return null;
        }
        return (T) event;
    }
}
