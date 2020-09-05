package org.example.crypt.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES
 *
 * @Author: taomee
 * @Date: 2020/6/14 0014 21:48
 * @Description:
 */
public class DESAES {

    public static String encrypt(String in,String algorithm,String encryptType,String key) throws Exception{
        // 创建加密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 创建加密规则
        // 参数一：加密key的字节数组
        // 参数二：加密类型
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),encryptType);
        // 进行加密初始化
        // 参数一：加解密，ENCRYPT_MODE/DECRYPT_MODE
        // 参数二：加密规则
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 调用加密方法
        byte[] enBytes = cipher.doFinal(in.getBytes());
        // 打印加密结果，通常会有乱码，因为负值没有对应的ascii码
//            String enMsg = new String(enBytes);

        String enMsg = Base64Util.encode(enBytes);
        return enMsg;
    }


    public static String decrpt(String in,String algorithm,String encryptType,String key) throws Exception{
        // 创建解密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 创建加密规则
        // 参数一：加密key的字节数组
        // 参数二：加密类型
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),encryptType);
        // 进行解密初始化
        // 参数一：加解密，ENCRYPT_MODE/DECRYPT_MODE
        // 参数二：加密规则
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        // 调用解密方法
        byte[] enBytes = Base64Util.decode(in);
        byte[] deBytes = cipher.doFinal(enBytes);
        String deMsg = new String(deBytes);
        return deMsg;
    }
}
