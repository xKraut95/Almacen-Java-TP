package modelo;

public class Comercio {

	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorK;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private DiaRetiro DiaRetiro;
	
	public Comercio (String nombreComercio, long cuit, double costoFijo, double costoPorK, int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo, DiaRetiro DiaRetiro) {
		this.nombreComercio= nombreComercio;
		this.cuit= cuit;
		this.costoFijo= costoFijo;
		this.costoPorK = costoPorK;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia= porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo= porcentajeDescuentoEfectivo;
		this.DiaRetiro = DiaRetiro;	
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

	public DiaRetiro getDiaRetiro() {
		return DiaRetiro;
	}

	public void setDiaRetiro(DiaRetiro diaRetiro) {
		DiaRetiro = diaRetiro;
	}
	
	
	@Override
	public String toString() {
	    return "Comercio: nombreComercio"+ this.nombreComercio + "Comercio: cuit"+ this.cuit + "Comercio: costoFijo"+ this.costoFijo + "Comercio: costoPorK"+ this.costoPorK + "Comercio: diaDescuento"+ this.diaDescuento + "Comercio: porcentajeDescuentoDia"+ this.porcentajeDescuentoDia + "Comercio: porcentajeDescuentoEfectivo"+ this.porcentajeDescuentoEfectivo + "Comercio:DiaRetiro"+ this.DiaRetiro;
	}
}
