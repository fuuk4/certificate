package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SafePass {
	private static final String ALG = "PBKDF2WithHmacSHA256";
	private static final int ITE_COUNT = 1000;
	private static final int KEY_LENGTH = 256;

	public static String getSafePass(String pass,String salt) {
		char[] passCharAry = pass.toCharArray();
		byte[] hashedSalt = getHashedSalt(salt);

		PBEKeySpec KeySpec = new PBEKeySpec(passCharAry,hashedSalt,ITE_COUNT,KEY_LENGTH);

		SecretKeyFactory skf;
		try {
			skf = SecretKeyFactory.getInstance(ALG);
		}catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		SecretKey sk;
		try {
			sk = skf.generateSecret(KeySpec);
		}catch(InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}

		byte[] passByteAry = sk.getEncoded();

		StringBuilder sb = new StringBuilder();

		for(byte b: passByteAry) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	private static byte[] getHashedSalt(String salt) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		}catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.update(salt.getBytes());
		return md.digest();
	}
}
