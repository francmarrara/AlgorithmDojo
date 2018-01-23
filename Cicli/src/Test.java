import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.cycle.HawickJamesSimpleCycles;
import org.jgrapht.graph.DefaultEdge;

public class Test {

	public static void main(String[] args) {
		
		   Scanner scanner = new Scanner(System.in);
	       
	       Integer n1;
	       Integer n2;
	       Integer numNodi = scanner.nextInt();//memorizzo il numero di nodi che deve avere il grafo
	       Integer archiRimovibili = scanner.nextInt();//memorizzo il numero di archi che posso rimuovere
	       
	       GrafoOrientato g = new GrafoOrientato(DefaultEdge.class);

			
			while(scanner.hasNext()){
				
				n1 = scanner.nextInt();
				n2 = scanner.nextInt();
				
				g.addEdge(n1, n2);

				
			}
			
			
			scanner.close();
			
			//Trova i cicli nel grafo
			HawickJamesSimpleCycles<Integer, DefaultEdge> cd = new HawickJamesSimpleCycles<>(g);
			
			int archiRimossi = 0;
			
			System.out.println("Numero di nodi: " + numNodi);			
			System.out.println("Numero di archi rimovibili: " + archiRimovibili);
			System.out.println("Grafo:" + g.toString());
			System.out.println("Cicli del grafo: " + cd.findSimpleCycles());
			
			System.out.println();
			System.out.println();
			
			List<List<Integer>> listaCicli = new ArrayList<>();//lista dei cicli
			List<Integer>cicloSingolo = new ArrayList<>();//lista singolo ciclo
			
			listaCicli = cd.findSimpleCycles();
			
			//Iteratore per scorrere la lista dei cicli
			Iterator<List<Integer>> it = listaCicli.iterator();
			
			if(cd.findSimpleCycles().size() > archiRimovibili)
				System.out.println("Numero cicli > numeroArchi rimovibili");
			else{
				
				while(it.hasNext()){
					
					cicloSingolo = it.next();
					
					System.out.println("Ciclo singolo: " + cicloSingolo);
					
					//size-1 e size-2 perchè gli archi li salva al contrario = 2-3-4 sarebbe il percorso 4-3-2
					g.removeAllEdges(cicloSingolo.get(cicloSingolo.size()-1), cicloSingolo.get(cicloSingolo.size()-2));
					archiRimossi++;
					
			}

			System.out.println();
			System.out.println("Grafo:" + g.toString());
				
			if(archiRimossi > archiRimovibili)
				System.out.println("Num archi rimossi è > del num di archi rimovibili");
			else
				System.out.println("Archi rimossi: " + archiRimossi);
		
		}
			
	}
}
