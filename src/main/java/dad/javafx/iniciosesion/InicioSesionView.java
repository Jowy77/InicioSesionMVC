package dad.javafx.iniciosesion;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InicioSesionView extends VBox {

	private Label userLabel,contrasenaLabel;
	private TextField userTexto;
	private PasswordField contrasenaTexto;
	private Button loginButton, cancelButton;
	
	public InicioSesionView() {
	
		userLabel = new Label("Usuario:");
		userLabel.setPrefWidth(80);
		
		contrasenaLabel = new Label("Contraseña:");
		contrasenaLabel.setPrefWidth(80);
		
		userTexto = new TextField();
		userTexto.setPromptText("Usuario");
		userTexto.setPrefColumnCount(10);
		
		contrasenaTexto = new PasswordField();
		contrasenaTexto.setPromptText("Contraseña");
		contrasenaTexto.setPrefColumnCount(10);
		
		loginButton = new Button("Acceder");
		loginButton.setDefaultButton(true);
		
		cancelButton = new Button("Cancelar");
		
		HBox userBox = new HBox(20, userLabel, userTexto);
		userBox.setFillHeight(false);
		userLabel.setAlignment(Pos.BASELINE_LEFT);
		
		HBox passBox = new HBox(20, contrasenaLabel, contrasenaTexto);
		passBox.setFillHeight(false);
		passBox.setAlignment(Pos.BASELINE_LEFT);
		
		HBox btBox = new HBox(5, loginButton, cancelButton);
		btBox.setFillHeight(false);
		btBox.setAlignment(Pos.BASELINE_CENTER);
		
		getChildren().addAll(userBox, passBox, btBox);
		setAlignment(Pos.CENTER);
		setSpacing(10);
		setFillWidth(false);
	}

	public TextField getUsuarioTexto() {
		return userTexto;
	}

	public PasswordField getContrasenaTexto() {
		return contrasenaTexto;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

}
