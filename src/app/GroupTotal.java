package app;

public class GroupTotal implements Visitable {
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
