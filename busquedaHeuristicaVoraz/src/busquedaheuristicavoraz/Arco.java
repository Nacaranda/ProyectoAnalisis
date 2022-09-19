package busquedaheuristicavoraz;

public class Arco {
    
    public int valor;
    public Vertice siguiente;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Vertice getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Vertice siguiente) {
        this.siguiente = siguiente;
    }

    public Arco(int valor, Vertice siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

}       
