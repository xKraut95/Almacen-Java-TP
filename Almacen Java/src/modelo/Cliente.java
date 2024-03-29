package modelo;

public class Cliente {
	private String apellido;
	private String nombre;
	private long dni;
	private char sexo;

	public Cliente(String apellido, String nombre, long dni, char sexo) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
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

	public void setDni(long dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String toString() {
		return "Cliente:Apellido" + this.apellido + "Cliente: Nombre" + this.nombre + "Cliente: dni" + this.dni
				+ "Cliente: sexo" + this.sexo;
	}

	public boolean validarIdentificadorUnico() {
		String dniString = Long.toString(this.dni);

		if (dniString.length() == 8) {
			return true;
		}

		else {
			return false;

		}

	}
	
    public boolean validarSexo(char sexo)
    {
    	
    	Cliente Cliente1 = new Cliente("Romanov", "Ignar", 39107542, ' ');
    	Cliente1.setSexo(sexo);
    	boolean estado = false;

    	if (Cliente1.sexo == 'm')
    	{
    		estado = true;
    	}
    	if (Cliente1.sexo == 'f')
    	{
    		estado = true;
    	}
    	else 
    	{
    		estado = false;
    	}
    	return estado;
    }
}
