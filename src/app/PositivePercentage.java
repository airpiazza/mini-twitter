package app;

// PositivePercentage type that is used in the visitor pattern to help retrieve positive percentage
public class PositivePercentage implements Visitable{
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
