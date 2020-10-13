package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comercio extends Actor {

	private String nombreComercio;
	private long cuit;
	private double costoFijo;
	private double costoPorKm;
	private int diaDescuento;
	private int porcentajeDescuentoDia;
	private int porcentajeDescuentoEfectivo;
	private ArrayList<DiaRetiro> lstDiaRetiro;
	private ArrayList<Articulo> lstArticulo;
	private ArrayList<Carrito> lstCarrito;

	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm,
			int diaDescuento, int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {

		super(id, contacto);
		this.nombreComercio = nombreComercio;
		this.setCuit(cuit);
		this.costoFijo = costoFijo;
		this.costoPorKm = costoPorKm;
		this.diaDescuento = diaDescuento;
		this.porcentajeDescuentoDia = porcentajeDescuentoDia;
		this.porcentajeDescuentoEfectivo = porcentajeDescuentoEfectivo;
		this.lstDiaRetiro = new ArrayList<DiaRetiro>();
		this.lstArticulo = new ArrayList<Articulo>();
		this.lstCarrito = new ArrayList<Carrito>();

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

	public ArrayList<Carrito> getLstCarrito() {
		return lstCarrito;
	}

	public void setLstCarrito(ArrayList<Carrito> lstCarrito) {
		this.lstCarrito = lstCarrito;
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

	public void mostrarListaDiasRetiro() {
		for (DiaRetiro dia : getLstDiaRetiro()) {
			System.out.println(dia);
		}
	}

	public void separador() {
		System.out.println(">~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<");
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

	public boolean agregarDiaRetiro(int diaSemana, LocalTime horaDesde, LocalTime horaHasta, int intervalo) {
		int idDiaRetiro = 1;
		DiaRetiro aux = new DiaRetiro(idDiaRetiro, diaSemana, horaDesde, horaHasta, intervalo);
		boolean resultado = false;

		if ((traerDiaRetiro(aux) == null) || (diaSemana > 7) || (diaSemana < 1)) {
			resultado = false;
		} else {
			if (lstDiaRetiro.size() > 0)
				idDiaRetiro = lstDiaRetiro.get(lstDiaRetiro.size() - 1).getId() + 1;
			lstDiaRetiro.add(aux);
			aux.setId(idDiaRetiro);
			resultado = true;
		}
		return resultado;
	}

	public DiaRetiro traerDiaRetiro(LocalDate fecha) {
		DiaRetiro aux = null;
		int diaSemana = fecha.getDayOfWeek().getValue();
		for (DiaRetiro dia : lstDiaRetiro) {
			if (dia.getDiaSemana() == diaSemana) {
				aux = dia;
			}
		}

		return aux;
	}

	public List<Turno> generarAgenda(LocalDate fecha) throws Exception {

		DiaRetiro aux = traerDiaRetiro(fecha);
		List<Turno> agenda = new ArrayList<Turno>();
		if (aux == null)
			throw new Exception("Error: No se puede generar la Agenda. Almacen Cerrado");
		else {
			LocalTime hora = aux.getHoraDesde();
			agenda.add(new Turno(fecha, hora, false));

			while (hora.isBefore(aux.getHoraHasta())) {
				hora = hora.plusMinutes(aux.getIntervalo());
				agenda.add(new Turno(fecha, hora, false));
			}
		}
		return agenda;
	}

	public List<Carrito> listaCarritos(Carrito carrito) {
		lstCarrito.add(carrito);
		return lstCarrito;
	}

	public Carrito traerCarrito(ArrayList<Carrito> lstCarrito, Cliente cliente) {
		Carrito aux = null;
		for (Carrito cart : lstCarrito) {
			if (cart.getCliente() == cliente) {
				aux = cart;
			}
		}
		return aux;
	}

	public boolean aptoAbrirNuevoCarrito(ArrayList<Carrito> lstCarrito, Cliente cliente) throws Exception {
		Carrito aux = null;
		boolean apto = true;
		for (Carrito cart : lstCarrito) {
			if (cart.getCliente() == cliente) {
				aux = cart;
				apto = true;
			}
		}
		if (aux.isCerrado() == false) {
			apto = false;
		}
		if (apto == false)
			throw new Exception("Error: Debe cerrar su carrito anterior para generar uno nuevo");
		return apto;
	}

	public int traerSoloHora(LocalTime tiempo) {
		int soloHora = tiempo.getHour();
		return soloHora;
	}

	public int traerDecenaMinutos(LocalTime tiempo) {
		int soloMinutos = tiempo.getMinute();
		int decena = soloMinutos / 10;
		return decena;

	}

	public boolean asignarTurno(List<Turno> agenda) {
		boolean flag = false;
		Entrega entrega = null;
		for (Carrito carrito : lstCarrito) {
			for (Turno turno : agenda) {
				if (turno.getHora() == carrito.getHora()) {
					turno.setOcupado(true);
					entrega = carrito.getEntrega();
					((RetiroLocal) entrega).setHoraEntrega(turno.getHora());
					flag = true;
				}
			}
		}

		return flag;
	}

	public List<Turno> generarTurnosLibres(List<Turno> agenda, LocalDate fecha) {
		List<Turno> turnos = new ArrayList<Turno>();

		for (Turno turno : agenda) {
			if (turno.isOcupado() == false) {
				turnos.add(turno);
			}
		}
		return turnos;
	}

	public List<Turno> traerTurnosOcupados(List<Turno> agenda, LocalDate fecha) {
		List<Turno> turnos = new ArrayList<Turno>();

		for (Turno turno : agenda) {
			if (turno.isOcupado() == true) {
				turnos.add(turno);
			}
		}
		return turnos;
	}

	@Override
	public boolean ValidarIdentificadorUnico() {
		// TODO Auto-generated method stub
		return false;
	}
}
