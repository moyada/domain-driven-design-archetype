package ${package}.${subArtifactId}.entity;

public abstract class Entity<T> {

    private T id;

    public boolean isEquals(Entity<T> entity) {
        return id.equals(entity.id);
    }
}
