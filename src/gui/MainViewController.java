package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
    
    @FXML //esse três são os atributos de item de menu
    private MenuItem menuItemSeller;//(1)SELLER - VENDEDOR
    @FXML
    private MenuItem menuItemDepartment;//(2)DEPARTMENT - DEPARTAMENTO
    @FXML
    private MenuItem menuItemAbout;//(3)HELP - AJUDA
    
    @FXML //Metodo para tratar os eventos do menu
    public void onMenuItemSellerAction(){
        System.out.println("onMenuItemSellerAcrion");
    }
    
    @FXML //Metodo para tratar os eventos do menu
    public void onMenuItemDepartmentAction() {
        System.out.println("onMenuItemDepartmentAcrion");
    }
    
    @FXML //Metodo para tratar os eventos do menu
    public void onMenuItemAboutAcrion() {
        System.out.println("onMenuItemAboutAcrion");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
