package app;

import javafx.scene.control.TreeItem;

// Leaf component in the composite pattern
public class Leaf implements Component {

    private TreeItem<String> treeItem;

    // tree item represents a user in the tree
    public Leaf(TreeItem<String> treeItem) {
        this.treeItem = treeItem;
    }

    // returns the tree item representing the user
    @Override
    public TreeItem<String> getId() {
        return treeItem;
    }
}
