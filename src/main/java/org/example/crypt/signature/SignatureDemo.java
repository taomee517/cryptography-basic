package org.example.crypt.signature;

import org.example.crypt.algorithm.AsymmetricAlgorithm;
import org.example.crypt.utils.KeyPairUtil;
import org.example.crypt.utils.SignatureUtil;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * SignitureDemo
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 18:40
 * @Description:
 */
public class SignatureDemo {
    public static void main(String[] args) throws Exception {
        String msg = "www.signature.com";
        //指定算法
        String algorithm = AsymmetricAlgorithm.RSA.getAlgorithm();
        //获取公钥，私钥
        PublicKey publicKey = KeyPairUtil.getPublicKey(algorithm,"RSA.pub");
        PrivateKey privateKey = KeyPairUtil.getPrivatelicKey(algorithm, "RSA.pri");
        //生成签名
        String sign = SignatureUtil.buildSignature("sha256withrsa", privateKey, msg);
        System.out.println(sign);
        //校验签名
        boolean verify = SignatureUtil.verifySignature(msg, "sha256withrsa", publicKey, sign);
        System.out.println(verify);
    }
}
