package ${package}.service.dci;


public interface Context<U, R> {

    R apply(U u) throws Throwable;
}
