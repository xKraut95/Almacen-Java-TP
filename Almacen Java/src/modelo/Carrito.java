package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrito {
	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private boolean cerrado;
	private double descuento;
	private Cliente cliente;
	private Entrega entrega;
	private List<ItemCarrito> lstItemCarrito;

	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente,
			Entrega entrega) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.entrega = entrega;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
	}

	public Carrito(int id, LocalDate fecha, LocalTime hora, boolean cerrado, double descuento, Cliente cliente) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.cerrado = cerrado;
		this.descuento = descuento;
		this.cliente = cliente;
		this.lstItemCarrito = new ArrayList<ItemCarrito>();
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

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
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

	public List<ItemCarrito> getLstItemCarrito() {
		return lstItemCarrito;
	}

	public void setLstItemCarrito(List<ItemCarrito> listaItem) {
		this.lstItemCarrito = listaItem;
	}

	@Override
	
	public String toString() {
		return "Carrito: " + id + "\n\tFecha = " + fecha + "\n\tHora = " + hora + "\n\tCerrado = " 
				+ cerrado + "\n\tDescuento = "
				+ descuento + "\n\tCliente = " + cliente + "\n\tEntrega = " + entrega + ",\n\tLista de Items = \n"
				+ lstItemCarrito;
	}

	public ItemCarrito traerItemCarrito(Articulo articulo) {
		ItemCarrito aux = new ItemCarrito(articulo, 0);
		boolean band = false;
		int i = 0;
		Iterator<ItemCarrito> iterador = lstItemCarrito.iterator();

		while ((iterador.hasNext()) && (band == false)) {
			if (iterador.next().getArticulo().getId() == articulo.getId()) {
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

	public boolean agregarAlCarrito(Articulo articulo, int cantidad) {
		ItemCarrito aux = traerItemCarrito(articulo);
		if (aux == null)
			return lstItemCarrito.add(new ItemCarrito(articulo, cantidad));
		else {
			int sumaDeCantArticulo = aux.getCantidad() + cantidad;
			aux.setCantidad(sumaDeCantArticulo);
			return true;
		}
	}

	public boolean eliminarItem(Articulo articulo, int cantidad) throws Exception {
		ItemCarrito aux = traerItemCarrito(articulo);
		if (aux == null)
			throw new Exception("Error: No existe el producto " + articulo.getId() + " en el carrito");
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
		if (diaDescuento == fecha.getDayOfWeek().getValue()) {
			for (ItemCarrito item : lstItemCarrito) {
				int cantidad = item.getCantidad();
				int divisor = 2;
				float calculo = cantidad / divisor;
				descuento += calculo * item.getArticulo().getPrecio() * (porcentajeDescuentoDia / 100);
			}
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
		setDescuento(descuentoSup);
		return descuentoSup;
	}

	public double totalAPagarCarrito() {
		return calcularTotal() - getDescuento();
	}
	
	public LocalTime traerHoraRetiro(LocalDate fecha) {
        LocalTime hora = null;
        if(this.entrega instanceof RetiroLocal && entrega.getFecha()==fecha) {
            hora=((RetiroLocal) entrega).getHoraEntrega();

        }
        return hora;
      
    }
	
	
	
	
}
