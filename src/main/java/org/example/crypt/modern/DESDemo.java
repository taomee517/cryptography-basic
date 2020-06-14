package org.example.crypt.modern;

import org.example.crypt.modern.util.DESAES;

/**
 * DESDemo
 *
 * @Author: taomee
 * @Date: 2020/6/14 0014 21:48
 * @Description:
 */
public class DESDemo {
    public static void main(String[] args) throws Exception {
        // 消息原文
        String in = "重要情报";
        // 定义key,密钥必须是8个字节
        String key = "12345678";
        // 算法
        String algorithm = "DES";
        // 加密类型
        String encryptType = "DES";
        // 调用加密方法
        String enMsg = DESAES.encrypt(in,algorithm,encryptType,key);
        System.out.println("加密结果：" + enMsg);
        String deMsg = DESAES.decrpt(enMsg,algorithm,encryptType,key);
        System.out.println("解密结果：" + deMsg);
    }
}
