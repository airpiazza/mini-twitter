package app;

// UserTotal type that is used in the visitor pattern to help retrieve total number of users
public class UserTotal implements Visitable{
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
