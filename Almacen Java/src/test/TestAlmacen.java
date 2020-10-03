package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.Comercio;
import modelo.Cliente;

public class TestAlmacen {

	public static void main(String[] args) throws Exception {

		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();

//INSTANCIA DE COMERCIO
		Comercio almacen = new Comercio("Almacen Granate", 30242112322L, 2, 4, 5, 2, 4);

		System.out.println(almacen.separador());
		System.out.println("Escenario 1: Validaciones Cuit del Comercio");
		System.out.println(almacen.separador());

//VALIDACIONES DE CUIT EN COMERCIO
		try {
			almacen.setCuit(30242112322L);
			if (almacen.validarIdentificadorUnico(almacen.getCuit())) {
				System.out.println("Cuit de Comercio Válido");
			}
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			almacen.setCuit(3023232L);
			System.out.println(almacen.validarIdentificadorUnico(almacen.getCuit()));
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			almacen.setCuit(30112233445L);
			System.out.println(almacen.validarIdentificadorUnico(almacen.getCuit()));

		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			almacen.setCuit(12223344456L);
			System.out.println(almacen.validarIdentificadorUnico(almacen.getCuit()));
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}

//DATOS DE COMERCIO
		System.out.println();
		System.out.println(almacen.separador());
		System.out.println(almacen);

//INSTANCIA DE CLIENTE Y VALIDACION DEL DNI

		Cliente cliente = new Cliente("Soloduja", "Ignacio", 42678234, 'm');
		try {
			cliente.setDni(547);// No funciona cuando NO es numerico
		} catch (Exception e) {
			System.out.println("Excepcion: Valor Asignado no es numérico");
		}

		System.out.println(almacen.separador());
		System.out.println(cliente);

//CREACION DE OTRO CLIENTE Y VALIDACIONES DE DNI
		Cliente cliente2 = new Cliente("Del Rancho", "Cornelio", 12345678L, 'm');
		try {
			System.out.println(cliente2.validarIdentificadorUnico(cliente2.getDni()));
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			cliente2.setDni(123456789L);
		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
		try {
			cliente2.setDni(1234567L);

		} catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}

		System.out.println(cliente2);

//INSTANCIA DE CARRITO
		Carrito carrito = new Carrito(1, fecha, hora, true, 1, cliente);

//DATOS DE CARRITO
		System.out.println();
		System.out.println(almacen.separador());
		System.out.println("Creación de un Carrito e impresion de sus datos");
		System.out.println(almacen.separador());
		System.out.println(carrito);
		System.out.println(almacen.separador());

// INSTANCIA DE ARTICULOS
		Articulo art1 = new Articulo(1, "Alcohol en Gel", "7790139000196", 36.50);
		Articulo art2 = new Articulo(2, "Harina 'Favorita'","7790070507235", 75.25);
		Articulo art3 = new Articulo(3, "Azucar 'Ledesma'", "7792540260138", 40);
		Articulo art4 = new Articulo(4, "Mate Cocido 'Taragüi'","7790387000856", 84.75);
		Articulo art5 = new Articulo(5, "Café 'Dolca","7613035068414", 60.25);
		
		
//VALIDACION DE CODIGO DE BARRA DE LOS ARTICULOS
		System.out.println("Validación de Código de Barras");
		System.out.println(almacen.separador());
		try {

			art1.setCodBarras("7790201962683");
		}
		catch (Exception e) {
			System.out.println("Excepción (art1): " + e.getMessage());
		}
		
		try  {
		art2.setCodBarras("7791234507235");
		}
		catch (Exception e) {
			System.out.println("Excepción (art2): " + e.getMessage());
		}
		
		try {
		art3.setCodBarras("7797654260138");
		}
		catch (Exception e) {
			System.out.println("Excepción (art3): " + e.getMessage());
		}
		
		try {
		art4.setCodBarras("7790387000856");
		}
		catch (Exception e) {
			System.out.println("Excepción (art4): " + e.getMessage());
		}
		
		try {
		art5.setCodBarras("7613035068414");
		}
		catch (Exception e) {
			System.out.println("Excepción (art5): " + e.getMessage());
		}
		
		System.out.println();
		
		System.out.println(almacen.separador());
		
		System.out.println("Impresion de Articulos Instanciados");
		System.out.println(art1);
		System.out.println(art2);
		System.out.println(art3);
		System.out.println(art4);
		System.out.println(art5);

		
// AGREGAR AL CARRITO
		try {
			carrito.agregarAlCarrito(art1, 1);
			carrito.agregarAlCarrito(art2, 2);
			carrito.agregarAlCarrito(art3, 3);
			carrito.agregarAlCarrito(art4, 4);
			carrito.agregarAlCarrito(art5, 5);

		} catch (Exception e) {

			System.out.println("Excepcion: " + e.getMessage());
		}

		System.out.println(almacen.separador());

//VER LOS ARTICULOS AGREGADOS
		System.out.println();
		System.out.println("Items Agregados al Carrito");
		System.out.println(almacen.separador());
		for (ItemCarrito item : carrito.getLstItemCarrito()) {
			System.out.println(item);
		}

//ELIMINAR UN ARTICULO DEL CARRITO
		try {
			carrito.eliminarItem(art1, 1);
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		try {
			carrito.eliminarItem(art1, 1);
		} catch (Exception e) {
			System.out.println("\nExcepcion: " + e.getMessage() + "\n");
		}

//TRAER ARTICULO INDIVIDUALMENTE
		System.out.println("Item solicitado: \n" + carrito.traerItemCarrito(art5));

//PRODUCTOS DESPUES DE LAS MODIFICACIONES
		System.out.println("Carrito:\n");
		for (ItemCarrito item : carrito.getLstItemCarrito()) {
			System.out.println(item);
		}

//TOTAL Y SUBTOTAL
		System.out.println();
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

	}

}
