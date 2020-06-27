package org.example.crypt.algorithm;


/**
 * DigestAlgorithm
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 11:07
 * @Description:
 */
public enum DigestAlgorithm {
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512"),
    ;

    private String algorithm;

    DigestAlgorithm(String algorithm){
        this.algorithm = algorithm;
    }


    public String getAlgorithm() {
        return algorithm;
    }
}
