package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import comercio.ItemCarrito;


public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalDate hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private Entrega entrega;
	
	//relacion de composición
	private ArrayList<ItemCarrito>lstItemCarrito;
	//private ItemCarrito[] lstItemCarrito;
	
	public Carrito(int id, LocalDate fecha, LocalDate hora, boolean cerrado,double descuento, Cliente cliente, Entrega entrega) {
		this.id=id;
		this.fecha=fecha;
		this.hora=hora;
		this.cerrado=cerrado;
		this.descuento=descuento;
		this.cliente=cliente;
		this.entrega=entrega;
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

	/* *****No estoy segura si de esta forma es el get y set de la lista******
	public ArrayList<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(ArrayList<ItemCarrito> lstItemCarrito) {
		this.lstItemCarrito = lstItemCarrito;
	}

	//Revisar de aquí para abajo!!!!!!!!!!!!!!!!!!!!!!!!
	//redefinir equals, y agregar los demás métodos que se piden
	private boolean equals(Articulo articulo, int id) {
		if ()
		return false;
	}

	public void agregarACarrito(ItemCarrito item) {
		
		if(equals(item.getArticulo(),item.getArticulo().getId()){
			
		}
		else {
			lstItemCarrito.add(item);
		}
		
	}


	}
	*/
}

