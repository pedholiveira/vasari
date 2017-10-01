package utils;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author pedholiveira
 */
public abstract class EncryptionUtils {
	
	/**
	 * Encrypt some value using SHA-256 algorithim.
	 * 
	 * @param value
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptSHA256(String value) {
		return DigestUtils.sha256Hex(value);
	}
}
