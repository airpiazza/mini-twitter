package app;

public class GroupIdValidation implements Visitable {
    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
