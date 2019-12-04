package contato.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import contato.model.Contato;
import contato.model.Email;
import parceiro.model.Parceiro;
import parceiro.model.Representante;

public class EmailDAO extends ContatoDAO{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmailDAO(Connection con) {
		super(con);
		this.con = con;
	}

	public Email insert(Email email) throws SQLException{
		email.addContato(super.insert(email));
		return insert(email);
	}
	
	public void update(Email email) throws SQLException{
		super.update(email);
		updateEmail(email);
		
	}
	
	public void delete(Email email) throws SQLException{
		deleteEmail(email);
		super.delete(email);
	}
	
	public Email getObject(int id) throws SQLException{
		ps = con.prepareStatement("SELECT * FROM EMAIL WHERE ID_CONTATO=?");
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return getEmail(rs);
		}
		return null;
	}
	
		
	public List<Email> readAll(Parceiro parceiro) throws SQLException{
		ps = con.prepareStatement("SELECT E.ID_CONTATO, E.NOME, E.TIPO FROM EMAIL AS E "
				+ "INNER JOIN PARCEIRO_CONTATO AS RR "
				+ "ON E.ID_CONTATO = RR.ID_CONTATO "
				+ "WHERE RR.ID_PARCEIRO = ?");
		ps.setInt(1, parceiro.getIdParceiro());
		
		rs = ps.executeQuery();
		
		List<Email>emails = new ArrayList<Email>();
		
		while(rs.next()) {
			emails.add(getEmail(rs));
		}
		return emails;
	}
	
	public List<Email> read(Representante r) throws SQLException{
		ps = con.prepareStatement("SELECT E.ID_CONTATO, E.NOME, E.TIPO FROM EMAIL AS E "
				+ "INNER JOIN REPRESENTANTE_CONTATO AS RR "
				+ "ON E.ID_CONTATO = RR.ID_CONTATO "
				+ "WHERE RR.ID_REPRESENTANTE = ?");
		ps.setInt(1, r.getIdRepresentante());
		
		rs = ps.executeQuery();
		
		List<Email>emails = new ArrayList<Email>();
		
		while(rs.next()) {
			emails.add(getEmail(rs));
		}
		return emails;
	}
	
	
	private void deleteEmail(Email email) throws SQLException{
		ps =con.prepareStatement("DELETE FROM EMAIL WHERE ID_CONTATO=?");
		ps.setInt(1, email.getIdContato());
		ps.executeUpdate();
		
	}
	private void updateEmail(Email email) throws SQLException{
		ps =con.prepareStatement("UPDATE EMAIL SET EMAIL=?, TIPO=? WHERE ID_CONTATO=?");
		ps.setString(1, email.getEmail());
		ps.setInt(2, email.getTipoEmail());
		ps.setInt(3, email.getIdContato());
		ps.executeUpdate();
	}
	
	private Email insertEmail(Email email) throws SQLException{
		ps = con.prepareStatement("INSERT INTO EMAIL(EMAIL, TIPO, ID_CONTATO) VALUES(?,?,?)");
		ps.setString(1, email.getEmail());
		ps.setInt(2, email.getTipoEmail());
		ps.setInt(3, email.getIdContato());
		ps.executeUpdate();
		return email;
	}
	
	private Email getEmail(ResultSet rs) throws SQLException{
		Email e = new Email();
		e.addContato(super.getObjeto(rs.getInt("id_contato")));
		e.setEmail(rs.getString("email"));
		e.setTipoEmail(rs.getInt("tipo"));
		return e;
	}
	
}
