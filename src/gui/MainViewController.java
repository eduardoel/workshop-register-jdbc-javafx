package gui;

import application.Main;
import gui.util.Alerts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class MainViewController implements Initializable {

    @FXML //These three are menu item attributes - Esse três são os atributos de item de menu
    private MenuItem menuItemSeller;//(1)SELLER - VENDEDOR
    @FXML
    private MenuItem menuItemDepartment;//(2)DEPARTMENT - DEPARTAMENTO
    @FXML
    private MenuItem menuItemAbout;//(3)HELP - AJUDA

    @FXML //Method for handling menu events - Metodo para tratar os eventos do menu
    public void onMenuItemSellerAction() {
        System.out.println("onMenuItemSellerAcrion");
    }

    @FXML //Method for handling menu events - Metodo para tratar os eventos do menu
    public void onMenuItemDepartmentAction() {
        loadView2("/gui/DepartmentList.fxml");
    }

    @FXML //Method for handling menu events - Metodo para tratar os eventos do menu
    public void onMenuItemAboutAction() {
        loadView("/gui/About.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    //SYNCHRONIZED is to ensure that it is not interrupted - SYNCHRONIZED para garantir que não seja interrompido
    private synchronized void loadView(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
    
    private synchronized void loadView2(String absoluteName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
            
            DepartmentListControler controller = loader.getController();
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
        }
    }
}
