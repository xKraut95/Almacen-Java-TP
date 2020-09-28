package test;

import comercio.Articulo;

public class Test_Articulo {

	public static void main(String[] args) {
		// Validacion del Codigo de Barra. En este test todos los códigos de barra son incorrectos.

		try {
			Articulo art1 = new Articulo(1, "Fideos", "7791234567898", 36.50);
			Articulo art2 = new Articulo(2, "Harina", "7792413123459", 75.25);
			Articulo art3 = new Articulo(3, "Azucar", "7791324467537", 40);
			Articulo art4 = new Articulo(4, "Yerba", "7793142136424", 84.75);
			Articulo art5 = new Articulo(5, "Arroz", "7794332635213", 35);

		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage());
		}

	}

}
