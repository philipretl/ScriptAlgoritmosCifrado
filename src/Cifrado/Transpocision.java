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

/**
 *
 * @author philip
 */
public class Transpocision {
    
    private StringBuilder bloque1;
    private StringBuilder bloque2;
    private StringBuilder bloque3;
    private StringBuilder bloque4;
    
    public Transpocision(){
       
    }
    public void descifrar(String ruta,String tipo, String base) throws IOException{
         switch(tipo){
            case "-ts":
                 transpocisionsimple(ruta,"d",base);
            break;
            
            case "-td":
                transpocisiondoble(ruta,"d",base);
            break;
            
            case "-ti":
                transpocisioninversa(ruta,"d",base);
            break;
            
            case "-tse":
                
            break;
            
            default:
                System.out.println("Error: Tipo no valido por favor revise la sintaxis\n Si tienes duda para usar el algoritmo consulta la ayuda\n");
                
                System.out.println(" \nConsultar la ayuda de un algoritmo en especifico: \n");
                System.out.println("        sintaxis: java -jar Cifrado.jar <algoritmo> -a");
            
            break;
        
        
        
        }
    }
    
    public void cifrar(String ruta,String tipo,String base) throws FileNotFoundException, IOException{
        
        switch(tipo){
            case "-ts":
                transpocisionsimple(ruta,"c",base);
            break;
            
            case "-td":
                transpocisiondoble(ruta,"c",base);
            break;
            
            case "-ti":
                transpocisioninversa(ruta,"c",base);
            break;
            
            case "-tse":
                
            break;
            
            default:
                System.out.println("Error: Tipo no valido por favor revise la sintaxis\n Si tienes duda para usar el algoritmo consulta la ayuda\n");
                
                System.out.println(" \nConsultar la ayuda de un algoritmo en especifico: \n");
                System.out.println("        sintaxis: java -jar Cifrado.jar <algoritmo> -a");
            
            break;
        
        
        
        }
        
    }
    
    public void transpocisionsimple(String ruta,String modo, String base) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        int contador = 0;
        StringBuilder sbc;
        StringBuilder sbd;
        String textc="";
        String textd="";
        boolean flag=false;
        File archivo = new File(ruta);
        BufferedWriter bw= null;
        
        
        
