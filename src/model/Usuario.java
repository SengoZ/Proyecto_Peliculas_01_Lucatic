package model;
import java.sql.Date;

public class Usuario {
	
	private int idcliente;
	private String nombre_completo;
	private String ciudad;
	private Date date;
	private int categoria;
	
	public Usuario() {}
	
	public Usuario(int idCliente, String nombre_completo, Date date, String ciudad, int categoria) {
		this.idcliente = idCliente;
		this.nombre_completo = nombre_completo;
		this.date = date;
		this.ciudad = ciudad;
		this.categoria = categoria;
		
	}
	
	public Usuario(String nombre_completo, Date date, int idCliente, String ciudad, int categoria) {
		this.nombre_completo = nombre_completo;
		this.date = date;
		this.idcliente = idCliente;
		this.ciudad = ciudad;
		this.categoria = categoria;
	}
	
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Date getDate() {
		return date;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getNombre_completo() {
		return nombre_completo;
	}
	
	public int getIdcliente() {
		return idcliente;
	}
	
	@Override
	public String toString() {
		return "Cliente:"+idcliente+"\nNombre Cliente: " + nombre_completo +", Ciudad: "+ciudad+", Fecha Nacimiento: "+date+", Categoria: "+categoria;
	}

}
