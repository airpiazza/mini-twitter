package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController {
    @FXML
    private TextField userIdTextField;
    @FXML
    private Button followUserButton;
    @FXML
    private ListView currentlyFollowingListView;
    @FXML
    private TextArea tweetMessageTextArea;
    @FXML
    private Button postTweetButton;
    @FXML
    private ListView newsFeedListView;

    public void followUser(ActionEvent event) {
        String currentUserId = ((Stage) ((Node) event.getSource()).getScene().getWindow()).getTitle();
        User currentUser = UserDatabaseSingleton.getInstance().getUserMap().get(currentUserId);
        User otherUser = UserDatabaseSingleton.getInstance().getUserMap().get(userIdTextField.getText());

        currentUser.setNewsFeedListView(this.newsFeedListView);

        currentUser.followUser(otherUser);

        currentlyFollowingListView.getItems().add(otherUser.getUserId());

        System.out.println("following " + userIdTextField.getText());
        System.out.println("current user: " + currentUserId);
    }

    public void postTweet(ActionEvent event) {
        String currentUserId = ((Stage) ((Node) event.getSource()).getScene().getWindow()).getTitle();
        User currentUser = UserDatabaseSingleton.getInstance().getUserMap().get(currentUserId);

        currentUser.setNewsFeedListView(this.newsFeedListView);

        String tweet = currentUserId + ": " + tweetMessageTextArea.getText();

        currentUser.postTweet(tweet);
    }
}
