package app;

// Visitable interface for different types used in the visitor pattern
public interface Visitable {
    public int accept(Visitor visitor);
}
