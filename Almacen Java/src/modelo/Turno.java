package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

	private LocalDate dia;
	private LocalTime hora;
	private boolean ocupado;

	public Turno(LocalDate dia, LocalTime hora, boolean ocupado) {
		this.dia = dia;
		this.hora = hora;
		this.ocupado = ocupado;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public boolean equals(Turno t) {
		return ((this.dia == t.getDia()) && (this.hora == t.getHora()));
	}

	@Override
	public String toString() {
		return "Turno:dia" + this.dia + "Turno:Hora" + this.hora + "Turno:ocupado" + this.ocupado;
	}
}


