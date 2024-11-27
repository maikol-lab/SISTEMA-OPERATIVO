
package NUCLEO;

import java.util.Vector;

public class LRU {
    
    private int nMarco;
    private String[] numeros;
    private int MAXFALLOS = 40;
    private String[][] pagina;
    private int nFallos;
    private Vector cola;
    
    public LRU(int nMarco, String[] numeros) {
        this.nMarco = nMarco;
        this.numeros = numeros;
        this.pagina = new String[nMarco][MAXFALLOS];
        this.nFallos = 0;
        cola = new Vector();
    }
    
    private boolean verificarExistenciaEnPagina(String cadena,int columna) {
        boolean estado =  false;
        
        for (int i = 0; i < nMarco; i++) {
            if ( pagina[i][columna - 1] != null && pagina[i][columna - 1].equals(cadena) ) {
                return estado = true;
            }
        }
        
        return estado;
    }
    
    private int obtenerPosicionMarco(String cadena,int columna) {
        int posicion = 0;
        
        for (int i = 0; i < nMarco; i++) {
            if ( pagina[i][columna - 1] == null ) {
                return i;
            }
        }
        
        String elemento = (String) cola.get(0);
        
        for (int i = 0; i < nMarco; i++) {
            if ( pagina[i][columna - 1] != null && pagina[i][columna - 1].equals(elemento) ) {
                cola.remove( 0 );
                return  i;
            }
        }
        
        return posicion;
    }
    
    private void actualizarCola(String cadena) {
        
        while(cola.remove( cadena )  ) {
        }
        cola.add( cadena );
    }
    
    private void actualizarDatos(String cadena, int pos, int columna) {
        for (int i = 0; i < nMarco; i++) {
            if ( i == pos ) {
                pagina[i][columna] = cadena;
            }else if ( pagina[i][columna - 1] != null ){
                pagina[i][columna] = pagina[i][columna - 1];
            }
        }
        
    }
    
    public String[][] procesar(){
        //********* inicializando**************
        pagina[0][0] = numeros[0] ;
        actualizarCola( pagina[0][0] );
        nFallos = 1;
        
        //*************************************
        for (int i = 1; i < numeros.length; i++) {
            boolean estado = verificarExistenciaEnPagina( numeros[i], nFallos );
            if (estado) {
                actualizarCola( numeros[i] );
            }else {
                int pos =  obtenerPosicionMarco(numeros[i], nFallos );
                actualizarDatos( numeros[i], pos, nFallos );
                actualizarCola( numeros[i] );
                nFallos++;
            }
        }
        nFallos = nFallos;
        return pagina;
    }
    
    public int getNFallos() {
        return nFallos;
    }
    
}
