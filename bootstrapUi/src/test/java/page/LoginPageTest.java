package page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ldh.common.ui.JavafxMainApplication;
import ldh.common.ui.page.LoginPage;
import org.controlsfx.control.GridView;

public class LoginPageTest extends Application {

    public static Stage STAGE = null;

    public void start(Stage primaryStage) throws Exception {
        LoginPage loginPage = new LoginPage(400, 500);
        loginPage.setStage(primaryStage);
        Scene scene = new Scene(loginPage);
        scene.getStylesheets().addAll("bootstrapfx.css");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.centerOnScreen();
        primaryStage.show();
        STAGE = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
