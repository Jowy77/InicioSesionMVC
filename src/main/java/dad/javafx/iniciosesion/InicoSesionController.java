package dad.javafx.iniciosesion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicoSesionController {

	private final String usersFile = "usuarios.csv";
	
	private InicioSesionModel model;
	private InicioSesionView view;
	
	public InicoSesionController() {
		
		model = new InicioSesionModel();
		view = new InicioSesionView();
		
		model.userProperty().bindBidirectional(view.getUsuarioTexto().textProperty());
		model.contrasenaProperty().bindBidirectional(view.getContrasenaTexto().textProperty());
		
		view.getLoginButton().setOnAction( e -> onLoginBtAction(e));
		view.getCancelButton().setOnAction( e -> Platform.exit() );
	}
	
	private void onLoginBtAction(ActionEvent e) {
		
		String usuario = model.getUsuario();
		String contrasena = model.getContrasena();
		
		if( usuario.isEmpty() || contrasena.isEmpty() || !isUserValid(usuario, contrasena) ) {
			launchLoginError();
			model.setContrasena("");
		}
		
		else {
			
			launchLoginOk();
			Platform.exit();
		}
	}
	
	
	private boolean isUserValid(String nombreUsuario, String contrasena) {
		
		FileInputStream file = null;
		InputStreamReader in = null;
		BufferedReader buff = null;
		
		try {
			
			 file = new FileInputStream(usersFile);
			 in = new InputStreamReader(file, StandardCharsets.UTF_8);
			 buff = new BufferedReader(in);
			 
			 String line;
			 while( (line = buff.readLine()) != null ) {
				 
				 String[] data = line.split(",");
				 if( nombreUsuario.equals(data[0]) && codificarContrasena(contrasena).equals(data[1]) ) {
					 return true;
				 }
			 }			
			 
		} catch (IOException e) {
		} finally {
			
			try {
				if( buff != null ) {
					buff.close();
				}
				
				if( in != null ) {
					in.close();
				}
				
				if( file != null ) {
					file.close();
				}
			} catch (IOException e) {
			}
		}
		
		return false;
	}
	
	private String codificarContrasena(String text) { 
		
		return DigestUtils.md5Hex(text).toUpperCase(); 
	}
	
	private void launchLoginOk() {
		
		Alert confAlert = new Alert(AlertType.INFORMATION);
		confAlert.setHeaderText("Acceso permitido");
		confAlert.setContentText("Las credenciales de acceso son válidas");
		confAlert.showAndWait();
	}

	private void launchLoginError() {
		
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("Acceso denegado");
		errorAlert.setContentText("El usuario y/o la contraseña no son válidos");
		errorAlert.showAndWait();
	}
	
	public InicioSesionView getRootView() {
		return view;
	}
}
