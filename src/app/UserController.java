package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

// class that handles user interactions with the user window
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

    // handles user clicking follow user
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

    // handles user clicking post tweet
    public void postTweet(ActionEvent event) {
        String currentUserId = ((Stage) ((Node) event.getSource()).getScene().getWindow()).getTitle();
        User currentUser = UserDatabaseSingleton.getInstance().getUserMap().get(currentUserId);

        currentUser.setNewsFeedListView(this.newsFeedListView);

        String tweet = currentUserId + ": " + tweetMessageTextArea.getText();

        currentUser.postTweet(tweet);
    }
}
