package com.soomla.util;

import android.text.TextUtils;
import com.soomla.Soomla;
import com.soomla.SoomlaUtils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class AESObfuscator {
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] IV = {16, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};
    private static final String KEYGEN_ALGORITHM = "PBEWITHSHAAND256BITAES-CBC-BC";
    private static final String TAG = "SOOMLA AESObfuscator";
    private static final String UTF8 = "UTF-8";
    private static final String header = "com.soomla.billing.util.AESObfuscator-1|";
    private Cipher mDecryptor;
    private Cipher mEncryptor;

    public AESObfuscator(byte[] bArr, String str, String str2) {
        byte[] digest;
        String str3 = Soomla.SECRET;
        if (str3.equals("SOOMLA_SEC")) {
            SoomlaUtils.LogError(TAG, "You didn't provide a SOOMLA secret!!! Stopping now!");
        }
        try {
            digest = SecretKeyFactory.getInstance(KEYGEN_ALGORITHM).generateSecret(new PBEKeySpec((str + str2 + str3).toCharArray(), bArr, 1024, 256)).getEncoded();
        } catch (GeneralSecurityException unused) {
            SoomlaUtils.LogDebug(TAG, "Probably an incompatible device. Trying different approach.");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                char[] charArray = (str + str2 + str3).toCharArray();
                for (char c : charArray) {
                    messageDigest.update((byte) c);
                }
                digest = messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Invalid environment", e);
            }
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(digest, "AES");
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            this.mEncryptor = cipher;
            cipher.init(1, secretKeySpec, new IvParameterSpec(IV));
            Cipher cipher2 = Cipher.getInstance(CIPHER_ALGORITHM);
            this.mDecryptor = cipher2;
            cipher2.init(2, secretKeySpec, new IvParameterSpec(IV));
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment 2", e2);
        }
    }

    public String obfuscateInt(int i) {
        return obfuscateString("" + i);
    }

    public synchronized String obfuscateString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Cipher cipher = this.mEncryptor;
            return Base64.encode(cipher.doFinal((header + str).getBytes(UTF8)));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Invalid environment", e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    public int unobfuscateToInt(String str) throws ValidationException {
        return Integer.parseInt(unobfuscateToString(str));
    }

    public synchronized String unobfuscateToString(String str) throws ValidationException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            try {
                String str2 = new String(this.mDecryptor.doFinal(Base64.decode(str)), UTF8);
                if (str2.indexOf(header) != 0) {
                    throw new ValidationException("Header not found (invalid data or key):" + str);
                }
                return str2.substring(40, str2.length());
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Invalid environment", e);
            } catch (IllegalBlockSizeException e2) {
                throw new ValidationException(e2.getMessage() + ":" + str);
            }
        } catch (Base64DecoderException e3) {
            throw new ValidationException(e3.getMessage() + ":" + str);
        } catch (BadPaddingException e4) {
            throw new ValidationException(e4.getMessage() + ":" + str);
        }
    }

    /* loaded from: classes.dex */
    public class ValidationException extends Exception {
        private static final long serialVersionUID = 1;

        public ValidationException() {
        }

        public ValidationException(String str) {
            super(str);
        }
    }
}