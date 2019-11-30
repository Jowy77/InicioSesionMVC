package dad.javafx.iniciosesion;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesionModel {

	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty contrasena = new SimpleStringProperty();
	
	public final StringProperty userProperty() {
		return this.usuario;
	}
	
	public final String getUsuario() {
		return this.userProperty().get();
	}
	
	public final void setUsuario(final String usuario) {
		this.userProperty().set(usuario);
	}
	
	public final StringProperty contrasenaProperty() {
		return this.contrasena;
	}
	
	public final String getContrasena() {
		return this.contrasenaProperty().get();
	}
	
	public final void setContrasena(final String contrasena) {
		this.contrasenaProperty().set(contrasena);
	}
	
	
	
}
