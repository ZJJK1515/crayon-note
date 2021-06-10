package com.crayon.gateway.auth;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

public class RSAEncrypt {

	private static final Map<String, String> keyMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		String message = "heheheh";
		String publicKey = genKeyPair();
		String privateKey = keyMap.get(publicKey);
		System.out.println("随机生成的公钥为:" + publicKey);
		System.out.println("============================================");
		System.out.println("随机生成的私钥为:" + privateKey);
		System.out.println("============================================");
		String messageEn = encrypt(message, publicKey);
		System.out.println("加密后的字符串为:" + messageEn);
		System.out.println("============================================");
		String messageDe = decrypt(messageEn, privateKey);
		System.out.println("还原后的字符串为:" + messageDe);
	}

	public static String getPrivateKey(String publicKey) {
		return keyMap.get(publicKey);
	}

	/**
	 * 随机生成密钥对
	 */
	public static String genKeyPair()
			throws NoSuchAlgorithmException {
		// KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		// 初始化密钥对生成器，密钥大小为96-1024位
		keyPairGen.initialize(1024, new SecureRandom());
		// 生成一个密钥对，保存在keyPair中
		KeyPair keyPair = keyPairGen.generateKeyPair();
		// 得到私钥
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate(); 
		// 得到公钥
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic(); 
		String publicKeyString = new sun.misc.BASE64Encoder().encode(publicKey.getEncoded());
		// 得到私钥字符串
		String privateKeyString = new sun.misc.BASE64Encoder().encode((privateKey.getEncoded()));
		keyMap.put(publicKeyString, privateKeyString);
		return publicKeyString;
	}

	/**
	 * RSA公钥加密
	 * @param str 加密字符串
	 * @param publicKey 公钥
	 * @return 密文
	 * @throws Exception 加密过程中的异常信息
	 */
	public static String encrypt(String str, String publicKey) throws Exception {
		// base64编码的公钥
		byte[] decoded = new sun.misc.BASE64Decoder().decodeBuffer(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
				.generatePublic(new X509EncodedKeySpec(decoded));
		// RSA加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		return new sun.misc.BASE64Encoder().encode(cipher.doFinal(str
				.getBytes(StandardCharsets.UTF_8)));
	}

	/**
	 * RSA私钥解密
	 * @param str 加密字符串
	 * @param privateKey 私钥
	 * @return 铭文
	 * @throws Exception 解密过程中的异常信息
	 */
	public static String decrypt(String str, String privateKey)
			throws Exception {
		// 64位解码加密后的字符串
		byte[] inputByte = new sun.misc.BASE64Decoder().decodeBuffer(str);
		// base64编码的私钥
		byte[] decoded = new sun.misc.BASE64Decoder().decodeBuffer(privateKey);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
				.generatePrivate(new PKCS8EncodedKeySpec(decoded));
		// RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		return new String(cipher.doFinal(inputByte));
	}
}