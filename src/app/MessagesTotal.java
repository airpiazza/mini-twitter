package app;

public class MessagesTotal implements Visitable{
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
