package app;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite implements Component {
    private List<Component> children;
    private TreeItem<String> parent;

    public Composite(TreeItem<String> parent, Component... components) {
        this.parent = parent;
        children = new ArrayList<>();
        children.addAll(Arrays.asList(components));
    }

    @Override
    public TreeItem<String> getId() {
        parent.getChildren().clear();
        for (Component child:
             children) {
            parent.getChildren().add(child.getId());
        }

        return parent;
    }

    public void add(Component child) {
        children.add(child);
    }
}
