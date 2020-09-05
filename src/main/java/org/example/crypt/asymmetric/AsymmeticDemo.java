package org.example.crypt.asymmetric;

import org.example.crypt.algorithm.AsymmetricAlgorithm;
import org.example.crypt.utils.AsymmetricCodec;

/**
 * AsymmeticDemo
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 11:25
 * @Description:
 */
public class AsymmeticDemo {
    public static void main(String[] args) throws Exception {
        String algorithm = AsymmetricAlgorithm.RSA.getAlgorithm();
//        KeyPairUtil.buildKeyPair(algorithm);
        String message = "Hello,World!";
        //公私加密-> 私钥解密
        String base64Encode = AsymmetricCodec.encode(message, algorithm, "RSA.pub");
        System.out.println(base64Encode);

        String src = AsymmetricCodec.decode(base64Encode,algorithm,"RSA.pri");
        System.out.println(src);

        //私钥加密-> 公钥解密
        String encode = AsymmetricCodec.privateEncode(message, algorithm, "RSA.pri");
        System.out.println(encode);

        String srcMsg = AsymmetricCodec.publicDecode(encode,algorithm,"RSA.pub");
        System.out.println(srcMsg);
    }
}
