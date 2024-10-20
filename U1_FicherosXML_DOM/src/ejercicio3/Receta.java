package ejercicio3;

public class Receta {
	private String titulo;
	private String ingrediente1;
	private String ingrediente2;	
	private String cantidad1;
	private String cantidad2;	
	private String procedimiento;
	private String tiempo;

	public Receta(String titulo, String ingrediente1, String cantidad1, String ingrediente2, String cantidad2, String procedimiento, String tiempo) {
		super();
		this.titulo = titulo;
		this.ingrediente1 = ingrediente1;
		this.cantidad1 = cantidad1;
		this.ingrediente2 = ingrediente2;
		this.cantidad2 = cantidad2;
		this.procedimiento = procedimiento;
		this.tiempo = tiempo;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIngrediente1() {
		return ingrediente1;
	}

	public void setIngrediente1(String ingrediente1) {
		this.ingrediente1 = ingrediente1;
	}

	public String getIngrediente2() {
		return ingrediente2;
	}

	public void setIngrediente2(String ingrediente2) {
		this.ingrediente2 = ingrediente2;
	}

	public String getCantidad1() {
		return cantidad1;
	}

	public void setCantidad1(String cantidad1) {
		this.cantidad1 = cantidad1;
	}

	public String getCantidad2() {
		return cantidad2;
	}

	public void setCantidad2(String cantidad2) {
		this.cantidad2 = cantidad2;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	
}
