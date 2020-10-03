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
	
	public boolean equals(Cliente c) {
		return this.dni==c.getDni();
	}

	public boolean validarIdentificadorUnico() {
		String dniString = Long.toString(this.dni);
		String numeroDni = "";
		String dniComparado = "";
		String[] unoAlNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		int i, j;
		boolean flag = false;
		if(dniString.length()==8) {
			for(i=0;i<8;i++) {
				numeroDni = dniString.substring(i, i+1);
								
				for(j=0; j<unoAlNueve.length; j++) {
					if(numeroDni.equals(unoAlNueve[j])) {
						dniComparado = dniComparado + unoAlNueve[j];
					}
						
				}
			}
		}
				
		if(dniComparado.length() == 8) {
			flag = true;
		}
				
		return flag;
	}
}
