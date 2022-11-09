package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

    // method that pops open the admin panel runs when the application is launched
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = Singleton.getInstance().getRoot();
        primaryStage.setTitle("Admin Control Panel");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // launches application
    public static void main(String[] args) {
        launch(args);
    }
}
