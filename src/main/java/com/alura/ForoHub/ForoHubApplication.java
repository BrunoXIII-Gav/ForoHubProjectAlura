package com.alura.ForoHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ForoHubApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("CONTRASEÑA QUE DEBES COLOCAR/ACTUALIZAR EN TU BASE DE DATOS CADA VEZ QUE SE REINICIA / contraseña a ingresar en postman: 1234");
		System.out.println(encoder.encode("1234"));
		SpringApplication.run(ForoHubApplication.class, args);
	}

}
