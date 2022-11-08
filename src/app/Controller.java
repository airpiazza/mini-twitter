package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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

    String userID;

    String groupID;

    Map<TreeItem<String>, Component> treeItemComponentMap;

    Composite parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Composite root = new Composite(new TreeItem<>("Root", new ImageView(new Image("C:\\Users\\nick\\IdeaProjects\\MiniTwitter\\src\\app\\folder.png"))));

        TreeItem<String> rootTreeItem = root.getId();

        treeItemComponentMap = new HashMap<>();

        treeItemComponentMap.put(rootTreeItem, root);

        parent = root;

        treeView.setRoot(rootTreeItem);
    }

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
}
