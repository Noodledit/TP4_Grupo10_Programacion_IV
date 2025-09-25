package dominio;

public class TipoSeguro {

	int idTipo;
	String descripcion;
	
	public TipoSeguro() {		
	}
	
	public TipoSeguro(int idTipo, String descripcion) {		
		this.idTipo = idTipo;
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoSeguro\nID Tipo: " + idTipo + "\ndescripcion: " + descripcion;
	}
}
