package modelo;

public class Cliente extends Actor {
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;

	public Cliente(int id, Contacto contacto, String apellido, String nombre, long dni, char sexo) throws Exception {

		super(id, contacto);
		this.apellido = apellido;
		this.nombre = nombre;
		this.setDni(dni);
		this.sexo = sexo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) throws Exception {
		if (!validarIdentificadorUnico(dni))
			throw new Exception("Error: DNI Invalido");
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String toString() {
		return "Datos del Cliente\n\t\tApellido: " + this.apellido + "\n\t\tNombre: " + this.nombre + "\n\t\tDni: "
				+ this.dni + "\n\t\tSexo: " + this.sexo;
	}

	public boolean equals(Cliente c) {
		return this.dni == c.getDni();
	}

	public boolean validarIdentificadorUnico(long dni) throws Exception {
		String dniString = Long.toString(dni);
		boolean flag = false;
		
		if ((dniString.length() == 8) && (dni>0)) { 
			flag = true;

		}
		return flag;

	}

}
