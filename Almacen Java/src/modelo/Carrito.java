package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalDate hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private Entrega entrega;
	private ArrayList<ItemCarrito> lstItemCarrito;

	public Carrito(int id, LocalDate fecha, LocalDate hora, boolean cerrado, double descuento, Cliente cliente,
			Entrega entrega) 
	{
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.entrega = entrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalDate getHora() {
		return hora;
	}

	public void setHora(LocalDate hora) {
		this.hora = hora;
	}

	public boolean isCerrado() {
		return cerrado;
	}

	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public ArrayList<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(ArrayList<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	public ItemCarrito traerItemCarrito(int idArticulo) {
		Articulo articulo = new Articulo(1, "nada", "nada", 5);
		ItemCarrito aux = new ItemCarrito(articulo, 1);
		boolean band = false;
		int i = 0;
		Iterator<ItemCarrito> iterador = lstItemCarrito.iterator();

		while ((iterador.hasNext()) && (band == false)) {
			if (iterador.next().getArticulo().getId() == idArticulo) {
				band = true;
				aux = lstItemCarrito.get(i);
			}
			i++;
		}

		if (band == false)
			return null;
		else
			return aux;
	}

	public boolean agregar(Articulo articulo, int cantidad) {
		int idArticulo = articulo.getId();
		ItemCarrito aux = traerItemCarrito(idArticulo);
		if (aux == null)
			return lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
		else {
			int sumaDeCantArticulo = aux.getCantidad() + cantidad;
			aux.setCantidad(sumaDeCantArticulo);
			return true;
		}
	}

	public boolean eliminarItem(Articulo articulo, int cantidad) throws Exception {
		int idArticulo = articulo.getId();
		ItemCarrito aux = traerItemCarrito(idArticulo);

		if (aux == null)
			throw new Exception("Error: No  existe el producto en el carrito");
		else {
			if (aux.getCantidad() > cantidad) {
				int restaCantArticulo = aux.getCantidad() - cantidad;
				aux.setCantidad(restaCantArticulo);
			} else {
				return lstItemCarrito.remove(aux);
			}
		}
		return true;
	}

	public double calcularTotal() {
		int i = 0;
		double calculo = 0;
		while (i < lstItemCarrito.size()) {
			calculo += lstItemCarrito.get(i).calcularSubTotal();
			i++;
		}
		return calculo;
	}

	public double calcularDescuentoDia(int diaDescuento, double porcentajeDescuentoDia) {
		double descuento = 0;
		for (ItemCarrito item : lstItemCarrito) {
			int cantidad = item.getCantidad();
			int divisor = 2;
			float calculo = cantidad / divisor;
			descuento += calculo * item.getArticulo().getPrecio() * (porcentajeDescuentoDia / 100);
		}
		return descuento;
	}

	public double calcularDescuentoEfectivo(double porcentajeDescuentoEfectivo) {
		double descuento = calcularTotal() * (porcentajeDescuentoEfectivo / 100);
		return descuento;
	}

	public double calcularDescuentoCarrito(int diaDescuento, double porcentajeDescuento,
			double porcentajeDescuentoEfectivo) {
		double descuentoSup = 0;
		if (calcularDescuentoEfectivo(porcentajeDescuentoEfectivo) < calcularDescuentoDia(diaDescuento,
				porcentajeDescuento)) {
			descuentoSup = calcularDescuentoDia(diaDescuento, porcentajeDescuento);
		} else {
			descuentoSup = calcularDescuentoEfectivo(porcentajeDescuentoEfectivo);
		}
		return descuentoSup;
	}

}
