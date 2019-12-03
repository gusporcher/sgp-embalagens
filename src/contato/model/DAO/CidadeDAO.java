package contato.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import contato.model.Cidade;
import utils.GenericDAO;

public class CidadeDAO implements GenericDAO<Cidade> {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CidadeDAO(Connection con) {
		this.con = con;
	}

	@Override
	public Cidade insert(Cidade t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Cidade t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Cidade t) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cidade getObjeto(int id) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM CIDADE WHERE IDCIDADE=?");
		ps.setInt(1, id);

		rs = ps.executeQuery();

		if (rs.next()) {
			return getCidade(rs);
		}

		return null;
	}

	@Override
	public List<Cidade> readAll() throws SQLException {
		ps = con.prepareStatement("SELECT * FROM CIDADE");

		rs = ps.executeQuery();

		List<Cidade> cidades = new ArrayList<>();

		while (rs.next()) {
			cidades.add(getCidade(rs));
		}

		return cidades;
	}

	public List<Cidade> read(String cidade) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM CIDADE WHERE MUNICIPIO ILIKE ?");
		ps.setString(1, "%" + cidade + "%");

		rs = ps.executeQuery();

		List<Cidade> cidades = new ArrayList<>();

		while (rs.next()) {
			cidades.add(getCidade(rs));
		}

		return cidades;
	}

	public List<Cidade> readByEstado(String estado) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM CIDADE WHERE ESTADO ILIKE ?");
		ps.setString(1, "%" + estado + "%");

		rs = ps.executeQuery();

		List<Cidade> cidades = new ArrayList<>();

		while (rs.next()) {
			cidades.add(getCidade(rs));
		}

		return cidades;
	}

	private Cidade getCidade(ResultSet rs) throws SQLException {
		Cidade c = new Cidade();
		c.setIdCidade(rs.getInt("idcidade"));
		c.setMunicipio(rs.getString("municipio"));
		c.setEstado(rs.getString("estado"));
		return c;
	}

}
