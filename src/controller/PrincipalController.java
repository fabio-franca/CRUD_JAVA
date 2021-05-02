package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PrincipalController {

	  @FXML
	    void cadastroContatoTela(ActionEvent event) {
		  Main.changeScreen("AgendaContato");
	    }

	    @FXML
	    void cadastroUsuarioTela(ActionEvent event) {
	    	Main.changeScreen("cadastroLogin");
	    }
}
