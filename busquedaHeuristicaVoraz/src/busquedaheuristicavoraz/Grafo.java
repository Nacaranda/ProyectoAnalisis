package busquedaheuristicavoraz;

import java.util.ArrayList;

public class Grafo {
    
    public ArrayList<Vertice> vertices;  

    
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public Grafo(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void agregarVertice(Vertice vertice){
        vertices.add(vertice);
    }
    
    
}
