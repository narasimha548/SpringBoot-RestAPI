package com.cgs.aes.algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class is used to represents the File Encryption and DeCryption using
 * AES-256 Algorithm
 * 
 * 
 * 
 * @author Prasad
 * @version 1.0
 * @since 08-07-2021
 * 
 * 
 *
 */

@Component
public class FileEncryption {

	@Value("${AES-SECRET-KEY}")
	private String secertKey;

	@Value("${SALT-KEY}")
	private String saltKey;

	/**
	 * This method is used to encrypt the file using AES-256 algorithm
	 * 
	 * 
	 * @param inputFile
	 * @param encryptFileName
	 */

	public Map<String, String> fileEncryption(String inputFile, String encryptFileName) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		Map<String, String> resMap=new HashMap<String,String>();

		byte[] ivByte = { 'S', 'T', 'A', 'R', 'c', 'a', 'r', 'D', 'M', 'a', 'N', 'P', 'C', 'I', 'D', 'S' };

		IvParameterSpec ivParam = new IvParameterSpec(ivByte);

		System.out.println(" secertKey*********  " + secertKey + "  saltKey*****" + saltKey);

		try {
			SecretKeyFactory secretKeyFact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(secertKey.toCharArray(), saltKey.getBytes(), 65536, 256);

			SecretKey generateSecret = secretKeyFact.generateSecret(spec);

			SecretKeySpec secretKeySpec = new SecretKeySpec(generateSecret.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParam);

			fis = new FileInputStream(inputFile);

			fos = new FileOutputStream(encryptFileName);

			CipherInputStream cis = new CipherInputStream(fis, cipher);
			writeEncryptFile(cis, fos);
			
			resMap.put("SCC-0","File Encypted Sucessfully");
		} catch (NoSuchAlgorithmException msg) {
			System.err.print(msg.getMessage());

			resMap.put("ERR-01", "NoSuchAlgorithmException");
		} catch (InvalidKeySpecException e) {
			System.err.print(e.getMessage());
			resMap.put("ERR-02", "InvalidKeySpecException");
			
		} catch (NoSuchPaddingException e) {
			System.err.print(e.getMessage());
			resMap.put("ERR-03", "NoSuchPaddingException");
		}  catch (InvalidAlgorithmParameterException e) {
			System.err.print(e.getMessage());
			resMap.put("ERR-04", "InvalidAlgorithmParameterException");
		} catch (FileNotFoundException e) {
			System.err.print(e.getMessage());
			resMap.put("ERR-05", "FileNotFoundException");
		} catch (IOException e) {
			System.err.print(e.getMessage());
			resMap.put("ERR-06", "IOException");
		} catch (InvalidKeyException e) {
			System.err.print(e.getMessage());
			resMap.put("ERR-07", "IOException");
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			System.out.println("Resources closed successfully");

		}
		
	
		
		return resMap;

	}
	
	

	/**
	 * This method is used to write the file
	 * 
	 * 
	 * @param InputStream
	 * @param OutputStream
	 * @throws IOException
	 * 
	 * 
	 */

	public static void writeEncryptFile(InputStream is, OutputStream os) throws IOException {
		System.out.println("input stream is ===    " + is + "    output stream is =====" + os);
		byte[] bytes = new byte[1024];

		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		System.out.println("$$$$$$$$$$$$ FILE COPIED in Docopy %%%%%%%%%%%%%%%%%%%");
		os.flush();
		os.close();
		is.close();
	}

}
