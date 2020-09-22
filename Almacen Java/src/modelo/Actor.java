package modelo;

public abstract class Actor {
	protected int id;
	protected Contacto contacto;

	public Actor(int id, Contacto contacto) {
		this.id = id;
		this.contacto = contacto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "Actor: id " + this.id + "Actor: contacto" + this.contacto;
	}
}
