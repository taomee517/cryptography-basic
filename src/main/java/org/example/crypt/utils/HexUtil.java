package org.example.crypt.utils;

/**
 * HexUtil
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 11:06
 * @Description:
 */
public class HexUtil {
    public static String toHex(byte[] sha){
        //转成16进制
        StringBuilder sb = new StringBuilder();
        for (byte b: sha) {
            String hex = Integer.toHexString(b&0xff);
            if(hex.length() == 1){
                hex = "0" + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
