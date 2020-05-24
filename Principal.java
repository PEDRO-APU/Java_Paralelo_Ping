/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparalelo;

import java.util.ArrayList;



/**
 *
 * @author PEJOSE
 */
public class Principal {
    
    public static void main(String[] args){
        Conexion con = new Conexion();
        
        ArrayList<PingParalelo> lista = con.listaIp();
 
        //hilos concurrentes
        lista.parallelStream().forEach((p)->{
           p.start();
        });
        
        System.out.println("principal...");
        

       
    }
}
