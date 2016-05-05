/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package safe.beans;

import aproc.crud.AprocLogMethods;
import aproc.map.Uztuser;
import flexjson.JSONSerializer;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author elvis
 */
@Stateless
public class SessionBeanBaseDeDatos implements InterfaceBaseDeDatos{

    public String toJson(ArrayList prueba)
    {
        JSONSerializer json= new JSONSerializer();
        return json.serialize(prueba);
    }
    
     public String encriptar(String texto)  {
 
        String secretKey = "qualityinfosolutions"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}
         public String Desencriptar(String textoEncriptado)throws Exception {
 
        String secretKey = "qualityinfosolutions"; //llave para desenciptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
}
    
    @Override
    public String LlamadoBaseAprocLog() {
       AprocLogMethods met= new AprocLogMethods();
        ArrayList<Uztuser> usuarios = met.ListUsuarios();
        String prueba= toJson(usuarios);
        return prueba; 
    }

    @Override
    public boolean insertarUsuario() {
         AprocLogMethods met= new AprocLogMethods();
         Uztuser usuario= new Uztuser(BigDecimal.valueOf(1111), encriptar("L00010320"), encriptar("Elvis Sarchi"), encriptar("Estudiante"), 'A', encriptar("01"), null);
         
         return met.InsertarUsuario(usuario);
    }

    
}
