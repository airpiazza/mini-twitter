package app;

import javafx.scene.control.TreeItem;

// Component interface for composite pattern
public interface Component {
    // this method should return a JavaFX tree item
    public TreeItem<String> getId();
}
