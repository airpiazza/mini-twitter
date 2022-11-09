package app;

// MessagesTotal type that is used in the visitor pattern to help retrieve the total number of messages
public class MessagesTotal implements Visitable{
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
