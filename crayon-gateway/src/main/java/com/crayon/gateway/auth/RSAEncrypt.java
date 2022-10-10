package com.crayon.gateway.auth;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class RSAEncrypt {

	private static final Map<String, String> keyMap = new HashMap<>();
	public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCIdBb5U1aZ1sMf2/+RaJNnef7RKGSbDwNcrAPCt7rLff6v6g1Zv5Yi1CSehqaaxcua/GRkZlbs2APB6Kc39LJ7S+N0W7cp6woDwtSeREK7RC7gUFIbjMn0cbJItrVFSV2Mso7fi5fkbcq1Y7r4+mQacEoy5O8w7fBzScKvwLQA7QIDAQAB";
	public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIh0FvlTVpnWwx/b/5Fok2d5/tEoZJsPA1ysA8K3ust9/q/qDVm/liLUJJ6GpprFy5r8ZGRmVuzYA8Hopzf0sntL43RbtynrCgPC1J5EQrtELuBQUhuMyfRxski2tUVJXYyyjt+Ll+RtyrVjuvj6ZBpwSjLk7zDt8HNJwq/AtADtAgMBAAECgYBO0K8MaASXayLdXhcqB/tMQ3zZlrk1juBkQL8TU0hDjYz0Uv5PHog7qclU/3Vv5FuMM8hQ7YO73bGd6SHdAiushTr83ba9def2ne/secMU7BNyQtSgqJapstFOt1KxCQeXX+PVIZztX8wtpqAWWBXw5Yy+FmgZRFKYuADwa1jOAQJBAP+qTHgnAToli3LwuJzvpEH/9/5RMxTHdvL2R0L1TBjpZGaRD9wGhzEhqfygkgED/Y9oR+4e1PMzqDAHjiKieS0CQQCIodSGjMUEHqPn6jX1IIo2UnbTIH5yTnY8PEk99l8DI3li+hW2PE7ojB3tbZsBke9F/TqDpEgKL0fsuE01bP7BAkEAjxd5hSYPgcPRsJsaOHvHq0jgO+6mcFLTOFiuucMgvDCkiONXxQXCVLVKtqIIFZluKP1shNGszhFzaK5R1wCoYQJAchBoFEvAzkemHh5xHUslF2SQvoEKDvNh0beijY/4ke4zkGWnapO+bHVNJsGx/gWO86cMCopDef0u1nimPEvaAQJBAJM9UXz2aHEWImtcDYuOUNUj3PX/592vp+tOo6wIl7KxgRHNR1F3WHmcYQdGzmMUVD+Re3Dx9Q71F1vok6+TSSs=";

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

//	public static String getPrivateKey(String publicKey) {
//		return keyMap.get(publicKey);
//	}

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
		String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
		// 得到私钥字符串
		String privateKeyString = Base64.getEncoder().encodeToString((privateKey.getEncoded()));
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
		byte[] decoded = Base64.getDecoder().decode(publicKey);
		RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA")
				.generatePublic(new X509EncodedKeySpec(decoded));
		// RSA加密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
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
		byte[] inputByte = Base64.getDecoder().decode(str);
		// base64编码的私钥
		byte[] decoded = Base64.getDecoder().decode(privateKey);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
				.generatePrivate(new PKCS8EncodedKeySpec(decoded));
		// RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		return new String(cipher.doFinal(inputByte));
	}
}