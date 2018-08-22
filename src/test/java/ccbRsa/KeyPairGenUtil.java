package ccbRsa;
import java.io.FileOutputStream;  
import java.io.FileWriter;
import java.io.ObjectOutputStream;  
import java.security.Key;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.NoSuchAlgorithmException;  
import java.security.SecureRandom;


import sun.misc.BASE64Encoder;  
  
public class KeyPairGenUtil {  
  
    /** 指定加密算法为RSA */  
    private static final String ALGORITHM = "RSA";  
    /** 密钥长度，用来初始化 */  
    private static final int KEYSIZE = 2048;  
    /** 指定公钥存放文件 */  
    private static String PUBLIC_KEY_FILE = "PublicKey";  
    /** 指定私钥存放文件 */  
    private static String PRIVATE_KEY_FILE = "PrivateKey";  
  
    public static void main(String[] args) throws Exception {  
        generateKeyPair();  
    
    }  
  
    /** 
    * 生成密钥对 
    * @throws Exception 
    */  
    private static void generateKeyPair() throws Exception {
  
        //     /** RSA算法要求有一个可信任的随机数源 */  
        //     SecureRandom secureRandom = new SecureRandom();  
        /** 为RSA算法创建一个KeyPairGenerator对象 */  
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);  
  
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */  
        //     keyPairGenerator.initialize(KEYSIZE, secureRandom);  
        keyPairGenerator.initialize(KEYSIZE);  
  
        /** 生成密匙对 */  
        KeyPair keyPair = keyPairGenerator.generateKeyPair();  
  
        /** 得到公钥 */  
        Key publicKey = keyPair.getPublic();  
  
        /** 得到私钥 */  
        Key privateKey = keyPair.getPrivate();  
        
        byte[] publicKeyBytes = publicKey.getEncoded();  
        byte[] privateKeyBytes = privateKey.getEncoded();
  
        String publicKeyBase64 = new BASE64Encoder().encode(publicKeyBytes);
        String privateKeyBase64 = new BASE64Encoder().encode(privateKeyBytes);
        System.out.println("公钥为:\n"+publicKeyBase64);
        System.out.println("私钥为:\n"+privateKeyBase64);

        FileWriter publicKeyWiter;
        FileWriter privateKeyWiter;

      	publicKeyWiter=new FileWriter(PUBLIC_KEY_FILE);
    	privateKeyWiter=new FileWriter(PRIVATE_KEY_FILE);
        try {
           publicKeyWiter.write(publicKeyBase64);
           privateKeyWiter.write(privateKeyBase64);

           publicKeyWiter.flush();
          privateKeyWiter.flush();
          publicKeyWiter.close();
          privateKeyWiter.close();

     } catch (Exception e) {
         throw e;
     } finally {
	    publicKeyWiter.close();
        privateKeyWiter.close();
     }
    }
}  