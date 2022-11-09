package app;

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
        double positiveWordCount = 0;
        double totalWords = 0;
        for(String message : MessageDatabaseSingleton.getInstance().getMessageList()) {
            String[] words = message.split(" ");
            totalWords += words.length - 1;
            for(String word : words) {
                for(String positiveWord : positiveWords) {
                    if(word.equalsIgnoreCase(positiveWord)) {
                        System.out.println("word: "+ word);
                        positiveWordCount++;
                    }
                }
            }
        }

        System.out.println("Positive Words: " + positiveWordCount);
        System.out.println("Total Words: " + totalWords);

        return (int) Math.round((positiveWordCount/totalWords) * 100);
    }
}
