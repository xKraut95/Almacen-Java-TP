package modelo;

public class Contacto {
	private String email;
	private String celular;
	private Ubicacion ubicacion;

	public Contacto(String email, String celular, Ubicacion ubicacion) throws Exception{
		this.setEmail(email);
		this.celular = celular;
		this.ubicacion = ubicacion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws Exception {
		if(!encontrarArroba(email)) throw new Exception("Error: email no valido.");
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean equals(Contacto c) {
		return ((this.email == c.getEmail()) && (this.celular == c.getCelular())
				&& (this.ubicacion.equals(c.getUbicacion())));

	}

	@Override
	public String toString() {
		return "Email: " + this.email + " Celular:" + this.celular + " " + ubicacion.toString();
	}
	
	public boolean encontrarArroba(String email){
		int longitud = 0;
		boolean encontrado=false;
		while(longitud<(email.length()-1)||encontrado==false) {
			if(email.charAt(longitud)==('@')) {
				encontrado=true;
			}
			longitud++;
		}
		return encontrado;	
	}

}
