package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Singleton {
    private static Singleton instance = null;

    private Parent root;

    private Singleton() throws IOException {
        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
    }

    public static Singleton getInstance() throws IOException {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public Parent getRoot() {
        return root;
    }


}
