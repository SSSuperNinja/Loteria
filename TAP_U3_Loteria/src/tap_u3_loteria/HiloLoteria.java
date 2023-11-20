package tap_u3_loteria;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class HiloLoteria extends Thread{
    Ventana p;
    boolean estadoCiclo = true;
    boolean ejecutaCodigo = true;
    public HiloLoteria(Ventana p){
        this.p = p;
    }
    
    public void run(){        
        while(estadoCiclo){
            try {
                sleep(5000);
            }catch (InterruptedException ex) {
                Logger.getLogger(HiloLoteria.class.getName()).log(Level.SEVERE, null, ex);
            }//try-catch            
            if(ejecutaCodigo==true){
            }//if
            if (ejecutaCodigo){
                 p.jLabel1.setIcon(new ImageIcon
                    (this.getClass().getResource("/LOTERIA/" + p.pila.pop() + ".png")));
            }
        }
    }
    
    public void terminar(){
        estadoCiclo = false;
    }
    public void pausar(){
        ejecutaCodigo = false;
    }
    public void despausar(){
        ejecutaCodigo = true;
    }
    public boolean estaPausado(){
        return ejecutaCodigo;
    }
    public boolean estaTerminado(){
        return estadoCiclo;
    }
    public void reanudar(){
        ejecutaCodigo = true;
    }
}
