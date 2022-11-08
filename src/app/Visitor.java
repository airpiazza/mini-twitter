package app;

public interface Visitor {
    public int visit(UserTotal users);
    public int visit(GroupTotal groups);
    public int visit(MessagesTotal messages);
    public int visit(PositivePercentage positivity);
}
