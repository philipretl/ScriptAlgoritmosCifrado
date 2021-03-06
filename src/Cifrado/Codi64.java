/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
/**
 *
 * @author philip
 */
public class Codi64 {
    
    private String cod;
    private String descod;
    StringBuilder sbc; 
    StringBuilder sbd;
    public Codi64(){
        cod="";
        descod="";
    }
    
   
    public void codificar64(String ruta) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String textc="";
        sbc= new StringBuilder();
        File archivo = new File(ruta);
        BufferedWriter bw;
        File antiguo=new File(ruta.split("\\.")[0]+".b64");
        if (antiguo.exists()){
            antiguo.delete();
        }
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
        
        bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(ruta.split("\\.")[0]+".b64",true), "ISO-8859-1"));
        
        while ((textc= f.readLine())!=null) {
           sbc.append(textc);
        }
        f.close();
        
        Base64.Encoder encoder = Base64.getEncoder();
        cod = encoder.encodeToString(sbc.toString().getBytes(StandardCharsets.UTF_8) );  
        bw.write(cod);
        bw.close();
       
    }
    
    
    public void descodificar64(String ruta) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        String textd="";
        File archivo = new File(ruta);
        BufferedWriter bw; 
        sbd = new StringBuilder();
        File antiguo=new File(ruta.split("\\.")[0]+".dec");
        if (antiguo.exists()){
            antiguo.delete();
        }
        bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(ruta.split("\\.")[0]+".dec",true), "ISO-8859-1"));
         
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
        
        while ((textd= f.readLine())!=null) {
           sbd.append(textd);
        }
        f.close();
        
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(sbd.toString());
            
        descod = new String(decodedByteArray);
        bw.write(descod);
        bw.close();
        
        antiguo= new File(ruta.split("\\.")[0]+".b64");
         if (antiguo.exists()){
            antiguo.delete();
        }
        
        antiguo= new File(ruta.split("\\.")[0]+".dec64");
         if (antiguo.exists()){
            antiguo.delete();
        }
       
    }
    
    
}
