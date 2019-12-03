package parceiro.model;

import java.util.List;

import contato.model.Contato;
import contato.model.Endereco;

public class Parceiro {
	public static final int CLIENTE = 0;
	public static final int FORNECEDOR = 1;
	public static final int AMBOS = 2;

	private int idParceiro;
	private String razaoSocial;
	private String nomeFantasia;
	private Representante representante;
	private List<Endereco> enderecos;
	private List<Contato> contatos;
	private int tipoParceiro;

	public int getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) throws IllegalArgumentException {
		if (razaoSocial.length() > 50) {
			throw new IllegalArgumentException("razão social inválida! preencha o campo com menos de 50 caracteres");
		}

		if (razaoSocial.equals("")) {
			throw new IllegalArgumentException("razão social inválida! o campo não pode ser vazio");
		}
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) throws IllegalArgumentException {
		if (nomeFantasia.length() > 50) {
			throw new IllegalArgumentException("nome fantasia inválido! preencha o campo com menos de 50 caracteres");
		}

		if (nomeFantasia.equals("")) {
			throw new IllegalArgumentException("nome fantasia inválido! o campo não pode ser vazio");
		}

		this.nomeFantasia = nomeFantasia;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) throws NullPointerException {
		if (representante == null) {
			throw new NullPointerException("representante nulo");
		}
		this.representante = representante;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public int getTipoParceiro() {
		return tipoParceiro;
	}

	public void setTipoParceiro(int tipoParceiro) throws IllegalArgumentException {
		if (tipoParceiro != 0 && tipoParceiro != 1 && tipoParceiro != 2) {
			throw new IllegalArgumentException("tipo de parceiro inválido");
		}
		this.tipoParceiro = tipoParceiro;
	}

}
