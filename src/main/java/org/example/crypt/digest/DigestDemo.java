package org.example.crypt.digest;

import org.example.crypt.algorithm.DigestAlgorithm;
import org.example.crypt.utils.DigestCodec;

/**
 * DigestDemo
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 10:54
 * @Description:
 */
public class DigestDemo {

    public static void main(String[] args) throws Exception{
        //原文
        String msg = "Hello,World!";
        String encode = DigestCodec.encode(msg, DigestAlgorithm.MD5);
        System.out.println(encode);
    }
}
