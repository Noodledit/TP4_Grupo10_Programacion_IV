package dominio;

public class Seguro {
	int idSeguro;
	String descripcion;
	int idTipo;
	double costoContracion;
	double costoAsegurado;
	
	public Seguro() {
	}
	
	public Seguro(int idSeguro, String descripcion, int idTipo, double costoContracion, double costoAsegurado) {
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContracion = costoContracion;
		this.costoAsegurado = costoAsegurado;
	}
	
	//sin id para inserciones
	public Seguro(String descripcion, int idTipo, double costoContracion, double costoAsegurado) {
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContracion = costoContracion;
		this.costoAsegurado = costoAsegurado;
	}
	

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public double getCostoContracion() {
		return costoContracion;
	}

	public void setCostoContracion(double costoContracion) {
		this.costoContracion = costoContracion;
	}

	public double getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return "ID Seguro: " + idSeguro + " Descripcion: " + descripcion + "ID Tipo: " + idTipo
				+ ", Costo de Contracion: " + costoContracion + " Costo Asegurado:" + costoAsegurado;
	}
	
	
}
