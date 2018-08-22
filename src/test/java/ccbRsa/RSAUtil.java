package ccbRsa;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {  
      
    /** 指定加密算法为RSA */  
    private static final String ALGORITHM = "RSA";  
    /** 指定公钥存放文件 */  
    private static String PUBLIC_KEY_FILE = "PublicKey";  
    /** 指定私钥存放文件 */  
    private static String PRIVATE_KEY_FILE = "PrivateKey";  
    
    
    /**
     * 还原公钥
     * 
     * @param keyBytes
     * @return
     */
    public static PublicKey restorePublicKey(byte[] keyBytes) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
            PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
            return publicKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 还原私钥
     * 
     * @param keyBytes
     * @return
     */
    public static PrivateKey restorePrivateKey(byte[] keyBytes) {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
                keyBytes);
        try {
            KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
            PrivateKey privateKey = factory
                    .generatePrivate(pkcs8EncodedKeySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] readTobyte(String fileName) {  
       
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
       
  
        try {
			return  new BASE64Decoder().decodeBuffer(new String(filecontent));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
       
    }  
    
    public static String bytesToHexString(byte[] src) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (src == null || src.length <= 0) {
			return null;
		}
		for (int i = 0; i < src.length; i++) {
			int v = src[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}  
  
    public static void main(String[] args) throws Exception {  
          
    	String  data="hello world";


    	PrivateKey pvtKey=restorePrivateKey(readTobyte(PRIVATE_KEY_FILE));
    	Signature signature = Signature.getInstance("SHA256WithRSA");
    	signature.initSign(pvtKey);
    	signature.update(data.getBytes());
    	byte sign[]= signature.sign();
    	System.out.println("报文签名串长度"+sign.length);
        System.out.println("签名串="+bytesToHexString(sign).toUpperCase());
    	
    	PublicKey pubKey=restorePublicKey(readTobyte(PUBLIC_KEY_FILE));
    	Signature signature1 = Signature.getInstance("SHA256WithRSA");
    	signature.initVerify(pubKey);
    	signature.update(data.getBytes());
    	boolean b= signature.verify(sign);
        System.out.println("报文验签结果="+b);

    } 
} 