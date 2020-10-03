package modelo;

public class Ubicacion {
	private double latitud;
	private double longitud;

	public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public boolean equals(Ubicacion u) {
		return ((this.latitud == u.getLatitud()) && (this.longitud == u.getLongitud()));
	}

	@Override
	public String toString() {
		return "Ubicación: Latitud:" + this.latitud + " Longitud:" + this.longitud;
	}

}
