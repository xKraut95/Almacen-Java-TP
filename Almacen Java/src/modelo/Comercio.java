package modelo;

import java.util.ArrayList;

public class Comercio {

	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorK;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private ArrayList<DiaRetiro> lstDiaRetiro;
	private ArrayList<Articulo> lstArticulo;
	private ArrayList<Carrito> lstICarrito;

	public Comercio(String nombreComercio, long cuit, double costoFijo, double costoPorK, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) {
		this.nombreComercio = nombreComercio;
		this.cuit = cuit;
		this.costoFijo = costoFijo;
		this.costoPorK = costoPorK;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.lstICarrito = new ArrayList<Carrito>();
	}

	public ArrayList<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public ArrayList<Articulo> getLstArticulo() {
		return lstArticulo;
	}

	public ArrayList<Carrito> getLstICarrito() {
		return lstICarrito;
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public double getCostoPorK() {
		return costoPorK;
	}

	public void setCostoPorK(double costoPorK) {
		this.costoPorK = costoPorK;
	}

	public int getDiaDescuento() {
		return diaDescuento;
	}

	public void setDiaDescuento(int diaDescuento) {
		this.diaDescuento = diaDescuento;
	}

	public int getPorcentajeDescuentoDia() {
		return porcentajeDescuentoDia;
	}

	public void setPorcentajeDescuentoDia(int porcentajeDescuentoDia) {
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
	}

	public int getPorcentajeDescuentoEfectivo() {
		return porcentajeDescuentoEfectivo;
	}

	public void setPorcentajeDescuentoEfectivo(int porcentajeDescuentoEfectivo) {
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
	}

	@Override
	public String toString() {
		return "Comercio: nombreComercio" + this.nombreComercio + "Comercio: cuit" + this.cuit + "Comercio: costoFijo"
				+ this.costoFijo + "Comercio: costoPorK" + this.costoPorK + "Comercio: diaDescuento" + this.diaDescuento
				+ "Comercio: porcentajeDescuentoDia" + this.porcentajeDescuentoDia
				+ "Comercio: porcentajeDescuentoEfectivo" + this.porcentajeDescuentoEfectivo;
	}
}
