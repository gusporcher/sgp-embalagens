package contato.model;

public class Email extends Contato {

	public static final int PRINCIPAL = 0;
	public static final int FISCAL = 1;
	public static final int OUTRO = 2;

	private String email;
	private int tipoEmail;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws IllegalArgumentException{
		if (email.length() > 100) {
			throw new IllegalArgumentException(
					"valor muito longo para e-mail. Digite um e-mail com menos de 150 caracteres");
		}
		this.email = email;
	}

	public int getTipoEmail() {
		return tipoEmail;
	}

	public void setTipoEmail(int tipoEmail) throws IllegalArgumentException {
		if (tipoEmail != 0 && tipoEmail != 1 && tipoEmail != 2) {
			throw new IllegalArgumentException("valor inválido para tipo de e-mail");
		}
		this.tipoEmail = tipoEmail;
	}
	
	

}
