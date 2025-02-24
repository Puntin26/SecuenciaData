import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Grafo {


    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.addArista("A", "B");
        grafo.addArista("A", "C");
        grafo.addArista("B", "D");
        grafo.addArista("B", "E");
        grafo.addArista("C", "F");
        grafo.addArista("C", "G");
        grafo.addArista("D", "E");
        grafo.addArista("D", "H");
        grafo.addArista("E", "I");
        grafo.addArista("F", "G");
        grafo.addArista("G", "H");
        grafo.addArista("H", "I");
        grafo.addArista("I", "F");

        System.out.println("Secuencia de grados:");
        Map<String, Integer> secuenciaGrados = grafo.getSecuenciaGrados();
        for(Map.Entry<String, Integer> entry: secuenciaGrados.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nLista de adyacencia:");
        grafo.listAdyacencia();


    }
    private HashMap<String, ArrayList<String>> adjList;
    public Grafo(){
        adjList = new HashMap<>();
    }

    public void addArista(String vA, String vB){
        addVertice(vA);
        addVertice(vB);
        adjList.get(vA).add(vB);
        adjList.get(vB).add(vA);
    }

    private void addVertice(String vA) {
        if(!adjList.containsKey(vA)){
            adjList.put(vA, new ArrayList<>());
        }
    }

    public Map<String, Integer> getSecuenciaGrados(){
        HashMap<String, Integer> secuenciaGrados = new HashMap<>();

        for(Map.Entry<String, ArrayList<String>> entry: adjList.entrySet()){
            secuenciaGrados.put(entry.getKey(), entry.getValue().size());
        }

        return secuenciaGrados;
    }


    public void listAdyacencia(){
        for(Map.Entry<String, ArrayList<String>> entry: adjList.entrySet()){
            System.out.print(entry.getKey() + ": ");

            for(String neighbor: entry.getValue()){
                System.out.print(neighbor + ",");
            }

            System.out.println();
        }
    }

}