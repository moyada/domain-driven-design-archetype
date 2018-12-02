package ${package}.${subArtifactId}.aggregate;

public abstract class AggregateRoot<T> {

    protected T root;

    public AggregateRoot(T root) {
        this.root = root;
    }

    public final T getRoot() {
        return root;
    }
}
