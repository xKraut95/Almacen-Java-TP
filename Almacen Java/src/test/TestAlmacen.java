package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Actor;
import modelo.Articulo;
import modelo.Carrito;
import modelo.ItemCarrito;
import modelo.Ubicacion;
import modelo.Comercio;
import modelo.Contacto;
import modelo.Cliente;

public class TestAlmacen {

	public static void main(String[] args) throws Exception {

		LocalDate fecha = LocalDate.now();
		LocalTime hora = LocalTime.now();
		Ubicacion ubicacionAlmacen=new Ubicacion(343647, 582238);
		Contacto contactoAlmacen= new Contacto ("almacengranate@gmail.com","42673455",ubicacionAlmacen);
		try {
			contactoAlmacen.setEmail("almacengranate@gmail.com");
		}
		catch (Exception e) {
			System.out.println("Excepcion:" + e.getMessage());
		}
//INSTANCIA DE COMERCIO
		Actor comercio= new Comercio(1, contactoAlmacen, "Almacen Granate", 30242112322L, 2, 4, 5, 2, 4);
		Comercio almacen=(Comercio)comercio;

		almacen.separador();
		System.out.println("Escenario 1: Validaciones Cuit del Comercio");
		almacen.separador();

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
		almacen.separador();
		System.out.println(almacen);

//INSTANCIA DE CLIENTE Y VALIDACION DEL DNI
		Actor customer1= new Cliente(1, new Contacto ("nachosoloduja@hotmail.com","1112345678",new Ubicacion(11111, 22222)), "Soloduja", "Ignacio", 42678234, 'm');
		Cliente cliente1=(Cliente)customer1;
		try {
			cliente1.setDni(547);
		} catch (Exception e) {
			System.out.println("Excepcion: Valor Asignado no es numérico");
		}

		almacen.separador();
		System.out.println(cliente1);

//CREACION DE OTRO CLIENTE Y VALIDACIONES DE DNI
		Actor customer2= new Cliente(2, new Contacto ("cordelranch@gmail.com","1123658745",new Ubicacion(33333, 444444)), "Del Rancho", "Cornelio", 12345678, 'm');
		Cliente cliente2=(Cliente)customer2;
	
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

		almacen.separador();
		System.out.println(cliente2);
		

	

//INSTANCIA DE CARRITO
		Carrito carrito = new Carrito(1, fecha, hora, false, 1, cliente1);

//DATOS DE CARRITO
		System.out.println();
		almacen.separador();
		System.out.println("Creación de un Carrito e impresion de sus datos");
		almacen.separador();
		System.out.println(carrito);
		almacen.separador();

// INSTANCIA DE ARTICULOS
		Articulo art1 = new Articulo(1, "Alcohol en Gel", "7790139000196", 36.50);
		Articulo art2 = new Articulo(2, "Harina 'Favorita'", "7790070507235", 75.25);
		Articulo art3 = new Articulo(3, "Azucar 'Ledesma'", "7792540260138", 40);
		Articulo art4 = new Articulo(4, "Mate Cocido 'Taragüi'", "7790387000856", 84.75);
		Articulo art5 = new Articulo(5, "Café 'Dolca", "7613035068414", 60.25);

//VALIDACION DE CODIGO DE BARRA DE LOS ARTICULOS
		System.out.println("Validación de Código de Barras");
		almacen.separador();
		try {

			art1.setCodBarras("7790201962683");
		} catch (Exception e) {
			System.out.println("Excepción (art1): " + e.getMessage());
		}

		try {
			art2.setCodBarras("7791234507235");
		} catch (Exception e) {
			System.out.println("Excepción (art2): " + e.getMessage());
		}

		try {
			art3.setCodBarras("7797654260138");
		} catch (Exception e) {
			System.out.println("Excepción (art3): " + e.getMessage());
		}

		try {
			art4.setCodBarras("7790387000856");
		} catch (Exception e) {
			System.out.println("Excepción (art4): " + e.getMessage());
		}

		try {
			art5.setCodBarras("7613035068414");
		} catch (Exception e) {
			System.out.println("Excepción (art5): " + e.getMessage());
		}

		System.out.println();

		almacen.separador();

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
			carrito.agregarAlCarrito(art3, 3);

		} catch (Exception e) {

			System.out.println("Excepcion: " + e.getMessage());
		}

