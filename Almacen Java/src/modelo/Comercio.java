package modelo;

import java.util.ArrayList;
import java.util.Objects;

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


   public boolean validarIdentificadorUnico (long cuit) 
   {
	   String cuit1= ""+ cuit;
	   
	  
	   if (cuit1.length() != 11)  
	   
	   {
		 System.out.println("Cuit no valido, No son 11 caracteres");
		 return false;  
		 
	   }
	   
	   
	   char[] cuitVector = cuit1.toCharArray();
	   
	   Integer[] multiplos = {5,4,3,2,7,6,5,4,3,2};
	   Integer aux=0;
	   
	   for (int i=0; i<10; i++)
	   {
		   aux+= Character.getNumericValue(cuitVector[i]) * multiplos[i];
	   }
	   aux = 11 - (aux % 11);
	   if(aux==11)
	   {
		   aux=0;
	   }
	   if(aux==10)
	   {
		   aux=3;
	   }
	   
	   System.out.println("Tira false si la validacion no da igual, y true si la validacion es correcta");
	   
	   return Objects.equals(Character.getNumericValue(cuitVector[10]),aux);

   }
}
