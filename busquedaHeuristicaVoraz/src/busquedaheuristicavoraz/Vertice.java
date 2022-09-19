package busquedaheuristicavoraz;

import java.util.ArrayList;

public class Vertice {
    
   public String nombre;
   public ArrayList<Arco> arcos = new ArrayList<Arco>();  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Arco> getArcos() {
        return arcos;
    }

    public void setArcos(ArrayList<Arco> arcos) {
        this.arcos = arcos;
    }

    public Vertice(String nombre) {
        this.nombre = nombre;
    }
   
   public void agregarArco(Arco arco){
       arcos.add(arco);
   }   
}