		almacen.separador();

//VER LOS ARTICULOS AGREGADOS
		System.out.println();
		System.out.println("Items Agregados al Carrito");
		almacen.separador();
		for (ItemCarrito item : carrito.getLstItemCarrito()) {
			System.out.println(item);
		}

//ELIMINAR ARTICULOS DEL CARRITO
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
		try {
			carrito.eliminarItem(art5, 2);
		} catch (Exception e) {
			System.out.println("\nExcepcion: " + e.getMessage() + "\n");
		}

//TRAER ARTICULO INDIVIDUALMENTE
		System.out.println("Item solicitado: \n" + carrito.traerItemCarrito(art5));

//UNA VEZ HECHO LOS CAMBIOS NECESARIOS, SE CIERRA EL CARRITO
		carrito.setCerrado(true);

//PRODUCTOS DESPUES DE LAS MODIFICACIONES, IMPRESION DE CARRITO COMPLETO
		almacen.separador();
		System.out.println(carrito);
		almacen.separador();

		if (carrito.isCerrado()) { // Si, is cerrado() es True

//SUBTOTAL
			System.out.println("SubTotal Por Item");
			almacen.separador();

			System.out.println("Subtotal del item " + carrito.getLstItemCarrito().get(0).getArticulo() + ": "
					+ carrito.getLstItemCarrito().get(0).calcularSubTotal());

			System.out.println("Subtotal del item " + carrito.getLstItemCarrito().get(1).getArticulo() + ": "
					+ carrito.getLstItemCarrito().get(1).calcularSubTotal());

			System.out.println("Subtotal del item " + carrito.getLstItemCarrito().get(2).getArticulo() + ": "
					+ carrito.getLstItemCarrito().get(2).calcularSubTotal());

			System.out.println("Subtotal del item " + carrito.getLstItemCarrito().get(3).getArticulo() + ": "
					+ carrito.getLstItemCarrito().get(3).calcularSubTotal());

//TOTAL A PAGAR
			System.out.println();
			almacen.separador();
			System.out.println("Total: " + carrito.calcularTotal());
			almacen.separador();

//BLOQUE DE DIA DE DESCUENTO NEGATIVO
			System.out.println();
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
		
	
		almacen.agregarDiaRetiro(1, LocalTime.of(9, 00), LocalTime.of(20, 00), 10);
		almacen.agregarDiaRetiro(2, LocalTime.of(9, 00), LocalTime.of(20, 00), 10);
		almacen.agregarDiaRetiro(3, LocalTime.of(9, 00), LocalTime.of(20, 00), 10);
		almacen.agregarDiaRetiro(4, LocalTime.of(9, 00), LocalTime.of(20, 00), 10);
		almacen.agregarDiaRetiro(5, LocalTime.of(9, 00), LocalTime.of(20, 00), 10);
		almacen.agregarDiaRetiro(6, LocalTime.of(10, 00), LocalTime.of(15, 00), 15);
		almacen.agregarDiaRetiro(7, LocalTime.of(10, 00), LocalTime.of(15, 00), 10);//Despues borrar
		
		//Casos, en los que no se agrega el dato nuevo
		almacen.agregarDiaRetiro(3, LocalTime.of(9, 00), LocalTime.of(20, 00), 10);//No se agrega porque ya existe uno identico
		almacen.agregarDiaRetiro(9, LocalTime.of(1, 00), LocalTime.of(5, 00), 20);//No se agrega porque numero de DiaSemana es mayor al valido
		almacen.agregarDiaRetiro(0, LocalTime.of(1, 00), LocalTime.of(5, 00), 20);//No se agrega porque numero de DiaSemana es menos al valido
		
		almacen.mostrarListaDiasRetiro();
		almacen.separador();
		try {
			System.out.println(almacen.generarAgenda(fecha));
		} catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
		}
		almacen.separador();
		almacen.mostrarListaCarritos();
		//System.out.println(almacen.generarTurnosLibres(fecha));
		//System.out.println(almacen.traerTurnosOcupados(fecha));
		almacen.separador();
		
		
	}
}
