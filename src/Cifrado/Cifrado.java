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
        Trithemius trit = new Trithemius();
        Alberti albert = new Alberti();
        long startTime = System.currentTimeMillis();
        Codi64 cod64 = new Codi64();
        // prueba
        //cif.cifrar("tabula recta");
        
        // Valida si el Script recibe uno o ningun argumento.
        if(args.length==0 || args.length==1 ){
            System.out.println("--------------------------------------------------------------------\n      Algoritmos de Cifrado\n Sintaxis: java -jar Cifrado.jar <algoritmo> <parametros>");
            System.out.println(" \n<algoritmo>:\n          -ctth Algoritmo de cifrado de trithemius");
            System.out.println(" \n<algoritmo>:\n          -calb Algoritmo de cifrado de trithemius");
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
                    System.out.println(" si <modo> es -d el <Archivo de entrada> tiene extension .cif");
                    System.out.println(" \nsi <codificacion> es -64 sera codificado a base 64");
                    System.out.println(" \nsi <codificacion> es -n mantendra la codificacion original");
                    System.out.println("\n\n Salidas: \n      si <modo> : es -c la salida sera .cif");
                    System.out.println("                  es -d la salida sera .def ");
                    System.out.println(" \nEjemplos:");
                    System.out.println("         Cifrar: java -jar Cifrado.jar -c -e prueba.txt ");
                    System.out.println("         Descifrar: java -jar Cifrado.jar -d -e prueba.txt.cif ");
                    System.out.println("\nElaborado por: Andres Felipe Vega felipevega@unicauca.edu.co");
                }else{
                    System.out.println("Error de sintaxis.");
                
                }
                
                if (com2.equals("-a") && com1.equals("-calb")){
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("       Algoritmo de cifrado de Alberti\n");
                    System.out.println(" Sintaxis: java -jar Cifrado.jar -calb <modo> <n-cifradas> <paso>\n <letraExterna> <letraInterna> <codificacion> -e <Archivo entrada>\n");
                    System.out.println(" <modo> -c para cifrar\n        -d para descifrar\n");
                    System.out.println(" <n-cifradas>\n        (Entero)cada cuantas letras cifradas debe girar el disco externo\n");
                    System.out.println(" <paso>\n        (Entero) cada n-letras cifradas, cuantas pocisiones gira el disco externo\n");
                    System.out.println(" <letraExterna>\n        (Caracter) La letra del disco externo que coincidira inicialmente con <letraInterna>\n");
                    System.out.println(" <letraInterna>\n        (Caracter) la letra del disco interno que coincidira inicialmente con <letraExterna>\n");
                    System.out.println(" \nsi <codificacion> es -64 sera codificado a base 64");
                    System.out.println(" \nsi <codificacion> es -n mantendra la codificacion original");
                    System.out.println(" <Archivo entrada> nombre del archivo de entrada\n");
                    System.out.println(" si <modo> es -c el <Archivo de entrada> tiene extension .txt");
                    System.out.println(" si <modo> es -d el <Archivo de entrada> tiene extension .cif");
                    System.out.println("\n Salidas: \n      si <modo> : es -c la salida sera .cif");
                    System.out.println("                  es -d la salida sera .def ");
                    System.out.println(" \nEjemplos:");
                    System.out.println("         Cifrar: java -jar Cifrado.jar -calb -c 10 3 a b -e prueba.txt ");
                    System.out.println("         Descifrar: java -jar Cifrado.jar -calb -d -e prueba.cif ");
                    System.out.println("\nElaborado por: Andres Felipe Vega felipevega@unicauca.edu.co");
                }else{
                    System.out.println("Error de sintaxis.");
                
                }

            }else{
                
                /**
                 * Escoge la opcion digitada en los argumentos del script
                 * para entrar a cada uno de los distintos algoritmos de cifrado
                 */
                
                if(args.length==5){     
                    switch(args[0]){
                        // Algoritmo de Trithemius
                        case "-ctth": 
                            // Cifrar con algoritmo de Trithemius.
                            if(args[1].equals("-c")& args[3].equals("-e") & !args[4].equals("")){

                                System.out.println("procesando....");
                                if(args[2].equals("-64")){

                                    cod64.codificar64(args[4]);
                                    trit.cifrar64(args[4].split("\\.")[0]+".64");
                                }else{
                                    trit.cifrar(args[4]);
                                }
                                System.out.println("Archivo cifrado correctamente.");
                                System.out.println("Archivo creado: "+ args[4].split("\\.")[0]+".cif");
                                break;
                            }    
                            // Descifrar con algoritmo de Trithemius.
                            if(args[1].equals("-d")& args[3].equals("-e") & !args[3].equals("")){
                                
                                System.out.println("procesando....");
                                if(args[2].equals("-64")){
                                    
                                    trit.descrifrar64(args[4].split("\\.")[0]+".cif");
                                    cod64.descodificar64(args[4].split("\\.")[0]+".dec");
                                }else{
                                    trit.descrifrar(args[4]);
                                }


                                System.out.println("Archivo descifrado correctamente.");
                                System.out.println("Archivo creado: "+ args[4].split("\\.")[0]+".dec");
                                 break;

                            }else{
                                System.out.println("error de sintaxis.");

                            }
                        break;
                         //algoritmo de alberti
                        case "-calb":

                             // Cifrar con algoritmo de Trithemius.
                            if(args[1].equals("-c")& !args[2].equals("") & !args[3].equals("") & !args[4].equals("") & !args[5].equals("")){

                                System.out.println("procesando.... con alberti");

                                System.out.println("Archivo cifrado correctamente.");
                                System.out.println("Archivo creado: "+ args[3]+".cif");
                                break;
                            }    
                            // Descifrar con algoritmo de Trithemius.
                            if(args[1].equals("-d")& args[2].equals("-e") & !args[3].equals("")){


                                System.out.println("procesando.... con alberti");
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
                }else{
                    System.out.println("Error de sintaxis.");
                }
            }
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecucion: " + endTime * 0.001 +" segundos");
        
     }
    
}
