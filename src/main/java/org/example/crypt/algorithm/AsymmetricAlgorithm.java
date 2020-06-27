package org.example.crypt.algorithm;

/**
 * AsymmetricAlgorithm
 *
 * @Author: taomee
 * @Date: 2020/6/20 0020 14:54
 * @Description:
 */
public enum AsymmetricAlgorithm {
    RSA("RSA"),
    ECC("ECC"),
    ;

    private String algorithm;

    AsymmetricAlgorithm(String algorithm){
        this.algorithm = algorithm;
    }


    public String getAlgorithm() {
        return algorithm;
    }
}
