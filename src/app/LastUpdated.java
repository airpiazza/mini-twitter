package app;

public class LastUpdated implements Visitable {
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
