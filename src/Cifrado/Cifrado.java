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
        Trithemius cif = new Trithemius();
        long startTime = System.currentTimeMillis();
        // prueba
        //cif.cifrar("tabula recta");
        
        // Valida si el Script recibe uno o ningun argumento.
        if(args.length==0 || args.length==1 ){
            System.out.println("--------------------------------------------------------------------\n      Algoritmos de Cifrado\n Sintaxis: java -jar Cifrado.jar <algoritmo>");
            System.out.println(" \n<algoritmo>:\n          -ctth Algoritmo de cifrado de trithemius");
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


                if (com2.equals("-a")){
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("       Algoritmo de cifrado de Trithemius\n");
                    System.out.println(" Sintaxis: java -jar Cifrado.jar -ctth <modo> -e <Archivo entrada>\n");
                    System.out.println(" <modo> -c para cifrar\n        -d para descifrar\n\n");
                    System.out.println(" <Archivo entrada>: nombre del archivo de entrada\n");
                    System.out.println(" si <modo> es -c el <Archivo de entrada> tiene extension .txt");
                    System.out.println(" si <modo> es -d el <Archivo de entrada> tiene extension .cif");
                    System.out.println("\n\n Salidas: \n      si <modo> : es -c la salida sera .cif");
                    System.out.println("                  es -d la salida sera .def ");
                    System.out.println(" \nEjemplos:");
                    System.out.println("         Cifrar: java -jar Cifrado.jar -c -e prueba.txt ");
                    System.out.println("         Descifrar: java -jar Cifrado.jar -d -e prueba.txt.cif ");
                    System.out.println("\nElaborado por: Andres Felipe Vega felipevega@unicauca.edu.co");
                }else{
                    System.out.println("Error de sintaxis.");
                
                }

            }else{
                
                /**
                 * Escoge la opcion digitada en los argumentos del script
                 * para entrar a cada uno de los distintos algoritmos de cifrado
                 */
                switch(args[0]){
                    // Algoritmo de Trithemius
                    case "-ctth": 
                        // Cifrar con algoritmo de Trithemius.
                        if(args[1].equals("-c")& args[2].equals("-e") & !args[3].equals("")){
                        
                            System.out.println("procesando....");
                            cif.cifrar(args[3]);
                            System.out.println("Archivo cifrado correctamente.");
                            System.out.println("Archivo creado: "+ args[3]+".cif");
                            break;
                        }    
                        // Descifrar con algoritmo de Trithemius.
                        if(args[1].equals("-d")& args[2].equals("-e") & !args[3].equals("")){
                           

                            System.out.println("procesando....");
                            cif.descrifrar(args[3]);
                            System.out.println("Archivo descifrado correctamente.");
                            System.out.println("Archivo creado: "+ args[3]+".dec");
                             break;

                        }else{
                            System.out.println("error de sintaxis.  ");

                        }
                    break;

                    default:
                        System.out.println("Error de sintaxis.");
                    break;



                }
            }
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecucion: " + endTime * 0.001 +" segundos");
        
     }
    
}
