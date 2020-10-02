package test;

import java.util.ArrayList;

import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.Comercio;
import modelo.DiaRetiro;
import modelo.Cliente;

public class TestAlmacen {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Articulo art1 = new Articulo(1, "Fideos", "7791234567898", 36.50);
		Articulo art2 = new Articulo(2, "Harina", "7792413123459", 75.25);
		Articulo art3 = new Articulo(3, "Azucar", "7791324467537", 40);
		Articulo art4 = new Articulo(4, "Yerba", "7793142136424", 84.75);
		Articulo art5 = new Articulo(5, "Arroz", "7794332635213", 35);

		System.out.println(art1);
		System.out.println(art2);
		System.out.println(art3);
		System.out.println(art4);
		System.out.println(art5);

		ItemCarrito item = new ItemCarrito(art1, 6);
		System.out.println(item);

		Comercio Almacen = new Comercio("Almacen Granate", 30242112322L, 2, 4, 5, 2, 4);
		try {
			System.out.println(Almacen.validarIdentificadorUnico(Almacen.getCuit()));
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			Almacen.setCuit(3023232L);
			System.out.println(Almacen.validarIdentificadorUnico(Almacen.getCuit()));
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			Almacen.setCuit(30112233445L);
			System.out.println(Almacen.validarIdentificadorUnico(Almacen.getCuit()));

		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			Almacen.setCuit(12223344456L);
			System.out.println(Almacen.validarIdentificadorUnico(Almacen.getCuit()));
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}

	}

}
