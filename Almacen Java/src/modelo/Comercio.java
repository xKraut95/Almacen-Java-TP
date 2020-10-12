package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import java.time.LocalDate;
import java.time.LocalTime;

public class Comercio extends Actor{

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

	public Comercio(int id, Contacto contacto, String nombreComercio, long cuit, double costoFijo, double costoPorKm, int diaDescuento,
			int porcentajeDescuentoDia, int porcentajeDescuentoEfectivo) throws Exception {
		
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
	
	//Redefinido
	/*public DiaRetiro traerDiaRetiro(LocalDate fecha) {
		//DiaRetiro aux = new DiaRetiro(0, diaRetiro.getDiaSemana(), diaRetiro.getHoraDesde(), diaRetiro.getHoraHasta(),
		//		diaRetiro.getIntervalo());
		DiaRetiro aux = null; 
		int diaSemana = fecha.getDayOfWeek().getValue();
		boolean resultado = false;
		Iterator<DiaRetiro> iterador = lstDiaRetiro.iterator();
		while ((iterador.hasNext()) && (resultado == false)) {
			if (iterador.next().equals(diaSemana)) {
				resultado = true;
				
			}
		}
		if (resultado == true)
			return aux;
		else
			return null;
	}*/
	
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


		public List<Turno> generarAgenda (LocalDate fecha) throws Exception { //Retorna una lista de objetos Turno indicando si está ocupado o libre
					
			DiaRetiro aux = traerDiaRetiro(fecha);
			List<Turno> agenda = new ArrayList <Turno>();
			//List<Turno> ocupados = traerTurnosOcupados(fecha);
			if(aux == null) throw new Exception ("Error: No se puede generar la Agenda. Almacen Cerrado");
			else {
				LocalTime hora = aux.getHoraDesde();
				agenda.add(new Turno(fecha,hora,false));
				
				while(hora.isBefore(aux.getHoraHasta())){
					hora=hora.plusMinutes(aux.getIntervalo());
					//if()
					agenda.add(new Turno(fecha, hora, false));
				}
			}
			return agenda;
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
			 
			 for(Carrito car: lstCarrito)
			 {
				 LocalTime hora = car.traerHoraRetiro(fecha);
				 
				 if(hora != null)
				 {
					 turnosOcupados.add(new Turno(fecha, hora, true));
				 }
			 }
			
			 return turnosOcupados;
		 }
		
		/*public List<Turno> generarTurnosLibres(LocalDate fecha)
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
		 }*/
		 
		// public List<Carrito> listaCarritos(Cliente cliente){//(LocalDate fecha)
			 
		// }
		 
		 //esto no funciona
		/*public void mostrarListaCarritos() {
				for (Carrito carritos : getLstICarrito()) {
					System.out.println(carritos);
				}
				
		}*/
		 
		 public List<Carrito> listaCarritos (Carrito carrito) { //Retorna una lista de objetos Turno indicando si está ocupado o libre
			 lstCarrito.add(carrito);
			 return lstCarrito;
		 }

		/* public Carrito traerCarrito(ArrayList<Carrito> lstCarrito, Cliente cliente) {
				int id =1;
				
				boolean encontrado = false;
				Iterator<Carrito> iterador = lstCarrito.iterator();
				while (iterador.hasNext()) {
					if (iterador.next().equals(cliente.getId())) {
						encontrado = true;
						return carr
						
					}
					id++;
				}
				if (resultado == true)
					return null;
				else
					return aux;
			}*/
		 
		 public Carrito traerCarrito(ArrayList<Carrito> lstCarrito, Cliente cliente) {//traerUltimoCarritoDelCliente
			 Carrito aux=null;
			 for(Carrito cart: lstCarrito){
				 if(cart.getCliente()==cliente){
					 aux=cart;
					 }
				 }
		return aux;
		 }
		 //polimorfismo? del metodo iscerrado de la clase Carrito
		 /*public boolean isCerrado(Carrito cart) {
				return cart.isCerrado();
			}*/
		 
		 
		 public boolean aptoAbrirNuevoCarrito(ArrayList<Carrito> lstCarrito, Cliente cliente) throws Exception{
			 Carrito aux=null;
			 boolean apto=true;
			 for(Carrito cart: lstCarrito){
				 if(cart.getCliente()==cliente){
					 aux=cart;
					 apto=true;
					 }
				 }
			/* if(aux.isCerrado()==true||aux==null) {
				 apto=true;
			 }
			 else throw{*/
			 if(aux.isCerrado()==false) {
				 apto=false;
			 }
			 if(apto==false)throw new Exception("Error: Debe cerrar su carrito anterior para generar uno nuevo");
			 return apto;
		 }
		 
		 
}		 
		 /////
		/*//quitarComentario
		  public int traerSoloHora(LocalTime tiempo) {
		 
			int soloHora = tiempo.getHour();
			 return soloHora;
		 }
		 public int traerDecenaMinutos(LocalTime tiempo) {
			 int soloMinutos = tiempo.getMinute();
			 
		 }
		 ///////////////////////////////////BORRADOR
		 public List<Turno> modificarSetOcupado(List<Turno> agenda,Carrito cart) {
			 Iterator<Turno> iterador = agenda.iterator();
				//while ((iterador.hasNext()) && (resultado == false)) {
			 while ((iterador.hasNext())) {
					if (iterador.next().equals(traerSoloHora(cart.getHora()))&&iterador.next().equals(obj)) {
						while ())
						
						
						resultado = true;
					}
				}
				if (resultado == true)
					return null;
				else
					return aux;
		 }
			 //////
			 /*while()
				for(Turno turno : agenda){
					if(turno.()==diaSemana)
					{
						aux= dia;
					}
				}
				
				return aux;
			}*/
		  //Quitar comentario
		 ////////////////////////////////////////
		 //}*/
		 //TraerCarrito trae el ultimo carrito de ese cliente antes de abrir otro
		 //isCerrado se fija que la ultima compra/carrito este cerrado
		 //Si no esta cerrado avisa que no se puede abrir un carrito nuevo hasta que se cierre el anterior
	

