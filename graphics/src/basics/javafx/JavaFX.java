package basics.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX extends Application {
    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        StackPane stackPane = new StackPane(label);
        Scene scene = new Scene(stackPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
    	// https://gluonhq.com/products/javafx/
    	// Unzip
    	// Include in project
    	// Add e(fx)clipse from Help -> install new software
    	// Run as -> Run configurations -> Arguments -> VM Arguments
    	// --module-path "(...)\javafx-sdk-version\lib" --add-modules javafx.controls
    	//,javafx.media
        launch();
    }
}
