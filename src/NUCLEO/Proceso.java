/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NUCLEO;

/**
 *
 * @author Rolando
 */
public class Proceso {
    
    /*Atirbutos*/
    
    private String nombre;
    private int numeroRecursos;
    private int tiempoEjecucion;
    private int tiempoLlegada;
    private int tiempoEspera;
    private String cadena;
    
    /*Constructor*/
    
    public Proceso(String nombre,int numeroRecursos, int tiempoEjecucion,
            int tiempoLlegada, int tiempoEspera, String cadena){
        this.nombre = nombre;
        this.numeroRecursos = numeroRecursos;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEspera = tiempoEspera;
        this.cadena = cadena;
        
    }

    public String getCadena() {
        return cadena;
    }

    /*Métodos*/
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroRecursos() {
        return numeroRecursos;
    }

    public void setNumeroRecursos(int numeroRecursos) {
        this.numeroRecursos = numeroRecursos;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }
    
}
