package modelo;

public class Comercio {

	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorK;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private DiaRetiro ListaDiaRetiro;
	private Articulo Articulo;
	private Carrito Carrito;
	
	public Comercio (String nombreComercio, long cuit, double costoFijo, double costoPorK, int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo, DiaRetiro ListaDiaRetiro, Articulo Articulo) {
		this.nombreComercio= nombreComercio;
		this.cuit= cuit;
		this.costoFijo= costoFijo;
		this.costoPorK = costoPorK;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia= porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo= porcentajeDescuentoEfectivo;
		this.ListaDiaRetiro = ListaDiaRetiro;	
		this.Articulo = Articulo;
		this.Carrito = Carrito;
	}

	public DiaRetiro getListaDiaRetiro() {
		return ListaDiaRetiro;
	}

	public void setListaDiaRetiro(DiaRetiro listaDiaRetiro) {
		ListaDiaRetiro = listaDiaRetiro;
	}

	public Articulo getArticulo() {
		return Articulo;
	}

	public void setArticulo(Articulo articulo) {
		Articulo = articulo;
	}

	public Carrito getCarrito() {
		return Carrito;
	}

	public void setCarrito(Carrito carrito) {
		Carrito = carrito;
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
	    return "Comercio: nombreComercio"+ this.nombreComercio + "Comercio: cuit"+ this.cuit + "Comercio: costoFijo"+ this.costoFijo + "Comercio: costoPorK"+ this.costoPorK + "Comercio: diaDescuento"+ this.diaDescuento + "Comercio: porcentajeDescuentoDia"+ this.porcentajeDescuentoDia + "Comercio: porcentajeDescuentoEfectivo"+ this.porcentajeDescuentoEfectivo + "Comercio:DiaRetiro"+ this.ListaDiaRetiro + "Comercio: Articulo" + this.Articulo + "Comercio:Carrito" + this.Carrito;
	}
}
