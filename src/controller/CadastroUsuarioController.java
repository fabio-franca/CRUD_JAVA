package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.LoginUsuario;
import model.LoginUsuarioDao;

public class CadastroUsuarioController  extends LoginController  implements Initializable{

	   @FXML
	    private TextField idUsuario;

	    @FXML
	    private TextField loginCadastro;

	    @FXML
	    private PasswordField senhaCadastro;
	    
	    @FXML
	    private Button btn_cadastrarUsuario;
	    
	    @FXML
	    void telaLogin(ActionEvent event) {
	    	Main.changeScreen("principal");
	    }
	    
	    LoginUsuarioDao dao;
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			
			dao = new LoginUsuarioDao();
			
		}
	    
	    @FXML
	    protected void registrarUsuario(ActionEvent e) {
	    
	    	if (idUsuario.getText().isEmpty()) {
	    		
	    		LoginUsuario loginUsuario = new LoginUsuario();
	    		
	    		loginUsuario.setLogin(loginCadastro.getText());
	    		loginUsuario.setSenha(senhaCadastro.getText());
	    		
	    		
	    		try {
	    			
	    			dao.salvarUsuario(loginUsuario);
	    			
	    			mensagem("Contato Salvo!");
	    			limpaFormulario();
	    			
	    		} catch (Exception ee) {
	    			ee.printStackTrace();
	    		}
	    		
	    	} else {
	    		mensagem("Não é possível cadastrar um contato já existente");
	    	} 
	    }
	    

	    @FXML
	    protected void acessarAcao(ActionEvent e) {
	    	if(loginEntrada.equals(loginCadastro) && senhaEntrada.equals(senhaCadastro)) {
	    		System.out.println("Entrada permitida");
	    	} else {
	    		System.out.println("Entrada negada");
	    	}
	    }
	    
	    //LimpaFormulario
	    @FXML
	    void limpaFormulario() {
	    	idUsuario.clear();
	    	loginCadastro.clear();
	    	senhaCadastro.clear();
	    
	    }
	    
	    //Mensagem do sistema
	    private void mensagem(String informacao) {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Mensagem do sistema");
	    	alert.setHeaderText(null);
	    	alert.setContentText(informacao);
	    	
	    	alert.showAndWait();
	    }
	    
}
