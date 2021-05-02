package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController  {

	@FXML
    public TextField loginEntrada;

    @FXML
    public PasswordField senhaEntrada;

    @FXML
    private Button btn_acessar;

    
    @FXML
    protected void acessarAgenda(ActionEvent event) {
    	Main.changeScreen("principal");
    }
   
    @FXML
    void telaCadastroLogin(ActionEvent event) {
    	Main.changeScreen("cadastroLogin");
    }
    
}
