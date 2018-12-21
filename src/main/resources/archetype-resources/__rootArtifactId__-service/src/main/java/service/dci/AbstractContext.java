package ${package}.service.dci;

import ${package}.service.dci.Context;


public abstract class AbstractContext<A, B, E, R> implements Context<E, R> {

    protected final B assign;

    public AbstractContext(A assign) {
        if (null == assign) {
            throw new NullPointerException("construct argument is null");
        }
        this.assign = transferTo(assign);
    }

    abstract B transferTo(A assign);
}