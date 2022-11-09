package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

// class that handles user interactions with admin UI
public class Controller implements Initializable {
    @FXML
    private TextField userIDTextField;
    @FXML
    private TextField groupIDTextField;
    @FXML
    private Button addUserButton;
    @FXML
    private Button addGroupButton;
    @FXML
    private TreeView treeView;
    @FXML
    private Button openUserViewButton;
    @FXML
    private Button showUserTotalButton;
    @FXML
    private Button showGroupTotalButton;
    @FXML
    private Button showMessagesTotalButton;
    @FXML
    private Button showPositivePercentageButton;

    String userID;

    String groupID;

    Map<TreeItem<String>, Component> treeItemComponentMap;

    Composite parent;

    // add the Root when the admin UI is opened
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Composite root = new Composite(new TreeItem<>("Root", new ImageView(new Image("C:\\Users\\nick\\IdeaProjects\\MiniTwitter\\src\\app\\folder.png"))));

        GroupDatabaseSingleton.getInstance().getGroupList().add("Root");

        TreeItem<String> rootTreeItem = root.getId();

        treeItemComponentMap = new HashMap<>();

        treeItemComponentMap.put(rootTreeItem, root);

        parent = root;

        treeView.setRoot(rootTreeItem);
    }

    // add user when the Add User button is clicked
    public void addUser(ActionEvent event) {
        userID = userIDTextField.getText();

        User newUser = new User(userID);

        UserDatabaseSingleton.getInstance().getUserMap().put(userID, newUser);

        TreeItem<String> userItem = new TreeItem<>(userID);

        Component user = new Leaf(userItem);

        treeItemComponentMap.put(userItem, user);

        parent.add(user);

        parent.getId();

        System.out.println(userID + " added");
    }

    // add group when the Add Group button is clicked
    public void addGroup(ActionEvent event) {
        groupID = groupIDTextField.getText();

        TreeItem<String> groupItem = new TreeItem<>(groupID, new ImageView(new Image("C:\\Users\\nick\\IdeaProjects\\MiniTwitter\\src\\app\\folder.png")));

        Component group = new Composite(groupItem);

        treeItemComponentMap.put(groupItem, group);

        parent.add(group);

        parent.getId();

        GroupDatabaseSingleton.getInstance().getGroupList().add(groupID);

        System.out.println(groupID + " added");
    }

    // open the user's view when Open User View button is clicked
    public void openUserView(ActionEvent event) throws IOException {
        TreeItem <String> treeItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        if(treeItem != null) {
            Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
            Stage userStage = new Stage();
            userStage.setTitle(treeItem.getValue());
            userStage.setScene(new Scene(root));
            userStage.show();
        }
    }

    // handles when a tree item is clicked
    public void itemClicked() {
        TreeItem <String> treeItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        if(treeItem != null) {
            System.out.println(treeItem.getValue() + " clicked");

            Component treeNode = treeItemComponentMap.get(treeItem);

            if(treeNode instanceof Composite) {
                parent = (Composite) treeNode;
            } else {
                parent = (Composite) treeItemComponentMap.get(treeItem.getParent());
            }
        }
    }

    // display dialog of total users when the Show User Total button is clicked
    public void showUserTotal(ActionEvent event) {
        AnalysisVisitor analysisVisitor = new AnalysisVisitor();
        UserTotal userTotal = new UserTotal();

        Text text = new Text(10, 20,"User Total: " + userTotal.accept(analysisVisitor));
        text.setFont(new Font(20));
        Scene scene = new Scene(new Group(text));
        Stage stage = new Stage();
        stage.setTitle("User Total");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // show dialog with total number of groups when the Show Group Total button is clicked
    public void showGroupTotal(ActionEvent event) {
        AnalysisVisitor analysisVisitor = new AnalysisVisitor();
        GroupTotal groupTotal = new GroupTotal();

        Text text = new Text(10, 20, "Group Total: " + groupTotal.accept(analysisVisitor));
        text.setFont(new Font(20));
        Scene scene = new Scene(new Group(text));
        Stage stage = new Stage();
        stage.setTitle("Group Total");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // show dialog with total number of messages when the Show Messages Total button is clicked
    public void showMessagesTotal(ActionEvent event) {
        AnalysisVisitor analysisVisitor = new AnalysisVisitor();
        MessagesTotal messagesTotal = new MessagesTotal();

        Text text = new Text(10, 20, "Messages Total: " + messagesTotal.accept(analysisVisitor));
        text.setFont(new Font(20));
        Scene scene = new Scene(new Group(text));
        Stage stage = new Stage();
        stage.setTitle("Messages Total");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    // show dialog of positive percentage when the Show Positive Percentage button is clicked
    public void showPositivePercentage(ActionEvent event) {
        AnalysisVisitor analysisVisitor = new AnalysisVisitor();
        PositivePercentage positivePercentage = new PositivePercentage();

        Text text = new Text(10, 20, "Positive Percentage: " + positivePercentage.accept(analysisVisitor) + "%");
        text.setFont(new Font(20));
        Scene scene = new Scene(new Group(text));
        Stage stage = new Stage();
        stage.setTitle("Positive Percentage");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}
