package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

        TreeItem<String> userItem = new TreeItem<>(userID);

        Component user = new Leaf(userItem);

        treeItemComponentMap.put(userItem, user);

        parent.add(user);

        parent.getId();

        System.out.println(userID);
    }

    public void addGroup(ActionEvent event) {
        groupID = groupIDTextField.getText();

        TreeItem<String> groupItem = new TreeItem<>(groupID, new ImageView(new Image("C:\\Users\\nick\\IdeaProjects\\MiniTwitter\\src\\app\\folder.png")));

        Component group = new Composite(groupItem);

        treeItemComponentMap.put(groupItem, group);

        parent.add(group);

        parent.getId();

        System.out.println(groupID);
    }

    public void itemClicked() {
        TreeItem <String> treeItem = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();

        if(treeItem != null) {
            System.out.println(treeItem.getValue());

            Component treeNode = treeItemComponentMap.get(treeItem);

            if(treeNode instanceof Composite) {
                parent = (Composite) treeNode;
            }
        }


    }
}
