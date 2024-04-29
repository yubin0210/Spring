package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class HashComponent {

	public String getHash(String userpw) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(userpw.getBytes());
			String hash = String.format("%0128x", new BigInteger(1, md.digest()));
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
