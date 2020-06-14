package org.example.crypt.classic;

/**
 * CaesarEncrypt
 *
 * @Author: taomee
 * @Date: 2020/6/14 0014 21:16
 * @Description: 凯撒加密法
 */
public class CaesarEncrypt {
    public static final int OFFSET = 3;
    public static void main(String[] args) {
        String msg = "Hello,World!";
        String enMsg = encrypt(msg);
        System.out.println("加密内容：" + enMsg);
        String deMsg = decrypt(enMsg);
        System.out.println("解密内容：" + deMsg);
    }

    private static String encrypt(String in){
        char[] chars = in.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character c: chars){
            sb.append((char)(c+OFFSET));
        }
        String out = sb.toString();
        return out;
    }

    private static String decrypt(String in){
        char[] chars = in.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(Character c: chars){
            sb.append((char)(c-OFFSET));
        }
        String out = sb.toString();
        return out;
    }
}
