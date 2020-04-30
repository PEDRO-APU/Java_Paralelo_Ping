/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparalelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author PEJOSE
 */
public class JavaParalelo {

    /**
     * @param args the command line arguments
     */
    public static final String SEPARADOR = ";";
   
    
    public static void main(String[] args){
     
        BufferedReader bufferLectura = null;
        try {
            Ping ip;
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader("C:\\Users\\PEJOSE\\Documents\\NetBeansProjects\\JavaParalelo\\ip.csv"));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
            ArrayList<Ping> lista = new ArrayList<>();   
            
            while (linea != null) {
                
                // Sepapar la linea leída con el separador definido previamente.
                String[] campos = linea.split(SEPARADOR); 
                              
                String verIp = campos[0];
                String nombre= campos[1];
                ip = new Ping(verIp, nombre);
                lista.add(ip);
                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
            lista.parallelStream().forEach((p)->{
               p.start();
            });
            lista.parallelStream().forEach((p)->{
                try{
                    p.join();
                }catch(Exception e){
                    System.out.printf("Error al terminar hilos..."+e.getMessage());
                }
            });
            System.out.println("Total ip: "+lista.size());
            /*for(Ping p: lista){
                
                p.start();
            }*/
            
        }    
        catch(IOException e){
                e.printStackTrace();
            }
        finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
            try {
                bufferLectura.close();
            } 
            catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
  
        }
    }
}
