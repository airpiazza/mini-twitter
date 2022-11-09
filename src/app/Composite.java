package app;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Composite class that implements component and represents groups
public class Composite implements Component {
    private List<Component> children;
    private TreeItem<String> parent;

    // Assigns group level tree item, records child components
    public Composite(TreeItem<String> parent, Component... components) {
        this.parent = parent;
        children = new ArrayList<>();
        children.addAll(Arrays.asList(components));
    }

    // adds child tree items to the group level tree item
    @Override
    public TreeItem<String> getId() {
        parent.getChildren().clear();
        for (Component child:
             children) {
            parent.getChildren().add(child.getId());
        }

        return parent;
    }

    // adds component to children list
    public void add(Component child) {
        children.add(child);
    }
}
