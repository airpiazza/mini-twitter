package app;

import java.util.HashSet;
import java.util.Set;

public class AnalysisVisitor implements Visitor {

    private String[] positiveWords;

    public AnalysisVisitor() {
        this.positiveWords = new String[] {"good", "great", "excellent", "amazing", "awesome", "nice", "beautiful"};
    }


    @Override
    public int visit(UserTotal users) {
        return UserDatabaseSingleton.getInstance().getUserMap().size();
    }

    @Override
    public int visit(GroupTotal groups) {
        return GroupDatabaseSingleton.getInstance().getGroupList().size();
    }

    @Override
    public int visit(MessagesTotal messages) {
        return MessageDatabaseSingleton.getInstance().getMessageList().size();
    }

    @Override
    public int visit(PositivePercentage positivity) {
        double positiveMessages = 0;
        double totalWords = 0;
        for(String message : MessageDatabaseSingleton.getInstance().getMessageList()) {
            String[] words = message.split(" ");
            for(String word : words) {
                totalWords++;
                for(String positiveWord : words) {
                    if(word.contains(positiveWord)) {
                        positiveMessages++;
                    }
                }
            }
        }

        return (int) Math.round(positiveMessages/totalWords);
    }
}
