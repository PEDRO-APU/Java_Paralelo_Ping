/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaparalelo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author PEJOSE
 */
public class PingParalelo extends Thread{
    private String ip;
    private String nombre;
    private static InetAddress ping;
    public PingParalelo(String ip, String nombre){
        this.ip= ip;
        this.nombre=nombre;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public static InetAddress getPing() {
        return ping;
    }

    public static void setPing(InetAddress ping) {
        PingParalelo.ping = ping;
    }
    
    @Override
    public void run(){
        System.out.println("Nombre: "+this.nombre + " Estado: "+ estado(this.ip)+ " "+Thread.currentThread().getName());
    }
    
    
    static boolean estado(String ip){
        Boolean estado = false;
        try{
            ping = InetAddress.getByName(ip);
            estado = ping.isReachable(5000);
            
        }catch(Exception e){
            System.out.println("no se pudo comprobar ip: "+e.getMessage());
        }        
        return estado;
    }
    
}
