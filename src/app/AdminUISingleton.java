package app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class AdminUISingleton {
    private static AdminUISingleton instance = null;

    private Parent root;

    private AdminUISingleton() throws IOException {
        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
    }

    public static AdminUISingleton getInstance() throws IOException {
        if(instance == null) {
            instance = new AdminUISingleton();
        }

        return instance;
    }

    public Parent getRoot() {
        return root;
    }


}
