package contato.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import contato.model.Endereco;
import parceiro.model.Parceiro;

public class EnderecoParceiroDAO {
	private Connection con;
	private PreparedStatement ps;


	public EnderecoParceiroDAO(Connection con) {
		this.con = con;
	}
	
	public void insertRelation(Endereco endereco, Parceiro parceiro) throws SQLException{
		ps = con.prepareStatement("INSERT INTO PARCEIRO_ENDERECO VALUES(?,?)");
		ps.setInt(1, endereco.getIdEndereco());
		ps.setInt(2, parceiro.getIdParceiro());
		ps.executeUpdate();
	}
	
	public void deleteRelation(Endereco endereco) throws SQLException{
		ps = con.prepareStatement("DELETE FROM PARCEIRO_ENDERECO WHERE ID_ENDERECO=?");
		ps.setInt(1, endereco.getIdEndereco());
		ps.executeUpdate();
	}
	
	public void deleteRelation(Parceiro parceiro) throws SQLException{
		ps = con.prepareStatement("DELETE FROM PARCEIRO_ENDERECO WHERE ID_PARCEIRO=?");
		ps.setInt(1, parceiro.getIdParceiro());
		ps.executeUpdate();
	}

}
