package modelo;

public class Articulo {
	private int id;
	private String nombre;
	private String codBarras;
	private double precio;

	public Articulo(int id, String nombre, String codBarras, double precio) throws Exception {
		this.id = id;
		this.nombre = nombre;
		this.setCodBarras(codBarras);
		this.precio = precio;
	}

	public Articulo(int id, String nombre, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) throws Exception {
		if (!validarCodBarras(codBarras))
			throw new Exception("Error: Codigo de Barra NO válido. Codigo Verificador Incorrecto");
		this.codBarras = codBarras;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo " + getId() + " (Nombre=" + getNombre() + ", Codigo de Barra=" + getCodBarras() + ", Precio="
				+ getPrecio() + ")";
	}

	public boolean validarCodBarras(String codBarras) {
		int[] codBarrasInt = new int[13];
		int posicion = 0;
		char[] codBarrasSeparado = codBarras.toCharArray();
		int sumaPar = 0;
		int sumaImpar = 0;

		// Algoritmo para Validar Dígito Verificador
		/*
<<<<<<< HEAD
		 * Paso 1: Sumar digitos de las posiciones pares Paso 2: Sumar dígitos de las
		 * posiciones impares Paso 3: Multiplicar por 3 el valor obtenido del paso 2
		 * Paso 4: Sumar paso 1 y 3 Paso 5: Se redondea el resultado del paso 4 para que
		 * sea multiplo de 100 Paso 6: Resta de paso 5 y 4
=======
		 * Paso 1: Sumar digitos de las posiciones pares 
		 * Paso 2: Sumar dígitos de las posiciones impares 
		 * Paso 3: Multiplicar por 3 el valor obtenido del paso 2
		 * Paso 4: Sumar paso 1 y 3 
		 * Paso 5: Se redondea el resultado del paso 4 para que
		 * sea multiplo de 100 
		 * Paso 6: Resta de paso 5 y 4
>>>>>>> refs/heads/Roger
		 */

		// Asignamos Los valores del codigo de barra a cada posicion del nuevo array
		while (posicion <= 11) {

			codBarrasInt[posicion] = Character.getNumericValue(codBarrasSeparado[posicion]);

			if (esPar(posicion)) {
				sumaPar = sumaPar + codBarrasInt[posicion]; // Paso 1
			} else {
				sumaImpar = sumaImpar + codBarrasInt[posicion]; // Paso 2
			}
			posicion++;

		}
		sumaImpar = sumaImpar * 3;// paso 3

		sumaPar = sumaPar + sumaImpar;// paso 4

		int valorRedondeado = multiploDiez(sumaPar);// Paso 5

		int digitoVerficador = valorRedondeado - sumaPar; // Paso 6
		codBarrasInt[12] = Character.getNumericValue(codBarrasSeparado[12]);

		if (digitoVerficador == codBarrasInt[12]) {
			return true;
		} else {
			return false;
		}
	}

	public boolean esPar(int numeroAEvaluar) {
		int resto = numeroAEvaluar % 2;
		if (resto == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int multiploDiez(int valorPaso4) {
		int resto = valorPaso4 % 10;
		int resultado = valorPaso4;

		while (resto != 0) {// paso 5
			resultado = resultado + 1;
			resto = resultado % 10;
		}

		return resultado;
	}

}
