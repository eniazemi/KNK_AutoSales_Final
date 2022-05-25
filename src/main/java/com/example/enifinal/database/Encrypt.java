package com.example.enifinal.database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encrypt {

    public String encryptionWithMD5(String crypt) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = crypt.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();

            for (byte b : digested) {
                sb.append(Integer.toHexString(0xff & b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException ignore) {
        }

        return null;
    }
}
