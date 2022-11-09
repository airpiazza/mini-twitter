package app;

// GroupTotal type that is used in visitor pattern to help retrieve the total number of groups
public class GroupTotal implements Visitable {
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
