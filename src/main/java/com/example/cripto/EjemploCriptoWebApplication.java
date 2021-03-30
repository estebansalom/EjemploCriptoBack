package com.example.cripto;

import com.example.cripto.config.EncryptionConfig;
import com.example.cripto.config.JWTConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemploCriptoWebApplication {

	public static JWTConfig jwtConfig = new JWTConfig();
	public static EncryptionConfig encryptionConfig = new EncryptionConfig();

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EjemploCriptoWebApplication.class, args);
		System.out.println("corriendo...");
//		System.out.println("Encrypting hello world");
//		String hola = "hello world";
//		String holaEnc = encryptionConfig.encrypt(hola, "471F809856685AAC", "1234567812345678");
//		System.out.println(holaEnc);
//		System.out.println("Decripting " + holaEnc + " :");
//		String holaDenc = encryptionConfig.desEncrypt(holaEnc, "471F809856685AAC", "1234567812345678");
//		System.out.println(holaDenc);
	}

}
