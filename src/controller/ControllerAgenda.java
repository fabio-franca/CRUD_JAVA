package controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Contato;
import model.ContatoDao;

public class ControllerAgenda implements Initializable {

	@FXML
    private TextField idContato;

    @FXML
    private TextField nome;

    @FXML
    private TextField sobrenome;

    @FXML
    private TextField idade;

    @FXML
    private TextField telefone;
    
    @FXML
    private TableView<Contato> tabelaAgenda;

    @FXML
    private TableColumn<Contato, Long> idTabela;
    
    @FXML
    private TableColumn<Contato, String> nomeTabela;

    @FXML
    private TableColumn<Contato, String> sobrenomeTabela;

    @FXML
    private TableColumn<Contato, Integer> idadeTabela;

    @FXML
    private TableColumn<Contato, String> telefoneTabela;

    @FXML
    void retornarPrincipal(ActionEvent event) {
    	Main.changeScreen("principal");
    }
    
    ContatoDao dao;
    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		dao = new ContatoDao();
		
		idTabela.setCellValueFactory(new PropertyValueFactory<>("id"));
		nomeTabela.setCellValueFactory(new PropertyValueFactory<>("nome"));
		sobrenomeTabela.setCellValueFactory(new PropertyValueFactory<>("sobrenome"));
		idadeTabela.setCellValueFactory(new PropertyValueFactory<>("idade"));
		telefoneTabela.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		
		listarContato();
	}
	
	//CADASTRAR
	@FXML
    void cadastrarContato(ActionEvent event) {
    	if (idContato.getText().isEmpty()) {
    		
    		Contato contato = new Contato();
    		
    		contato.setNome(nome.getText());
    		contato.setSobrenome(sobrenome.getText());
    		contato.setIdade(Integer.parseInt(idade.getText()));
    		contato.setTelefone(telefone.getText());
    		
    		try {
    			
    			dao.salvarContato(contato);
    			
    			mensagem("Contato Salvo!");
    			listarContato();
    			limpaFormulario();
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    	} else {
    		mensagem("Não é possível cadastrar um contato já existente");
    	} 
    }
    
    @FXML
    void listarContato() {
    	List<Contato> contatos = dao.ConsultarContato();
    	
    	if(!contatos.isEmpty()) {
    		tabelaAgenda.setItems(FXCollections.observableList(contatos));
    	}
    }
    
    @FXML
    void detalhesContato(ActionEvent event) {
    	if (tabelaAgenda.getSelectionModel().getSelectedItem()==null) {
    		mensagemErro("Não existe nenhum contato selecionado");
    	} else {
    		Contato contato = tabelaAgenda.getSelectionModel().getSelectedItem();
    		
    		idContato.setText(String.valueOf(contato.getId()));
    		nome.setText(contato.getNome());
    		sobrenome.setText(contato.getSobrenome());
    		idade.setText(String.valueOf(contato.getIdade()));
    		telefone.setText(contato.getTelefone());
    	}
    }
    
    //ALTERAR
    @FXML
    void atualizarContato(ActionEvent event) {
    	if (!idContato.getText().isEmpty()) {
    		
    		Contato contato = new Contato();
    		
    		contato.setId(Long.parseLong(idContato.getText()));
    		contato.setNome(nome.getText());
    		contato.setSobrenome(sobrenome.getText());
    		contato.setIdade(Integer.parseInt(idade.getText()));
    		contato.setTelefone(telefone.getText());
    		
    		try {
    			
    			dao.editarContato(contato);
    			
    			mensagem("Contato alterado com sucesso!");
    			listarContato();
    			
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    	} else {
    		mensagem("Não é possível cadastrar um contato já existente");
    	}
    }
    
    //EXCLUIR
    @FXML
    void apagarContato(ActionEvent event) {
    	if (tabelaAgenda.getSelectionModel().getSelectedItem()==null) {
    		mensagem("Não existe nenhum contato selecionado");
    	} else {
    		if(mensagemConfirmacao("Você realmente deseja deletar esse contato")) {
    			dao.deletarContato(tabelaAgenda.getSelectionModel().getSelectedItem().getId());
    			
    			listarContato();
    			
    		}
    	}
    }
    
    @FXML
    void limpaFormulario() {
    	idContato.clear();
    	nome.clear();
    	sobrenome.clear();
    	idade.clear();
    	telefone.clear();
    }
    
    private void mensagem(String informacao) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Mensagem do sistema");
    	alert.setHeaderText(null);
    	alert.setContentText(informacao);
    	
    	alert.showAndWait();
    }
    
    private void mensagemErro(String informacao) {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Mensagem do sistema");
    	alert.setHeaderText(null);
    	alert.setContentText(informacao);
    }
    
    private boolean mensagemConfirmacao(String informacao) {
    	Alert alert = new Alert (AlertType.CONFIRMATION);
    	alert.setTitle("Mensagem do sistema");
    	alert.setHeaderText(null);
    	alert.setContentText(informacao);
    	
    	Optional<ButtonType> opcao = alert.showAndWait();
    	
    	if(opcao.get() == ButtonType.OK) {
    		return true;
    	} else {
    		return false;
    	}
    }

}
