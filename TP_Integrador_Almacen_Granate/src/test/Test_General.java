package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import comercio.Articulo;
import comercio.Carrito;
import comercio.Cliente;
import comercio.ItemCarrito;
//import comercio.Entrega;

public class Test_General {

	public static void main(String[] args) {

		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		// Instancias de Articulo

		Articulo art1 = new Articulo(1, "Alcohol en Gel", 36.50);
		Articulo art2 = new Articulo(2, "Harina 'Favorita'", 75.25);
		Articulo art3 = new Articulo(3, "Azucar 'Ledesma'", 40);
		Articulo art4 = new Articulo(4, "Mate Cocido 'Taragüi'", 84.75);
		Articulo art5 = new Articulo(5, "Café 'Dolca", 60.25);

		try {

			art1.setCodBarras("7790139000196");
			art2.setCodBarras("7790070507235");
			art3.setCodBarras("7792540260138");
			art4.setCodBarras("7790387000856");
			art5.setCodBarras("7613035068414");
		}

		catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage());
		} finally {

			System.out.println(art1);
			System.out.println(art2);
			System.out.println(art3);
			System.out.println(art4);
			System.out.println(art5);
			System.out.println();

			ItemCarrito item1;
			ItemCarrito item2;
			ItemCarrito item3;

			List<ItemCarrito> items = new ArrayList<ItemCarrito>();
			items.add(item1 = new ItemCarrito(art1, 5));
			items.add(item2 = new ItemCarrito(art2, 2));
			items.add(item3 = new ItemCarrito(art3, 2));

			// Creacion de un Cliente
			Cliente customer1 = new Cliente("Garcia", "Pablito", 45678123);
			// Creacion de un Carrito
			Carrito carrito1 = new Carrito(1, date, time, false, 50, customer1);
			carrito1.setLstItemCarrito(items);
			carrito1.agregarAlCarrito(art4, 6);
			carrito1.agregarAlCarrito(art2, 2);

			try {
				carrito1.eliminarItem(art1, 1);
				carrito1.eliminarItem(art3, 2);
				carrito1.eliminarItem(art5, 7);
				carrito1.eliminarItem(art1, 5);
			} catch (Exception e2) {
				System.out.println("Excepción: " + e2.getMessage() + "\n");
			}

			System.out.println(items);

			System.out.println();

			System.out.println(art1.validarCodBarras(art1.getCodBarras()) + "\n");

			System.out.println(customer1 + "\n");

			System.out.println(carrito1.traerItemCarrito(art1) + "\n");

			System.out.println(carrito1.getLstItemCarrito() + "\n");

			System.out.println(carrito1 + "\n");

			System.out.println(carrito1.traerItemCarrito(art2) + "\n");
		}

	}

}