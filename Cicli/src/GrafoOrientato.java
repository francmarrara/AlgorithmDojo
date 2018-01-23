import java.util.Collection;
import java.util.Set;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

@SuppressWarnings({ "rawtypes" })
public class GrafoOrientato extends DefaultDirectedGraph<Integer, DefaultEdge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3356198212404184754L;

	@SuppressWarnings("unchecked")
	public GrafoOrientato(Class edgeClass) {
		super(edgeClass);
	}

	//Aggiunge l'arco di nodi passati in input
	@Override
	public DefaultEdge addEdge(Integer sorceVertex, Integer targetVertex) {
		
		addVertex(sorceVertex);
		addVertex(targetVertex);
		
		return super.addEdge(sorceVertex, targetVertex);
	}

	//Aggiunge un nodo al grafo
	@Override
	public boolean addVertex(Integer v) {
		return super.addVertex(v);
	}

	//Verifica se l'arco è contenuto nel grafo
	@Override
	public boolean containsEdge(DefaultEdge e) {
		return super.containsEdge(e);
	}

	//Verifica se il nodo è contenuto nel grafo
	@Override
	public boolean containsVertex(Integer v) {
		return super.containsVertex(v);
	}

	//Restituisce i collegamenti del nodo passato in input
	@Override
	public int degreeOf(Integer vertex) {
		return super.degreeOf(vertex);
	}
	
	//Restituisce il numero degli archi entranti nel nodo passato in input
	@Override
	public int inDegreeOf(Integer vertex) {
		return super.inDegreeOf(vertex);
	}
	
	//Restituisce il numero degli archi uscenti nel nodo passato in input
	@Override
	public int outDegreeOf(Integer vertex) {
		return super.outDegreeOf(vertex);
	}

	//Restituisce l'insieme di archi presenti nel grafo
	@Override
	public Set<DefaultEdge> edgeSet() {
		return super.edgeSet();
	}

	//Restituisce l'insieme di archi che toccano il nodo passato in input
	@Override
	public Set<DefaultEdge> edgesOf(Integer vertex) {
		return super.edgesOf(vertex);
	}

	//Restituisce l'insieme di archi che uniscono il vertice di partenza al vertice di arrivo, se esistono nel grafo
	@Override
	public Set<DefaultEdge> getAllEdges(Integer sourceVertex, Integer targetVertex) {
		return super.getAllEdges(sourceVertex, targetVertex);
	}

	//Restituisce un arco che uniscono il vertice di partenza al vertice di arrivo, se esistono nel grafo
	@Override
	public DefaultEdge getEdge(Integer sourceVertex, Integer targetVertex) {
		return super.getEdge(sourceVertex, targetVertex);
	}

	//Restituisce il nodo vertice dell'arco passato in input
	@Override
	public Integer getEdgeSource(DefaultEdge e) {
		return super.getEdgeSource(e);
	}

	//Restituisce il nodo target dell'arco passato in input
	@Override
	public Integer getEdgeTarget(DefaultEdge e) {
		return super.getEdgeTarget(e);
	}

	//Restituisce il peso dell'arco passato in input
	@Override
	public double getEdgeWeight(DefaultEdge e) {
		return super.getEdgeWeight(e);
	}

	//Restituisce l'insieme di archi entranti nel nodo passato in input
	@Override
	public Set<DefaultEdge> incomingEdgesOf(Integer vertex) {
		return super.incomingEdgesOf(vertex);
	}

	//Restituisce l'insieme di archi uscenti dal nodo passato in input
	@Override
	public Set<DefaultEdge> outgoingEdgesOf(Integer vertex) {
		return super.outgoingEdgesOf(vertex);
	}

	//Restituisce l'arco eliminato che va dal nodo di origine al nodo di fine passati in input
	@Override
	public DefaultEdge removeEdge(Integer sourceVertex, Integer targetVertex) {
		return super.removeEdge(sourceVertex, targetVertex);
	}

	//Elimina il nodo e gli archi ad esso collegati, se il nodo esiste
	@Override
	public boolean removeVertex(Integer arg0) {
		return super.removeVertex(arg0);
	}

	//Assegna un peso all'arco
	@Override
	public void setEdgeWeight(DefaultEdge e, double weight) {
		super.setEdgeWeight(e, weight);
	}

	//Restituisce l'insieme dei nodi contenuti nel grafo
	@Override
	public Set<Integer> vertexSet() {
		return super.vertexSet();
	}

	//Verifica che in nodo passato in input esista nel grafo, altrimenti restituisce un eccezione
	@Override
	protected boolean assertVertexExist(Integer v) {
		return super.assertVertexExist(v);
	}

	//Verifica se e solo se esiste un arco che va dal nodo origine al nodo finale
	@Override
	public boolean containsEdge(Integer sourceVertex, Integer targetVertex) {
		return super.containsEdge(sourceVertex, targetVertex);
	}

	//Verifica se due grafi sono uguali
	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	//Restituisce il codice hash relativo al grafo
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	//Rimuove gli archi presenti nella collection dal grafo 
	@Override
	public boolean removeAllEdges(Collection<? extends DefaultEdge> arg0) {
		return super.removeAllEdges(arg0);
	}

	//Rimuove gli archi presenti nell'array dal grafo 
	@Override
	protected boolean removeAllEdges(DefaultEdge[] arg0) {
		return super.removeAllEdges(arg0);
	}

	//Rimuove tutti gli archi che vanno dal nodo di origine al nodo finale presenti nel grafo
	@Override
	public Set<DefaultEdge> removeAllEdges(Integer sourceVertex, Integer targetVertex) {
		return super.removeAllEdges(sourceVertex, targetVertex);
	}

	//Rimuove i nodi presenti nella collection dal grafo 
	@Override
	public boolean removeAllVertices(Collection<? extends Integer> arg0) {
		return super.removeAllVertices(arg0);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected String toStringFromSets(Collection<? extends Integer> arg0, Collection<? extends DefaultEdge> arg1,
			boolean arg2) {
		return super.toStringFromSets(arg0, arg1, arg2);
	}

}
