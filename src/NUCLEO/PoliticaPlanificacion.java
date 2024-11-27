/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NUCLEO;

import PRESENTACION.dialogoAdministrador;
import java.util.ArrayList;

/**
 *
 * @author Rolando
 */
public class PoliticaPlanificacion {
    
    /*Atributos*/
    
    private ArrayList<Proceso> colaEspera;
    private static int timer=0;
    
    /*Constructor*/
    
    public PoliticaPlanificacion(ArrayList<Proceso> colaEspera){
        this.colaEspera = colaEspera;
    }
    
    /*Métodos*/
    
    public static int getTimer() {
        return timer;
    }
    
    public void aniadirProceso(Proceso p){
        colaEspera.add(p);
    }

    public ArrayList<Proceso> getColaEspera() {
        return colaEspera;
    }

    public void setColaEspera(ArrayList<Proceso> colaEspera) {
        this.colaEspera = colaEspera;
    }
    
    /*Política de planificación FIFO*/
    
    public void atenderProcesos(ArrayList<Proceso> colaEspera, 
            dialogoAdministrador d){
        int t_aux=0;
        int t_espera=0;
        if(colaEspera.size()>0){
            t_aux = colaEspera.get(0).getTiempoEjecucion();
            colaEspera.get(0).setTiempoEjecucion(t_aux - 1);
            
            Object [] fila = new Object[2];
            fila[0] = colaEspera.get(0).getNombre();
            fila[1] = t_aux - 1;
            d.getModelo_cpu().addRow(fila);
            
            for(int i=1; i<colaEspera.size(); i++){
                if(colaEspera.get(i).getTiempoLlegada()<=timer){
                   t_espera = colaEspera.get(i).getTiempoEspera(); 
                   colaEspera.get(i).setTiempoEspera(t_espera + 1);
                   
                   fila[0] = colaEspera.get(i).getNombre();
                   fila[1] = t_espera;
                   d.getModelo_esp().addRow(fila);
                   
                }
            }
            if(colaEspera.get(0).getTiempoEjecucion()==0){
                colaEspera.remove(0);
                d.getModelo_pro().removeRow(0);
            }
        }
        timer = timer+1;
    }
    /*
    public static void main(String[] argv){
        ArrayList<Proceso> colaEspera;
        colaEspera = new ArrayList<Proceso>();
        PoliticaPlanificacion fifo = new PoliticaPlanificacion();
        Proceso p1,p2,p3,p4;
        p1 = new Proceso("A",0,6,0,0);
        p2 = new Proceso("B",0,4,3,0);
        p3 = new Proceso("C",0,2,5,0);
        p4 = new Proceso("D",0,7,10,0);
        
        colaEspera.add(p1);
        colaEspera.add(p2);
        colaEspera.add(p3);
        colaEspera.add(p4);
        
        fifo.setColaEspera(colaEspera);
        for(int i=0; i<19; i++){
            fifo.atenderProcesos(colaEspera);
        }
        
    }
    */
}
