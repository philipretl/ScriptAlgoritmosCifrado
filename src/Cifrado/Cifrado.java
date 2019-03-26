/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cifrado;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Cifrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String valor="";
        boolean flag=false;
        Trithemius trit = new Trithemius();
        Transpocision transp = new Transpocision();
        long startTime = System.currentTimeMillis();
        Codi64 cod64 = new Codi64();
        // prueba
        //cif.cifrar("tabula recta");
        
        // Valida si el Script recibe uno o ningun argumento.
        if(args.length==0 || args.length==1 ){
            System.out.println("--------------------------------------------------------------------\n      Algoritmos de Cifrado\n Sintaxis: java -jar Cifrado.jar <algoritmo> <parametros>");
            System.out.println(" \n<algoritmo>:\n          -ctth Algoritmo de cifrado de trithemius");
            System.out.println(" \n<algoritmo>:\n          -ctr Algoritmos de cifrado por transpocision");
            System.out.println(" \nConsultar la ayuda de un algoritmo en especifico: \n");
            System.out.println("        sintaxis: java -jar Cifrado.jar <algoritmo> -a");
            
        }else{
            // Si el tamaño es de dos valida si se trata de la opcion correcta.
            // En este apartado se encuentra la descripcion de cada uno de los 
            // Algoritmos.
            
            if(args.length==2){
                String com1="";
                String com2="";
                com1=args[0];
                com2=args[1];


                if (com2.equals("-a") && com1.equals("-ctth")){
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("       Algoritmo de cifrado de Trithemius\n");
                    System.out.println(" Sintaxis: java -jar Cifrado.jar -ctth <modo> <codificacion> -e <Archivo entrada> \n");
                    System.out.println(" <modo> -c para cifrar\n        -d para descifrar\n\n");
                    System.out.println(" <Archivo entrada>: nombre del archivo de entrada\n");
                    System.out.println(" si <modo> es -c el <Archivo de entrada> tiene extension .txt");
                    System.out.println(" si <modo> es -d y <codificacion> -n el <Archivo de entrada> tiene extension .cif");
                    System.out.println(" si <modo>(b64) es -d y <codificacion> -64 el <Archivo de entrada> tiene extension .cif64");
                    System.out.println(" \n<codificacion> es -64 sera codificado a base 64");
                    System.out.println(" \n<codificacion> es -n mantendra la codificacion original");
                    System.out.println("\n\n Salidas: \n      si <modo> : es -c la salida sera .cif");
                    System.out.println("                  es -d la salida sera .def ");
                    System.out.println("\n\n Salidas(b64): \n      si <modo> : es -c y <codificacion> -64 la salida sera .cif64");
                    System.out.println("                  es -d la salida sera .dec64");
                    System.out.println(" \n Ejemplos:");
                    System.out.println("         Cifrar: java -jar Cifrado.jar -c -e prueba.txt ");
                    System.out.println("         Descifrar: java -jar Cifrado.jar -d -e prueba.txt.cif ");
                    System.out.println("\nElaborado por: Andres Felipe Vega felipevega@unicauca.edu.co");
                    flag=true;
                }
                
                if (com2.equals("-a") && com1.equals("-ctr")){
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("       Algoritmos de cifrado por Transpocision\n");
                    System.out.println(" Sintaxis: java -jar Cifrado.jar -ctr <modo> <tipo> <codificacion> -e <Archivo entrada>\n");
                    System.out.println(" <modo> -c para cifrar\n        -d para descifrar\n");
                    System.out.println(" <tipo> -ts transpocision simple");
                    System.out.println(" <tipo> -td transpocision doble");
                    System.out.println(" <tipo> -ti transpocision inversa");
                    System.out.println(" \n<codificacion> es -64 sera codificado a base 64");
                    System.out.println(" \n<codificacion> es -n mantendra la codificacion original\n");
                    System.out.println(" <Archivo entrada> nombre del archivo de entrada\n");
                    System.out.println(" si <modo> es -c el <Archivo de entrada> tiene extension .txt");
                    System.out.println(" si <modo> es -d el <Archivo de entrada> tiene extension .cif");
                    System.out.println(" si <modo> es -d y <codificacion> -n el <Archivo de entrada> tiene extension .cif");
                    System.out.println(" si <modo>(b64) es -d y <codificacion> -64 el <Archivo de entrada> tiene extension .cif64");
                   
                    System.out.println("\n Salidas: \n      si <modo> : es -c la salida sera .cif");
                    System.out.println("                  es -d la salida sera .dec ");
                    System.out.println("\n\n Salidas(b64): \n      si <modo> : es -c y <codificacion> -64 la salida sera .cif64");
                    System.out.println("                  es -d la salida sera .dec64");
                    System.out.println(" \nEjemplos:");
                    System.out.println("         Cifrar: java -jar Cifrado.jar -ctr -c -ts -e prueba.txt ");
                    System.out.println("         Descifrar: java -jar Cifrado.jar -ctr -d -ts -e prueba.cif ");
                    System.out.println("\nElaborado por: Andres Felipe Vega felipevega@unicauca.edu.co");
                    flag=true;
                }else{
                    if(flag==false)
                        System.out.println("Error de sintaxis.");
                
                }

            }else{
                
                /**
                 * Escoge la opcion digitada en los argumentos del script
                 * para entrar a cada uno de los distintos algoritmos de cifrado
                 */
                
                if(args.length==5 || args.length==6 ){     
                    switch(args[0]){
                        // Algoritmo de Trithemius
                      
                        case "-ctth": 
                               System.out.println("\nAlgoritmo de cifrado de Trithemius");
                             if(args[1].equals("-c")& args[3].equals("-e") & !args[4].equals("")){

                                System.out.println("procesando....");
                                if(args[2].equals("-64")){

                                    cod64.codificar64(args[4]);
                                    trit.cifrar64(args[4].split("\\.")[0]+".b64");
                                    System.out.println("Archivo cifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[4].split("\\.")[0]+".cif64");
                                }else{
                                    trit.cifrar(args[4]);
                                    System.out.println("Archivo cifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[4].split("\\.")[0]+".cif");
                                }
                                
                                break;
                            }    
                            // Descifrar con algoritmo de Trithemius.
                            if(args[1].equals("-d")& args[3].equals("-e") & !args[3].equals("")){
                                
                                System.out.println("procesando....");
                                if(args[2].equals("-64")){
                                    
                                    trit.descifrar64(args[4].split("\\.")[0]+".cif64");
                                    cod64.descodificar64(args[4].split("\\.")[0]+".dec64");
                                    System.out.println("Archivo descifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[4].split("\\.")[0]+".dec");
                                }else{
                                    trit.descifrar(args[4]);
                                    System.out.println("Archivo descifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[4].split("\\.")[0]+".dec");
                                }


                                
                                 break;

                            }else{
                                System.out.println("Error de sintaxis.");

                            }
                            ////
                            
                            
                            
                        break;
                         //algoritmo de Transpocision
                        case "-ctr":
                            System.out.println("\nAlgoritmo de cifrado por transpocision");
                          
                            // Cifrar con algoritmo de Trithemius.
                            if(args[1].equals("-c") & !args[2].equals("") & !args[3].equals("") & args[4].equals("-e") & !args[5].equals("")){
                                
                                System.out.println("procesando....");
                                if(args[3].equals("-64")){

                                    cod64.codificar64(args[5]);
                                    transp.cifrar(args[5].split("\\.")[0]+".b64",args[2],args[3]);
                                    System.out.println("Archivo cifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[5].split("\\.")[0]+".cif64");
                               
                                }else{
                                    transp.cifrar(args[5],args[2],args[3]);
                                    System.out.println("Archivo cifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[5].split("\\.")[0]+".cif");
                                }
                                
                                break;
                            }    
                            // Descifrar con algoritmo de Transposicion.
                             if(args[1].equals("-d") & !args[2].equals("") & !args[3].equals("") & args[4].equals("-e") & !args[5].equals("")){
                               
                                System.out.println("procesando....");
                                if(args[3].equals("-64")){
                                    
                                    transp.descifrar(args[5].split("\\.")[0]+".cif64",args[2],args[3]);
                                    cod64.descodificar64(args[5].split("\\.")[0]+".dec64");
                                    System.out.println("Archivo descifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[5].split("\\.")[0]+".dec");
                                    
                                }else{
                                    transp.descifrar(args[5],args[2],args[3]);
                                    System.out.println("Archivo descifrado correctamente.");
                                    System.out.println("Archivo creado: "+ args[5].split("\\.")[0]+".dec");
                                }


                                
                                 break;

                            }else{
                                System.out.println("error de sintaxis.");

                            }

                        break;

                        default:
                            System.out.println("Error de sintaxis.");
                        break;



                    }
                }else{
                    System.out.println("Error de sintaxis.");
                }
            }
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecucion: " + endTime * 0.001 +" segundos");
        
     }
    
}
