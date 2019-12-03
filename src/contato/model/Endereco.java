package contato.model;

public class Endereco {
	public static final int PRINCIPAL = 0;
	public static final int ENTREGA = 1;
	public static final int COBRANCA = 2;
	public static final int OUTRO = 3;

	private int idEndereco;
	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private int tipoEndereco;
	private Cidade cidade;

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) throws IllegalArgumentException {
		if (logradouro.length() > 50) {
			throw new IllegalArgumentException(
					"Valor muito longo para logradouro! Digite uma rua com menos de 50 caracteres");
		}

		if (logradouro.equals("")) {
			throw new IllegalArgumentException("O campo logradouro não pode ser vazio");
		}
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) throws IllegalArgumentException {
		if (bairro.length() > 20) {
			throw new IllegalArgumentException(
					"Valor muito longo para bairro! Digite um bairro com menos de 20 carcteres");
		}

		if (bairro.equals("")) {
			throw new IllegalArgumentException("O campo bairro não pode ser vazio");
		}

		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws IllegalArgumentException {
		if (cep.length() != 8) {
			throw new IllegalArgumentException("O cep tem 8 caracteres");
		}

		if (cep.equals("")) {
			throw new IllegalArgumentException("O campo cep não pode ser vazio");
		}
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws IllegalArgumentException {
		if (numero.length() > 10) {
			throw new IllegalArgumentException(
					"Valor muito longo para número! Digite um número com menos de 10 caracteres");
		}

		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) throws IllegalArgumentException {
		if (complemento.length() > 10) {
			throw new IllegalArgumentException(
					"Valor muito longo para complemento! Digite um complemento com menos de 10 caracteres");
		}
		this.complemento = complemento;
	}

	public int getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(int tipoEndereco) throws IllegalArgumentException {
		if (tipoEndereco != 0 && tipoEndereco != 1 && tipoEndereco != 2 && tipoEndereco != 3) {
			throw new IllegalArgumentException("valor inválido para tipo de endereço");
		}
		this.tipoEndereco = tipoEndereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) throws NullPointerException {
		if (cidade == null) {
			throw new NullPointerException("Cidade não pode ser nula");
		}
		this.cidade = cidade;
	}

}
