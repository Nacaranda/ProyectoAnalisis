//programa Java para aplicar fuerza bruta a la solución del problema de cobertura mínima de vértices para un grafo dado y devolver el conjunto de vértices que forman la cobertura mínima de vértices
import java.util.*;

public class prueba {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                         {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                         {1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                         {0, 1, 1, 0, 1, 1, 0, 0, 0, 0},
                         {0, 0, 1, 1, 0, 1, 0, 0, 0, 0},
                         {0, 0, 0, 1, 1, 0, 1, 1, 0, 0},
                         {0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
                         {0, 0, 0, 0, 0, 1, 1, 0, 1, 1},
                         {0, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                         {0, 0, 0, 0, 0, 0, 0, 1, 1, 0}}; //grafo de prueba
        int[] vertexCover = vertexCover(graph); //llamada a la función
        System.out.println(Arrays.toString(getVertexCover(vertexCover))); //imprime el resultado
    }

    //funciión que toma un arreglo de 1 y 0 y devuelve el índice de los 1
    public static int[] getVertexCover(int[] vertexCover) {
        int[] result = new int[vertexCover.length];
        int count = 0;
        for (int i = 0; i < vertexCover.length; i++) {
            if (vertexCover[i] == 1) {
                result[count] = i;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public static int[] vertexCover(int[][] graph) { //función que devuelve el conjunto de vértices que forman la cobertura mínima de vértices
        int n = graph.length; //número de vértices
        int[] vertexCover = new int[n]; //conjunto de vértices que forman la cobertura mínima de vértices
        int[] vertexCoverMin = new int[n]; //conjunto de vértices que forman la cobertura mínima de vértices
        int min = n; //número de vértices en la cobertura mínima de vértices
        for (int i = 0; i < Math.pow(2, n); i++) { //bucle que recorre todas las posibles combinaciones de vértices
            int count = 0; //número de vértices en la cobertura
            for (int j = 0; j < n; j++) { //bucle que recorre los vértices
                if ((i & (1 << j)) > 0) { //si el vértice está en la combinación
                    vertexCover[j] = 1; //añade el vértice a la cobertura
                    count++; //aumenta el número de vértices en la cobertura
                } else { //si el vértice no está en la combinación
                    vertexCover[j] = 0; //no añade el vértice a la cobertura
                }
            }
            if (count < min && isVertexCover(graph, vertexCover)) { //si la cobertura es mínima y es válida
                min = count; //actualiza el número de vértices en la cobertura mínima de vértices
                vertexCoverMin = vertexCover.clone(); //actualiza el conjunto de vértices que forman la cobertura mínima de vértices
            }
        }
        return vertexCoverMin; //devuelve el conjunto de vértices que forman la cobertura mínima de vértices
    }

    public static boolean isVertexCover(int[][] graph, int[] vertexCover) { //función que devuelve si un conjunto de vértices es una cobertura de vértices válida
        int n = graph.length; //número de vértices
        for (int i = 0; i < n; i++) { //bucle que recorre los vértices
            for (int j = 0; j < n; j++) {//bucle que recorre los vértices
                if (graph[i][j] == 1 && vertexCover[i] == 0 && vertexCover[j] == 0) { //si hay una arista entre dos vértices y ninguno de los vértices está en la cobertura
                    return false; //no es una cobertura de vértices válida
                }
            }
        }
        return true; //es una cobertura de vértices válida
    }

}