        String cadena = "";
      
       
        if (modo.equals("c")){
            sbc= new StringBuilder();
            StringBuilder mensaje= new StringBuilder();
            
            if (base.equals("-n")){
                File antiguo=new File(ruta.split("\\.")[0]+".cif");
                if (antiguo.exists()){
                   antiguo.delete();
                }
               bw = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(ruta.split("\\.")[0]+".cif",true), "ISO-8859-1"));
            }
            
            // si es base 64
            
            if (base.equals("-64")){
               File antiguo=new File(ruta.split("\\.")[0]+".cif64");
               if (antiguo.exists()){
                  antiguo.delete();
               }
              bw = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(ruta.split("\\.")[0]+".cif64",true), "ISO-8859-1"));
            }
               
            
            
            BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            
            bloque1=new StringBuilder();
            bloque2=new StringBuilder();
            
            while ((textc= f.readLine())!=null) {
                sbc.append(textc); 
            }
            
            for (int i = 0; i < sbc.length(); i++) {
                if (i%2==0){
                    bloque1.append(sbc.charAt(i));
                    
                }else{
                    
                    bloque2.append(sbc.charAt(i));
                }
                 
            }
            mensaje.append(bloque1);
            mensaje.append(bloque2);
           
            
            bw.write(mensaje.toString());
            f.close();
            bw.close();
        }
        
        if (modo.equals("d")){
            sbd= new StringBuilder();
            int fin=0;
            int range=0;
            StringBuilder mensaje = new StringBuilder();
            bloque1=new StringBuilder();
            bloque2=new StringBuilder();
              
           
            BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            
            if (base.equals("-n")){
                File antiguo=new File(ruta.split("\\.")[0]+".dec");
                if (antiguo.exists()){
                   antiguo.delete();
                }
               bw = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(ruta.split("\\.")[0]+".dec",true), "ISO-8859-1"));
            }
            
            // si es base 64
            
            if (base.equals("-64")){
               File antiguo=new File(ruta.split("\\.")[0]+".dec64");
               if (antiguo.exists()){
                  antiguo.delete();
               }
              bw = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(ruta.split("\\.")[0]+".dec64",true), "ISO-8859-1"));
            }
               
            while ((textd= f.readLine())!=null) {
                sbd.append(textd); 
            }
            
            fin=sbd.length()/2;
           
           
            for (int i = 0; i <fin; i++) {
               bloque1.append(sbd.charAt(i));
            }
            for (int j = fin; j<sbd.length(); j++) {
               bloque2.append(sbd.charAt(j));
            }
           
            for (int x = 0; x < fin; x++) {
                if(sbd.length()%2==0){
                   mensaje.append(bloque1.charAt(x));
                   mensaje.append(bloque2.charAt(x));
                }else{
                  mensaje.append(bloque1.charAt(x));
                  mensaje.append(bloque2.charAt(x+1));
                }
                
                
            }
           
            if(sbd.length()%2!=0){
               mensaje.append(bloque2.charAt(0));
            }
            
            bw.write(mensaje.toString());
        
           
            f.close();
            bw.close();
        }
        
        
    }
    
    public void transpocisiondoble(String ruta,String modo, String base) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        int contador = 0;
        StringBuilder sbc;
        StringBuilder sbd;
        String textc="";
        String textd="";
        boolean flag=false;
        File archivo = new File(ruta);
        BufferedWriter bw= null;
        
        String cadena = "";
      
       
        if (modo.equals("c")){
            sbc= new StringBuilder();
            StringBuilder mensaje= new StringBuilder();
            StringBuilder mensaje2= new StringBuilder();
            
            if (base.equals("-n")){
                File antiguo=new File(ruta.split("\\.")[0]+".cif");
                if (antiguo.exists()){
                   antiguo.delete();
                }
               bw = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(ruta.split("\\.")[0]+".cif",true), "ISO-8859-1"));
            }
            
            // si es base 64
            
            if (base.equals("-64")){
               File antiguo=new File(ruta.split("\\.")[0]+".cif64");
               if (antiguo.exists()){
                  antiguo.delete();
               }
              bw = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(ruta.split("\\.")[0]+".cif64",true), "ISO-8859-1"));
            }
               
            
            
            BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            
            bloque1=new StringBuilder();
            bloque2=new StringBuilder();
            
            while ((textc= f.readLine())!=null) {
                sbc.append(textc); 
            }
             for (int i = 0; i < sbc.length(); i++) {
                if (i%2==0){
                    bloque1.append(sbc.charAt(i));
                    
                }else{
                    
                    bloque2.append(sbc.charAt(i));
                }
                 
            }
            mensaje.append(bloque1);
            mensaje.append(bloque2);
            
            
            bloque3=new StringBuilder();
            bloque4=new StringBuilder();
            
             for (int i = 0; i < mensaje.length(); i++) {
                if (i%2==0){
                    bloque3.append(mensaje.charAt(i));
                }else{
                    bloque4.append(mensaje.charAt(i));
                }
                 
            }
            mensaje2.append(bloque3);
            mensaje2.append(bloque4);
            
            bw.write(mensaje2.toString()); 
            f.close();
            bw.close();
        }
        
        if (modo.equals("d")){
            sbd= new StringBuilder();
            int fin=0;
            int range=0;
            StringBuilder mensaje = new StringBuilder();
            StringBuilder mensaje2 = new StringBuilder();
            bloque1=new StringBuilder();
            bloque2=new StringBuilder();
            bloque3=new StringBuilder();
            bloque4=new StringBuilder();
              
           
            BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            
            if (base.equals("-n")){
                File antiguo=new File(ruta.split("\\.")[0]+".dec");
                if (antiguo.exists()){
                   antiguo.delete();
                }
               bw = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(ruta.split("\\.")[0]+".dec",true), "ISO-8859-1"));
            }
            
            // si es base 64
            
            if (base.equals("-64")){
               File antiguo=new File(ruta.split("\\.")[0]+".dec64");
               if (antiguo.exists()){
                  antiguo.delete();
               }
              bw = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(ruta.split("\\.")[0]+".dec64",true), "ISO-8859-1"));
            }
               
            while ((textd= f.readLine())!=null) {
                sbd.append(textd); 
            }
           
            
             // primera Iteracion
            fin=sbd.length()/2;
           
           
            for (int i = 0; i <fin; i++) {
               bloque1.append(sbd.charAt(i));
            }
            for (int j = fin; j<sbd.length(); j++) {
               bloque2.append(sbd.charAt(j));
            }
           
            for (int x = 0; x < fin; x++) {
                if(sbd.length()%2==0){
                   mensaje.append(bloque1.charAt(x));
                   mensaje.append(bloque2.charAt(x));
                }else{
                  mensaje.append(bloque1.charAt(x));
                  mensaje.append(bloque2.charAt(x+1));
                }
                
                
            }
          
            if(sbd.length()%2!=0){
               mensaje.append(bloque2.charAt(0));
            }
            
            //Segunda Iteracion
            
            for (int i = 0; i <fin; i++) {
               bloque3.append(mensaje.charAt(i));
            }
            for (int j = fin; j<mensaje.length(); j++) {
               bloque4.append(mensaje.charAt(j));
            }
          
            for (int x = 0; x < fin; x++) {
                if(sbd.length()%2==0){
                   mensaje2.append(bloque3.charAt(x));
                   mensaje2.append(bloque4.charAt(x));
                }else{
                  mensaje2.append(bloque3.charAt(x));
                  mensaje2.append(bloque4.charAt(x+1));
                }
                
                
            }
          
            if(mensaje.length()%2!=0){
               mensaje2.append(bloque4.charAt(0));
            }
            
            bw.write(mensaje2.toString());
        
           
            f.close();
            bw.close();
        }
        
        
    }
    
    public void transpocisioninversa(String ruta,String modo, String base) throws UnsupportedEncodingException, FileNotFoundException, IOException{
        int contador = 0;
        StringBuilder sbc;
        StringBuilder sbd;
        String textc="";
        String textd="";
        boolean flag=false;
        File archivo = new File(ruta);
        BufferedWriter bw= null;
        
        
        
        String cadena = "";
      
       
        if (modo.equals("c")){
            sbc= new StringBuilder();
            StringBuilder mensaje= new StringBuilder();
            
            if (base.equals("-n")){
                File antiguo=new File(ruta.split("\\.")[0]+".cif");
                if (antiguo.exists()){
                   antiguo.delete();
                }
               bw = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(ruta.split("\\.")[0]+".cif",true), "ISO-8859-1"));
            }
            
            // si es base 64
            
            if (base.equals("-64")){
               File antiguo=new File(ruta.split("\\.")[0]+".cif64");
               if (antiguo.exists()){
                  antiguo.delete();
               }
              bw = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(ruta.split("\\.")[0]+".cif64",true), "ISO-8859-1"));
            }
               
            
            
            BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            
            bloque1=new StringBuilder();
            bloque2=new StringBuilder();
            
            while ((textc= f.readLine())!=null) {
                sbc.append(textc); 
            }
         
            for (int i = sbc.length()-1; i >=0 ; i--) {
               bloque1.append(sbc.charAt(i));
                 
            }
            mensaje.append(bloque1);
           
           
            
            bw.write(mensaje.toString());
            f.close();
            bw.close();
        }
        
        if (modo.equals("d")){
            sbd= new StringBuilder();
            int fin=0;
            int range=0;
            StringBuilder mensaje = new StringBuilder();
            bloque1=new StringBuilder();
            bloque2=new StringBuilder();
              
           
            BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
            
            if (base.equals("-n")){
                File antiguo=new File(ruta.split("\\.")[0]+".dec");
                if (antiguo.exists()){
                   antiguo.delete();
                }
               bw = new BufferedWriter(new OutputStreamWriter(
                       new FileOutputStream(ruta.split("\\.")[0]+".dec",true), "ISO-8859-1"));
            }
            
            // si es base 64
            
            if (base.equals("-64")){
               File antiguo=new File(ruta.split("\\.")[0]+".dec64");
               if (antiguo.exists()){
                  antiguo.delete();
               }
              bw = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(ruta.split("\\.")[0]+".dec64",true), "ISO-8859-1"));
            }
               
            while ((textd= f.readLine())!=null) {
                sbd.append(textd); 
            }
            
       
            for (int i = sbd.length()-1; i >=0 ; i--) {
               bloque2.append(sbd.charAt(i));
                 
            }
            mensaje.append(bloque2);
           
            
           
            
            bw.write(mensaje.toString());
        
           
            f.close();
            bw.close();
        }
        
        
    }
}