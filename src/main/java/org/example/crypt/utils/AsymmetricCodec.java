package org.example.crypt.utils;

import javax.crypto.Cipher;
import java.security.Key;

/**
 * AsymmetricCodec
 * 非对称加密算法
 * @Author: taomee
 * @Date: 2020/6/20 0020 15:24
 * @Description:
 */
public class AsymmetricCodec {

    public static String privateEncode(String message, String algorithm, String privateKeyPath) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        Key privateKey = KeyPairUtil.getPrivatelicKey(algorithm, privateKeyPath);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] bytes = cipher.doFinal(message.getBytes());
        String base64Encode = Base64Util.encode(bytes);
        return base64Encode;
    }

    public static String publicDecode(String encode, String algorithm, String publicKeyPath) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        Key publicKey = KeyPairUtil.getPublicKey(algorithm, publicKeyPath);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] encodeBytes = Base64Util.decode(encode);
        byte[] bytes = cipher.doFinal(encodeBytes);
        return new String(bytes);
    }

    public static String encode(String message, String algorithm, String publicKeyPath) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        Key publicKey = KeyPairUtil.getPublicKey(algorithm, publicKeyPath);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(message.getBytes());
        String base64Encode = Base64Util.encode(bytes);
        return base64Encode;
    }

    public static String decode(String encode, String algorithm, String privateKeyPath) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        Key privatelicKey = KeyPairUtil.getPrivatelicKey(algorithm, privateKeyPath);
        cipher.init(Cipher.DECRYPT_MODE, privatelicKey);
        byte[] encodeBytes = Base64Util.decode(encode);
        byte[] bytes = cipher.doFinal(encodeBytes);
        return new String(bytes);
    }
}
