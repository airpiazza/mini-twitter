package app;

// AnalysisVisitor implements Visitor and uses database singletons in the visit methods
public class AnalysisVisitor implements Visitor {

    private String[] positiveWords;

    // initialize positiveWords array with selected positive words
    public AnalysisVisitor() {
        this.positiveWords = new String[] {"good", "great", "excellent", "amazing", "awesome", "nice", "beautiful"};
    }

    // returns total number of users
    @Override
    public int visit(UserTotal users) {
        return UserDatabaseSingleton.getInstance().getUserMap().size();
    }

    // returns total number of groups
    @Override
    public int visit(GroupTotal groups) {
        return GroupDatabaseSingleton.getInstance().getGroupList().size();
    }

    // returns total number of messages in all the users' news feeds
    @Override
    public int visit(MessagesTotal messages) {
        return MessageDatabaseSingleton.getInstance().getMessageList().size();
    }

    // returns the percentage of positive tweets in all the users' news feeds
    @Override
    public int visit(PositivePercentage positivity) {
        double positiveMessages = 0;
        for(String message : MessageDatabaseSingleton.getInstance().getMessageList()) {
            for(String positiveWord : positiveWords) {
                if(message.contains(positiveWord)) {
                    positiveMessages++;
                    break;
                }
            }
        }

        System.out.println("Positive messages: " + positiveMessages);
        System.out.println("Total messages: " + MessageDatabaseSingleton.getInstance().getMessageList().size());

        return (int) Math.round((positiveMessages/MessageDatabaseSingleton.getInstance().getMessageList().size()) * 100);
    }
}
