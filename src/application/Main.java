package application;
	


import java.util.List;

import contato.model.Cidade;
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
			
			Cidade c = new Cidade();
			c.setIdCidade(2);
			
			Endereco e = new Endereco();
			e.setBairro("centro");
			e.setCep("93800064");
			e.setCidade(c);
			e.setComplemento("apto 403");
			e.setLogradouro("ipiranga");
			e.setNumero("64");
			e.setTipoEndereco(0);
			e.setIdEndereco(1);
			
			List<Endereco>en =new EnderecoDAO(ConnectionFactory.openConnection()).readAll();
			
			System.out.println(en);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
