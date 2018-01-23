import java.util.Collection;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings({ "serial" })
public class GrafoNonOrientato extends SimpleGraph<Integer, DefaultEdge>{

	public GrafoNonOrientato(Class<? extends DefaultEdge> edgeClass) {
		super(edgeClass);
	}

	//Dice se l'arco fa parte del grafo
	@Override
	public boolean containsEdge(Integer sourceVertex, Integer targetVertex) {
		return super.containsEdge(sourceVertex, targetVertex);
	}

	//Rimuove tutti gli archi contenuti nella lista passata alla funzione
	@Override
	public boolean removeAllEdges(Collection<? extends DefaultEdge> edges) {
		return super.removeAllEdges(edges);
	}

	//Rimuove tutti gli archi che vanno dal vertex di partenza a quello di arrivo
	//e restituisce gli archi rimossi
	@Override
	public Set<DefaultEdge> removeAllEdges(Integer sourceVertex, Integer targetVertex) {
		return super.removeAllEdges(sourceVertex, targetVertex);
	}
	
	//Rimuove tutti gli archi contenuti nell'array passata alla funzione
	@Override
	protected boolean removeAllEdges(DefaultEdge[] edges) {
		return super.removeAllEdges(edges);
	}

	//Rimuove tutti i vertici contenuti nella lista passata alla funzione
	@Override
	public boolean removeAllVertices(Collection<? extends Integer> vertices) {
		return super.removeAllVertices(vertices);
	}

	//Stampa il grafo
	@Override
	public String toString() {
		return super.toString();
	}

	//Controlla se il vertice esiste nel grafo, altrimenti notifica un errore
	@Override
	protected boolean assertVertexExist(Integer v) {
		return super.assertVertexExist(v);
	}



	@Override
	protected String toStringFromSets(Collection<? extends Integer> vertexSet,
			Collection<? extends DefaultEdge> edgeSet, boolean directed) {
		return super.toStringFromSets(vertexSet, edgeSet, directed);
	}

	//Ritorna il codice hash del grafo
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	//Verifica se due grafi sono uguali
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	//Aggiunge un arco al grafo
	@Override
	public DefaultEdge addEdge(Integer sourceVertex, Integer targetVertex) {
		
		addVertex(sourceVertex);
		addVertex(targetVertex);
		
		return super.addEdge(sourceVertex, targetVertex);
	}

	//Setta il peso di un arco
	@Override
	public void setEdgeWeight(DefaultEdge e, double weight) {
		super.setEdgeWeight(e, weight);
	}

	//Aggiunge un vertice al grafo
	@Override
	public boolean addVertex(Integer v) {
		return super.addVertex(v);
	}

	//Verifica se l'arco passato in input è contenuto nel grafo
	@Override
	public boolean containsEdge(DefaultEdge e) {
		return super.containsEdge(e);
	}

	//Verifica se il vertice passato in input è contenuto nel grafo
	@Override
	public boolean containsVertex(Integer v) {
		return super.containsVertex(v);
	}

	
	@Override
	public Integer getEdgeSource(DefaultEdge e) {
		return super.getEdgeSource(e);
	}

	@Override
	public Integer getEdgeTarget(DefaultEdge e) {
		return super.getEdgeTarget(e);
	}

	@Override
	public double getEdgeWeight(DefaultEdge e) {
		return super.getEdgeWeight(e);
	}

	@Override
	public boolean removeEdge(DefaultEdge e) {
		return super.removeEdge(e);
	}

	@Override
	public DefaultEdge removeEdge(Integer sourceVertex, Integer targetVertex) {
		return super.removeEdge(sourceVertex, targetVertex);
	}

	@Override
	public boolean removeVertex(Integer arg0) {
		return super.removeVertex(arg0);
	}
	
}