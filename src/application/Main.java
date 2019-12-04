package application;
	


import java.util.ArrayList;
import java.util.List;

import contato.model.Cidade;
import contato.model.Contato;
import contato.model.Email;
import contato.model.Endereco;
import contato.model.DAO.CidadeDAO;
import contato.model.DAO.EnderecoDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.ConnectionFactory;



public class Main extends Application {	
	
	
	@Override
	public void start(Stage primaryStage) {		
		try {		
			/*
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PrincipalView.fxml"));	
			Parent p = loader.load();
			Scene scene = new Scene(p);					
			primaryStage.setScene(scene);
			primaryStage.setTitle("SGP Embalagens");
			primaryStage.setMaximized(true);
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("box16.png")));
			
			primaryStage.show();	
			*/	
			
			Email e = new Email();
			e.setIdContato(1);
			e.setNome("gustavo");
			e.setEmail("teste@teste");
			e.setTipoEmail(0);
			
			List<Contato> contatos = new ArrayList<Contato>();
			contatos.add(e);
			
			for(Contato c: contatos) {
				if(c instanceof Email) {
					Email em = (Email) c;
					System.out.println(em.getEmail());
				}
				
			}
								
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
