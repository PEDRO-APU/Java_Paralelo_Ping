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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PEJOSE
 */
public class  Conexion {
    public static final String SEPARADOR = ";";
    private PingParalelo ip;
    BufferedReader bufferLectura = null;
    public ArrayList<PingParalelo> listaIp(){    
        ArrayList<PingParalelo> lista = new ArrayList<>();
        try{          
         
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader("C:\\Users\\PEJOSE\\Documents\\NetBeansProjects\\JavaParalelo\\ip.csv"));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();          
            
            while (linea != null) {
                
                // Sepapar la linea leída con el separador definido previamente.
                String[] campos = linea.split(SEPARADOR);
                
                String verIp = campos[0];
                String nombre= campos[1];
                ip = new PingParalelo(verIp, nombre);                
                lista.add(ip);
                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException e){
                System.out.println("Error capturado al leer csv: "+e.getMessage());
            }                     
        return lista;      
        
        }    
}
