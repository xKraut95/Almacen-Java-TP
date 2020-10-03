package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Comercio {

	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private ArrayList<DiaRetiro> lstDiaRetiro;
	private ArrayList<Articulo> lstArticulo;
	private ArrayList<Carrito> lstICarrito;

	public Comercio(String nombreComercio, long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		this.nombreComercio = nombreComercio;
		this.setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;

	}

	public ArrayList<DiaRetiro> getLstDiaRetiro() {
		return lstDiaRetiro;
	}

	public void setLstDiaRetiro(ArrayList<DiaRetiro> lstDiaRetiro) {
		this.lstDiaRetiro = lstDiaRetiro;
	}

	public ArrayList<Articulo> getLstArticulo() {
		return lstArticulo;
	}

	public void setLstArticulo(ArrayList<Articulo> lstArticulo) {
		this.lstArticulo = lstArticulo;
	}

	public ArrayList<Carrito> getLstICarrito() {
		return lstICarrito;
	}

	public void setLstICarrito(ArrayList<Carrito> lstICarrito) {
		this.lstICarrito = lstICarrito;
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

	public void setCuit(long cuit) throws Exception {
		String cuit1 = "" + cuit;
		if (cuit1.length() != 11)
			throw new Exception("Cuit no valido. No son 11 caracteres");
		char[] cuitVector = cuit1.toCharArray();
		if (cuitVector[0] != '3' && (cuitVector[1] != '0'))
			throw new Exception("Cuit no valido. No es empresa");
		if (!validarIdentificadorUnico(cuit))
			throw new Exception("Error: Cuit Invalido");
		this.cuit = cuit;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;

	}

	public double getCostoPorKm() {
		return costoPorKm;
	}

	public void setCostoPorKm(double costoPorKm) {
		this.costoPorKm = costoPorKm;
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
		return "Datos de Comercio\n\tNombre: " + this.nombreComercio + "\n\tCuit: " + this.cuit + "\n\tCostoFijo: "
				+ this.costoFijo + "\n\tCostoPorKm: " + this.costoPorKm + "\n\tDia de Descuento: " + this.diaDescuento
				+ "\n\tPorcentajeDescuentoDia: " + this.porcentajeDescuentoDia + "\n\tPorcentajeDescuentoEfectivo: "
				+ this.porcentajeDescuentoEfectivo;
	}

	public String separador() {
		return (">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<");
	}

	public boolean validarIdentificadorUnico(long cuit) throws Exception {

		String cuit1 = "" + cuit;

		char[] cuitVector = cuit1.toCharArray();

		int[] multiplos = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
		int aux = 0;

		for (int i = 0; i < 10; i++) {
			aux += Character.getNumericValue(cuitVector[i]) * multiplos[i];
		}
		aux = 11 - (aux % 11);
		if (aux == 11) {
			aux = 0;
		}
		if (aux == 10) {
			aux = 3;
		}
		return Objects.equals(Character.getNumericValue(cuitVector[10]), aux);
	}
}