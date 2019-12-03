package contato.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contato.model.Cidade;
import contato.model.Endereco;
import parceiro.model.Parceiro;
import utils.GenericDAO;

public class EnderecoDAO implements GenericDAO<Endereco> {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public EnderecoDAO(Connection con) {
		this.con = con;
	}

	@Override
	public Endereco insert(Endereco t) throws SQLException {
		ps = con.prepareStatement("INSERT INTO ENDERECO(ID_CIDADE, BAIRRO, CEP, LOGRADOURO, NUMERO, COMPLEMENTO, TIPO) "
				+ "VALUES (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, t.getCidade().getIdCidade());
		ps.setString(2, t.getBairro());
		ps.setString(3, t.getCep());
		ps.setString(4, t.getLogradouro());
		ps.setString(5, t.getNumero());
		ps.setString(6, t.getComplemento());
		ps.setInt(7, t.getTipoEndereco());
		ps.executeUpdate();

		rs = ps.getGeneratedKeys();

		if (rs.next()) {
			t.setIdEndereco(rs.getInt(1));
			return t;
		}
		return null;
	}

	@Override
	public void update(Endereco t) throws SQLException {
		ps = con.prepareStatement("UPDATE ENDERECO SET ID_CIDADE=?, BAIRRO=?, CEP=?, LOGRADOURO=?, "
				+ "NUMERO=?, COMPLEMENTO=?, TIPO =? WHERE IDENDERECO=?");
		ps.setInt(1, t.getCidade().getIdCidade());
		ps.setString(2, t.getBairro());
		ps.setString(3, t.getCep());
		ps.setString(4, t.getLogradouro());
		ps.setString(5, t.getNumero());
		ps.setString(6, t.getComplemento());
		ps.setInt(7, t.getTipoEndereco());
		ps.setInt(8, t.getIdEndereco());
		ps.executeUpdate();

	}

	@Override
	public void delete(Endereco t) throws SQLException {
		new EnderecoParceiroDAO(con).deleteRelation(t);
		deleteEndereco(t);
	}

	@Override
	public Endereco getObjeto(int id) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM ENDERECO WHERE IDENDERECO = ?");
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			return getEndereco(rs, new CidadeDAO(con).getObjeto(rs.getInt("id_cidade")));
		}
		return null;
	}

	@Override
	public List<Endereco> readAll() throws SQLException {
		ps = con.prepareStatement("SELECT * FROM ENDERECO");
				
		rs = ps.executeQuery();
		
		Map<Integer, Cidade>cidades = new HashMap<Integer, Cidade>();
		List<Endereco>enderecos = new ArrayList<Endereco>();
		
		Cidade c = null;
		
		while(rs.next()) {
			int idCidade = rs.getInt("id_cidade");
			c = cidades.get(idCidade);
			
			if(c==null) {
				c = new CidadeDAO(con).getObjeto(idCidade);
				cidades.put(idCidade, c);
			}
			
			enderecos.add(getEndereco(rs, c));
		}
		
		return enderecos;
	}
	
	public List<Endereco> readByTipo(int tipoEndereco) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM ENDERECO WHERE TIPO=?");
		ps.setInt(1, tipoEndereco);	
		rs = ps.executeQuery();
		
		Map<Integer, Cidade>cidades = new HashMap<Integer, Cidade>();
		List<Endereco>enderecos = new ArrayList<Endereco>();
		
		Cidade c = null;
		
		while(rs.next()) {
			int idCidade = rs.getInt("id_cidade");
			c = cidades.get(idCidade);
			
			if(c==null) {
				c = new CidadeDAO(con).getObjeto(idCidade);
				cidades.put(idCidade, c);
			}
			
			enderecos.add(getEndereco(rs, c));
		}
		
		return enderecos;
	}
	
	public List<Endereco> readByParceiro(Parceiro parceiro) throws SQLException {
		ps = con.prepareStatement("SELECT * FROM ENDERECO AS E INNER JOIN PARCEIRO_ENDERECO AS PE "
				+ "ON E.IDENDERECO = PE.ID_ENDERECO "
				+ "WHERE PE.ID_PARCEIRO = ?");
		ps.setInt(1, parceiro.getIdParceiro());	
		rs = ps.executeQuery();
		
		Map<Integer, Cidade>cidades = new HashMap<Integer, Cidade>();
		List<Endereco>enderecos = new ArrayList<Endereco>();
		
		Cidade c = null;
		
		while(rs.next()) {
			int idCidade = rs.getInt("id_cidade");
			c = cidades.get(idCidade);
			
			if(c==null) {
				c = new CidadeDAO(con).getObjeto(idCidade);
				cidades.put(idCidade, c);
			}
			
			enderecos.add(getEndereco(rs, c));
		}
		
		return enderecos;
	}
	
	private Endereco getEndereco(ResultSet rs, Cidade c) throws SQLException{
		Endereco e = new Endereco();
		e.setBairro(rs.getString("bairro"));
		e.setCep(rs.getString("cep"));
		e.setCidade(c);
		e.setComplemento(rs.getString("complemento"));
		e.setIdEndereco(rs.getInt("idendereco"));
		e.setLogradouro(rs.getString("logradouro"));
		e.setNumero(rs.getString("numero"));
		e.setTipoEndereco(rs.getInt("tipo"));
		return e;
	}
	
	private void deleteEndereco(Endereco t)throws SQLException{
		ps = con.prepareStatement("DELETE FROM ENDERECO WHERE IDENDERECO=?");
		ps.setInt(1, t.getIdEndereco());
		ps.executeUpdate();
	}

}
