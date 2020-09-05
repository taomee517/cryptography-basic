package org.example.crypt.utils;


//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import org.apache.commons.codec.binary.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * SignatureUtil
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 18:49
 * @Description:
 */
public class SignatureUtil {
    public static String buildSignature(String algorithm, PrivateKey privateKey, String input) throws Exception{
        //创建签名对象
        Signature signature = Signature.getInstance(algorithm);
        //初始化签名对象
        signature.initSign(privateKey);
        //输入原文
        signature.update(input.getBytes());
        //开始签名
        byte[] sign = signature.sign();
        //转码
//        String signStr = Base64.encode(sign);
        byte[] encodeBytes = Base64.encodeBase64(sign);
        String signStr = HexUtil.toHex(encodeBytes);
        return signStr;
    }

    public static boolean verifySignature(String src, String algorithm, PublicKey publicKey, String sign) throws Exception{
        //创建签名对象
        Signature signature = Signature.getInstance(algorithm);
        //初始化校验
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
//        byte[] signBytes = Base64.decode(sign);
        byte[] decodeBytes = Base64.decodeBase64(sign);
        return signature.verify(decodeBytes);
    }
}
