package modelo;

public class Cliente {
	private String apellido;
	private String nombre;
	private int dni;
	private char sexo;

	public Cliente(String apellido, String nombre, int dni, char sexo) {
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
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



    public boolean validarSexo(char sexo)
    {
    	String sexo1 = "" + sexo;
    	boolean estado = false;

    	if (sexo1 == "m")
    	{
    		System.out.println("Masculino");
    		estado= true;
    	}
    	if (sexo1 == "f")
    	{
    		System.out.println("Femenino");
    		estado = true;
    	}
    	else
    	{
    		System.out.println("Sexo no valido");
    		return false;
    	}
    	
    	return estado;
    	
    }
}
