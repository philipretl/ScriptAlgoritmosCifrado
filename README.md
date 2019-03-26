# ScriptAlgoritmosCifrado
                       Algoritmos de Cifrado Sintaxis: java -jar Cifrado.jar <algoritmo> <parametros>    
                       <algoritmo>:          -ctth Algoritmo de cifrado de trithemius    
                       <algoritmo>:          -ctr Algoritmos de cifrado por transpocision    
                       Consultar la ayuda de un algoritmo en especifico:     
                               sintaxis: java -jar Cifrado.jar <algoritmo> -a    


                      // Si el tamaño es de dos valida si se trata de la opcion correcta.
                      // En este apartado se encuentra la descripcion de cada uno de los 
                      // Algoritmos.
            
                                
                       Algoritmo de cifrado de Trithemius    
                      Sintaxis: java -jar Cifrado.jar -ctth <modo> <codificacion> -e <Archivo entrada>     
                      <modo> -c para cifrar        -d para descifrar    
                      <Archivo entrada>: nombre del archivo de entrada    
                      si <modo> es -c el <Archivo de entrada> tiene extension .txt    
                      si <modo> es -d y <codificacion> -n el <Archivo de entrada> tiene extension .cif    
                      si <modo>(b64) es -d y <codificacion> -64 el <Archivo de entrada> tiene extension .cif64    
                     <codificacion> es -64 sera codificado a base 64    
                     <codificacion> es -n mantendra la codificacion original    
                       Salidas:        si <modo> : es -c la salida sera .cif    
                                       es -d la salida sera .def    
                       Salidas(b64):        si <modo> : es -c y <codificacion> -64 la salida sera .cif64    
                                       es -d la salida sera .dec64    
                      Ejemplos:    
                              Cifrar: java -jar Cifrado.jar -c -e prueba.txt    
                              Descifrar: java -jar Cifrado.jar -d -e prueba.txt.cif    
                     Elaborado por: Andres Felipe Vega felipevega@unicauca.edu.co    
                                   
                      Algoritmos de cifrado por Transpocision    
	        -------------------------------------------------------------------------------------------------------------------
                      Sintaxis: java -jar Cifrado.jar -ctr <modo> <tipo> <codificacion> -e <Archivo entrada>n   
                      <modo> -c para cifrar        -d para descifrar    
                      <tipo> -ts transpocision simple    
                      <tipo> -td transpocision doble    
                      <tipo> -ti transpocision inversa   
                     <codificacion> es -64 sera codificado a base 64    
                     <codificacion> es -n mantendra la codificacion original    
                      <Archivo entrada> nombre del archivo de entrada    
                      si <modo> es -c el <Archivo de entrada> tiene extension .txt    
                      si <modo> es -d el <Archivo de entrada> tiene extension .cif    
                      si <modo> es -d y <codificacion> -n el <Archivo de entrada> tiene extension .cif    
                      si <modo>(b64) es -d y <codificacion> -64 el <Archivo de entrada> tiene extension .cif64    
                   
                      Salidas:        si <modo> : es -c la salida sera .cif    
                                       es -d la salida sera .dec    
                       Salidas(b64):        si <modo> : es -c y <codificacion> -64 la salida sera .cif64    
                                       es -d la salida sera .dec64    
                     Ejemplos:    
                              Cifrar: java -jar Cifrado.jar -ctr -c -ts -e prueba.txt    
                              Descifrar: java -jar Cifrado.jar -ctr -d -ts -e prueba.cif    
                     Elaborado por: Andres Felipe Vega felipevega@unicauca.edu.co    

