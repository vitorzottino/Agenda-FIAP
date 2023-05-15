package br.com.fiap.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptoUtil {
	
	public static String criptografar (String senha) throws Exception{
			
			//Obtem a instancia de um algoritmo
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Passa os dois a serem criptografados e estipula enconding padrão
			md.update(senha.getBytes("ISO-8859-1"));
			//Gera a chave criptografada em array de Bytes para posterior hashing
			BigInteger hash = new BigInteger(1, md.digest());
			//Retorna a senha criptografada
			return hash.toString(16);
		
			
	}
	

}
