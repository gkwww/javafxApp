package ldh.descktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import ldh.fx.StageUtil;
import ldh.fx.component.DialogModel;
import ldh.fx.component.LDialog;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeHeadController implements Initializable {

    @FXML private VBox userContent;
    @FXML private Button userBtn;
    @FXML private HBox head;

    private HomeController homeController;
    private Popup userPopup;

    public void setHomeController(HomeController homeController) {
        this.homeController = homeController;
    }

    @FXML
    public void tongleLeftPane(ActionEvent e) {
        homeController.tongleLeftPane();
    }

    @FXML public void showUserPopup(ActionEvent e) {
        double width = userContent.getPrefWidth();
        if (width < 1) {
            width = userContent.prefWidth(-1);
            width = width < 1 ? 200 : width;
        }
        userPopup.show(head.getScene().getWindow(),
                head.getScene().getWindow().getX() + userBtn.localToScene(0, 0).getX() + userBtn.getScene().getX() + userBtn.getWidth() - width -1,
                head.getScene().getWindow().getY() + userBtn.localToScene(0, 0).getY() + userBtn.getScene().getY() + userBtn.getHeight()+2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initPopup();
    }

    private void initPopup() {
        head.getChildren().remove(userContent);
        userContent.getStyleClass().add("nav-user-popup");
        userPopup = new Popup();
        userPopup.setAutoHide(true);
        userPopup.getContent().add(userContent);
    }

    @FXML public void settingBtn(ActionEvent e) {
        LDialog ldhDialog = new LDialog(StageUtil.STAGE, "test", 500d, 600d, DialogModel.Normal);
        VBox box = new VBox();
        for (int i=0; i<10; i++) {
            box.getChildren().add(new Label("asdfasfd"));
        }
        ldhDialog.setContentPane(box);
        ldhDialog.show();
    }

    @FXML public void profileBtn(ActionEvent actionEvent) {
        LDialog ldhDialog = new LDialog(StageUtil.STAGE, "test", 500d, 300d, DialogModel.Normal);
        VBox box = new VBox();
        for (int i=0; i<10; i++) {
            box.getChildren().add(new Label("asdfasfd"));
        }
        ldhDialog.setContentPane(box);
//        ldhDialog.setModel(false);
        ldhDialog.show();
    }

    @FXML public void logoutBtn(ActionEvent actionEvent) {
        StageUtil.exit();
    }
}
