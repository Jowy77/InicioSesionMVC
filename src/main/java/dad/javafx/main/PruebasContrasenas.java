package dad.javafx.main;

import org.apache.commons.codec.digest.DigestUtils;

public class PruebasContrasenas {

	public static void main(String[] args) {
		//ESTAS SON LAS CONTRASEÑAS ORIGINALES DEL FICHERO EN ORDEN
		String password = "1234";
		String password2 = "5555";
		String password3 = "7777";
		String password4 = "6969";
		
		String md5 = DigestUtils.md5Hex(password).toUpperCase();
		String md52 = DigestUtils.md5Hex(password2).toUpperCase();
		String md53 = DigestUtils.md5Hex(password3).toUpperCase();
		String md54 = DigestUtils.md5Hex(password4).toUpperCase();
		
		System.out.println("Password cifrado: " + md5);
		System.out.println("Password cifrado: " + md52);
		System.out.println("Password cifrado: " + md53);
		System.out.println("Password cifrado: " + md54);

	}

}
