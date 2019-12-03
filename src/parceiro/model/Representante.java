package parceiro.model;

import java.util.List;

import contato.model.Contato;


public class Representante {
	private int idRepresentante;
	private String nome;
	private double comissao;
	private List<Contato> contatos;

	public int getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(int idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException{
		if (nome.length() > 50) {
			throw new IllegalArgumentException("nome inválido! preencha o campo com menos de 50 caracteres");
		}

		if (nome.equals("")) {
			throw new IllegalArgumentException("nome inválido! o campo não pode ser vazio");
		}
		this.nome = nome;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public void addContato(Contato contato) {
		contatos.add(contato);
	}
	
	public void removeContato(Contato contato) {
		contatos.remove(contato);
	}

}
