package org.example.crypt.utils;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.io.FileUtils;
import org.example.crypt.algorithm.AsymmetricAlgorithm;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * KeyPairUtil
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 14:56
 * @Description:
 */
public class KeyPairUtil {
    public static void buildKeyPair(String algorithm) throws Exception{
        //创建密钥对对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //生成公，私钥
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        byte[] encodedPrivate = privateKey.getEncoded();
        byte[] encodedPublic = publicKey.getEncoded();
        //Base64转码
        String prv = Base64.encode(encodedPrivate);
        String pub = Base64.encode(encodedPublic);
        String pubFile = buildFilePath(algorithm,"pub");
        String priFile = buildFilePath(algorithm,"pri");
        FileUtils.writeStringToFile(new File(pubFile), pub, Charset.forName("utf-8"));
        FileUtils.writeStringToFile(new File(priFile), prv, Charset.forName("utf-8"));
    }

    public static PublicKey getPublicKey(String algorithm, String pubKeyPath) throws Exception {
        String pub = FileUtils.readFileToString(new File(pubKeyPath), Charset.forName("utf-8"));
        byte[] pubBytes = Base64.decode(pub);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        KeySpec keySpec = new X509EncodedKeySpec(pubBytes);
        return keyFactory.generatePublic(keySpec);
    }

    public static PrivateKey getPrivatelicKey(String algorithm, String privateKeyPath) throws Exception {
        String privateKey = FileUtils.readFileToString(new File(privateKeyPath), Charset.forName("utf-8"));
        byte[] privateBytes = Base64.decode(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        KeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
        return keyFactory.generatePrivate(keySpec);
    }

    private static String buildFilePath(String algorithm, String suffix){
        StringBuilder sb = new StringBuilder();
        sb.append(algorithm);
        sb.append(".");
        sb.append(suffix);
        return sb.toString();
    }
}
