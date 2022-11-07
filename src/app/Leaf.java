package app;

import javafx.scene.control.TreeItem;

public class Leaf implements Component {

    private TreeItem<String> treeItem;

    public Leaf(TreeItem<String> treeItem) {
        this.treeItem = treeItem;
    }

    @Override
    public TreeItem<String> getId() {
        return treeItem;
    }
}
