package contato.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contato.model.Contato;
import contato.model.Email;
import parceiro.model.Representante;
import utils.GenericDAO;

public class ContatoDAO implements GenericDAO<Contato> {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public ContatoDAO(Connection con) {
		this.con = con;
	}

	@Override
	public Contato insert(Contato t) throws SQLException {
		ps = con.prepareStatement("INSERT INTO CONTATO(NOME) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, t.getNome());
		ps.executeUpdate();

		rs = ps.getGeneratedKeys();

		if (rs.next()) {
			t.setIdContato(rs.getInt(1));
			return t;
		}
		return null;
	}

	@Override
	public void update(Contato t) throws SQLException {
		ps = con.prepareStatement("UPDATE CONTATO SET NOME=? WHERE IDCONTATO=?");
		ps.setString(1, t.getNome());
		ps.setInt(2, t.getIdContato());
		ps.executeUpdate();

	}

	@Override
	public void delete(Contato t) throws SQLException {
		ps = con.prepareStatement("DELETE FROM contato WHERE idcontato =?");
		ps.setInt(1, t.getIdContato());
		ps.executeUpdate();

	}

	@Override
	public Contato getObjeto(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> readAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
