package org.example.crypt.utils;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    public static String encode(byte[] bytes){
        byte[] encodeBytes = Base64.encodeBase64(bytes);
        return HexUtil.toHex(encodeBytes);
    }

    public static byte[] decode(String encodeStr){
        return Base64.decodeBase64(encodeStr);
    }
}
