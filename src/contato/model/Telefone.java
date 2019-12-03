package contato.model;

public class Telefone extends Contato {
	public static final int PRINCIPAL = 0;
	public static final int OUTRO = 1;

	private String numero;
	private int tipoTelefone;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws IllegalArgumentException {
		if (numero.length() > 11 && numero.length() < 10) {
			throw new IllegalArgumentException(
					"valor inv�lido para n�mero de telefone. Digite um n�mero entre 10 e 11 caracteres");
		}

		if (numero.equals("")) {
			throw new IllegalArgumentException("o n�mero n�o pode ser vazio");
		}
		this.numero = numero;
	}

	public int getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(int tipoTelefone) throws IllegalArgumentException {
		if (tipoTelefone != 0 && tipoTelefone != 1) {
			throw new IllegalArgumentException("Valor inv�lido para tipo de telefone");
		}
		this.tipoTelefone = tipoTelefone;
	}

}
