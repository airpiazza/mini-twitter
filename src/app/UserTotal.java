package app;

public class UserTotal implements Visitable{
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
