package org.example.crypt.utils;

import org.example.crypt.algorithm.DigestAlgorithm;

import java.security.MessageDigest;

/**
 * DigestCodec
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 14:53
 * @Description:
 */
public class DigestCodec {
    public static String encode(String msg, DigestAlgorithm type) throws Exception{
        //创建消息摘要对象
        MessageDigest digest = MessageDigest.getInstance(type.getAlgorithm());
        //执行摘要算法
        byte[] sha = digest.digest(msg.getBytes());
        //使用Base64转码
//        String base64Str = Base64.encode(sha);
        return HexUtil.toHex(sha);
    }
}
