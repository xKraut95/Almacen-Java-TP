package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

	public void setCuit(long cuit) throws Exception {
		String cuit1 = "" + cuit;
		if (cuit1.length() != 11)
			throw new Exception("Cuit no valido, No son 11 caracteres");
		char[] cuitVector = cuit1.toCharArray();
		if (cuitVector[0] != '3' & (cuitVector[1] != '0'))
			throw new Exception("Cuit no valido, no es empresa");
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
	
	public DiaRetiro traerDiaRetiro(DiaRetiro diaRetiro) {
		DiaRetiro aux = new DiaRetiro(0, diaRetiro.getDiaSemana(), diaRetiro.getHoraDesde(), diaRetiro.getHoraHasta(),
				diaRetiro.getIntervalo());
		boolean resultado = false;
		Iterator<DiaRetiro> iterador = lstDiaRetiro.iterator();
		while ((iterador.hasNext()) && (resultado == false)) {
			if (iterador.next().equals(diaRetiro)) {
				resultado = true;
			}
		}
		if (resultado == true)
			return null;
		else
			return aux;
	}
	public DiaRetiro traerDiaRetiro(LocalDate fecha)
	{
		DiaRetiro aux = null; 
		int diaSemana = fecha.getDayOfWeek().getValue();
		for(DiaRetiro dia: lstDiaRetiro)
		{
			if(dia.getDiaSemana()==diaSemana)
			{
				aux= dia;
			}
		}
		
		return aux;
	}
	
	
	public boolean agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		int idDiaRetiro = 1;
		DiaRetiro aux = new DiaRetiro(idDiaRetiro, diaSemana, horaDesde, horaHasta, intervalo);
		boolean resultado = false;

		if ((traerDiaRetiro(aux) == null) || (diaSemana > 7) || (diaSemana < 1)) {
			resultado = false;
		} else {
			if (lstDiaRetiro.size() > 0)
				idDiaRetiro = lstDiaRetiro.get(lstDiaRetiro.size() - 1).getId() + 1;
		
			aux.setId(idDiaRetiro);
			resultado = lstDiaRetiro.add(aux);
		}
		return resultado;
	}

	


 public List<Turno> generarTurnosLibres(LocalDate fecha)
 {
	 DiaRetiro config = traerDiaRetiro(fecha);
	 
	 List<Turno> ocupados = traerTurnosOcupados(fecha);
	 List<Turno> libres = new ArrayList <Turno>();
	 boolean busca = false;
	boolean ingresado = false;
	 
	LocalTime inicio = config.getHoraDesde();
	 
	while(busca == false)
	{
	   for(Turno turn: ocupados)
	   {
		 if(turn.getHora().equals(inicio))
         {
        	 ingresado = true;
         } 
	   }
	   if(ingresado !=true)
	   {
		   libres.add(new Turno(fecha, inicio, false));
	   }
	   if(inicio.equals(config.getHoraHasta()))
	   {
		   busca= true;
	   }
	   else
	   {
		   inicio.plusMinutes(config.getIntervalo());
		   ingresado= false;
	   }
	}
	return libres;
	 
 }
 public List<Turno> traerTurnosOcupados(LocalDate fecha)
 {
	 List<Turno> turnosOcupados = new ArrayList<Turno>();
	 
	 for(Carrito car: lstICarrito)
	 {
		 LocalTime hora = car.traerHoraRetiro(fecha);
		 
		 if(hora != null)
		 {
			 turnosOcupados.add(new Turno(fecha, hora, true));
		 }
	 }
	
	 return turnosOcupados;
 }
 public List<Turno> traerTurnosLibres(LocalDate fecha)
 {
	 List<Turno> turnosLibres = new ArrayList<Turno>();
	 
	 for(Carrito car: lstICarrito)
	 {
		 LocalTime hora = car.traerHoraRetiro(fecha);
		 
		 if(hora != null)
		 {
			 turnosLibres.add(new Turno(fecha, hora, false));
		 }
	 }
	
	 return turnosLibres;
 }
 
 
 }

	
	
	
	
	