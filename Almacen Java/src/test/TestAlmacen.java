package test;


import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.Comercio;
import modelo.Cliente;

public class TestAlmacen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Articulo art1 = new Articulo(1, "Fideos", "7791234567898", 36.50);
		Articulo art2 = new Articulo(2, "Harina", "7792413123459", 75.25);
		Articulo art3 = new Articulo(3, "Azucar", "7791324467537", 40);
		Articulo art4 = new Articulo(4, "Yerba", "7793142136424", 84.75);
		Articulo art5 = new Articulo(5, "Arroz", "7794332635213", 35);

		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();
		Carrito carrito = new Carrito(0, fecha, hora, true, 1);
// BLOQUE DEL CARRITO
		try {
			carrito.agregar(art1, 1);
			carrito.agregar(art2, 2);
			carrito.agregar(art3, 3);
			carrito.agregar(art4, 4);
			carrito.agregar(art5, 5);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
//VER LOS ARTICULOS AGREGADOS
		for (ItemCarrito item : carrito.getLstItemCarrito()) {
			System.out.println(item);
		}
//ELIMINAR UN ARTICULO
		try {
			carrito.eliminarItem(art1, 1);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		try {
			carrito.eliminarItem(art1, 1);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
//TRAER ARTICULO INDIVIDUALMENTE
		System.out.println("Item solicitado: " + carrito.traerItemCarrito(art5.getId()));
//PRODUCTOS DESPUES DE LAS MODIFICACIONES
		System.out.println("Carrito:");
		for (ItemCarrito item : carrito.getLstItemCarrito()) {
			System.out.println(item);
		}
//TOTAL Y SUBTOTAL
		System.out.println("Subtotal del item " + carrito.getLstItemCarrito().get(0).getArticulo() + ": "
				+ carrito.getLstItemCarrito().get(0).calcularSubTotal());
		System.out.println("Total: " + carrito.calcularTotal());
//BLOQUE DE DIA DE DESCUENTO NEGATIVO
		if (carrito.calcularDescuentoDia(3, 10d) > 0) {
			System.out.println("El descuento por el dia Miercoles es: " + carrito.calcularDescuentoDia(3, 10d));
		} else {
			System.out.println("Miercoles no es un dia de descuento");
		}
//BLOQUE DE DIA DE DESCUENTO AFIRMATIVO
		if (carrito.calcularDescuentoDia(2, 10d) > 0) {
			System.out.println("El descuento por el dia Sabado es: " + carrito.calcularDescuentoDia(2, 10d));
		} else {
			System.out.println(carrito.getFecha().getDayOfWeek() + " no es un dia de descuento");
		}
//DESCUENTO MAYOR
		System.out.println("El descuento por pagar en efectivo es: " + carrito.calcularDescuentoEfectivo(50d));
		System.out.println("El mayor descuento es: " + carrito.calcularDescuentoCarrito(2, 10d, 50d));
//TOTAL FINAL
		System.out.println("Total final: " + carrito.totalAPagarCarrito());
//VALIDACIONES
		Comercio Almacen = new Comercio("Almacen Granate", 30242112322L, 2, 4, 5, 2, 4);
		System.out.println(Almacen.validarIdentificadorUnico(30242112322L));
		
		Cliente cliente1 = new Cliente ("Soloduja" ,"Ignacio" , 12312312, 'm');
		System.out.println(cliente1.validarSexo('f'));
	}

}
