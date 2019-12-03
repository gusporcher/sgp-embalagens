package contato.model;

public class Contato {
	private int idContato;
	private String nome;

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws IllegalArgumentException{
		if(nome.length()>50) {
			throw new IllegalArgumentException("nome muito longo! Digite um nome com menos de 50 caracteres");
		}
		this.nome = nome;
	}
	
	public void addContato(Contato contato) {
		setIdContato(contato.getIdContato());
		setNome(contato.getNome());
	}

}
