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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.E;

/**
 *
 * @author ACER
 */
public class Trithemius {
    
    private String matriz [][]; 
    private String textoClaro;
    private String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
      
    public Trithemius(){
         matriz = new String [27][27];
        llenarMatriz();
    }
    
    public void llenarMatriz(){
        int base=0;
       
        for (int i = 0; i < 27; i++) {  
            for (int j = 0 ; j < 27-base; j++) {
               
                matriz[i][j] = abecedario[j+base];
            
            }    
            
            if( base!=0){
                
                int k=0;
                for (int l = 27-base; l < 27; l++) {
                    
                    matriz[i][l]=abecedario[k]; 
                    k++;
                }       
            }
            base++;
        }
   
    
    }
    
    public void cifrar(String ruta) throws UnsupportedEncodingException, IOException{
    
        int contador = 0;
        boolean flag=false;
        File archivo = new File(ruta);
        BufferedWriter bw;
        
        bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(archivo+".cif",true), "ISO-8859-1"));
        
        String cadena = "";
        
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
        
        int caract =f.read();
        while(caract != -1 ) {
            char caracter = (char) caract;
            cadena=Character.toString((char)caract);
            
            for (int j = 0; j < 27; j++) {
                if(cadena.equals(matriz[j][0])){
                    
                    bw.write(matriz[j][contador%27]);
                    contador++;
                    flag=true;
               
                }
           
            }
            if(!flag){
              
                bw.write(cadena);
            }
            caract =f.read();
            flag=false;
          
        }
        bw.close();
       
    }
 
    
    public void descrifrar(String ruta) throws UnsupportedEncodingException, IOException{
        int contador=0;
        boolean flag=false;
        
        File archivo = new File(ruta);
        BufferedWriter bw;
        bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(archivo+".dec",true), "ISO-8859-1"));
        
        String cadena = "";
        
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(archivo),"ISO-8859-1"));
        int caract =f.read();
        
        while(caract != -1 ) {
             char caracter = (char) caract;
            cadena=Character.toString((char)caract).toUpperCase();
            for (int j = 0; j < 27; j++) {
                
                if(cadena.equals(matriz[j][contador%27])){
                    bw.write(matriz[j][0]);
                    contador++;
                    flag=true;
                    break;
                }
   
            }
            if(!flag){
               
                bw.write(cadena);
            }
            caract =f.read();
            flag=false;
          
        }
        bw.close();
                

 
    }
 }
