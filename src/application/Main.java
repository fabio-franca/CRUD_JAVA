package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	private static Stage stage;
	
	private static Scene mainScene;
	private static Scene principalScene;
	private static Scene cadastroLoginScene;
	private static Scene agendaScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			stage = primaryStage; //inicializa a constante stage no primaryStage
		
			primaryStage.setTitle("Projeto Agenda Java");
			
			Parent fxmlMain = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			mainScene = new Scene(fxmlMain);
			
			Parent fxmlPrincipal = FXMLLoader.load(getClass().getResource("../view/Principal.fxml"));
			principalScene = new Scene(fxmlPrincipal);
			
			Parent fxmlDetails = FXMLLoader.load(getClass().getResource("../view/CadastroLogin.fxml"));
			cadastroLoginScene = new Scene(fxmlDetails);
			
			Parent fxmlAgenda = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
			agendaScene = new Scene(fxmlAgenda);
			
			
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(mainScene);
			primaryStage.show();
		
	}
	
	public static void changeScreen(String scr) {
		switch (scr) {
			case "main":
				stage.setScene(mainScene);
				break;
			case "principal":
				stage.setScene(principalScene);
				break;
			case "cadastroLogin":
				stage.setScene(cadastroLoginScene);
				break;
			case "AgendaContato":
				stage.setScene(agendaScene);
		}
	}	

	public static void main(String[] args) {
	launch(args);
}	
	
	/*@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Projeto Agenda Java");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	} */
}
